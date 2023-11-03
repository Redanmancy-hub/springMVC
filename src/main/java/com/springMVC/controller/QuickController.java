package com.springMVC.controller;

import com.springMVC.service.QuickService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class QuickController {

    //直接注入Service进行使用
    @Autowired
    private QuickService quickService;

    //@RequestMapping(value = "/show",method = RequestMethod.GET)
    @GetMapping("/show")
    public String show(){
        System.out.println("running...."+quickService);
        return "/spring_mvc.jsp";
    }
}
