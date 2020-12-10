<%@page import="com.bit.utils.emaillist.dao.EmaillistDaoOrcl"%>
<%@page import="com.bit.utils.emaillist.dao.EmaillistDao"%>
<%@page import="com.bit.utils.emaillist.vo.EmaillistVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//	요청 정보로부터 파라미터 추출
String lastName = request.getParameter("ln");
String firstName = request.getParameter("fn");
String email = request.getParameter("email");

//	DTO 객체 생성
EmaillistVo vo = new EmaillistVo();
//	필드 세팅
vo.setLastName(lastName);
vo.setFirstName(firstName);
vo.setEmail(email);
//	DAO 객체 생성
EmaillistDao dao = new EmaillistDaoOrcl();
dao.insert(vo);

//	REDIRECT
//	30x 응답 : 브라우저에게 요청 완료를 위해 새 페이지로 접속해 줄 것을 요청

response.sendRedirect(request.getContextPath() + "/emaillist/");	//	이동할 페이지를 명시
%>