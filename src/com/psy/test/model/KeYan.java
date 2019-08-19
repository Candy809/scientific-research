package com.psy.test.model;

public class KeYan {
    private Long ky_id;
    private String ky_bianhao;
    private String ky_mingcheng;
    private String ky_fuzeren;
    private String ky_laiyuan;
    private String ky_leixing;
    private String ky_dengji;
    private String ky_jingfei;
    private String ky_renwu;
    private String ky_shenhe;
    private String ky_image;
    private String ky_imagename;
    private Integer ky_defen;
    private Long stu_keyan_id;

    private Student student;

    public Long getKy_id() {
        return ky_id;
    }

    public void setKy_id(Long ky_id) {
        this.ky_id = ky_id;
    }

    public String getKy_bianhao() {
        return ky_bianhao;
    }

    public void setKy_bianhao(String ky_bianhao) {
        this.ky_bianhao = ky_bianhao;
    }

    public String getKy_mingcheng() {
        return ky_mingcheng;
    }

    public void setKy_mingcheng(String ky_mingcheng) {
        this.ky_mingcheng = ky_mingcheng;
    }

    public String getKy_fuzeren() {
        return ky_fuzeren;
    }

    public void setKy_fuzeren(String ky_fuzeren) {
        this.ky_fuzeren = ky_fuzeren;
    }

    public String getKy_laiyuan() {
        return ky_laiyuan;
    }

    public void setKy_laiyuan(String ky_laiyuan) {
        this.ky_laiyuan = ky_laiyuan;
    }

    public String getKy_leixing() {
        return ky_leixing;
    }

    public void setKy_leixing(String ky_leixing) {
        this.ky_leixing = ky_leixing;
    }

    public String getKy_dengji() {
        return ky_dengji;
    }

    public void setKy_dengji(String ky_dengji) {
        this.ky_dengji = ky_dengji;
    }

    public String getKy_jingfei() {
        return ky_jingfei;
    }

    public void setKy_jingfei(String ky_jingfei) {
        this.ky_jingfei = ky_jingfei;
    }

    public String getKy_renwu() {
        return ky_renwu;
    }

    public void setKy_renwu(String ky_renwu) {
        this.ky_renwu = ky_renwu;
    }

    public String getKy_shenhe() {
        return ky_shenhe;
    }

    public void setKy_shenhe(String ky_shenhe) {
        this.ky_shenhe = ky_shenhe;
    }

    public String getKy_image() {
        return ky_image;
    }

    public void setKy_image(String ky_image) {
        this.ky_image = ky_image;
    }

    public String getKy_imagename() {
        return ky_imagename;
    }

    public void setKy_imagename(String ky_imagename) {
        this.ky_imagename = ky_imagename;
    }

    public Integer getKy_defen() {
        return ky_defen;
    }

    public void setKy_defen(Integer ky_defen) {
        this.ky_defen = ky_defen;
    }

    public Long getStu_keyan_id() {
        return stu_keyan_id;
    }

    public void setStu_keyan_id(Long stu_keyan_id) {
        this.stu_keyan_id = stu_keyan_id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "KeYan{" +
                "ky_id=" + ky_id +
                ", ky_bianhao='" + ky_bianhao + '\'' +
                ", ky_mingcheng='" + ky_mingcheng + '\'' +
                ", ky_fuzeren='" + ky_fuzeren + '\'' +
                ", ky_laiyuan='" + ky_laiyuan + '\'' +
                ", ky_leixing='" + ky_leixing + '\'' +
                ", ky_dengji='" + ky_dengji + '\'' +
                ", ky_jingfei='" + ky_jingfei + '\'' +
                ", ky_renwu='" + ky_renwu + '\'' +
                ", ky_shenhe='" + ky_shenhe + '\'' +
                ", ky_image='" + ky_image + '\'' +
                ", ky_imagename='" + ky_imagename + '\'' +
                ", ky_defen=" + ky_defen +
                ", stu_keyan_id=" + stu_keyan_id +
                '}';
    }
}
