package com.myhome.lee.repository;

import com.myhome.lee.entity.ApiMockRequestHeaders;
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

    @Query("from  ApiMockRequestParams a where a.api_mock_id=:apiMockId")
    List<ApiMockRequestParams> findApiMockRequestParams(@Param("id") Integer apiMockId);





}