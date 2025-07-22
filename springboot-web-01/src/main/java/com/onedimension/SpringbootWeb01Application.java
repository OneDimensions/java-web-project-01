package com.onedimension;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 此注解中包含了ComponentScan扫描注解 默认扫描当前包及子包
@SpringBootApplication
public class SpringbootWeb01Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootWeb01Application.class, args);
	}

}
