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

    /**
     * Find by name api mock request headers.
     *
     * @param name the name
     * @return the api mock request headers
     */
    ApiMockRequestHeaders findByName(String name);

    /**
     * Find by id api mock request headers.
     *
     * @param id the id
     * @return the api mock request headers
     */
    ApiMockRequestHeaders findById(Integer id);

    /**
     * Find by id and name api mock request headers.
     *
     * @param id   the id
     * @param name the name
     * @return the api mock request headers
     */
    ApiMockRequestHeaders findByIdAndName(Integer id, String name);

//    @Query(value = "select from  ApiMockRequestHeaders a where a.apiMockBasicinfo.id=?1")
//    List<ApiMockRequestHeaders> withApiMockIdQuery(Integer apiMockId);


    /**
     * Find by api mock id list.
     *
     * @param apiMockId the api mock id
     * @return the list
     */
    @Query(value = "SELECT a FROM ApiMockRequestHeaders a JOIN a.apiMockBasicinfo b WHERE b.id=:id")
    List<ApiMockRequestHeaders> findByApiMockId(@Param("id") Integer apiMockId);


}