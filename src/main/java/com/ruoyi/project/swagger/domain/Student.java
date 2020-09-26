package com.ruoyi.project.swagger.domain;

public class Student {

    private String id;
    private String username;
    private Integer sex;
    private String pqclass;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPqclass() {
        return pqclass;
    }

    public void setPqclass(String pqclass) {
        this.pqclass = pqclass;
    }
}
