package com.myhome.lee.model;

import java.util.Date;


public class ApiMockBasicinfoMybatis {

    private Integer id;

    private String name;

    private String url;

    private Integer method;

    private Boolean isEnabled;

    private String reqBodyType;

    private Integer contentType;

    private Integer statusCode;

    private Boolean isUploaded;

    private Integer projectId;

    private Date createTime;

    private Integer createdById;

    private Integer delay;

    private Integer lastModifiedById;

    private Date lastModifiedTime;

    private String desc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getMethod() {
        return method;
    }

    public void setMethod(Integer method) {
        this.method = method;
    }

    public Boolean getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    public String getReqBodyType() {
        return reqBodyType;
    }

    public void setReqBodyType(String reqBodyType) {
        this.reqBodyType = reqBodyType == null ? null : reqBodyType.trim();
    }

    public Integer getContentType() {
        return contentType;
    }

    public void setContentType(Integer contentType) {
        this.contentType = contentType;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public Boolean getIsUploaded() {
        return isUploaded;
    }

    public void setIsUploaded(Boolean isUploaded) {
        this.isUploaded = isUploaded;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Date getCreateTime() {
        return createTime;
    }


    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    public Integer getCreatedById() {
        return createdById;
    }


    public void setCreatedById(Integer createdById) {
        this.createdById = createdById;
    }

    public Integer getDelay() {
        return delay;
    }

    public void setDelay(Integer delay) {
        this.delay = delay;
    }

    public Integer getLastModifiedById() {
        return lastModifiedById;
    }

    public void setLastModifiedById(Integer lastModifiedById) {
        this.lastModifiedById = lastModifiedById;
    }

    public Date getLastModifiedTime() {
        return lastModifiedTime;
    }


    public void setLastModifiedTime(Date lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }
}