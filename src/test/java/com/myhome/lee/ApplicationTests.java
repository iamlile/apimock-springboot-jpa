package com.myhome.lee;

import com.myhome.lee.entity.ApiMockBasicinfo;
import com.myhome.lee.entity.User;
import com.myhome.lee.repository.ApiMockBasicinfoRepository;
import com.myhome.lee.repository.UserRepository;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;


/**
 * Created by lee on 17/3/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
/**
 * 参考:https://spring.io/blog/2016/04/15/testing-improvements-in-spring-boot-1-4
 * 其中:
 * Spring-boot-1.3支持:@SpringApplicationConfiguration(ApimockSpringboot2Application.class)
 * Spring-boot-1.4+支持:@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
 */

public class ApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ApiMockBasicinfoRepository apiMockBasicinfoRepository;

    @Test
    public void testone() {
    }


    @Test
    public void testTwo() throws Exception {
        Logger.getLogger(ApplicationTests.class).debug("-------" + apiMockBasicinfoRepository);


        ApiMockBasicinfo apiMockBasicinfo = new ApiMockBasicinfo();
        apiMockBasicinfo.setContentType(1);
        apiMockBasicinfo.setCreatedById(1);
        apiMockBasicinfo.setCreateTime(new Date());
        apiMockBasicinfo.setDelay(1);
        apiMockBasicinfo.setDepict(" ");
        apiMockBasicinfo.setIsEnabled(true);
        apiMockBasicinfo.setIsUploaded(true);
        apiMockBasicinfo.setLastModifiedById(1);
        apiMockBasicinfo.setLastModifiedTime(new Date());
        apiMockBasicinfo.setMethod(1);
        apiMockBasicinfo.setName("lapimoc");
        //apiMockBasicinfo.setProjectId(12);
        apiMockBasicinfo.setReqBodyType("dkjfd");
        apiMockBasicinfo.setStatusCode(200);
        apiMockBasicinfo.setUrl("kdjkjfkdj");
        //apiMockBasicinfoRepository.save(apiMockBasicinfo);
        apiMockBasicinfoRepository.save(new ApiMockBasicinfo("hello", "worlkd", 1, true, "body",
                12, 200, true,
                12, new Date(), 12,
                12, 12,
                new Date(), "desc"));


        // 测试findByName, 查询姓名为FFF的User
        Assert.assertEquals("hello", apiMockBasicinfoRepository.findByName("hello").getName());


    }


    @Test
    public void test() throws Exception {
        Logger.getLogger(ApplicationTests.class).debug("-------" + userRepository);

        // 创建10条记录
        userRepository.save(new User("AAA", 10));
        userRepository.save(new User("BBB", 20));
        userRepository.save(new User("CCC", 30));
        userRepository.save(new User("DDD", 40));
        userRepository.save(new User("EEE", 50));
        userRepository.save(new User("FFF", 60));
        userRepository.save(new User("GGG", 70));
        userRepository.save(new User("HHH", 80));
        userRepository.save(new User("III", 90));
        userRepository.save(new User("JJJ", 100));

        // 测试findAll, 查询所有记录
        Assert.assertEquals(10, userRepository.findAll().size());

        // 测试findByName, 查询姓名为FFF的User
        Assert.assertEquals(60, userRepository.findByName("FFF").getAge().longValue());

        // 测试findUser, 查询姓名为FFF的User
        Assert.assertEquals(60, userRepository.findUser("FFF").getAge().longValue());

        // 测试findByNameAndAge, 查询姓名为FFF并且年龄为60的User
        Assert.assertEquals("FFF", userRepository.findByNameAndAge("FFF", 60).getName());

        // 测试删除姓名为AAA的User
        userRepository.delete(userRepository.findByName("AAA"));

        // 测试findAll, 查询所有记录, 验证上面的删除是否成功
        Assert.assertEquals(9, userRepository.findAll().size());

    }


}
