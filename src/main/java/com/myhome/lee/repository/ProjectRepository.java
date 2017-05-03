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

    /**
     * Find by name project.
     *
     * @param name the name
     * @return the project
     */
    Project findByName(String name);

    /**
     * Find by id project.
     *
     * @param id the id
     * @return the project
     */
    Project findById(Integer id);

    /**
     * Find by id and name project.
     *
     * @param id   the id
     * @param name the name
     * @return the project
     */
    Project findByIdAndName(Integer id, String name);

    /**
     * Find project api mock basicinfo.
     *
     * @param id the id
     * @return the api mock basicinfo
     */
    @Query("from  Project a where a.id=:id")
    ApiMockBasicinfo findProject(@Param("id") Integer id);


}
