package com.behzad.hasani.springboot.toolkit.aerospike.controllers;


import com.behzad.hasani.springboot.toolkit.aerospike.entities.UserEntity;
import com.behzad.hasani.springboot.toolkit.aerospike.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class UserController {

    UserService userService;



    @PostMapping("/users-type1")
    public UserEntity cacheUserType1(@RequestBody UserEntity user) {

        return userService.addUser(user);
    }
    @PostMapping("/users-type2")
    public UserEntity cacheUserType2(@RequestBody UserEntity user) {

        return userService.addUser2(user);
    }
    @PostMapping("/users-type3")
    public UserEntity cacheUserType3(@RequestBody UserEntity user) {

        return userService.addUser3(user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUserById(@PathVariable("id") Integer id) {
        userService.removeUserById(id);
    }
}
