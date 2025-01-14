package com.behzad.hasani.springboot.toolkit.aerospike;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class AerospikeApplication {

	public static void main(String[] args) {
		SpringApplication.run(AerospikeApplication.class, args);
	}

}
