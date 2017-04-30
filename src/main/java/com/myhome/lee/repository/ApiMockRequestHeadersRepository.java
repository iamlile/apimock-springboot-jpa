package com.myhome.lee.repository;

import com.myhome.lee.entity.ApiMockRequestHeaders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

/**
 * Created by lee on 2017/4/30.
 */
public interface ApiMockRequestHeadersRepository extends JpaRepository<ApiMockRequestHeaders, Integer> {

    ApiMockRequestHeaders findByName(String name);

    ApiMockRequestHeaders findById(Integer id);

    ApiMockRequestHeaders findByIdAndName(Integer id, String name);

//    @Query(value = "select from  ApiMockRequestHeaders a where a.apiMockBasicinfo.id=?1")
//    List<ApiMockRequestHeaders> withApiMockIdQuery(Integer apiMockId);


    @Query(value = "SELECT a FROM ApiMockRequestHeaders a JOIN a.apiMockBasicinfo b WHERE b.id=:id")
    List<ApiMockRequestHeaders> findByApiMockRequestHeadersByApiMockId(@Param("id") Integer apiMockId);


}