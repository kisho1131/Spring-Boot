package com.javabrains.springbootquickstart.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String sayHi(){
        return  "Welcome to SpringBoot Rest Controller :) ";
    }

    @RequestMapping("/greeting")
    public String greeting(){
        return  "Hey, GoodAfter Noon Dude :))";
    }
}