package com.psy.test.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.psy.test.model.PageBean;
import com.psy.test.model.Teacher;
import com.psy.test.service.LunWenService;
import com.psy.test.service.TeacherService;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

public class TeacherAction extends ActionSupport implements ModelDriven<Teacher> {
    private Teacher teacher = new Teacher();

    @Override
    public Teacher getModel() {
        return teacher;
    }

    //注入Service
    private TeacherService teacherService;

    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
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
//==========================分割线==========================//

    /**
     * 跳转到添加页面的方法
     */
    public String saveUI() {
        return "saveUI";
    }

    /**
     * 保存教师的方法
     */
    public String save() {
        teacherService.save(teacher);
        return "saveSuccess";
    }

    /**
     * 分页查询所有的方法
     */
    public String findAll() {
        //接收参数：分页参数
        //最好使用DetachedCriteria对象（条件查询--带分页）方便
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Teacher.class);
        //设置条件()
        if (teacher.getTea_name() != null) {
            //设置按名称查询条件
            detachedCriteria.add(Restrictions.like("tea_name", "%" + teacher.getTea_name() + "%"));
        }
        //设置性别条件
        if (teacher.getTea_gender() != null && !"".equals(teacher.getTea_gender())) {
            detachedCriteria.add(Restrictions.eq("tea_gender", teacher.getTea_gender()));
        }
        //设置校区查询
        if (teacher.getTea_address() != null && !"".equals(teacher.getTea_address())) {
            detachedCriteria.add(Restrictions.eq("tea_address", teacher.getTea_address()));
        }
        //调用业务层去查询
        PageBean<Teacher> pageBean = teacherService.findByPage(detachedCriteria, currPage, pageSize);
        ActionContext.getContext().getValueStack().push(pageBean);
        System.out.println(pageBean);
        return "findAll";
    }

    /**
     * 编辑老师信息方法
     */
    public String edit() {
        teacher = teacherService.findById(teacher.getTea_id());
        return "editSuccess";
    }

    /**
     * 编辑老师修改的方法
     */
    public String update() {
        teacherService.update(teacher);
        return "updateSuccess";
    }

    /**
     * 删除老师的方法
     */
    public String delete() {
        teacher = teacherService.findById(teacher.getTea_id());
        teacherService.delete(teacher);
        return "deleteSuccess";
    }

    public void setTea_checkcode(String tea_checkcode) {
        this.tea_checkcode = tea_checkcode;
    }

    /**
     * 老师登录方法
     */
    private String tea_checkcode;
    public String login() {
        String rightcode = (String) ServletActionContext.getRequest().getSession().getAttribute("tea_checkcode");
        System.out.println("tea_rightcode----"+rightcode);
        System.out.println("tea_checkcode----"+tea_checkcode);
        if(tea_checkcode.equalsIgnoreCase(rightcode)){//验证码正确
            //2.调用service
            teacher = teacherService.login(teacher);
            //3.判断登录状态
            if(teacher != null){
                //System.out.println("登录成功");
                ActionContext.getContext().getSession().put("teacher", teacher);
                ActionContext.getContext().getSession().put("tea_id",teacher.getTea_id());
                return "loginSuccess";//主页面-后台页面
            }else{
                //System.out.println("登录失败，用户名密码不正确");
                addActionError("登录失败，用户名密码不正确");
            }
        }else{
            //System.out.println("验证码不正确");
            addActionError("验证码不正确");
            return "checkcodeFail";
        }
        return "login";
    }

    /**
     * 导出Excel表格
     */
    public void exportExcel() throws IOException {
        //创建文件
        HSSFWorkbook workbook = new HSSFWorkbook();
        //创建sheet
        HSSFSheet sheet = workbook.createSheet("教师数据");
        //创建标题行
        HSSFRow row = sheet.createRow(0);
        row.createCell(0).setCellValue("教师工号");
        row.createCell(1).setCellValue("教师姓名");
        row.createCell(2).setCellValue("性别");
        row.createCell(3).setCellValue("校区");
        row.createCell(4).setCellValue("年龄");
        row.createCell(5).setCellValue("移动电话");
        row.createCell(6).setCellValue("邮箱");
        row.createCell(7).setCellValue("QQ");

        //查数据
        List<Teacher> teachers = teacherService.findAll();
        for (Teacher teacher : teachers) {
            row = sheet.createRow(sheet.getLastRowNum() + 1);
            row.createCell(0).setCellValue(teacher.getTea_username());
            row.createCell(1).setCellValue(teacher.getTea_name());
            row.createCell(2).setCellValue(teacher.getTea_gender());
            row.createCell(3).setCellValue(teacher.getTea_address());
            row.createCell(4).setCellValue(teacher.getTea_age());
            row.createCell(5).setCellValue(teacher.getTea_mobile());
            row.createCell(6).setCellValue(teacher.getTea_email());
            row.createCell(7).setCellValue(teacher.getTea_qq());
        }

        //响应
        HttpServletResponse response = ServletActionContext.getResponse();

        //设置响应头
        String fileName = URLEncoder.encode("教师数据.xls", "utf-8");
        response.setHeader("Content-Disposition", "attachment;filename*=utf-8'zh_cn'" + fileName);
        String contentType = ServletActionContext.getServletContext().getMimeType(fileName);
        response.setContentType(contentType);

        //输出
        OutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
    }

    /**
     * 修改个人信息跳转
     */
    public String ziliaoUI(){
        teacher = teacherService.findById(teacher.getTea_id());
        System.out.println("teacher"+teacher);
        return "ziliaoUI";
    }

    /**
     * 修改学生个人信息方法
     */
    public String xiugai(){
        //调用service中的update方法，传入学生对象，进行修改
        teacherService.update(teacher);
        System.out.println("teacher"+teacher);
        return "xiugaiSuccess";
    }

}
