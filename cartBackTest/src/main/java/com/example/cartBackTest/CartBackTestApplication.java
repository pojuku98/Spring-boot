package com.example.cartBackTest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.cartBackTest.dao")
public class CartBackTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(CartBackTestApplication.class, args);
	}

}
