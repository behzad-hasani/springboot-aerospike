package com.behzad.hasani.springboot.toolkit.aerospike.services;

import com.behzad.hasani.springboot.toolkit.aerospike.entities.UserEntity;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

@Repository
public class UserService {


    @Cacheable(value = "user-set1", key = "#user.id")
    public UserEntity addUser(UserEntity user) {
        return user;
    }
    @Cacheable(value = "user-set2", key = "#user.id")
    public UserEntity addUser2(UserEntity user) {
        return user;
    }
    @Cacheable(value = "user-set3", key = "#user.id")
    public UserEntity addUser3(UserEntity user) {
        return user;
    }

    @CacheEvict(value = "user-set1", key = "#id")
    public void removeUserById(int id) {
        System.out.println("Remove user by id: " + id);
    }
}
