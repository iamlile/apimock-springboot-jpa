package com.myhome.lee.repository;

import com.myhome.lee.entity.ApiMockResponseHeaders;
import com.myhome.lee.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByName(String name);

    User findByNameAndAge(String name, Integer age);

    @Query("from User u where u.name=:name")
    User findUser(@Param("name") String name);

    @Query("select u from  User u where u.age=:age")
    List<User> withAgeQuery(@Param("age") Integer age);

}
