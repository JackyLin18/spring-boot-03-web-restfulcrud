package com.smart.filter;

import javax.servlet.*;
import java.io.IOException;
import java.util.EventListener;

public class MyFilter implements Filter, EventListener {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("MyFilter#doFilter() invoked...");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
