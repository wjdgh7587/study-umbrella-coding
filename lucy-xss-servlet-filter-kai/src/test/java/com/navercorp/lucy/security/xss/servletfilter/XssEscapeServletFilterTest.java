/*
 * Copyright 2014 NAVER Corp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.navercorp.lucy.security.xss.servletfilter;

import jakarta.servlet.http.HttpServletRequest;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.mock.web.MockFilterChain;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;

import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author todtod80
 * @author leeplay
 */
@Ignore
public class XssEscapeServletFilterTest {
	XssEscapeServletFilter filter = new XssEscapeServletFilter();
	MockHttpServletRequest request;
	MockHttpServletResponse response = new MockHttpServletResponse();
	MockFilterChain chain = new MockFilterChain();


	
	@Test
	public void testDoFilterWithUndefinedUrl() throws IOException, ServletException {
		request = new MockHttpServletRequest("GET", "/notExistUrl.do");
		request.addParameter("title", "<b>Text</b>");
		request.addParameter("globalParameter", "<b>Text</b>");
		
		filter.doFilter(request, response, chain);
		
		assertFiltered("title", "&lt;b&gt;Text&lt;/b&gt;", request);
		assertFiltered("globalParameter", "<b>Text</b>", request);
	}

	@Test
	public void testDoFilterWithDefinedUrl() throws IOException, ServletException {
		request = new MockHttpServletRequest("POST", "/url1.do");
		request.addParameter("title", "<b>Text</b>");
		request.addParameter("mode", "<script>Text</script>");
		request.addParameter("globalParameter", "<script>Text</script>");
		request.addParameter("url1Parameter", "<hello>");

		System.out.println(request.getParameter("title"));

		filter.doFilter(request, response, chain);

		assertFiltered("title", "&lt;b&gt;Text&lt;/b&gt;", request);
		assertFiltered("mode", "&lt;script&gt;Text&lt;/script&gt;", request);
		assertFiltered("globalParameter", "&lt;script&gt;Text&lt;/script&gt;", request);
		assertFiltered("url1Parameter", "<hello>", request);
	}
	
	private void assertFiltered(String paramName, String filteredValue, HttpServletRequest httpServletRequest) {
//		ServletRequest filteredRequest = chain.getRequest();
		ServletRequest filteredRequest = request;
		assertThat(filteredRequest.getParameter(paramName), is(filteredValue));
	}
}
