<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
//	세션 저장
//	세션 내에서는 어떠한 자바 객체도 다 담을 수 있다
session.setAttribute("sess1", "세션 String Test");
session.setAttribute("sess2", Integer.valueOf(2020));
session.setAttribute("sess3", Float.valueOf(3.14f));
%>
<h1>Test</h1>
<p>
	<a href="session_read.jsp">세션 변수 확인</a>
</p>
</body>
</html>