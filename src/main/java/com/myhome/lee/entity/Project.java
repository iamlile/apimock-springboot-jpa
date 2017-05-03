package com.myhome.lee.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by lee on 2017/3/13.
 */
@Entity
public class Project {

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String name;


    @OneToMany(mappedBy = "project", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<ApiMockBasicinfo> apiMockBasicinfosHashSet = new HashSet<ApiMockBasicinfo>();

    public Set<ApiMockBasicinfo> getApiMockBasicinfosHashSet() {
        return apiMockBasicinfosHashSet;
    }


    public Project(String name) {
        this.name = name;
    }
    public Project() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
