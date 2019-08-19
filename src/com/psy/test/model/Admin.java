package com.psy.test.model;

/**
 * 管理员模型
 */
public class Admin {
    private Long admin_id;
    private String admin_username;
    private String admin_password;
    private String admin_name;
    private String admin_address;
    private String admin_mobile;

    public Long getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(Long admin_id) {
        this.admin_id = admin_id;
    }

    public String getAdmin_username() {
        return admin_username;
    }

    public void setAdmin_username(String admin_username) {
        this.admin_username = admin_username;
    }

    public String getAdmin_password() {
        return admin_password;
    }

    public void setAdmin_password(String admin_password) {
        this.admin_password = admin_password;
    }

    public String getAdmin_name() {
        return admin_name;
    }

    public void setAdmin_name(String admin_name) {
        this.admin_name = admin_name;
    }

    public String getAdmin_address() {
        return admin_address;
    }

    public void setAdmin_address(String admin_address) {
        this.admin_address = admin_address;
    }

    public String getAdmin_mobile() {
        return admin_mobile;
    }

    public void setAdmin_mobile(String admin_mobile) {
        this.admin_mobile = admin_mobile;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "admin_id=" + admin_id +
                ", admin_username='" + admin_username + '\'' +
                ", admin_password='" + admin_password + '\'' +
                ", admin_name='" + admin_name + '\'' +
                ", admin_address='" + admin_address + '\'' +
                ", admin_mobile='" + admin_mobile + '\'' +
                '}';
    }
}
