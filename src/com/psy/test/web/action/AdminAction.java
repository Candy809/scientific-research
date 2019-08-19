package com.psy.test.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.psy.test.model.Admin;
import com.psy.test.model.PageBean;
import com.psy.test.service.AdminService;
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

public class AdminAction extends ActionSupport implements ModelDriven<Admin> {
    //模型注入
    private Admin admin = new Admin();

    @Override
    public Admin getModel() {
        return admin;
    }

    //注入Service
    private AdminService adminService;

    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
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

    public void setAdmin_checkcode(String admin_checkcode) {
        this.admin_checkcode = admin_checkcode;
    }

    /**
     * 管理员登录方法：login
     */
    private String admin_checkcode;
    public String login() {
        String rightcode = (String) ServletActionContext.getRequest().getSession().getAttribute("admin_checkcode");
        System.out.println("admin_rightcode----"+rightcode);
        System.out.println("admin_checkcode----"+admin_checkcode);
        //调用业务层查询用户
//        if(serverCheckCode.equalsIgnoreCase(clientCheckCode)){//验证码正确
        if(admin_checkcode.equalsIgnoreCase(rightcode)){//验证码正确
            //2.调用service
            admin = adminService.login(admin);
            //3.判断登录状态
            if(admin != null){
                //System.out.println("登录成功");
                ActionContext.getContext().getSession().put("admin", admin);
                ActionContext.getContext().getSession().put("admin_id",admin.getAdmin_id());
                return "loginSuccess";//主页
                // 面-后台页面
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
     * 跳转添加管理员页面的方法
     */
    public String saveUI() {
        return "saveUI";
    }

    /**
     * 保存管理员的方法
     */
    public String save() {
        //调用service业务层保存管理员
        adminService.save(admin);
        return "saveSuccess";
    }

    /**
     * 分页查询所有的方法
     */
    public String findAll() {
        //接收参数：分页参数
        //最好使用DetachedCriteria对象（条件查询--带分页）方便
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Admin.class);
        //设置条件()
        if (admin.getAdmin_name() != null) {
            //设置按名称查询条件
            detachedCriteria.add(Restrictions.like("admin_name", "%" + admin.getAdmin_name() + "%"));
        }
        //设置校区查询
        if (admin.getAdmin_address() != null && !"".equals(admin.getAdmin_address())) {
            detachedCriteria.add(Restrictions.eq("admin_address", admin.getAdmin_address()));
        }
        //调用业务层去查询
        PageBean<Admin> pageBean = adminService.findByPage(detachedCriteria, currPage, pageSize);
        //push到值栈中，方便页面获取
        ActionContext.getContext().getValueStack().push(pageBean);
        System.out.println(pageBean);
        return "findAll";
    }

    /**
     * 编辑管理员信息方法
     */
    public String edit() {
        //调用service中的findById()方法，传入管理员id，根据id修改
        admin = adminService.findById(admin.getAdmin_id());
        return "editSuccess";
    }

    public String ziliaoUI(){
       admin= adminService.findById(admin.getAdmin_id());
       return "ziliaoUI";
    }
    public String xiugai(){
        adminService.update(admin);
        System.out.println("student2"+admin);
        return "xiugaiSuccess";
    }

    /**
     * 编辑管理员修改的方法
     */
    public String update() {
        //调用service中的update方法，传入管理员对象admin
        adminService.update(admin);
        return "updateSuccess";
    }

    /**
     * 删除管理员的方法
     */
    public String delete() {
        //首先根据管理员id查询该管理员信息，并封装到管理员对象admin中
        admin = adminService.findById(admin.getAdmin_id());
        //调用service中的delete()方法，传入管理员对象，删除管理员
        adminService.delete(admin);
        return "deleteSuccess";
    }

    /**
     * 导出Excel表格
     */
    public void exportExcel() throws IOException {
        //创建文件
        HSSFWorkbook workbook = new HSSFWorkbook();
        //创建sheet
        HSSFSheet sheet = workbook.createSheet("管理员数据");
        //创建标题行
        HSSFRow row = sheet.createRow(0);
        row.createCell(0).setCellValue("管理员工号");
        row.createCell(1).setCellValue("管理员姓名");
        row.createCell(2).setCellValue("校区");
        row.createCell(3).setCellValue("移动电话");

        //查数据
        List<Admin> admins = adminService.findAll();
        for (Admin admin : admins) {
            row = sheet.createRow(sheet.getLastRowNum() + 1);
            row.createCell(0).setCellValue(admin.getAdmin_username());
            row.createCell(1).setCellValue(admin.getAdmin_name());
            row.createCell(2).setCellValue(admin.getAdmin_address());
            row.createCell(3).setCellValue(admin.getAdmin_mobile());
        }

        //响应
        HttpServletResponse response = ServletActionContext.getResponse();

        //设置响应头
        String fileName = URLEncoder.encode("管理员数据.xls", "utf-8");
        response.setHeader("Content-Disposition", "attachment;filename*=utf-8'zh_cn'" + fileName);
        String contentType = ServletActionContext.getServletContext().getMimeType(fileName);
        response.setContentType(contentType);

        //输出
        OutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
    }
}
