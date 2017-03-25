package com.myhome.lee.repository;

import com.myhome.lee.entity.ApiMockBasicinfo;
import com.myhome.lee.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by lee on 2017/3/18.
 */
public interface ProjectRepository extends JpaRepository<Project, Integer> {

    Project findByName(String name);

    Project findById(Integer id);

    Project findByIdAndName(Integer id, String name);

    @Query("from  Project a where a.id=:id")
    ApiMockBasicinfo findProject(@Param("id") Integer id);


}
