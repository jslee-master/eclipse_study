<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 현재 페이지가 컴파일 되어야 할 jsp 페이지임을 명시 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 사용자가 파라미터로 변수를 전달할 경우 -->
	<!-- url?파라미터명=값&파라미터명=값 형태로 전달 -->
	<%	//	jsp 페이지 내에서 자바 코드 사용
	//	사용자가 전달한 name 파라미터의 값을 확인
	String name = request.getParameter("name");
	//	파라미터가 전달되지 않으면 기본 값으로 설정
	if (name == null) {
		name = "Unknown";
	}
	%>
	
	<h1>Hello, JSP</h1>
	<p>Hello, <%=name %></p><!-- 값 출력을 위한 JSP 태그 -->
	
	<a href="index.html">인덱스 페이지로</a>
</body>
</html>