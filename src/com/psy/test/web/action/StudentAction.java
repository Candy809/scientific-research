package com.psy.test.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.psy.test.model.Admin;
import com.psy.test.model.PageBean;
import com.psy.test.model.Student;
import com.psy.test.service.StudentService;
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

public class StudentAction extends ActionSupport implements ModelDriven<Student> {
    //将学生对象注入模型驱动
    private Student student = new Student();
    @Override
    public Student getModel() {
        return student;
    }

    //注入Service
    private StudentService studentService;

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
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
     * 保存学生的方法
     */
    public String save(){
        //调用service中的save方法，传入学生对象，保存学生
        studentService.save(student);
        return "saveSuccess";
    }

    /**
     * 分页查询所有的方法
     */
    public String findAll(){
        //接收参数：分页参数
        //最好使用DetachedCriteria对象（条件查询--带分页）方便
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Student.class);
        //设置条件()
        //设置名字条件
        if (student.getStu_name() !=null){
            //设置按名称查询条件
            detachedCriteria.add(Restrictions.like("stu_name","%"+student.getStu_name()+"%"));
        }
        //设置性别条件
        if (student.getStu_gender()!=null&&!"".equals(student.getStu_gender())){
            detachedCriteria.add(Restrictions.eq("stu_gender",student.getStu_gender()));
        }
        //设置校区条件
        if (student.getStu_address()!=null&&!"".equals(student.getStu_address())){
            detachedCriteria.add(Restrictions.eq("stu_address",student.getStu_address()));
        }
        //设置班级条件
        if (student.getStu_class()!=null&&!"".equals(student.getStu_class())){
            detachedCriteria.add(Restrictions.eq("stu_class",student.getStu_class()));
        }
        //设置学号条件
        if (student.getStu_username()!=null&&!"".equals(student.getStu_username())){
            detachedCriteria.add(Restrictions.eq("stu_username",student.getStu_username()));
        }
        //调用业务层去查询
        PageBean<Student> pageBean = studentService.findByPage(detachedCriteria, currPage, pageSize);
        ActionContext.getContext().getValueStack().push(pageBean);
        System.out.println(pageBean);
        return "findAll";
    }

    /**
     * 编辑学生信息方法
     */
    public String edit(){
        //调用service中的findById方法，传入学生id，根据学生id进行查询
        student = studentService.findById(student.getStu_id());
        return "editSuccess";
    }

    /**
     * 编辑学生修改的方法
     */
    public String update(){
        //调用service中的update方法，传入学生对象，进行修改
        studentService.update(student);
        return "updateSuccess";
    }

    /**
     * 删除学生的方法
     */
    public String delete(){
        //根据学生id查询学生信息并封装再student中
        student = studentService.findById(student.getStu_id());
        //调用service中的delete方法，传入student对象，进行删除
        studentService.delete(student);
        return "deleteSuccess";
    }

    public void setStu_checkcode(String stu_checkcode) {
        this.stu_checkcode = stu_checkcode;
    }

    /**
     * 学生登录方法
     */
    private String stu_checkcode;

    public String login(){
        //调用service中的login方法查询学生

        String rightcode = (String) ServletActionContext.getRequest().getSession().getAttribute("stu_checkcode");
        System.out.println("stu_rightcode----"+rightcode);
        System.out.println("stu_checkcode----"+stu_checkcode);
//        if(serverCheckCode.equalsIgnoreCase(clientCheckCode)){//验证码正确
        if(stu_checkcode.equalsIgnoreCase(rightcode)){//验证码正确
            //2.调用service
            student = studentService.login(student);
            //3.判断登录状态
            if(student != null){
                //System.out.println("登录成功");
                ActionContext.getContext().getSession().put("student", student);
                ActionContext.getContext().getSession().put("stu_id",student.getStu_id());
                ActionContext.getContext().getSession().put("stu_name",student.getStu_name());
                return "loginSuccess";//主页面-后台页面
            }else{
                //System.out.println("登录失败，用户名密码不正确");
                addActionError("登录失败，用户名密码不正确");
            }
        }else{
            //System.out.println("验证码不正确");
            addActionError("验证码输入错误!");
            return "checkcodeFail";
        }
        return "login";
    }

    /**
     * 修改个人信息跳转
     */
    public String ziliaoUI(){
        student = studentService.findById(student.getStu_id());
        System.out.println("student1"+student);
        return "ziliaoUI";
    }

    /**
     * 修改学生个人信息方法
     */
    public String xiugai(){
        //调用service中的update方法，传入学生对象，进行修改
        studentService.update(student);
        System.out.println("student2"+student);
        return "xiugaiSuccess";
    }

    /**
     * 导出Excel表格
     */
    public void exportExcel() throws IOException {
        //创建文件
        HSSFWorkbook workbook = new HSSFWorkbook();
        //创建sheet
        HSSFSheet sheet = workbook.createSheet("研究生数据");
        //创建标题行
        HSSFRow row = sheet.createRow(0);
        row.createCell(0).setCellValue("研究生学号");
        row.createCell(1).setCellValue("研究生姓名");
        row.createCell(2).setCellValue("研究生班级");
        row.createCell(3).setCellValue("性别");
        row.createCell(4).setCellValue("校区");
        row.createCell(5).setCellValue("班级");
        row.createCell(9).setCellValue("年龄");
        row.createCell(7).setCellValue("移动电话");
        row.createCell(8).setCellValue("邮箱");
        row.createCell(9).setCellValue("QQ");

        //查数据
        List<Student> students = studentService.findAll();
        for (Student student : students) {
            row = sheet.createRow(sheet.getLastRowNum() + 1);
            row.createCell(0).setCellValue(student.getStu_username());
            row.createCell(1).setCellValue(student.getStu_name());
            row.createCell(2).setCellValue(student.getStu_class());
            row.createCell(3).setCellValue(student.getStu_gender());
            row.createCell(4).setCellValue(student.getStu_address());
            row.createCell(5).setCellValue(student.getStu_class());
            row.createCell(6).setCellValue(student.getStu_age());
            row.createCell(7).setCellValue(student.getStu_mobile());
            row.createCell(8).setCellValue(student.getStu_email());
            row.createCell(9).setCellValue(student.getStu_qq());
        }

        //响应
        HttpServletResponse response = ServletActionContext.getResponse();

        //设置响应头
        String fileName = URLEncoder.encode("研究生数据.xls","utf-8");
        response.setHeader("Content-Disposition","attachment;filename*=utf-8'zh_cn'" + fileName);
        String contentType = ServletActionContext.getServletContext().getMimeType(fileName);
        response.setContentType(contentType);

        //输出
        OutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
    }

}
