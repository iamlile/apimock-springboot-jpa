package com.myhome.lee.repository;

import com.myhome.lee.entity.ApiMockRequestHeaders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by lee on 2017/4/30.
 */
public interface ApiMockRequestHeadersRepository extends JpaRepository<ApiMockRequestHeaders, Integer> {

    ApiMockRequestHeaders findByName(String name);

    ApiMockRequestHeaders findById(Integer id);

    ApiMockRequestHeaders findByIdAndName(Integer id, String name);

    @Query("from  ApiMockRequestHeaders a where a.api_mock_id=:apiMockId")
    List<ApiMockRequestHeaders> findApiMockRequestHeaders(@Param("id") Integer apiMockId);





}