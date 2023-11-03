package com.springMVC.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springMVC.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


/*@Controller
@ResponseBody*/
@RestController
public class ResponseController2 {

    @RequestMapping("/ajax/req2")
    //@ResponseBody
    public User req2() throws Exception {
        User user = new User();
        user.setUsername("zhangsan");
        user.setAge(18);
        return user;
    }

    @RequestMapping("/ajax/req1")
    //@ResponseBody
    public String req1(){
        return "{\"username\":\"zhangsan\",\"age\":\"18\"}";
    }
}
