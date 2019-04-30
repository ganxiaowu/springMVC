package com.springMvc.test.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springMvc.test.aspect.handlerInterceptor.MyHandlerInterceptor;
import com.springMvc.test.aspect.handlerInterceptor.MyHandlerceptor2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;



import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by CQU-CST-WuErli on 2017/3/2 at 15:57.
 * Description :
 * Copyright (c) 2017 CQU_CST_WuErli. All rights reserved.
 */

@Configuration
@EnableWebMvc
@ComponentScan("com.springMvc.test")
public class DispatcherServletXml extends WebMvcConfigurerAdapter{
    /**
    <bean id="defaultViewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="viewClass" value="org.springframework.web.servlet.view.JstlView"/>
        <property name="prefix" value="/WEB-INF/views/"/><!--设置JSP文件的目录位置-->
        <property name="suffix" value=".jsp"/>
        <property name="exposeContextBeansAsAttributes" value="true"/>
    </bean>
     */
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setViewClass(org.springframework.web.servlet.view.JstlView.class);
        resolver.setPrefix("/WEB-INF/view/");
        resolver.setSuffix(".html");
        resolver.setExposeContextBeansAsAttributes(true);
        return resolver;
    }

    // 静态资源配置
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        // 开启默认转发
        configurer.enable();
        super.configureDefaultServletHandling(configurer);
    }

    //处理json数据
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(getMappingJackson2HttpMessageConverter());

    }


    @Bean
    public MappingJackson2HttpMessageConverter getMappingJackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        //设置日期格式
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleDateFormat smt = new SimpleDateFormat("yyyy-MM-dd");
        objectMapper.setDateFormat(smt);
        mappingJackson2HttpMessageConverter.setObjectMapper(objectMapper);
        //设置中文编码格式
        List<MediaType> list = new ArrayList<MediaType>();
        list.add(MediaType.APPLICATION_JSON_UTF8);
        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(list);
        return mappingJackson2HttpMessageConverter;
    }

    /**
    <mvc:resources mapping="/css/**" location="/WEB-INF/statics/css/"/>
    <mvc:resources mapping="/js/**" location="/WEB-INF/statics/js/"/>
    <mvc:resources mapping="/image/**" location="/WEB-INF/statics/image/"/>
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("/css/");
        registry.addResourceHandler("/js/**").addResourceLocations("/js/");
        registry.addResourceHandler("/image/**").addResourceLocations("WEB-INF/statics/image/");
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/", "classpath:/resources/");

        super.addResourceHandlers(registry);
    }

    /**
     * 拦截器 规则
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //registry.addInterceptor(new MyHandlerInterceptor()).addPathPatterns("/**/*.html");
        //registry.addInterceptor(new MyHandlerceptor2()).addPathPatterns("/**/*.html","/**/*.shtml");
    }
}
