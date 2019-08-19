package com.psy.test.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.psy.test.model.Mark;
import com.psy.test.model.PageBean;
import com.psy.test.model.Student;
import com.psy.test.model.ZhuanLi;
import com.psy.test.service.MarkService;
import com.psy.test.service.StudentService;
import com.psy.test.service.ZhuanLiService;
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

public class ZhuanLiAction extends ActionSupport implements ModelDriven<ZhuanLi> {
    private ZhuanLi zhuanli = new ZhuanLi();
    private Student student = new Student();

    public Student getStudent() {
        return student;
    }

    @Override
    public ZhuanLi getModel() {
        return zhuanli;
    }

    private ZhuanLiService zhuanLiService;
    private StudentService studentService;
    private MarkService markService;

    public void setMarkService(MarkService markService) {
        this.markService = markService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public void setZhuanLiService(ZhuanLiService zhuanLiService) {
        this.zhuanLiService = zhuanLiService;
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
     * 分数四个属性
     */
    private Integer fenshu = 0;
    private Integer fanwei = 0;
    private Integer zhuangtai = 0;
    private Integer shenhe = 0;
    private Integer guonei = 0;
    private Integer guoji = 0;
    private Integer shenqing = 0;
    private Integer gongkai = 0;
    private Integer shouquan = 0;
    private Integer shixiao = 0;
    private Integer tongguo = 0;
    private Integer weitongguo = 0;

    /**
     * 分页查询所有的方法
     */
    public String findAll() {
        //接收参数：分页参数
        //最好使用DetachedCriteria对象（条件查询--带分页）方便
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ZhuanLi.class);
        //设置条件()
        if (zhuanli.getZl_mingcheng() != null) {
            //设置按名称查询条件
            detachedCriteria.add(Restrictions.like("zl_mingcheng", "%" + zhuanli.getZl_mingcheng() + "%"));
        }
        if (zhuanli.getZl_famingren() != null && !"".equals(zhuanli.getZl_famingren())) {
            detachedCriteria.add(Restrictions.eq("zl_famingren", zhuanli.getZl_famingren()));
        }
        if (zhuanli.getZl_leixing() != null && !"".equals(zhuanli.getZl_leixing())) {
            detachedCriteria.add(Restrictions.eq("zl_leixing", zhuanli.getZl_leixing()));
        }
        if (zhuanli.getZl_fanwei() != null && !"".equals(zhuanli.getZl_fanwei())) {
            detachedCriteria.add(Restrictions.eq("zl_fanwei", zhuanli.getZl_fanwei()));
        }
        if (zhuanli.getZl_zhuangtai() != null && !"".equals(zhuanli.getZl_zhuangtai())) {
            detachedCriteria.add(Restrictions.eq("zl_zhuangtai", zhuanli.getZl_zhuangtai()));
        }
        if (zhuanli.getZl_shenhe() != null && !"".equals(zhuanli.getZl_shenhe())) {
            detachedCriteria.add(Restrictions.eq("zl_shenhe", zhuanli.getZl_shenhe()));
        }
        //调用业务层去查询
        PageBean<ZhuanLi> pageBean = zhuanLiService.findByPage(detachedCriteria, currPage, pageSize);
        ActionContext.getContext().getValueStack().push(pageBean);

        List<ZhuanLi> list = pageBean.getList();
        List<Mark> marks = markService.findAll();
        for (ZhuanLi newZhuanli : list) {
            if (newZhuanli.getStu_zhuanli_id() == ActionContext.getContext().getSession().get("stu_id")) {

                for (Mark mark : marks) {
                    guoji = Integer.parseInt(mark.getZl_mark_fanwei_guoji());
                    guonei = Integer.parseInt(mark.getZl_mark_fanwei_guonei());
                    gongkai = Integer.parseInt(mark.getZl_mark_zhuangtai_gongkai());
                    shouquan = Integer.parseInt(mark.getZl_mark_zhuangtai_shouquan());
                    shenqing = Integer.parseInt(mark.getZl_mark_zhuangtai_shenqing());
                    shixiao = Integer.parseInt(mark.getZl_mark_zhuangtai_shixiao());
                    tongguo = Integer.parseInt(mark.getZl_mark_shenhe_tongguo());
                    weitongguo = Integer.parseInt(mark.getZl_mark_shenhe_weitongguo());
                }

                fanwei = newZhuanli.getZl_fanwei().equals("国外") ? guoji : fanwei;
                fanwei = newZhuanli.getZl_fanwei().equals("国内") ? guonei : fanwei;
                zhuangtai = newZhuanli.getZl_zhuangtai().equals("专利公开") ? gongkai : zhuangtai;
                zhuangtai = newZhuanli.getZl_zhuangtai().equals("专利授权") ? shouquan : zhuangtai;
                zhuangtai = newZhuanli.getZl_zhuangtai().equals("专利申请") ? shenqing : zhuangtai;
                zhuangtai = newZhuanli.getZl_zhuangtai().equals("专利失效") ? shixiao : zhuangtai;
                shenhe = newZhuanli.getZl_shenhe().equals("审核通过") ? tongguo : shenhe;
                shenhe = newZhuanli.getZl_shenhe().equals("未通过审核") ? weitongguo : shenhe;
                fenshu = fanwei + zhuangtai + shenhe;
                newZhuanli.setZl_defen(fenshu);
                zhuanLiService.update(newZhuanli);
            }
            ActionContext.getContext().getSession().put("newZhuanli", newZhuanli);
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
     * 保存专利的方法
     */
    public String save() throws IOException {
        //上传图片
        if (upload != null) {
            //文件的上传
            //设置文件上传路径
            String uuidFileName = UploadUtils.getUuidFileName(uploadFileName);
            zhuanli.setZl_imagename(uuidFileName);
            String path = "D:\\WorkSpace\\IDEA_WorkSpace\\psy\\web\\upload\\zhuanli\\" + uuidFileName;
            File dictFile = new File(path);
            FileUtils.copyFile(upload, dictFile);
            //设置image属性值
            zhuanli.setZl_image(path);
        }
        //保存专利
        zhuanLiService.save(zhuanli);
        System.out.println("专利信息：" + zhuanli);
        return "saveSuccess";
    }

    /**
     * 删除专利的方法
     */
    public String delete() {
        //先查询，再删除
        zhuanli = zhuanLiService.findById(zhuanli.getZl_id());
        //删除图片
        if (zhuanli.getZl_image() != null) {
            File file = new File(zhuanli.getZl_image());
            if (file.exists()) {
                //如果存在
                file.delete();
            }
        }
        //删除专利
        zhuanLiService.delete(zhuanli);
        return "deleteSuccess";
    }

    /**
     * 编辑专利的方法：edit()
     */
    public String edit() {
        zhuanli = zhuanLiService.findById(zhuanli.getZl_id());
        return "editSuccess";
    }

    /**
     * 修改专利的方法：update()
     */
    public String update() throws IOException {
        //文件项是否已经选择，如果选择了，删除原有文件，如果没有选，那就是用原有的即可
        if (upload != null) {
            //已经选择了
            //删除原有文件
            String zl_image = zhuanli.getZl_image();
            if (zl_image != null || "".equals(zl_image)) {
                File file = new File(zl_image);
                file.delete();
            }
            //文件上传
            String uuidFileName = UploadUtils.getUuidFileName(uploadFileName);
            zhuanli.setZl_imagename(uuidFileName);
            String path = "D:\\WorkSpace\\IDEA_WorkSpace\\psy\\web\\upload\\zhuanli\\" + uuidFileName;
            File dictFile = new File(path);
            FileUtils.copyFile(upload, dictFile);
            //设置image属性值
            zhuanli.setZl_image(path);
        }
        zhuanLiService.update(zhuanli);
        return "updateSuccess";
    }

    /**
     * getzhuanliAll()
     */
    public String getzhuanliAll() {
        //接收参数：分页参数
        //最好使用DetachedCriteria对象（条件查询--带分页）方便
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ZhuanLi.class);
        //设置条件()
        if (zhuanli.getZl_mingcheng() != null) {
            //设置按名称查询条件
            detachedCriteria.add(Restrictions.like("zl_mingcheng", "%" + zhuanli.getZl_mingcheng() + "%"));
        }
        if (zhuanli.getZl_famingren() != null && !"".equals(zhuanli.getZl_famingren())) {
            detachedCriteria.add(Restrictions.eq("zl_famingren", zhuanli.getZl_famingren()));
        }
        if (zhuanli.getZl_leixing() != null && !"".equals(zhuanli.getZl_leixing())) {
            detachedCriteria.add(Restrictions.eq("zl_leixing", zhuanli.getZl_leixing()));
        }
        if (zhuanli.getZl_fanwei() != null && !"".equals(zhuanli.getZl_fanwei())) {
            detachedCriteria.add(Restrictions.eq("zl_fanwei", zhuanli.getZl_fanwei()));
        }
        if (zhuanli.getZl_zhuangtai() != null && !"".equals(zhuanli.getZl_zhuangtai())) {
            detachedCriteria.add(Restrictions.eq("zl_zhuangtai", zhuanli.getZl_zhuangtai()));
        }
        if (zhuanli.getZl_shenhe() != null && !"".equals(zhuanli.getZl_shenhe())) {
            detachedCriteria.add(Restrictions.eq("zl_shenhe", zhuanli.getZl_shenhe()));
        }
        //调用业务层去查询
        PageBean<ZhuanLi> pageBean = zhuanLiService.findByPage(detachedCriteria, currPage, pageSize);
        ActionContext.getContext().getValueStack().push(pageBean);
        System.out.println(pageBean);
        return "getzhuanliAll";
    }

    /**
     * 审核跳转
     */
    public String shenheUI() {
        zhuanli = zhuanLiService.findById(zhuanli.getZl_id());
        return "shenheUI";
    }

    /**
     * 审核
     */
    public String zhuanlishenhe() {
        zhuanLiService.update(zhuanli);
        return "zhuanlishenheSuccess";
    }

    /**
     * 导出Excel表格
     */
    public void exportExcel() throws IOException {
        //创建文件
        HSSFWorkbook workbook = new HSSFWorkbook();
        //创建sheet
        HSSFSheet sheet = workbook.createSheet("专利数据");
        //创建标题行
        HSSFRow row = sheet.createRow(0);
        row.createCell(0).setCellValue("专利名称");
        row.createCell(1).setCellValue("专利类型");
        row.createCell(2).setCellValue("登记编号");
        row.createCell(3).setCellValue("专利范围");
        row.createCell(4).setCellValue("专利状态");
        row.createCell(5).setCellValue("学校署名");
        row.createCell(6).setCellValue("申请号");
        row.createCell(7).setCellValue("职务专利");
        row.createCell(8).setCellValue("发明人姓名");
        row.createCell(9).setCellValue("发明人单位");
        row.createCell(10).setCellValue("专利费用");
        row.createCell(11).setCellValue("审核状态");

        //查数据
        List<ZhuanLi> zhuanLis = zhuanLiService.findAll();
        for (ZhuanLi zl : zhuanLis) {
            if (zl.getStu_zhuanli_id() == ActionContext.getContext().getSession().get("stu_id")) {
                row = sheet.createRow(sheet.getLastRowNum() + 1);
                row.createCell(0).setCellValue(zl.getZl_mingcheng());
                row.createCell(1).setCellValue(zl.getZl_leixing());
                row.createCell(2).setCellValue(zl.getZl_dengjibianhao());
                row.createCell(3).setCellValue(zl.getZl_fanwei());
                row.createCell(4).setCellValue(zl.getZl_zhuangtai());
                row.createCell(5).setCellValue(zl.getZl_shuming());
                row.createCell(6).setCellValue(zl.getZl_shenqinghao());
                row.createCell(7).setCellValue(zl.getZl_zhiwu());
                row.createCell(8).setCellValue(zl.getZl_famingren());
                row.createCell(9).setCellValue(zl.getZl_famingrendanwei());
                row.createCell(10).setCellValue(zl.getZl_zhuanlifei());
                row.createCell(11).setCellValue(zl.getZl_shenhe());

            }
        }

        //响应
        HttpServletResponse response = ServletActionContext.getResponse();

        //设置响应头
        String fileName = URLEncoder.encode(ActionContext.getContext().getSession().get("stu_name") + "的专利信息数据.xls", "utf-8");
        response.setHeader("Content-Disposition", "attachment;filename*=utf-8'zh_cn'" + fileName);
        String contentType = ServletActionContext.getServletContext().getMimeType(fileName);
        response.setContentType(contentType);

        //输出
        OutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
    }

    /**
     * 专利下载
     */
    private String fileName;
    private InputStream inputStream;
    private String contentType;

    public String execute() throws IOException {
        String path = ServletActionContext.getRequest().getSession().getServletContext().getRealPath("/upload/zhuanli/");
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

    private List<ZhuanLi> tubiao_zhuanli_list = null;

    /**
     * 学术图表页面跳转
     */
    public String tubiaoUI() {
        return "tubiaoUI";
    }

    /**
     * 学术图表功能
     */
    public String tubiao() throws IOException {
        List<ZhuanLi> zhuanLiList = zhuanLiService.findAll();
        for (ZhuanLi zhuanLi : zhuanLiList) {
            if (zhuanLi.getStu_zhuanli_id() == ActionContext.getContext().getSession().get("stu_id")) {
                tubiao_zhuanli_list = zhuanLiService.findAll();
            }
        }
        //将list转成JSON ----jsonlib
        JsonConfig jsonConfig = new JsonConfig();
        //不想要的值
        jsonConfig.setExcludes(new String[]{"zl_id", "zl_leixing", "zl_dengjibianhao", "zl_fanwei", "zl_zhuangtai", "zl_shuming", "zl_shenqinghao", "zl_zhiwu", "zl_famingren", "zl_famingrendanwei", "zl_zhuanlifei", "zl_shenhe", "zl_image", "zl_imagename", "stu_zhuanli_id", "student"});
        String zl_json = JSONArray.fromObject(tubiao_zhuanli_list, jsonConfig).toString();
        System.out.println("专利json---" + zl_json);
        //将JSON打印到页面上
        ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");
        ServletActionContext.getResponse().getWriter().print(zl_json);
        return null;
    }

    /**
     * 教师Excel表格
     */
    public void tea_exportExcel() throws IOException {
        //创建文件
        HSSFWorkbook workbook = new HSSFWorkbook();
        //创建sheet
        HSSFSheet sheet = workbook.createSheet("专利数据");
        //创建标题行
        HSSFRow row = sheet.createRow(0);
        row.createCell(0).setCellValue("专利名称");
        row.createCell(1).setCellValue("专利类型");
        row.createCell(2).setCellValue("登记编号");
        row.createCell(3).setCellValue("专利范围");
        row.createCell(4).setCellValue("专利状态");
        row.createCell(5).setCellValue("学校署名");
        row.createCell(6).setCellValue("申请号");
        row.createCell(7).setCellValue("职务专利");
        row.createCell(8).setCellValue("发明人姓名");
        row.createCell(9).setCellValue("发明人单位");
        row.createCell(10).setCellValue("专利费用");
        row.createCell(11).setCellValue("审核状态");

        //查数据
        List<ZhuanLi> zhuanLis = zhuanLiService.findAll();
        for (ZhuanLi zl : zhuanLis) {
            row = sheet.createRow(sheet.getLastRowNum() + 1);
            row.createCell(0).setCellValue(zl.getZl_mingcheng());
            row.createCell(1).setCellValue(zl.getZl_leixing());
            row.createCell(2).setCellValue(zl.getZl_dengjibianhao());
            row.createCell(3).setCellValue(zl.getZl_fanwei());
            row.createCell(4).setCellValue(zl.getZl_zhuangtai());
            row.createCell(5).setCellValue(zl.getZl_shuming());
            row.createCell(6).setCellValue(zl.getZl_shenqinghao());
            row.createCell(7).setCellValue(zl.getZl_zhiwu());
            row.createCell(8).setCellValue(zl.getZl_famingren());
            row.createCell(9).setCellValue(zl.getZl_famingrendanwei());
            row.createCell(10).setCellValue(zl.getZl_zhuanlifei());
            row.createCell(11).setCellValue(zl.getZl_shenhe());

        }

        //响应
        HttpServletResponse response = ServletActionContext.getResponse();

        //设置响应头
        String fileName = URLEncoder.encode("专利信息数据.xls", "utf-8");
        response.setHeader("Content-Disposition", "attachment;filename*=utf-8'zh_cn'" + fileName);
        String contentType = ServletActionContext.getServletContext().getMimeType(fileName);
        response.setContentType(contentType);

        //输出
        OutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
    }

}
