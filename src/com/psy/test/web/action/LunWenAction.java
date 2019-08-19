package com.psy.test.web.action;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.psy.test.model.LunWen;
import com.psy.test.model.Mark;
import com.psy.test.model.PageBean;
import com.psy.test.model.Student;
import com.psy.test.service.LunWenService;
import com.psy.test.service.MarkService;
import com.psy.test.service.StudentService;
import com.psy.test.utils.UploadUtils;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LunWenAction extends ActionSupport implements ModelDriven<LunWen> {
    private LunWen lunwen = new LunWen();
    private Student student = new Student();
    List<LunWen> tubiao_lunwen_list = null;

    public List<LunWen> getTubiao_lunwen_list() {
        return tubiao_lunwen_list;
    }

    public void setTubiao_lunwen_list(List<LunWen> tubiao_lunwen_list) {
        this.tubiao_lunwen_list = tubiao_lunwen_list;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public LunWen getModel() {
        return lunwen;
    }

    private LunWenService lunWenService;
    private StudentService studentService;
    private MarkService markService;

    public void setMarkService(MarkService markService) {
        this.markService = markService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public void setLunWenService(LunWenService lunWenService) {
        this.lunWenService = lunWenService;
    }

    //接收分页参数
    private Integer currPage = 1;
    private Integer pageSize = 6;

    public void setCurrPage(Integer currPage) {
        if (currPage == 0) {
            currPage = 6;
        }
        this.currPage = currPage;
    }

    public void setPageSize(Integer pageSize) {
        if (pageSize == 0) {
            pageSize = 6;
        }
        this.pageSize = pageSize;
    }

    /**
     * 文件上传提供的三个属性
     */
    private String uploadFileName;//文件名称
    private File upload;            //上传文件
    private String uploadContentType;//文件类型

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public void setUpload(File upload) {
        this.upload = upload;
    }

    public void setUploadContentType(String uploadContentType) {
        this.uploadContentType = uploadContentType;
    }


    /**
     * 分数属性
     */
    private Integer fenshu = 0;
    private Integer zijin = 0;
    private Integer shenhe = 0;
    private Integer zizjinzizhu = 0;
    private Integer zijinweizizhu = 0;
    private Integer shenhetongguo = 0;
    private Integer shenheweitongguo = 0;

    /**
     * 分页查询所有论文的方法
     */
    public String findAll() throws IOException {
        //接收参数：分页参数
        //最好使用DetachedCriteria对象（条件查询--带分页）方便
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(LunWen.class);
        //设置条件()
        if (lunwen.getLw_name() != null) {
            //设置按名称查询条件
            detachedCriteria.add(Restrictions.like("lw_name", "%" + lunwen.getLw_name() + "%"));
        }
        //设置审核条件
        if (lunwen.getLw_shenhe() != null && !"".equals(lunwen.getLw_shenhe())) {
            detachedCriteria.add(Restrictions.eq("lw_shenhe", lunwen.getLw_shenhe()));
        }
        //设置编号条件
        if (lunwen.getLw_bianhao() != null && !"".equals(lunwen.getLw_bianhao())) {
            detachedCriteria.add(Restrictions.eq("lw_bianhao", lunwen.getLw_bianhao()));
        }
        //调用业务层去查询
        PageBean<LunWen> pageBean = lunWenService.findByPage(detachedCriteria, currPage, pageSize);
        ActionContext.getContext().getValueStack().push(pageBean);
        List<LunWen> list = pageBean.getList();
        List<Mark> marks = markService.findAll();
        for (LunWen newLunwen : list) {
            if (newLunwen.getStu_lunwen_id() == ActionContext.getContext().getSession().get("stu_id")) {

                for (Mark mark : marks) {
                    zizjinzizhu = Integer.parseInt(mark.getLw_mark_zijinzizhu_zizhu());
                    zijinweizizhu = Integer.parseInt(mark.getLw_mark_zijinzizhu_weizizhu());
                    shenhetongguo = Integer.parseInt(mark.getLw_mark_shenhe_tongguo());
                    shenheweitongguo = Integer.parseInt(mark.getLw_mark_shenhe_weitongguo());
                }

                zijin = newLunwen.getLw_zizhu().equals("是") ? zizjinzizhu : zijin;
                zijin = newLunwen.getLw_zizhu().equals("否") ? zijinweizizhu : zijin;
                shenhe = newLunwen.getLw_shenhe().equals("审核通过") ? shenhetongguo : shenhe;
                shenhe = newLunwen.getLw_shenhe().equals("未通过审核") ? shenheweitongguo : shenhe;
                fenshu = shenhe + zijin;
                newLunwen.setLw_defen(fenshu);
                lunWenService.update(newLunwen);
            }
            ActionContext.getContext().getSession().put("stu_lunwen_id", newLunwen.getStu_lunwen_id());
        }
        System.out.println("pageBean---" + pageBean);
        return "findAll";
    }

    /**
     * 跳转到添加页面的方法
     */
    public String saveUI() {
        List<Student> stu_list = studentService.findAll();
        ActionContext.getContext().getValueStack().set("stu_list", stu_list);
        return "saveUI";
    }

    /**
     * 保存论文的方法
     */
    public String save() throws IOException {
        //上传图片
        if (upload != null) {
            //文件的上传
            //设置文件上传路径
            String uuidFileName = UploadUtils.getUuidFileName(uploadFileName);
            lunwen.setLw_imagename(uuidFileName);
            String path = "D:\\WorkSpace\\IDEA_WorkSpace\\psy\\web\\upload\\lunwen\\" + uuidFileName;
            File dictFile = new File(path);
            FileUtils.copyFile(upload, dictFile);
            //设置image属性值
            lunwen.setLw_image(path);
        }
        //保存论文
        lunWenService.save(lunwen);
        System.out.println("论文信息：" + lunwen);
        return "saveSuccess";
    }

    /**
     * 删除论文的方法
     */
    public String delete() {
        //先查询，再删除
        lunwen = lunWenService.findById(lunwen.getLw_id());
        //删除图片
        if (lunwen.getLw_image() != null) {
            File file = new File(lunwen.getLw_image());
            if (file.exists()) {
                //如果存在
                file.delete();
            }
        }
        //删除论文
        lunWenService.delete(lunwen);
        return "deleteSuccess";
    }

    /**
     * 编辑论文的方法：edit()
     */
    public String edit() {
        lunwen = lunWenService.findById(lunwen.getLw_id());
        return "editSuccess";
    }

    /**
     * 修改论文的方法：update()
     */
    public String update() throws IOException {
        //文件项是否已经选择，如果选择了，删除原有文件，如果没有选，那就是用原有的即可
        if (upload != null) {
            //已经选择了
            //删除原有文件
            String lw_image = lunwen.getLw_image();
            if (lw_image != null || "".equals(lw_image)) {
                File file = new File(lw_image);
                file.delete();
            }
            //文件上传
            String uuidFileName = UploadUtils.getUuidFileName(uploadFileName);
            lunwen.setLw_imagename(uuidFileName);
            String path = "D:\\WorkSpace\\IDEA_WorkSpace\\crm\\web\\upload\\lw\\" + uuidFileName;
            File dictFile = new File(path);
            FileUtils.copyFile(upload, dictFile);
            //设置image属性值
            lunwen.setLw_image(path);
        }
        lunWenService.update(lunwen);
        return "updateSuccess";
    }

    /**
     * 教师审核时的论文列表getAll()
     */
    public String getlunwenAll() {
        //接收参数：分页参数
        //最好使用DetachedCriteria对象（条件查询--带分页）方便
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(LunWen.class);
        //设置条件()
        if (lunwen.getLw_name() != null) {
            //设置按名称查询条件
            detachedCriteria.add(Restrictions.like("lw_name", "%" + lunwen.getLw_name() + "%"));
        }
        //设置审核条件
        if (lunwen.getLw_shenhe() != null && !"".equals(lunwen.getLw_shenhe())) {
            detachedCriteria.add(Restrictions.eq("lw_shenhe", lunwen.getLw_shenhe()));
        }
        //设置编号条件
        if (lunwen.getLw_bianhao() != null && !"".equals(lunwen.getLw_bianhao())) {
            detachedCriteria.add(Restrictions.eq("lw_bianhao", lunwen.getLw_bianhao()));
        }
        //调用业务层去查询
        PageBean<LunWen> pageBean = lunWenService.findByPage(detachedCriteria, currPage, pageSize);
        ActionContext.getContext().getValueStack().push(pageBean);
        System.out.println(pageBean);
        return "getlunwenAll";
    }

    /**
     * 论文审核跳转
     */
    public String shenheUI() {
        lunwen = lunWenService.findById(lunwen.getLw_id());
        return "shenheUI";
    }

    /**
     * 论文下载
     */
    private String fileName;
    private InputStream inputStream;
    private String contentType;

    public String execute() throws IOException {
        String path = ServletActionContext.getRequest().getSession().getServletContext().getRealPath("/upload/lunwen/");
        inputStream = new FileInputStream(new File(path, fileName));
        System.out.println("path---" + path);
        System.out.println("fileName---" + fileName);
        return SUCCESS;
    }

    //获取文件流
    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    /**
     * 论文审核
     */
    public String lunwenshenhe() {
        lunWenService.update(lunwen);
        return "lunwenshenheSuccess";
    }

    /**
     * 导出Excel表格
     */
    public void exportExcel() throws IOException {
        //创建文件
        HSSFWorkbook workbook = new HSSFWorkbook();
        //创建sheet
        HSSFSheet sheet = workbook.createSheet("论文数据");
        //创建标题行
        HSSFRow row = sheet.createRow(0);
        row.createCell(0).setCellValue("论文编号");
        row.createCell(1).setCellValue("论文名称");
        row.createCell(2).setCellValue("第一作者");
        row.createCell(3).setCellValue("第二作者");
        row.createCell(4).setCellValue("论文页码");
        row.createCell(5).setCellValue("刊物名称");
        row.createCell(6).setCellValue("卷号");
        row.createCell(7).setCellValue("资金资助");
        row.createCell(8).setCellValue("检索类型");
        row.createCell(9).setCellValue("审核状态");

        //查数据
        List<LunWen> lunWens = lunWenService.findAll();
        for (LunWen lw : lunWens) {
            if (lw.getStu_lunwen_id() == ActionContext.getContext().getSession().get("stu_id")) {
                row = sheet.createRow(sheet.getLastRowNum() + 1);
                row.createCell(0).setCellValue(lw.getLw_bianhao());
                row.createCell(1).setCellValue(lw.getLw_name());
                row.createCell(2).setCellValue(lw.getLw_zuozhe1());
                row.createCell(3).setCellValue(lw.getLw_zuozhe2());
                row.createCell(4).setCellValue(lw.getLw_yema());
                row.createCell(5).setCellValue(lw.getLw_kanwu());
                row.createCell(6).setCellValue(lw.getLw_juanhao());
                row.createCell(7).setCellValue(lw.getLw_zizhu());
                row.createCell(8).setCellValue(lw.getLw_jiansuo());
                row.createCell(9).setCellValue(lw.getLw_shenhe());
            }
        }

        //响应
        HttpServletResponse response = ServletActionContext.getResponse();

        //设置响应头
        String fileName = URLEncoder.encode(ActionContext.getContext().getSession().get("stu_name") + "的论文数据.xls", "utf-8");
        response.setHeader("Content-Disposition", "attachment;filename*=utf-8'zh_cn'" + fileName);
        String contentType = ServletActionContext.getServletContext().getMimeType(fileName);
        response.setContentType(contentType);

        //输出
        OutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
    }

    /**
     * 论文图表页面跳转
     */
    public String tubiaoUI() {
        return "tubiaoUI";
    }

    /**
     * 论文图表
     */
    public String tubiao() throws IOException {
        List<LunWen> lunWenList = lunWenService.findAll();
        for (LunWen lunWen : lunWenList) {
            if (lunWen.getStu_lunwen_id() == ActionContext.getContext().getSession().get("stu_id")) {
                tubiao_lunwen_list = lunWenService.findAll();
            }
        }
        //将list转成JSON ----jsonlib
        JsonConfig jsonConfig = new JsonConfig();
        //不想要的值
        jsonConfig.setExcludes(new String[]{"lw_id", "lw_bianhao", "lw_zuozhe1", "lw_zuozhe2", "lw_jiaocai", "lw_kanwu", "lw_juanhao", "lw_zizhu", "lw_jiansuo", "lw_shenhe", "lw_image", "lw_imagename", "stu_lunwen_id", "student"});
        String lw_json = JSONArray.fromObject(tubiao_lunwen_list, jsonConfig).toString();
        System.out.println("论文json---" + lw_json);
        //将JSON打印到页面上
        ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");
        ServletActionContext.getResponse().getWriter().print(lw_json);
        return null;
    }

    /**
     * 教师导出论文方法
     */
    public void tea_exportExcel() throws IOException {
        //创建文件
        HSSFWorkbook workbook = new HSSFWorkbook();
        //创建sheet
        HSSFSheet sheet = workbook.createSheet("论文数据");
        //创建标题行
        HSSFRow row = sheet.createRow(0);
        row.createCell(0).setCellValue("论文编号");
        row.createCell(1).setCellValue("论文名称");
        row.createCell(2).setCellValue("第一作者");
        row.createCell(3).setCellValue("第二作者");
        row.createCell(4).setCellValue("论文页码");
        row.createCell(5).setCellValue("刊物名称");
        row.createCell(6).setCellValue("卷号");
        row.createCell(7).setCellValue("资金资助");
        row.createCell(8).setCellValue("检索类型");
        row.createCell(9).setCellValue("审核状态");

        //查数据
        List<LunWen> lunWens = lunWenService.findAll();
        for (LunWen lw : lunWens) {
            row = sheet.createRow(sheet.getLastRowNum() + 1);
            row.createCell(0).setCellValue(lw.getLw_bianhao());
            row.createCell(1).setCellValue(lw.getLw_name());
            row.createCell(2).setCellValue(lw.getLw_zuozhe1());
            row.createCell(3).setCellValue(lw.getLw_zuozhe2());
            row.createCell(4).setCellValue(lw.getLw_yema());
            row.createCell(5).setCellValue(lw.getLw_kanwu());
            row.createCell(6).setCellValue(lw.getLw_juanhao());
            row.createCell(7).setCellValue(lw.getLw_zizhu());
            row.createCell(8).setCellValue(lw.getLw_jiansuo());
            row.createCell(9).setCellValue(lw.getLw_shenhe());
        }

        //响应
        HttpServletResponse response = ServletActionContext.getResponse();

        //设置响应头
        String fileName = URLEncoder.encode("论文数据.xls", "utf-8");
        response.setHeader("Content-Disposition", "attachment;filename*=utf-8'zh_cn'" + fileName);
        String contentType = ServletActionContext.getServletContext().getMimeType(fileName);
        response.setContentType(contentType);

        //输出
        OutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
    }


}
