package com.myhome.lee.repository;

import com.myhome.lee.entity.ApiMockRequestParams;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by lee on 2017/4/30.
 */
public interface ApiMockRequestParamsRepository  extends JpaRepository<ApiMockRequestParams, Integer> {

    ApiMockRequestParams findByName(String name);

    ApiMockRequestParams findById(Integer id);

    ApiMockRequestParams findByIdAndName(Integer id, String name);

//    @Query(value = "select from  ApiMockRequestParams a where a.apiMockBasicinfo.id=?1")
//    List<ApiMockRequestParams> withApiMockIdQuery(Integer apiMockId);

    @Query(value = "SELECT a FROM ApiMockRequestParams a JOIN a.apiMockBasicinfo b WHERE b.id=:id")
    List<ApiMockRequestParams> findByApiMockRequestHeadersByApiMockId(@Param("id") Integer apiMockId);





}