package com.myhome.lee.repository;

import com.myhome.lee.entity.ApiMockBasicinfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


/**
 * Created by lee on 2017/3/11.
 */
@Repository
public interface ApiMockBasicinfoRepository extends JpaRepository<ApiMockBasicinfo, Integer> {


    /**
     * Find by name api mock basicinfo.
     *
     * @param name the name
     * @return the api mock basicinfo
     */
    ApiMockBasicinfo findByName(String name);


    /**
     * Find by id api mock basicinfo.
     *
     * @param id the id
     * @return the api mock basicinfo
     */
    ApiMockBasicinfo findById(Integer id);

    /**
     * Find by id and name api mock basicinfo.
     *
     * @param id   the id
     * @param name the name
     * @return the api mock basicinfo
     */
    ApiMockBasicinfo findByIdAndName(Integer id, String name);


    /**
     * Find api mock basicinfo api mock basicinfo.
     *
     * @param id the id
     * @return the api mock basicinfo
     */
    @Query(value = "select a from  ApiMockBasicinfo a where a.id=:id")
    ApiMockBasicinfo findApiMockBasicinfo(@Param("id") Integer id);


}
