package com.psy.test.web.action;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.psy.test.model.Mark;
import com.psy.test.model.PageBean;
import com.psy.test.model.Student;
import com.psy.test.model.XueShu;
import com.psy.test.service.MarkService;
import com.psy.test.service.StudentService;
import com.psy.test.service.XueShuService;
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

public class XueShuAction extends ActionSupport implements ModelDriven<XueShu> {
    XueShu xueshu = new XueShu();

    @Override
    public XueShu getModel() {
        return xueshu;
    }

    private XueShuService xueShuService;
    private StudentService studentService;
    private MarkService markService;

    public void setMarkService(MarkService markService) {
        this.markService = markService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public void setXueShuService(XueShuService xueShuService) {
        this.xueShuService = xueShuService;
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
    private Integer leixing = 0;
    private Integer lunwen = 0;
    private Integer teyao = 0;
    private Integer zizhu = 0;
    private Integer shenhe = 0;
    private Integer guoji = 0;
    private Integer guonei = 0;
    private Integer lwtijiao = 0;
    private Integer lwweitijiao = 0;
    private Integer bgtijiao = 0;
    private Integer bgweitijiao = 0;
    private Integer ziijinzizhu = 0;
    private Integer weizizhu = 0;
    private Integer tongguo = 0;
    private Integer weitongguo = 0;

    /**
     * 分页查询所有的方法
     */
    public String findAll() {
        //接收参数：分页参数
        //最好使用DetachedCriteria对象（条件查询--带分页）方便
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(XueShu.class);
        //设置条件()
        if (xueshu.getXs_huiyimingcheng() != null) {
            //设置按名称查询条件
            detachedCriteria.add(Restrictions.like("xs_huiyimingcheng", "%" + xueshu.getXs_huiyimingcheng() + "%"));
        }
        //设置参会人条件
        if (xueshu.getXs_canhuiren() != null && !"".equals(xueshu.getXs_canhuiren())) {
            detachedCriteria.add(Restrictions.eq("xs_canhuiren", xueshu.getXs_canhuiren()));
        }
        //设置会议类型条件
        if (xueshu.getXs_huiyileixing() != null && !"".equals(xueshu.getXs_huiyileixing())) {
            detachedCriteria.add(Restrictions.eq("xs_huiyileixing", xueshu.getXs_huiyileixing()));
        }
        //设置审核条件
        if (xueshu.getXs_shenhe() != null && !"".equals(xueshu.getXs_shenhe())) {
            detachedCriteria.add(Restrictions.eq("xs_shenhe", xueshu.getXs_shenhe()));
        }
        //调用业务层去查询
        PageBean<XueShu> pageBean = xueShuService.findByPage(detachedCriteria, currPage, pageSize);
        ActionContext.getContext().getValueStack().push(pageBean);

        List<XueShu> list = pageBean.getList();
        List<Mark> marks = markService.findAll();
        for (XueShu newXueshu : list) {
            if (newXueshu.getStu_xueshu_id() == ActionContext.getContext().getSession().get("stu_id")) {

                for (Mark mark:marks){
                    guoji = Integer.parseInt(mark.getXs_mark_leixing_guonei());
                    guonei = Integer.parseInt(mark.getXs_mark_leixing_guoji());
                    lwtijiao = Integer.parseInt(mark.getXs_mark_lunwen_tijiao());
                    lwweitijiao = Integer.parseInt(mark.getXs_mark_lunwen_weitijiao());
                    bgtijiao = Integer.parseInt(mark.getXs_mark_baogao_tijiao());
                    bgweitijiao = Integer.parseInt(mark.getXs_mark_baogao_weitijiao());
                    ziijinzizhu = Integer.parseInt(mark.getXs_mark_zijinzizhu_zizhu());
                    weizizhu = Integer.parseInt(mark.getXs_mark_zijinzizhu_weizizhu());
                    tongguo = Integer.parseInt(mark.getXs_mark_shenhe_tongguo());
                    weitongguo = Integer.parseInt(mark.getXs_mark_shenhe_weitongguo());
                }

                leixing = newXueshu.getXs_huiyileixing().equals("国际") ? guoji : leixing;
                leixing = newXueshu.getXs_huiyileixing().equals("国内") ? guonei : leixing;
                lunwen = newXueshu.getXs_lunwentimu().equals("是") ? lwtijiao : lunwen;
                lunwen = newXueshu.getXs_lunwentimu().equals("否") ? lwweitijiao : lunwen;
                teyao = newXueshu.getXs_teyaobaogao().equals("是") ? bgtijiao : teyao;
                teyao = newXueshu.getXs_teyaobaogao().equals("否") ? bgweitijiao : teyao;
                zizhu = newXueshu.getXs_zijinzizhu().equals("是") ? ziijinzizhu : zizhu;
                zizhu = newXueshu.getXs_zijinzizhu().equals("否") ? weizizhu : zizhu;
                shenhe = newXueshu.getXs_shenhe().equals("审核通过") ? tongguo : shenhe;
                shenhe = newXueshu.getXs_shenhe().equals("未通过审核") ? weitongguo : shenhe;
                fenshu = leixing + lunwen + teyao + zizhu + shenhe;
                newXueshu.setXs_defen(fenshu);
                xueShuService.update(newXueshu);
            }
            ActionContext.getContext().getSession().put("newXueshu", newXueshu);
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
     * 保存学术交流的方法
     */
    public String save() throws IOException {
        //上传图片
        if (upload != null) {
            //文件的上传
            //设置文件上传路径
            String uuidFileName = UploadUtils.getUuidFileName(uploadFileName);
            xueshu.setXs_imagename(uuidFileName);
            String path = "D:\\WorkSpace\\IDEA_WorkSpace\\psy\\web\\upload\\xueshu\\" + uuidFileName;
            File dictFile = new File(path);
            FileUtils.copyFile(upload, dictFile);
            //设置image属性值
            xueshu.setXs_image(path);
        }
        //保存学术交流
        xueShuService.save(xueshu);
        return "saveSuccess";
    }

    /**
     * 删除学术交流的方法
     */
    public String delete() {
        //先查询，再删除
        xueshu = xueShuService.findById(xueshu.getXs_id());
        //删除图片
        if (xueshu.getXs_image() != null) {
            File file = new File(xueshu.getXs_image());
            if (file.exists()) {
                //如果存在
                file.delete();
            }
        }
        //删除学术交流
        xueShuService.delete(xueshu);
        return "deleteSuccess";
    }

    /**
     * 编辑学术交流的方法：edit()
     */
    public String edit() {
        xueshu = xueShuService.findById(xueshu.getXs_id());
        return "editSuccess";
    }

    /**
     * 修改学术交流的方法：update()
     */
    public String update() throws IOException {
        //文件项是否已经选择，如果选择了，删除原有文件，如果没有选，那就是用原有的即可
        if (upload != null) {
            //已经选择了
            //删除原有文件
            String xs_image = xueshu.getXs_image();
            if (xs_image != null || "".equals(xs_image)) {
                File file = new File(xs_image);
                file.delete();
            }
            //文件上传
            String uuidFileName = UploadUtils.getUuidFileName(uploadFileName);
            xueshu.setXs_imagename(uuidFileName);
            String path = "D:\\WorkSpace\\IDEA_WorkSpace\\psy\\web\\upload\\xueshu\\" + uuidFileName;
            File dictFile = new File(path);
            FileUtils.copyFile(upload, dictFile);
            //设置image属性值
            xueshu.setXs_image(path);
        }
        xueShuService.update(xueshu);
        return "updateSuccess";
    }

    /**
     * getxueshuAll()
     */
    public String getxueshuAll() {
        //接收参数：分页参数
        //最好使用DetachedCriteria对象（条件查询--带分页）方便
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(XueShu.class);
        //设置条件()
        if (xueshu.getXs_huiyimingcheng() != null) {
            //设置按名称查询条件
            detachedCriteria.add(Restrictions.like("xs_huiyimingcheng", "%" + xueshu.getXs_huiyimingcheng() + "%"));
        }
        //设置参会人条件
        if (xueshu.getXs_canhuiren() != null && !"".equals(xueshu.getXs_canhuiren())) {
            detachedCriteria.add(Restrictions.eq("xs_canhuiren", xueshu.getXs_canhuiren()));
        }
        //设置会议类型条件
        if (xueshu.getXs_huiyileixing() != null && !"".equals(xueshu.getXs_huiyileixing())) {
            detachedCriteria.add(Restrictions.eq("xs_huiyileixing", xueshu.getXs_huiyileixing()));
        }
        //设置审核条件
        if (xueshu.getXs_shenhe() != null && !"".equals(xueshu.getXs_shenhe())) {
            detachedCriteria.add(Restrictions.eq("xs_shenhe", xueshu.getXs_shenhe()));
        }
        //调用业务层去查询
        PageBean<XueShu> pageBean = xueShuService.findByPage(detachedCriteria, currPage, pageSize);
        ActionContext.getContext().getValueStack().push(pageBean);
        System.out.println(pageBean);
        return "getxueshuAll";
    }

    /**
     * 审核跳转
     */
    public String shenheUI() {
        xueshu = xueShuService.findById(xueshu.getXs_id());
        return "shenheUI";
    }


    /**
     * 审核
     */
    public String xueshushenhe() {
        xueShuService.update(xueshu);
        return "xueshushenheSuccess";
    }

    /**
     * 导出Excel表格
     */
    public void exportExcel() throws IOException {
        //创建文件
        HSSFWorkbook workbook = new HSSFWorkbook();
        //创建sheet
        HSSFSheet sheet = workbook.createSheet("学术交流数据");
        //创建标题行
        HSSFRow row = sheet.createRow(0);
        row.createCell(0).setCellValue("参会人");
        row.createCell(1).setCellValue("会议名称");
        row.createCell(2).setCellValue("主办单位");
        row.createCell(3).setCellValue("会议类型");
        row.createCell(4).setCellValue("学科门类");
        row.createCell(5).setCellValue("参会地址");
        row.createCell(6).setCellValue("论文提交");
        row.createCell(7).setCellValue("特邀报告");
        row.createCell(8).setCellValue("论文题目");
        row.createCell(9).setCellValue("报告题目");
        row.createCell(10).setCellValue("基金资助");
        row.createCell(11).setCellValue("资助金额");
        row.createCell(12).setCellValue("审核状态");

        //查数据
        List<XueShu> xueShus = xueShuService.findAll();
        for (XueShu xs : xueShus) {
            if (xs.getStu_xueshu_id() == ActionContext.getContext().getSession().get("stu_id")) {
                row = sheet.createRow(sheet.getLastRowNum() + 1);
                row.createCell(0).setCellValue(xs.getXs_canhuiren());
                row.createCell(1).setCellValue(xs.getXs_huiyimingcheng());
                row.createCell(2).setCellValue(xs.getXs_zhubandanwei());
                row.createCell(3).setCellValue(xs.getXs_huiyileixing());
                row.createCell(4).setCellValue(xs.getXs_xuekemenlei());
                row.createCell(5).setCellValue(xs.getXs_canhuidizhi());
                row.createCell(6).setCellValue(xs.getXs_tijiaolunwen());
                row.createCell(7).setCellValue(xs.getXs_teyaobaogao());
                row.createCell(8).setCellValue(xs.getXs_lunwentimu());
                row.createCell(9).setCellValue(xs.getXs_baogaotimu());
                row.createCell(10).setCellValue(xs.getXs_zijinzizhu());
                row.createCell(11).setCellValue(xs.getXs_zizhujine());
                row.createCell(12).setCellValue(xs.getXs_shenhe());
            }
        }

        //响应
        HttpServletResponse response = ServletActionContext.getResponse();

        //设置响应头
        String fileName = URLEncoder.encode(ActionContext.getContext().getSession().get("stu_name") + "的学术交流数据.xls", "utf-8");
        response.setHeader("Content-Disposition", "attachment;filename*=utf-8'zh_cn'" + fileName);
        String contentType = ServletActionContext.getServletContext().getMimeType(fileName);
        response.setContentType(contentType);

        //输出
        OutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
    }

    /**
     * 学术下载
     */
    private String fileName;
    private InputStream inputStream;
    private String contentType;

    public String execute() throws IOException {
        String path = ServletActionContext.getRequest().getSession().getServletContext().getRealPath("/upload/xueshu/");
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

    private List<XueShu> tubiao_xueshu_list = null;

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
        List<XueShu> xueShuList = xueShuService.findAll();
        for (XueShu xueShu : xueShuList) {
            if (xueShu.getStu_xueshu_id() == ActionContext.getContext().getSession().get("stu_id")) {
                tubiao_xueshu_list = xueShuService.findAll();
            }
        }
        //将list转成JSON ----jsonlib
        JsonConfig jsonConfig = new JsonConfig();
        //不想要的值
        jsonConfig.setExcludes(new String[]{"xs_id", "xs_canhuiren", "xs_zhubandanwei", "xs_huiyileixing", "xs_xuekemenlei", "xs_canhuidizhi", "xs_tijiaolunwen", "xs_teyaobaogao", "xs_lunwentimu", "xs_baogaotimu", "xs_zijinzizhu", "xs_shenhe", "xs_image", "xs_imagename", "stu_xueshu_id", "student"});
        String xs_json = JSONArray.fromObject(tubiao_xueshu_list, jsonConfig).toString();
        System.out.println("学术json---" + xs_json);
        //将JSON打印到页面上
        ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");
        ServletActionContext.getResponse().getWriter().print(xs_json);
        return null;
    }

    /**
     * 教师导出学术
     */
    public void tea_exportExcel() throws IOException {
        //创建文件
        HSSFWorkbook workbook = new HSSFWorkbook();
        //创建sheet
        HSSFSheet sheet = workbook.createSheet("学术交流数据");
        //创建标题行
        HSSFRow row = sheet.createRow(0);
        row.createCell(0).setCellValue("参会人");
        row.createCell(1).setCellValue("会议名称");
        row.createCell(2).setCellValue("主办单位");
        row.createCell(3).setCellValue("会议类型");
        row.createCell(4).setCellValue("学科门类");
        row.createCell(5).setCellValue("参会地址");
        row.createCell(6).setCellValue("论文提交");
        row.createCell(7).setCellValue("特邀报告");
        row.createCell(8).setCellValue("论文题目");
        row.createCell(9).setCellValue("报告题目");
        row.createCell(10).setCellValue("基金资助");
        row.createCell(11).setCellValue("资助金额");
        row.createCell(12).setCellValue("审核状态");

        //查数据
        List<XueShu> xueShus = xueShuService.findAll();
        for (XueShu xs : xueShus) {
            row = sheet.createRow(sheet.getLastRowNum() + 1);
            row.createCell(0).setCellValue(xs.getXs_canhuiren());
            row.createCell(1).setCellValue(xs.getXs_huiyimingcheng());
            row.createCell(2).setCellValue(xs.getXs_zhubandanwei());
            row.createCell(3).setCellValue(xs.getXs_huiyileixing());
            row.createCell(4).setCellValue(xs.getXs_xuekemenlei());
            row.createCell(5).setCellValue(xs.getXs_canhuidizhi());
            row.createCell(6).setCellValue(xs.getXs_tijiaolunwen());
            row.createCell(7).setCellValue(xs.getXs_teyaobaogao());
            row.createCell(8).setCellValue(xs.getXs_lunwentimu());
            row.createCell(9).setCellValue(xs.getXs_baogaotimu());
            row.createCell(10).setCellValue(xs.getXs_zijinzizhu());
            row.createCell(11).setCellValue(xs.getXs_zizhujine());
            row.createCell(12).setCellValue(xs.getXs_shenhe());

        }

        //响应
        HttpServletResponse response = ServletActionContext.getResponse();

        //设置响应头
        String fileName = URLEncoder.encode("学术交流数据.xls", "utf-8");
        response.setHeader("Content-Disposition", "attachment;filename*=utf-8'zh_cn'" + fileName);
        String contentType = ServletActionContext.getServletContext().getMimeType(fileName);
        response.setContentType(contentType);

        //输出
        OutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
    }

}
