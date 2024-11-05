///*
// * Copyright 2014 NAVER Corp.
// *
// * Licensed under the Apache License, Version 2.0 (the "License");
// * you may not use this file except in compliance with the License.
// * You may obtain a copy of the License at
// *
// *     http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// */
//
//package com.navercorp.lucy.security.xss.servletfilter;
//
//import javax.servlet.*;
//import java.io.IOException;
//
///**
// * @author todtod80
// * @author leeplay
// */
//public class XssEscapeServletFilterBackup implements Filter {
//
//	private XssEscapeFilter xssEscapeFilter = XssEscapeFilter.getInstance();
//
//	@Override
//	public void init(FilterConfig filterConfig) throws ServletException {
//	}
//
//	@Override
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//		chain.doFilter(new XssEscapeServletFilterWrapper(request, xssEscapeFilter), response);
//	}
//
//	@Override
//	public void destroy() {
//	}
//}
