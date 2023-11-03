package com.springMVC.init;

import com.springMVC.config.SpringMVCConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyAbstractAnnotationConfigDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    //提供spring容器的核心配置类
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringMVCConfig.class};
    }


    @Override
    //提供springMVC容器的核心配置类
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMVCConfig.class};
    }

    @Override
    //提供前端控制器的映射路径
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
