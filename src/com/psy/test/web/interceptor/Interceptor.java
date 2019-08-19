package com.psy.test.web.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.psy.test.model.Admin;
import com.psy.test.model.Student;
import com.psy.test.model.Teacher;
import org.apache.struts2.ServletActionContext;

/**
 * 权限拦截器
 */
public class Interceptor extends MethodFilterInterceptor {

    @Override
    protected String doIntercept(ActionInvocation invocation) throws Exception {
        //是否登录
        Student student = (Student) ServletActionContext.getRequest().getSession().getAttribute("student");
        Teacher teacher = (Teacher) ServletActionContext.getRequest().getSession().getAttribute("teacher");
        Admin admin = (Admin) ServletActionContext.getRequest().getSession().getAttribute("admin");
        System.out.println("student----"+student);
        System.out.println("teacher----"+teacher);
        System.out.println("admin----"+admin);

        System.out.println("拦截了.." + ServletActionContext.getRequest().getRequestURL());

        if ((student != null) || (teacher != null) || (admin != null)) {

            return invocation.invoke();
        }else {
            return "loginerror";//回到登录页面,配置一个全局的result
        }
    }
}
