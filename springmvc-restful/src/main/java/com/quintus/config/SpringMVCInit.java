package com.quintus.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringMVCInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{MvcConfig.class};   // 加载对应的MVC配置类文件
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};   // 设置访问地址
    }


}
