package com.myhome.lee.repository;

import com.myhome.lee.entity.ApiMockRequestParams;
import com.myhome.lee.entity.ApiMockResponseHeaders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

/**
 * Created by lee on 2017/4/30.
 */
public interface ApiMockResponseHeadersRepository   extends JpaRepository<ApiMockResponseHeaders, Integer> {

    ApiMockResponseHeaders findByName(String name);

    ApiMockResponseHeaders findById(Integer id);

    ApiMockResponseHeaders findByIdAndName(Integer id, String name);

//    @Query(value = "select a from  ApiMockResponseHeaders a where a.apiMockBasicinfo.id=?1")
//    List<ApiMockResponseHeaders> withApiMockIdQuery(Integer apiMockId);

    @Query("SELECT a FROM ApiMockResponseHeaders a JOIN a.apiMockBasicinfo b WHERE b.id=:id")
    List<ApiMockResponseHeaders> findByApiMockRequestHeadersByApiMOckId(@Param("id") Integer apiMockId);


}