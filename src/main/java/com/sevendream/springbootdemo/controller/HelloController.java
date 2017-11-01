package com.sevendream.springbootdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    //hello 或hi 都可以访问：http://127.0.0.1:8083/springboot/hello，http://127.0.0.1:8083/springboot/hi
    @RequestMapping(value = {"hello","hi"})
    public String sayHello(){
        return "Hello , SpringBoot! Let's do some interesting things!";
    }

}
