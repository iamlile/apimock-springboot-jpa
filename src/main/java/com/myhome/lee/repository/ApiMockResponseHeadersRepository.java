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

    /**
     * Find by name api mock response headers.
     *
     * @param name the name
     * @return the api mock response headers
     */
    ApiMockResponseHeaders findByName(String name);

    /**
     * Find by id api mock response headers.
     *
     * @param id the id
     * @return the api mock response headers
     */
    ApiMockResponseHeaders findById(Integer id);

    /**
     * Find by id and name api mock response headers.
     *
     * @param id   the id
     * @param name the name
     * @return the api mock response headers
     */
    ApiMockResponseHeaders findByIdAndName(Integer id, String name);

//    @Query(value = "select a from  ApiMockResponseHeaders a where a.apiMockBasicinfo.id=?1")
//    List<ApiMockResponseHeaders> withApiMockIdQuery(Integer apiMockId);

    /**
     * Find by api mock id list.
     *
     * @param apiMockId the api mock id
     * @return the list
     */
    @Query("SELECT a FROM ApiMockResponseHeaders a JOIN a.apiMockBasicinfo b WHERE b.id=:id")
    List<ApiMockResponseHeaders> findByApiMockId(@Param("id") Integer apiMockId);


}