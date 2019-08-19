package com.psy.test.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Student {
    private Long stu_id;
    private String stu_username;
    private String stu_password;
    private String stu_name;
    private String stu_age;
    private String stu_gender;
    private String stu_mobile;
    private String stu_email;
    private String stu_qq;
    private String stu_address;
    private String stu_class;

    private Set<LunWen> lunWens = new HashSet<LunWen>();
    private Set<ZhuanLi> zhuanLis = new HashSet<ZhuanLi>();
    private Set<KeYan> keYans = new HashSet<KeYan>();
    private Set<XueShu> xueShus = new HashSet<XueShu>();

    public String getStu_class() {
        return stu_class;
    }

    public void setStu_class(String stu_class) {
        this.stu_class = stu_class;
    }

    public Long getStu_id() {
        return stu_id;
    }

    public void setStu_id(Long stu_id) {
        this.stu_id = stu_id;
    }

    public String getStu_username() {
        return stu_username;
    }

    public void setStu_username(String stu_username) {
        this.stu_username = stu_username;
    }

    public String getStu_password() {
        return stu_password;
    }

    public void setStu_password(String stu_password) {
        this.stu_password = stu_password;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public String getStu_age() {
        return stu_age;
    }

    public void setStu_age(String stu_age) {
        this.stu_age = stu_age;
    }

    public String getStu_gender() {
        return stu_gender;
    }

    public void setStu_gender(String stu_gender) {
        this.stu_gender = stu_gender;
    }

    public String getStu_mobile() {
        return stu_mobile;
    }

    public void setStu_mobile(String stu_mobile) {
        this.stu_mobile = stu_mobile;
    }

    public String getStu_email() {
        return stu_email;
    }

    public void setStu_email(String stu_email) {
        this.stu_email = stu_email;
    }

    public String getStu_qq() {
        return stu_qq;
    }

    public void setStu_qq(String stu_qq) {
        this.stu_qq = stu_qq;
    }

    public String getStu_address() {
        return stu_address;
    }

    public void setStu_address(String stu_address) {
        this.stu_address = stu_address;
    }

    public Set<LunWen> getLunWens() {
        return lunWens;
    }

    public void setLunWens(Set<LunWen> lunWens) {
        this.lunWens = lunWens;
    }

    public Set<ZhuanLi> getZhuanLis() {
        return zhuanLis;
    }

    public void setZhuanLis(Set<ZhuanLi> zhuanLis) {
        this.zhuanLis = zhuanLis;
    }

    public Set<KeYan> getKeYans() {
        return keYans;
    }

    public void setKeYans(Set<KeYan> keYans) {
        this.keYans = keYans;
    }

    public Set<XueShu> getXueShus() {
        return xueShus;
    }

    public void setXueShus(Set<XueShu> xueShus) {
        this.xueShus = xueShus;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stu_id=" + stu_id +
                ", stu_username='" + stu_username + '\'' +
                ", stu_password='" + stu_password + '\'' +
                ", stu_name='" + stu_name + '\'' +
                ", stu_age='" + stu_age + '\'' +
                ", stu_gender='" + stu_gender + '\'' +
                ", stu_mobile='" + stu_mobile + '\'' +
                ", stu_email='" + stu_email + '\'' +
                ", stu_qq='" + stu_qq + '\'' +
                ", stu_address='" + stu_address + '\'' +
                '}';
    }

}
