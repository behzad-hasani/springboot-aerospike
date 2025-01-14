package com.behzad.hasani.springboot.toolkit.aerospike.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
public class UserEntity {
    @Id
    private int id;
    private String name;
    private String email;
    private int age;
}
