package com.springMVC.controller;

import com.springMVC.interceptors.MyInterceptor;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class MyWebMvcConfigurer implements WebMvcConfigurer {
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        //开启默认的servlet处理器
        configurer.enable();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加一个拦截器，配置拦截路径
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**");
    }
}
