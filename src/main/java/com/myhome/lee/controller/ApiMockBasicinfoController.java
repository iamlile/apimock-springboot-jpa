
package com.myhome.lee.controller;

import com.myhome.lee.entity.ApiMockBasicinfo;
import com.myhome.lee.repository.ApiMockBasicinfoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * Created by lee on 2017/5/3.
 */
@RestController
@RequestMapping(value="/apimock")     // 通过这里配置使下面的映射都在/users下，可去除
/**
 * http://blog.didispace.com/springbootrestfulapi/
 * http://blog.didispace.com/spring-boot-learning-1/
 * http://www.baeldung.com/jackson-bidirectional-relationships-and-infinite-recursion
 */
public class ApiMockBasicinfoController {

    @Autowired
    private ApiMockBasicinfoRepository apiMockBasicinfoRepository;

    final Logger logger = LoggerFactory.getLogger(ApiMockBasicinfoController.class);


    @RequestMapping(value="/", method= RequestMethod.GET)
    @ResponseBody
    public List<ApiMockBasicinfo> getUserList() throws IOException {
        List<ApiMockBasicinfo> apiMockBasicinfoList = apiMockBasicinfoRepository.findAll();
        logger.info("apiMockBasicinfoList==="+ apiMockBasicinfoList.toString());
        return apiMockBasicinfoList;
    }

}
