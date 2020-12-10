<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
세션 내부의 개별 속성(attribute)를 제어하고자 한다면 removeAttribute
세션 전체를 무효화 하고자 하면 invalidate 메서드를 사용
--%>
<% session.invalidate(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>세션을 무효화합니다.</h1>
	<p><a href="session_read.jsp">세션 변수 읽기</a></p>
</body>
</html>