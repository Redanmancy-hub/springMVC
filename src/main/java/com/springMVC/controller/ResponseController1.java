package com.springMVC.controller;

import com.springMVC.pojo.User;
import com.springMVC.service.QuickService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


@Controller
public class ResponseController1 {

    @RequestMapping("/rsp1")
    public String rep1(){
        return "redirect:spring_mvc.jsp";
    }

    @RequestMapping("/rsp2")
    public String rsp2(){
        return "forward:spring_mvc.jsp";
    }

    @RequestMapping("/rsp3")
    public ModelAndView rsp3(ModelAndView modelAndView){
        //ModelAndView是封装模型数据和视图名的
        //设置模型数据
        User user = new User();
        user.setUsername("张三");
        user.setAge(18);
        modelAndView.addObject("user",user);
        //设置视图名称，在页面中展示模型数据
        modelAndView.setViewName("/spring_mvc.jsp");
        return modelAndView;
    }
}
