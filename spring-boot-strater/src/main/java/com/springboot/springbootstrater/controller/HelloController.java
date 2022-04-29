package com.springboot.springbootstrater.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String hello(){
        return "Hello Spring Boot :))";
    }

    @RequestMapping(value = "/method", method = RequestMethod.GET)
    public String method(){
        return "Return Method !!";
    }
}
