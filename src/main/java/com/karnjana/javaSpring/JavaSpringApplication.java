package com.karnjana.javaSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.karnjana"})
public class JavaSpringApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(JavaSpringApplication.class, args);
	}

}
