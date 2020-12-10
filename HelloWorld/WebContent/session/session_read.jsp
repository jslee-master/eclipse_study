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
	<h1>세션 읽기 테스트</h1>
	<%
	//	세션 내 저장된 객체 읽어오기: session.getAttribute
	//	세션 내 객체를 다운캐스팅
	String sess1 = (String)session.getAttribute("sess1");
	Integer sess2 = (Integer)session.getAttribute("sess2");
	Float sess3 = (Float)session.getAttribute("sess3");
	%>
	<p>sess1(String): <%= sess1 %></p>
	<p>sess2(Integer): <%= sess2 %></p>
	<p>sess3(Float): <%= sess3 %></p>
	
	<p>
		<a href="session_invalidate.jsp">세션 무효화</a>
	</p>
</body>
</html>