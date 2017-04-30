package com.myhome.lee.repository;

import com.myhome.lee.entity.ApiMockRequestParams;
import com.myhome.lee.entity.ApiMockResponseHeaders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by lee on 2017/4/30.
 */
public interface ApiMockResponseHeadersRepository   extends JpaRepository<ApiMockResponseHeaders, Integer> {

    ApiMockResponseHeaders findByName(String name);

    ApiMockResponseHeaders findById(Integer id);

    ApiMockResponseHeaders findByIdAndName(Integer id, String name);

    @Query("from  ApiMockResponseHeaders a where a.api_mock_id=:apiMockId")
    List<ApiMockResponseHeaders> findApiMockResponseHeaders(@Param("id") Integer apiMockId);





}