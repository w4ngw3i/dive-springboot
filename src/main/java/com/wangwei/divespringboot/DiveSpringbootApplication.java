package com.wangwei.divespringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan(basePackages = "com.wangwei.divespringboot.web.servlet")
@SpringBootApplication
public class DiveSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiveSpringbootApplication.class, args);
	}
}
