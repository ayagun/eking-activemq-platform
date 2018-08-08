package com.eking.activemq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
	@MapperScan(basePackages = "com.eking.activemq")
	@ComponentScan(basePackages= "com.eking.activemq")
	public class EkingActivemqApplication {

	public static void main(String[] args) {
		SpringApplication.run(EkingActivemqApplication.class, args);
	}
}
