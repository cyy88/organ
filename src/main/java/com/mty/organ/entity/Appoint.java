package com.mty.organ.entity;

import lombok.Data;

@Data
public class Appoint{

    private Integer id;
    private String aid;
    private String uid;
    private java.util.Date createTime;

    private String aname;
    private String uname;
    private String oname;

    private String hours;

    private String place;


    public String getOname() {
        return oname;
    }

    public void setOname(String oname) {
        this.oname = oname;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public void setId(Integer value) {
        this.id = value;
    }
    public Integer getId() {
       return this.id;
    }
    public void setAid(String value) {
        this.aid = value;
    }
    public String getAid() {
       return this.aid;
    }
    public void setUid(String value) {
        this.uid = value;
    }
    public String getUid() {
       return this.uid;
    }
    public void setCreateTime(java.util.Date value) {
        this.createTime = value;
    }
    public java.util.Date getCreateTime() {
       return this.createTime;
    }
}
