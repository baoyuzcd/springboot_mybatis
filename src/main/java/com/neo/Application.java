package com.neo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@MapperScan("com.neo.dao")
@ImportResource({"classpath:dubbo.xml"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
