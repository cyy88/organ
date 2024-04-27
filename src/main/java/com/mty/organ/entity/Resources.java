package com.mty.organ.entity;


public class Resources{

    private Integer id;
    private String oid;
    private String name;
    private String files;
    private String remark;
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
    public void setName(String value) {
        this.name = value;
    }
    public String getName() {
       return this.name;
    }
    public void setFiles(String value) {
        this.files = value;
    }
    public String getFiles() {
       return this.files;
    }
    public void setRemark(String value) {
        this.remark = value;
    }
    public String getRemark() {
       return this.remark;
    }
    public void setCreateTime(java.util.Date value) {
        this.createTime = value;
    }
    public java.util.Date getCreateTime() {
       return this.createTime;
    }
}
