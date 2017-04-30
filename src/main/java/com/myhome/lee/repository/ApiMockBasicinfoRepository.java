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

    ApiMockBasicinfo findByName(String name);

    ApiMockBasicinfo findById(Integer id);

    ApiMockBasicinfo findByIdAndName(Integer id, String name);


    @Query("from  ApiMockBasicinfo a where a.id=:id")
    ApiMockBasicinfo findApiMockBasicinfo(@Param("id") Integer id);


}
