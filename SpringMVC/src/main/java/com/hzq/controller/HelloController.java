package com.hzq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    @RequestMapping("/hello")
    public String name(){
        System.out.println("进入hello");

        return "/WEB-INF/index.jsp";
    }

}
