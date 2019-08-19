package com.psy.test.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.psy.test.model.Admin;
import com.psy.test.model.Mark;
import com.psy.test.model.PageBean;
import com.psy.test.service.AdminService;
import com.psy.test.service.MarkService;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

public class MarkAction extends ActionSupport implements ModelDriven<Mark> {
    private MarkService markService;

    public void setMarkService(MarkService markService) {
        this.markService = markService;
    }

    private Mark mark = new Mark();

    @Override
    public Mark getModel() {
        return mark;
    }


    public String findAll() {
        List<Mark> marks = markService.findAll();
        System.out.println("分数----" + marks);
        ActionContext.getContext().getValueStack().set("marks", marks);
        return "findAll";
    }

    public String lw_editUI() {
        mark = markService.findById(mark.getMark_id());
        return "lw_editUI";
    }

    public String lw_edit() {
        markService.update(mark);
        return "lw_edit_success";
    }

    public String ky_editUI() {
        mark = markService.findById(mark.getMark_id());
        return "ky_editUI";
    }

    public String ky_edit() {
        markService.update(mark);
        return "ky_edit_success";
    }

    public String xs_editUI() {
        mark = markService.findById(mark.getMark_id());
        return "xs_editUI";
    }

    public String xs_edit() {
        markService.update(mark);
        return "xs_edit_success";
    }

    public String zl_editUI() {
        mark = markService.findById(mark.getMark_id());
        return "zl_editUI";
    }

    public String zl_edit() {
        markService.update(mark);
        return "zl_edit_success";
    }

}
