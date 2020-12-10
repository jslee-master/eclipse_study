<%@page import="com.bit.utils.emaillist.dao.EmaillistDaoOrcl"%>
<%@page import="com.bit.utils.emaillist.dao.EmaillistDao"%>
<%@page import="com.bit.utils.emaillist.vo.EmaillistVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//요청 정보로부터 파라미터 추출
String email = request.getParameter("email");
//Long no = request.getParameter("no");

//DTO 객체 생성
EmaillistVo vo = new EmaillistVo();
//필드 세팅
vo.setEmail(email);
//DAO 객체 생성
EmaillistDao dao = new EmaillistDaoOrcl();
//dao.delete(vo);

response.sendRedirect(request.getContextPath() + "/emaillist/");	//	이동할 페이지를 명시
%>