package com.psy.test.model;

public class XueShu {
    private Long xs_id;
    private String xs_canhuiren;
    private String xs_huiyimingcheng;
    private String xs_zhubandanwei;
    private String xs_huiyileixing;
    private String xs_xuekemenlei;
    private String xs_canhuidizhi;
    private String xs_tijiaolunwen;
    private String xs_teyaobaogao;
    private String xs_lunwentimu;
    private String xs_baogaotimu;
    private String xs_zijinzizhu;
    private String xs_zizhujine;
    private String xs_shenhe;
    private String xs_image;
    private String xs_imagename;
    private Integer xs_defen;
    private Long stu_xueshu_id;

    private Student student;

    public Long getXs_id() {
        return xs_id;
    }

    public void setXs_id(Long xs_id) {
        this.xs_id = xs_id;
    }

    public String getXs_canhuiren() {
        return xs_canhuiren;
    }

    public void setXs_canhuiren(String xs_canhuiren) {
        this.xs_canhuiren = xs_canhuiren;
    }

    public String getXs_huiyimingcheng() {
        return xs_huiyimingcheng;
    }

    public void setXs_huiyimingcheng(String xs_huiyimingcheng) {
        this.xs_huiyimingcheng = xs_huiyimingcheng;
    }

    public String getXs_zhubandanwei() {
        return xs_zhubandanwei;
    }

    public void setXs_zhubandanwei(String xs_zhubandanwei) {
        this.xs_zhubandanwei = xs_zhubandanwei;
    }

    public String getXs_huiyileixing() {
        return xs_huiyileixing;
    }

    public void setXs_huiyileixing(String xs_huiyileixing) {
        this.xs_huiyileixing = xs_huiyileixing;
    }

    public String getXs_xuekemenlei() {
        return xs_xuekemenlei;
    }

    public void setXs_xuekemenlei(String xs_xuekemenlei) {
        this.xs_xuekemenlei = xs_xuekemenlei;
    }

    public String getXs_canhuidizhi() {
        return xs_canhuidizhi;
    }

    public void setXs_canhuidizhi(String xs_canhuidizhi) {
        this.xs_canhuidizhi = xs_canhuidizhi;
    }

    public String getXs_tijiaolunwen() {
        return xs_tijiaolunwen;
    }

    public void setXs_tijiaolunwen(String xs_tijiaolunwen) {
        this.xs_tijiaolunwen = xs_tijiaolunwen;
    }

    public String getXs_teyaobaogao() {
        return xs_teyaobaogao;
    }

    public void setXs_teyaobaogao(String xs_teyaobaogao) {
        this.xs_teyaobaogao = xs_teyaobaogao;
    }

    public String getXs_lunwentimu() {
        return xs_lunwentimu;
    }

    public void setXs_lunwentimu(String xs_lunwentimu) {
        this.xs_lunwentimu = xs_lunwentimu;
    }

    public String getXs_baogaotimu() {
        return xs_baogaotimu;
    }

    public void setXs_baogaotimu(String xs_baogaotimu) {
        this.xs_baogaotimu = xs_baogaotimu;
    }

    public String getXs_zijinzizhu() {
        return xs_zijinzizhu;
    }

    public void setXs_zijinzizhu(String xs_zijinzizhu) {
        this.xs_zijinzizhu = xs_zijinzizhu;
    }

    public String getXs_zizhujine() {
        return xs_zizhujine;
    }

    public void setXs_zizhujine(String xs_zizhujine) {
        this.xs_zizhujine = xs_zizhujine;
    }

    public String getXs_shenhe() {
        return xs_shenhe;
    }

    public void setXs_shenhe(String xs_shenhe) {
        this.xs_shenhe = xs_shenhe;
    }

    public String getXs_image() {
        return xs_image;
    }

    public void setXs_image(String xs_image) {
        this.xs_image = xs_image;
    }

    public String getXs_imagename() {
        return xs_imagename;
    }

    public void setXs_imagename(String xs_imagename) {
        this.xs_imagename = xs_imagename;
    }

    public Integer getXs_defen() {
        return xs_defen;
    }

    public void setXs_defen(Integer xs_defen) {
        this.xs_defen = xs_defen;
    }

    public Long getStu_xueshu_id() {
        return stu_xueshu_id;
    }

    public void setStu_xueshu_id(Long stu_xueshu_id) {
        this.stu_xueshu_id = stu_xueshu_id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "XueShu{" +
                "xs_id=" + xs_id +
                ", xs_canhuiren='" + xs_canhuiren + '\'' +
                ", xs_huiyimingcheng='" + xs_huiyimingcheng + '\'' +
                ", xs_zhubandanwei='" + xs_zhubandanwei + '\'' +
                ", xs_huiyileixing='" + xs_huiyileixing + '\'' +
                ", xs_xuekemenlei='" + xs_xuekemenlei + '\'' +
                ", xs_canhuidizhi='" + xs_canhuidizhi + '\'' +
                ", xs_tijiaolunwen='" + xs_tijiaolunwen + '\'' +
                ", xs_teyaobaogao='" + xs_teyaobaogao + '\'' +
                ", xs_lunwentimu='" + xs_lunwentimu + '\'' +
                ", xs_baogaotimu='" + xs_baogaotimu + '\'' +
                ", xs_zijinzizhu='" + xs_zijinzizhu + '\'' +
                ", xs_zizhujine='" + xs_zizhujine + '\'' +
                ", xs_shenhe='" + xs_shenhe + '\'' +
                ", xs_image='" + xs_image + '\'' +
                ", xs_imagename='" + xs_imagename + '\'' +
                ", xs_defen=" + xs_defen +
                ", stu_xueshu_id=" + stu_xueshu_id +
                '}';
    }
}
