package com.myhome.lee.repository;

import com.myhome.lee.entity.ApiMockRequestParams;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by lee on 2017/4/30.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
//@DataJpaTest
public class ApiMockRequestParamsRepositoryTest {

    @Autowired
    private ApiMockRequestParamsRepository apiMockRequestParamsRepository;

    @Test
    public void testFindByName() throws Exception {

    }

    @Test
    public void testFindById() throws Exception {

    }

    @Test
    public void testFindByIdAndName() throws Exception {
        List<ApiMockRequestParams> list = apiMockRequestParamsRepository.findByApiMockId(new Integer(13));
        for (int i = 0;i < list.size();i++){
            ApiMockRequestParams apiParams = list.get(i);
            System.out.println(apiParams.getName());
        }
    }

    @Test
    public void testWithApiMockIdQuery() throws Exception {

    }
}