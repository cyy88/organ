package com.mty.organ.entity;


import lombok.Data;

@Data
public class Organ{

    private Integer id;
    private String image;
    private String name;
    private String type;
    private String uid;
    private String status;
    private String content;
    private java.util.Date createTime;

    private String uname;

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
    public void setType(String value) {
        this.type = value;
    }
    public String getType() {
       return this.type;
    }
    public void setUid(String value) {
        this.uid = value;
    }
    public String getUid() {
       return this.uid;
    }
    public void setStatus(String value) {
        this.status = value;
    }
    public String getStatus() {
       return this.status;
    }
    public void setContent(String value) {
        this.content = value;
    }
    public String getContent() {
       return this.content;
    }
    public void setCreateTime(java.util.Date value) {
        this.createTime = value;
    }
    public java.util.Date getCreateTime() {
       return this.createTime;
    }
}
