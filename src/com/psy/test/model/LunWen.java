package com.psy.test.model;

public class LunWen {
    private Long lw_id;
    private String lw_bianhao;
    private String lw_name;
    private String lw_zuozhe1;
    private String lw_zuozhe2;
    private String lw_yema;
    private String lw_kanwu;
    private String lw_juanhao;
    private String lw_zizhu;
    private String lw_jiansuo;
    private String lw_shenhe;
    private String lw_image;
    private String lw_imagename;
    private Integer lw_defen;
    private Long stu_lunwen_id;
    //多对一，一个学生，多篇论文
    private Student student;

    public Long getLw_id() {
        return lw_id;
    }

    public void setLw_id(Long lw_id) {
        this.lw_id = lw_id;
    }

    public String getLw_bianhao() {
        return lw_bianhao;
    }

    public void setLw_bianhao(String lw_bianhao) {
        this.lw_bianhao = lw_bianhao;
    }

    public String getLw_name() {
        return lw_name;
    }

    public void setLw_name(String lw_name) {
        this.lw_name = lw_name;
    }

    public String getLw_zuozhe1() {
        return lw_zuozhe1;
    }

    public void setLw_zuozhe1(String lw_zuozhe1) {
        this.lw_zuozhe1 = lw_zuozhe1;
    }

    public String getLw_zuozhe2() {
        return lw_zuozhe2;
    }

    public void setLw_zuozhe2(String lw_zuozhe2) {
        this.lw_zuozhe2 = lw_zuozhe2;
    }

    public String getLw_yema() {
        return lw_yema;
    }

    public void setLw_yema(String lw_yema) {
        this.lw_yema = lw_yema;
    }

    public String getLw_kanwu() {
        return lw_kanwu;
    }

    public void setLw_kanwu(String lw_kanwu) {
        this.lw_kanwu = lw_kanwu;
    }

    public String getLw_juanhao() {
        return lw_juanhao;
    }

    public void setLw_juanhao(String lw_juanhao) {
        this.lw_juanhao = lw_juanhao;
    }

    public String getLw_zizhu() {
        return lw_zizhu;
    }

    public void setLw_zizhu(String lw_zizhu) {
        this.lw_zizhu = lw_zizhu;
    }

    public String getLw_jiansuo() {
        return lw_jiansuo;
    }

    public void setLw_jiansuo(String lw_jiansuo) {
        this.lw_jiansuo = lw_jiansuo;
    }

    public String getLw_shenhe() {
        return lw_shenhe;
    }

    public void setLw_shenhe(String lw_shenhe) {
        this.lw_shenhe = lw_shenhe;
    }

    public String getLw_image() {
        return lw_image;
    }

    public void setLw_image(String lw_image) {
        this.lw_image = lw_image;
    }

    public String getLw_imagename() {
        return lw_imagename;
    }

    public void setLw_imagename(String lw_imagename) {
        this.lw_imagename = lw_imagename;
    }

    public Integer getLw_defen() {
        return lw_defen;
    }

    public void setLw_defen(Integer lw_defen) {
        this.lw_defen = lw_defen;
    }

    public Long getStu_lunwen_id() {
        return stu_lunwen_id;
    }

    public void setStu_lunwen_id(Long stu_lunwen_id) {
        this.stu_lunwen_id = stu_lunwen_id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "LunWen{" +
                "lw_id=" + lw_id +
                ", lw_bianhao='" + lw_bianhao + '\'' +
                ", lw_name='" + lw_name + '\'' +
                ", lw_zuozhe1='" + lw_zuozhe1 + '\'' +
                ", lw_zuozhe2='" + lw_zuozhe2 + '\'' +
                ", lw_yema='" + lw_yema + '\'' +
                ", lw_kanwu='" + lw_kanwu + '\'' +
                ", lw_juanhao='" + lw_juanhao + '\'' +
                ", lw_zizhu='" + lw_zizhu + '\'' +
                ", lw_jiansuo='" + lw_jiansuo + '\'' +
                ", lw_shenhe='" + lw_shenhe + '\'' +
                ", lw_image='" + lw_image + '\'' +
                ", lw_imagename='" + lw_imagename + '\'' +
                ", lw_defen=" + lw_defen +
                ", stu_lunwen_id=" + stu_lunwen_id +
                '}';
    }
}
