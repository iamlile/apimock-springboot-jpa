package com.myhome.lee.repository;

import com.myhome.lee.entity.ApiMockResponseHeaders;
import com.myhome.lee.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The interface User repository.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Find by name user.
     *
     * @param name the name
     * @return the user
     */
    User findByName(String name);

    /**
     * Find by name and age user.
     *
     * @param name the name
     * @param age  the age
     * @return the user
     */
    User findByNameAndAge(String name, Integer age);

    /**
     * Find user user.
     *
     * @param name the name
     * @return the user
     */
    @Query("from User u where u.name=:name")
    User findUser(@Param("name") String name);

    /**
     * With age query list.
     *
     * @param age the age
     * @return the list
     */
    @Query("select u from  User u where u.age=:age")
    List<User> withAgeQuery(@Param("age") Integer age);

}
