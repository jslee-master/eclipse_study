<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Cookie Test</h1>
	<h3>Add/Edit Cookie</h3>

	<%
	//	CookieTestServlet에서 설정한 attribute "example" 받아오기
	String cookieValue = (String)request.getAttribute("example");
	if (cookieValue == null) cookieValue = "";
	%>
	<!-- 서버에 값을 전송하고 example이라는 이름의 쿠키를 생성 -->
	<form method="POST"
		action="<%=request.getContextPath() %>/cookies">
		<input type="text" name="example" value="<%= cookieValue %>" />
		<input type="submit" value="쿠키 설정" />
	</form>
	
	<h3>Delete Cookie</h3>
	<a href="<%= request.getContextPath() %>/cookies?a=delete">쿠키 삭제</a>
</body>
</html>