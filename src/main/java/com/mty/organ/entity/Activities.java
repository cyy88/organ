package com.mty.organ.entity;


public class Activities{

    private Integer id;
    private String oid;
    private String image;
    private String name;
    private String stime;
    private String etime;
    private String content;
    private String status;
    private java.util.Date createTime;

    private String hours;

    private String place;

    private String oname;
    private String otype;

    public String getOname() {
        return oname;
    }

    public void setOname(String oname) {
        this.oname = oname;
    }

    public String getOtype() {
        return otype;
    }

    public void setOtype(String otype) {
        this.otype = otype;
    }

    public void setId(Integer value) {
        this.id = value;
    }
    public Integer getId() {
       return this.id;
    }
    public void setOid(String value) {
        this.oid = value;
    }
    public String getOid() {
       return this.oid;
    }
    public void setImage(String value) {
        this.image = value;
    }
    public String getImage() {
       return this.image;
    }
    public void setName(String value) {
        this.name = value;
    }
    public String getName() {
       return this.name;
    }
    public void setStime(String value) {
        this.stime = value;
    }
    public String getStime() {
       return this.stime;
    }
    public void setEtime(String value) {
        this.etime = value;
    }
    public String getEtime() {
       return this.etime;
    }
    public void setContent(String value) {
        this.content = value;
    }
    public String getContent() {
       return this.content;
    }
    public void setStatus(String value) {
        this.status = value;
    }
    public String getStatus() {
       return this.status;
    }
    public void setCreateTime(java.util.Date value) {
        this.createTime = value;
    }
    public java.util.Date getCreateTime() {
       return this.createTime;
    }
    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
