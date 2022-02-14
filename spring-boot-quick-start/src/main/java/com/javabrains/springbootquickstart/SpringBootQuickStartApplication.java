package com.javabrains.springbootquickstart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootQuickStartApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootQuickStartApplication.class, args);
        System.out.println("SpringBoot Application is started at port : 8080 ");
        System.out.println("SpringBoot Application Logging Tomcat started at port : 8080 ");
    }
}
