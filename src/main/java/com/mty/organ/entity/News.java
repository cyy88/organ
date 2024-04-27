package com.mty.organ.entity;


public class News{

    private Integer id;
    private String oid;
    private String image;
    private String title;
    private String detail;
    private String content;
    private java.util.Date createTime;

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
    public void setTitle(String value) {
        this.title = value;
    }
    public String getTitle() {
       return this.title;
    }
    public void setDetail(String value) {
        this.detail = value;
    }
    public String getDetail() {
       return this.detail;
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
