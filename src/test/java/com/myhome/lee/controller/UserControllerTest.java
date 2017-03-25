package com.myhome.lee.controller;

/**
 * Created by lee on 17/3/4.
 */

import net.minidev.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashMap;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/**
 * Created by lee on 17/3/4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = MockServletContext.class)
@SpringBootConfiguration
@WebAppConfiguration
public class UserControllerTest {

    private MockMvc mvc;
    private RequestBuilder request;


    @InjectMocks
    private UserController userController;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(userController).build();
        //mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }

   @Test
   public void testUserController() throws Exception {
       // 1、get查一下user列表，应该为空
       request = get("/users/");
       mvc.perform(request)
               .andExpect(status().isOk())
               .andExpect(content().string(equalTo("[]")));

       // 2、post提交一个user
       HashMap<String, String> userMap = new HashMap<String,String>();
       userMap.put("id", "1");
       userMap.put("name", "测试大师");
       userMap.put("age", "20");
       String requestJson = JSONObject.toJSONString(userMap);

       /**
       request = post("/users/")
               .param("id", "1")
               .param("name", "测试大师")
               .param("age", "20")
               .contentType(MediaType.APPLICATION_JSON);
        **/
       request = post("/users/").contentType(MediaType.APPLICATION_JSON).content(requestJson);

       mvc.perform(request)
               .andExpect(content().string(equalTo("success")));

       // 3、get获取user列表，应该有刚才插入的数据
       request = get("/users/");
       mvc.perform(request)
               .andExpect(status().isOk())
               .andExpect(content().string(equalTo("[{\"id\":1,\"name\":\"测试大师\",\"age\":20}]")));

       // 4、put修改id为1的user
       userMap.put("id", "1");
       userMap.put("name", "测试终极大师");
       userMap.put("age", "30");
       requestJson = JSONObject.toJSONString(userMap);
       request = put("/users/1").contentType(MediaType.APPLICATION_JSON).content(requestJson);

       /**
       request = put("/users/1")
               .param("name", "测试终极大师")
               .param("age", "30");
        **/
       mvc.perform(request)
               .andExpect(content().string(equalTo("success")));

       // 5、get一个id为1的user
       request = get("/users/1");
       mvc.perform(request)
               .andExpect(content().string(equalTo("{\"id\":1,\"name\":\"测试终极大师\",\"age\":30}")));

       // 6、del删除id为1的user
       request = delete("/users/1");
       mvc.perform(request)
               .andExpect(content().string(equalTo("success")));

       // 7、get查一下user列表，应该为空
       request = get("/users/");
       mvc.perform(request)
               .andExpect(status().isOk())
               .andExpect(content().string(equalTo("[]")));

   }


}