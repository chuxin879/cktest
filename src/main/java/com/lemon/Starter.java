package com.lemon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@MapperScan(basePackages="com.lemon.mapper")
@EnableTransactionManagement //业务层方法加入Transactional，表示所有输出同一
public class Starter {
	public static void main(String args[]) {
		SpringApplication.run(Starter.class, args);
//		System.out.println("22");
	}
}