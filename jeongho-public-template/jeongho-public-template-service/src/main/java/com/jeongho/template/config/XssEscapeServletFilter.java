package com.jeongho.template.config;

import jakarta.servlet.FilterConfig;
import jakarta.servlet.*;

import java.io.IOException;

public class XssEscapeServletFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
