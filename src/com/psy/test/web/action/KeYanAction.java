package com.psy.test.web.action;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.psy.test.model.KeYan;
import com.psy.test.model.Mark;
import com.psy.test.model.PageBean;
import com.psy.test.model.Student;
import com.psy.test.service.KeYanService;
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
import java.util.List;

public class KeYanAction extends ActionSupport implements ModelDriven<KeYan> {
    //注入模型驱动
    private KeYan keyan = new KeYan();

    @Override
    public KeYan getModel() {
        return keyan;
    }

    //注入service
    private KeYanService keYanService;
    private StudentService studentService;
    private MarkService markService;

    public void setMarkService(MarkService markService) {
        this.markService = markService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public void setKeYanService(KeYanService keYanService) {
        this.keYanService = keYanService;
    }

    //接收分页参数
    private Integer currPage = 1;
    private Integer pageSize = 6;

    public void setCurrPage(Integer currPage) {
        if (currPage == 0) {
            currPage = 1;
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
    private Integer leixing = 0;
    private Integer dengji = 0;
    private Integer shenhe = 0;
    private Integer yilei = 0;
    private Integer erlei = 0;
    private Integer fudaoyuan = 0;
    private Integer guojiaji = 0;
    private Integer shentingji = 0;
    private Integer xiaoji = 0;
    private Integer tongguo = 0;
    private Integer weitongguo = 0;

    /**
     * 分页查询所有的方法
     */
    public String findAll() {
        //接收参数：分页参数
        //最好使用DetachedCriteria对象（条件查询--带分页）方便
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(KeYan.class);
        //设置条件()
        if (keyan.getKy_mingcheng() != null) {
            //设置按名称查询条件
            detachedCriteria.add(Restrictions.like("ky_mingcheng", "%" + keyan.getKy_mingcheng() + "%"));
        }
        //设置科研编号条件
        if (keyan.getKy_bianhao() != null && !"".equals(keyan.getKy_bianhao())) {
            detachedCriteria.add(Restrictions.eq("ky_bianhao", keyan.getKy_bianhao()));
        }
        //设置类型条件
        if (keyan.getKy_leixing() != null && !"".equals(keyan.getKy_leixing())) {
            detachedCriteria.add(Restrictions.eq("ky_leixing", keyan.getKy_leixing()));
        }
        //设置等级条件
        if (keyan.getKy_dengji() != null && !"".equals(keyan.getKy_dengji())) {
            detachedCriteria.add(Restrictions.eq("ky_dengji", keyan.getKy_dengji()));
        }
        //设置审核条件
        if (keyan.getKy_shenhe() != null && !"".equals(keyan.getKy_shenhe())) {
            detachedCriteria.add(Restrictions.eq("ky_shenhe", keyan.getKy_shenhe()));
        }
        //调用业务层去查询
        PageBean<KeYan> pageBean = keYanService.findByPage(detachedCriteria, currPage, pageSize);
        //将pagebean放入值栈中，方便前端页面获取
        ActionContext.getContext().getValueStack().push(pageBean);

        List<KeYan> list = pageBean.getList();
        List<Mark> marks = markService.findAll();
        for (KeYan newKeyan : list) {
            if (newKeyan.getStu_keyan_id() == ActionContext.getContext().getSession().get("stu_id")) {

                for (Mark mark : marks) {
                    yilei = Integer.parseInt(mark.getKy_mark_leixing_yilei());
                    erlei = Integer.parseInt(mark.getKy_mark_leixing_erlei());
                    fudaoyuan = Integer.parseInt(mark.getKy_mark_leixing_fudaoyuan());
                    guojiaji = Integer.parseInt(mark.getKy_mark_dengji_guojiaji());
                    shentingji = Integer.parseInt(mark.getKy_mark_dengji_shentingji());
                    xiaoji = Integer.parseInt(mark.getKy_mark_dengji_xiaoji());
                    tongguo = Integer.parseInt(mark.getKy_mark_shenhe_tongguo());
                    weitongguo = Integer.parseInt(mark.getKy_mark_shenhe_weitongguo());
                }

                leixing = newKeyan.getKy_leixing().equals("一类") ? yilei : leixing;
                leixing = newKeyan.getKy_leixing().equals("二类") ? erlei : leixing;
                leixing = newKeyan.getKy_leixing().equals("辅导员专项") ? fudaoyuan : leixing;
                dengji = newKeyan.getKy_dengji().equals("国家级") ? guojiaji : dengji;
                dengji = newKeyan.getKy_dengji().equals("省厅级") ? shentingji : dengji;
                dengji = newKeyan.getKy_dengji().equals("校级") ? xiaoji : dengji;
                shenhe = newKeyan.getKy_shenhe().equals("审核通过") ? tongguo : shenhe;
                shenhe = newKeyan.getKy_shenhe().equals("未通过审核") ? weitongguo : shenhe;
                fenshu = leixing + dengji + shenhe;
                newKeyan.setKy_defen(fenshu);
                keYanService.update(newKeyan);
            }
            System.out.println("得分" + newKeyan.getKy_defen());
            ActionContext.getContext().getSession().put("newKeyan", newKeyan);
        }
        System.out.println(pageBean);
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
     * 保存科研项目的方法
     */
    public String save() throws IOException {
        //上传图片
        if (upload != null) {
            //文件的上传
            //设置文件上传路径
            //调用文件上传工具类中的getUuidFileName方法，产生一个随机文件名
            String uuidFileName = UploadUtils.getUuidFileName(uploadFileName);
            keyan.setKy_imagename(uuidFileName);
            //设置文件存入路径，并加上随机文件名
            String path = "D:\\WorkSpace\\IDEA_WorkSpace\\psy\\web\\upload\\keyan\\" + uuidFileName;
            File dictFile = new File(path);
            FileUtils.copyFile(upload, dictFile);
            //设置image属性值
            keyan.setKy_image(path);
        }
        //保存科研项目
        keYanService.save(keyan);
        return "saveSuccess";
    }

    /**
     * 删除科研项目的方法
     */
    public String delete() {
        //先查询，再删除
        keyan = keYanService.findById(keyan.getKy_id());
        //删除图片
        if (keyan.getKy_image() != null) {
            File file = new File(keyan.getKy_image());
            if (file.exists()) {
                //如果存在
                file.delete();
            }
        }
        //删除科研项目
        keYanService.delete(keyan);
        return "deleteSuccess";
    }

    /**
     * 编辑科研项目的方法：edit()
     */
    public String edit() {
        //调用service中的findbyid方法，查询该id，封装到对象中
        keyan = keYanService.findById(keyan.getKy_id());
        return "editSuccess";
    }

    /**
     * 修改科研项目的方法：update()
     */
    public String update() throws IOException {
        //文件项是否已经选择，如果选择了，删除原有文件，如果没有选，那就是用原有的即可
        if (upload != null) {
            //已经选择了
            //删除原有文件
            String ky_image = keyan.getKy_image();
            if (ky_image != null || "".equals(ky_image)) {
                File file = new File(ky_image);
                file.delete();
            }
            //文件上传
            String uuidFileName = UploadUtils.getUuidFileName(uploadFileName);
            keyan.setKy_imagename(uuidFileName);
            String path = "D:\\WorkSpace\\IDEA_WorkSpace\\crm\\web\\upload\\ky\\" + uuidFileName;
            File dictFile = new File(path);
            FileUtils.copyFile(upload, dictFile);
            //设置image属性值
            keyan.setKy_image(path);
        }
        //调用service中的update方法，传入科研对象keyan
        keYanService.update(keyan);
        return "updateSuccess";
    }

    /**
     * 教师审核时的科研列表getkeyanAll()
     */
    public String getkeyanAll() {
        //接收参数：分页参数
        //最好使用DetachedCriteria对象（条件查询--带分页）方便
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(KeYan.class);
        //设置条件()
        if (keyan.getKy_mingcheng() != null) {
            //设置按名称查询条件
            detachedCriteria.add(Restrictions.like("ky_mingcheng", "%" + keyan.getKy_mingcheng() + "%"));
        }
        //设置科研编号条件
        if (keyan.getKy_bianhao() != null && !"".equals(keyan.getKy_bianhao())) {
            detachedCriteria.add(Restrictions.eq("ky_bianhao", keyan.getKy_bianhao()));
        }
        //设置类型条件
        if (keyan.getKy_leixing() != null && !"".equals(keyan.getKy_leixing())) {
            detachedCriteria.add(Restrictions.eq("ky_leixing", keyan.getKy_leixing()));
        }
        //设置等级条件
        if (keyan.getKy_dengji() != null && !"".equals(keyan.getKy_dengji())) {
            detachedCriteria.add(Restrictions.eq("ky_dengji", keyan.getKy_dengji()));
        }
        //设置审核条件
        if (keyan.getKy_shenhe() != null && !"".equals(keyan.getKy_shenhe())) {
            detachedCriteria.add(Restrictions.eq("ky_shenhe", keyan.getKy_shenhe()));
        }
        //调用业务层去查询
        PageBean<KeYan> pageBean = keYanService.findByPage(detachedCriteria, currPage, pageSize);
        ActionContext.getContext().getValueStack().push(pageBean);
        System.out.println(pageBean);
        return "getkeyanAll";
    }

    /**
     * 科研审核跳转
     */
    public String shenheUI() {
        keyan = keYanService.findById(keyan.getKy_id());
        return "shenheUI";
    }

    /**
     * 科研审核
     */
    public String keyanshenhe() {
        keYanService.update(keyan);
        return "keyanshenheSuccess";
    }

    /**
     * 导出Excel表格
     */
    public void exportExcel() throws IOException {
        //创建文件
        HSSFWorkbook workbook = new HSSFWorkbook();
        //创建sheet
        HSSFSheet sheet = workbook.createSheet("科研数据");
        //创建标题行
        HSSFRow row = sheet.createRow(0);
        row.createCell(0).setCellValue("项目编号");
        row.createCell(1).setCellValue("项目名称");
        row.createCell(2).setCellValue("项目负责人");
        row.createCell(3).setCellValue("项目来源");
        row.createCell(4).setCellValue("项目类型");
        row.createCell(5).setCellValue("项目等级");
        row.createCell(6).setCellValue("项目经费");
        row.createCell(7).setCellValue("主要任务");
        row.createCell(8).setCellValue("审核状态");

        //查数据
        List<KeYan> keYans = keYanService.findAll();
        for (KeYan ky : keYans) {
            if (ky.getStu_keyan_id() == ActionContext.getContext().getSession().get("stu_id")) {
                row = sheet.createRow(sheet.getLastRowNum() + 1);
                row.createCell(0).setCellValue(ky.getKy_bianhao());
                row.createCell(1).setCellValue(ky.getKy_mingcheng());
                row.createCell(2).setCellValue(ky.getKy_fuzeren());
                row.createCell(3).setCellValue(ky.getKy_laiyuan());
                row.createCell(4).setCellValue(ky.getKy_leixing());
                row.createCell(5).setCellValue(ky.getKy_dengji());
                row.createCell(6).setCellValue(ky.getKy_jingfei());
                row.createCell(7).setCellValue(ky.getKy_renwu());
                row.createCell(8).setCellValue(ky.getKy_shenhe());

            }
        }

        //响应
        HttpServletResponse response = ServletActionContext.getResponse();

        //设置响应头
        String fileName = URLEncoder.encode(ActionContext.getContext().getSession().get("stu_name") + "的科研数据.xls", "utf-8");
        response.setHeader("Content-Disposition", "attachment;filename*=utf-8'zh_cn'" + fileName);
        String contentType = ServletActionContext.getServletContext().getMimeType(fileName);
        response.setContentType(contentType);

        //输出
        OutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
    }

    /**
     * 科研下载
     */
    private String fileName;
    private InputStream inputStream;
    private String contentType;

    public String execute() throws IOException {
        String path = ServletActionContext.getRequest().getSession().getServletContext().getRealPath("/upload/keyan/");
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
     * 论文图表页面跳转
     */
    public String tubiaoUI() {
        return "tubiaoUI";
    }

    private List<KeYan> tubiao_keyan_list = null;

    /**
     * 科研图表功能
     */
    public String tubiao() throws IOException {
        List<KeYan> keYanList = keYanService.findAll();
        for (KeYan keYan : keYanList) {
            if (keYan.getStu_keyan_id() == ActionContext.getContext().getSession().get("stu_id")) {
                tubiao_keyan_list = keYanService.findAll();
            }
        }
        //将list转成JSON ----jsonlib
        JsonConfig jsonConfig = new JsonConfig();
        //不想要的值
        jsonConfig.setExcludes(new String[]{"ky_id", "ky_bianhao", "ky_fuzeren", "ky_laiyuan", "ky_leixing", "ky_jingfei", "ky_renwu", "ky_shenhe", "ky_imagename", "ky_image", "stu_keyan_id", "student"});
        String ky_json = JSONArray.fromObject(tubiao_keyan_list, jsonConfig).toString();
        System.out.println("科研json---" + ky_json);
        //将JSON打印到页面上
        ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");
        ServletActionContext.getResponse().getWriter().print(ky_json);
        return null;
    }

    /**
     * 教师导出科研
     */
    public void tea_exportExcel() throws IOException {
        //创建文件
        HSSFWorkbook workbook = new HSSFWorkbook();
        //创建sheet
        HSSFSheet sheet = workbook.createSheet("科研数据");
        //创建标题行
        HSSFRow row = sheet.createRow(0);
        row.createCell(0).setCellValue("项目编号");
        row.createCell(1).setCellValue("项目名称");
        row.createCell(2).setCellValue("项目负责人");
        row.createCell(3).setCellValue("项目来源");
        row.createCell(4).setCellValue("项目类型");
        row.createCell(5).setCellValue("项目等级");
        row.createCell(6).setCellValue("项目经费");
        row.createCell(7).setCellValue("主要任务");
        row.createCell(8).setCellValue("审核状态");

        //查数据
        List<KeYan> keYans = keYanService.findAll();
        for (KeYan ky : keYans) {
            row = sheet.createRow(sheet.getLastRowNum() + 1);
            row.createCell(0).setCellValue(ky.getKy_bianhao());
            row.createCell(1).setCellValue(ky.getKy_mingcheng());
            row.createCell(2).setCellValue(ky.getKy_fuzeren());
            row.createCell(3).setCellValue(ky.getKy_laiyuan());
            row.createCell(4).setCellValue(ky.getKy_leixing());
            row.createCell(5).setCellValue(ky.getKy_dengji());
            row.createCell(6).setCellValue(ky.getKy_jingfei());
            row.createCell(7).setCellValue(ky.getKy_renwu());
            row.createCell(8).setCellValue(ky.getKy_shenhe());
        }

        //响应
        HttpServletResponse response = ServletActionContext.getResponse();

        //设置响应头
        String fileName = URLEncoder.encode("科研数据.xls", "utf-8");
        response.setHeader("Content-Disposition", "attachment;filename*=utf-8'zh_cn'" + fileName);
        String contentType = ServletActionContext.getServletContext().getMimeType(fileName);
        response.setContentType(contentType);

        //输出
        OutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
    }
}
