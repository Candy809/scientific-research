package com.psy.test.web.action;


import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.psy.test.model.*;
import com.psy.test.service.*;

import java.util.List;

public class EchartAction extends ActionSupport implements ModelDriven<Echart> {
    private Echart echart = new Echart();

    @Override
    public Echart getModel() {
        return echart;
    }

    private EchartService echartService;
    private LunWenService lunWenService;
    private KeYanService keYanService;
    private XueShuService xueShuService;
    private ZhuanLiService zhuanLiService;
    private StudentService studentService;

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public void setEchartService(EchartService echartService) {
        this.echartService = echartService;
    }

    public void setLunWenService(LunWenService lunWenService) {
        this.lunWenService = lunWenService;
    }

    public void setKeYanService(KeYanService keYanService) {
        this.keYanService = keYanService;
    }

    public void setXueShuService(XueShuService xueShuService) {
        this.xueShuService = xueShuService;
    }

    public void setZhuanLiService(ZhuanLiService zhuanLiService) {
        this.zhuanLiService = zhuanLiService;
    }

    public String tubiao(){
        List<LunWen> lunWens = lunWenService.findAll();
        List<ZhuanLi> zhuanLis = zhuanLiService.findAll();
        List<KeYan> keYans = keYanService.findAll();
        List<XueShu> xueShus = xueShuService.findAll();
        List<Student> students = studentService.findAll();

        System.out.println("论文---"+lunWens);
        System.out.println("专利---"+zhuanLis);
        System.out.println("科研---"+keYans);
        System.out.println("学术---"+xueShus);
        System.out.println("学生---"+students);

        return null;
    }
}
