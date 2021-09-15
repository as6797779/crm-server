package com.example.crm.config;


import com.example.crm.interceptor.SecurityInterceptor;
import com.example.crm.interceptor.TokenInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcBaseConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加权限拦截器
        registry.addInterceptor(new TokenInterceptor());

        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
