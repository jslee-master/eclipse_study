<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메일링 리스트: 가입 폼(JSP 버전)</title>
</head>
<body>
	<h1>메일링 리스트 가입</h1>
	<p>메일링 리스트에 가입하시려면,<br />
	아래 항목을 기입하고 등록 버튼을 클릭하세요.
	</p>
	<!-- action : 해당 요청을 처리할 페이지의 주소, method : 해당 폼을 전송할 때 사용할 전송 방식 -->
	<form action="<%= request.getContextPath() %>/emaillist/insert.jsp" method="POST">
		<label for="ln">성</label>
		<input type="text" name="ln" value=""><br />
		<label for="fn">이름</label>
		<input type="text" name="fn" value=""><br/>
		
		<label for="email">이메일</label>
		<input type="text" name="email" value=""><br />
		
		<input type="submit" value="등록">
	</form>
	
	<p>
		<a href="">목록</a>
	</p>
</body>
</html>