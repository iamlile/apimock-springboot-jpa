package com.myhome.lee.repository;

import com.myhome.lee.entity.ApiMockRequestParams;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by lee on 2017/4/30.
 */

@Component
public interface ApiMockRequestParamsRepository  extends JpaRepository<ApiMockRequestParams, Integer> {

    /**
     * Find by name api mock request params.
     *
     * @param name the name
     * @return the api mock request params
     */
    ApiMockRequestParams findByName(String name);

    /**
     * Find by id api mock request params.
     *
     * @param id the id
     * @return the api mock request params
     */
    ApiMockRequestParams findById(Integer id);

    /**
     * Find by id and name api mock request params.
     *
     * @param id   the id
     * @param name the name
     * @return the api mock request params
     */
    ApiMockRequestParams findByIdAndName(Integer id, String name);

//    @Query(value = "select from  ApiMockRequestParams a where a.apiMockBasicinfo.id=?1")
//    List<ApiMockRequestParams> withApiMockIdQuery(Integer apiMockId);

    /**
     * Find by api mock id list.
     *
     * @param apiMockId the api mock id
     * @return the list
     */
    @Query(value = "SELECT a FROM ApiMockRequestParams a JOIN a.apiMockBasicinfo b WHERE b.id=:id")
    List<ApiMockRequestParams> findByApiMockId(@Param("id") Integer apiMockId);





}