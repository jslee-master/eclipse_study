package com.bit.utils.emaillist.controller;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/cookies")
public class CookieTestServlet extends HttpServlet {
	//	GET 처리
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("a");
		if ("delete".equals(action)) {
			//	쿠키 삭제
			Cookie[] cookies = req.getCookies();
			if (cookies != null) {
				for (Cookie cookie: cookies) {
					if (cookie.getName().equals("example")) {
						//	쿠키 무효화: 지속시간을 0으로
						cookie.setMaxAge(0);
						resp.addCookie(cookie);
						break;
					}
				}
			}
		} else {
			//	요청 정보로부터 쿠키얻어오기
			Cookie[] cookies = req.getCookies();	//	쿠키의 배열
			//	쿠키가 비어 있는가?
			if (cookies != null) {
				//	쿠키가 있다.
				//	세팅했던 example 쿠키를 확인
				for (Cookie cookie: cookies) {
					//	쿠키의 이름 확인
					if (cookie.getName().equals("example")) {
						String cookieValue = URLDecoder.decode(cookie.getValue(), "UTF-8");
						//	찾아낸 쿠키의 값을 attribute로 추가
						req.setAttribute("example", cookieValue);
						break;
					}
				}
			}
		}

		//	쿠키 설정 폼으로 Forward
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/views/cookies/cookie_form.jsp");
		rd.forward(req, resp);
	}

	//	POST 처리
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//	쿠키 설정
		//	폼으로부터 example 값을 얻어오자
		String value = req.getParameter("example");
		//	example이라는 이름을 가진 쿠키를 설정
		Cookie cookie = new Cookie("example", URLEncoder.encode(value, "UTF-8"));
		//	쿠키 지속 시간
		cookie.setMaxAge(3600);
		//	쿠키를 저장하기 위해 응답에 추가해서 클라이언트로 전송
		resp.addCookie(cookie);
		
		resp.sendRedirect(req.getContextPath() + "/cookies");
	}

}
