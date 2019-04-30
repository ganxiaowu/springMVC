package com.springMvc.test.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


public class WebXml extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {ApplicationContextXml.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {DispatcherServletXml.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}
