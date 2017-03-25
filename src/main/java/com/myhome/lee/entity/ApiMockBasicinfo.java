package com.myhome.lee.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity

//@Table(indexes = {@Index(name = "idx_project_id", columnList = "projectId")})
public class ApiMockBasicinfo {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String url;

    @Column(nullable = false)
    private Integer method;

    @Column(nullable = false)
    private Boolean isEnabled;

    @Column(nullable = false)
    private String reqBodyType;

    @Column(nullable = false)
    private Integer contentType;

    @Column(nullable = false)
    private Integer statusCode;

    @Column(nullable = false)
    private Boolean isUploaded;

//    @Column(nullable = false)
//    private Integer projectId;

    @Column(nullable = false)
    private Date createTime;

    @Column(nullable = false)
    private Integer createdById;

    @Column(nullable = false)
    private Integer delay;

    @Column(nullable = false)
    private Integer lastModifiedById;

    @Column(nullable = false)
    private Date lastModifiedTime;

    public Boolean getEnabled() {
        return isEnabled;
    }

    public void setEnabled(Boolean enabled) {
        isEnabled = enabled;
    }

    public Boolean getUploaded() {
        return isUploaded;
    }

    public void setUploaded(Boolean uploaded) {
        isUploaded = uploaded;
    }

    @Column(nullable = false)
    private String depict;

    public Project getProject() {
        return project;
    }

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "project_id", nullable = true)
    private Project project;


    @OneToMany(mappedBy = "apiMockBasicinfo", cascade = CascadeType.ALL)
    private Set<ApiMockRequestHeaders> apiMockRequestHeadersHashSet = new HashSet<ApiMockRequestHeaders>();


    @OneToMany(mappedBy = "apiMockBasicinfo", cascade = CascadeType.ALL)
    private Set<ApiMockRequestParams> apiMockRequestParamsHashSet = new HashSet<ApiMockRequestParams>();

    @OneToMany(mappedBy = "apiMockBasicinfo", cascade = CascadeType.ALL)
    private Set<ApiMockResponseHeaders> apiMockResponseHeadersHashSet = new HashSet<ApiMockResponseHeaders>();


    public Set<ApiMockRequestHeaders> getApiMockRequestHeadersHashSet() {
        return apiMockRequestHeadersHashSet;
    }

    public Set<ApiMockRequestParams> getApiMockRequestParamsHashSet() {
        return apiMockRequestParamsHashSet;
    }

    public Set<ApiMockResponseHeaders> getApiMockResponseHeadersHashSet() {
        return apiMockResponseHeadersHashSet;
    }


    public ApiMockBasicinfo() {
    }

    public ApiMockBasicinfo(String name) {
        this.name = name;

    }

    public ApiMockBasicinfo(String name, String url, Integer method, Boolean isEnabled, String reqBodyType, Integer contentType, Integer statusCode, Boolean isUploaded, Integer projectId, Date createTime, Integer createdById, Integer delay, Integer lastModifiedById, Date lastModifiedTime, String depict) {
        this.name = name;
        this.url = url;
        this.method = method;
        this.isEnabled = isEnabled;
        this.reqBodyType = reqBodyType;
        this.contentType = contentType;
        this.statusCode = statusCode;
        this.isUploaded = isUploaded;
        this.project.setId(projectId);
        this.createTime = createTime;
        this.createdById = createdById;
        this.delay = delay;
        this.lastModifiedById = lastModifiedById;
        this.lastModifiedTime = lastModifiedTime;
        this.depict = depict;
    }

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

//    public Integer getProjectId() {
//        return project.getId();
//    }
//
//    public void setProjectId(Integer projectId) {
//        this.project.setId(projectId);
//    }

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

    public String getDepict() {
        return depict;
    }

    public void setDepict(String depict) {
        this.depict = depict == null ? null : depict.trim();
    }
}