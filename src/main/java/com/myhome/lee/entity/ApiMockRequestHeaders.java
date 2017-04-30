package com.myhome.lee.entity;

import javax.persistence.*;

@Entity
public class ApiMockRequestHeaders {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String value;

    @Column(nullable = false)
    private Boolean isMatch;

    //@Column(nullable = false)
    //private Integer apiMockId;


    //@OneToOne
    //@JoinColumn(name = "id",foreignKey = @ForeignKey(name = "fk_api_mock_request_headers"))

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "api_mock_id", nullable = true)
    private ApiMockBasicinfo apiMockBasicinfo;

    //@OneToOne(mappedBy = "apiMockBasicinfo")
    public ApiMockBasicinfo getApiMockBasicinfo() {
        return apiMockBasicinfo;
    }

    @Column(nullable = false)
    private String depict;

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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    public Boolean getIsMatch() {
        return isMatch;
    }

    public void setIsMatch(Boolean isMatch) {
        this.isMatch = isMatch;
    }

//    public Integer getApiMockId() {
//        return getApiMockBasicinfo().getId();
//    }

//    public void setApiMockId(Integer apiMockId) {
//        this.apiMockId = getApiMockBasicinfo().getId();
//    }

    public String getDepict() {
        return depict;
    }

    public void setDepict(String depict) {
        this.depict = depict == null ? null : depict.trim();
    }
}