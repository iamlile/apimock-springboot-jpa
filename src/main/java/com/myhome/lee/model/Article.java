package com.myhome.lee.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by lee on 17/3/1.
 */
@Entity
@Table(name = "Article")
public class Article {
    @Id
    @Column(name="id", nullable = false)
    private String id;

    @Column(name="title", unique=true, nullable=false)
    private String title;
}