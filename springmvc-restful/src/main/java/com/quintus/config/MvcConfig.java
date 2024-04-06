package com.quintus.config;

import com.quintus.interceptor.MyInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.net.MalformedURLException;

@Configuration
@ComponentScan({"com.quintus.controller", "com.quintus.error"})
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 拦截全部请求
        registry.addInterceptor(new MyInterceptor());

        // 指定地址拦截
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/user/**");

        // 排除地址拦截 （排除的地址应该在拦截地址内部！
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/user/**").excludePathPatterns("/user/data1");
    }
}
