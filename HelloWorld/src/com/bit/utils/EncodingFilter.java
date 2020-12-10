package com.bit.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//	필터
//	여러 서블릿에서 공동으로 수행되어야 할 요청과 응답을 대신 처리하는 기능
//	javax.servlet.Filter를 구현해야 한다
public class EncodingFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		Filter.super.destroy();
	}

	@Override
	public void doFilter(ServletRequest req, 
			ServletResponse resp, 
			FilterChain chain)
			throws IOException, ServletException {
		//	전달 받은 요청 객체에 작업을 수행
		req.setCharacterEncoding("UTF-8");
		//	뒤쪽에 연결된 필터 (혹은 서블릿)로 요청과 응답을 전달
		chain.doFilter(req, resp);
		//	응답의 경우 필터의 적용 순서는 역순
		//	응갑 객체의 추가적인 처리
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		Filter.super.init(filterConfig);
	}

}
