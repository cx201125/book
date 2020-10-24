package com.chenxin.blog.config;

import com.chenxin.blog.handler.UserLoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/admain/index").setViewName("admain/index");
        registry.addViewController("/admain").setViewName("admain/login");
        registry.addViewController("/admain/blogs").setViewName("admain/blogs");
       // registry.addViewController("/admain/types-input").setViewName("admain/types-input");
        //registry.addViewController("/admain/types").setViewName("admain/types");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new UserLoginInterceptor()).addPathPatterns("/admain/**")
                .excludePathPatterns("/admain")
                .excludePathPatterns("/admain/login");
    }
}
