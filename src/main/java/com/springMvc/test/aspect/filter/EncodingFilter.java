package com.springMvc.test.aspect.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2019/3/27.
 */
public class EncodingFilter implements Filter{
    private String encoding;


    public void init(FilterConfig filterConfig) throws ServletException {
        this.encoding = "utf-8";
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        HttpServletResponse response=(HttpServletResponse)servletResponse;

        request.setCharacterEncoding(encoding);
        response.setCharacterEncoding(encoding);
        System.out.println("encodingFilter ----------------------");
        //过滤通行证
        filterChain.doFilter(request, response);

    }

    public void destroy() {

    }
}
