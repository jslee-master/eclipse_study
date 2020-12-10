<%@page import="com.bit.utils.emaillist.vo.EmaillistVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메일링 리스트:메인(Model 2)</title>
</head>
<body>
	<h1>메일링 리스트</h1>
	<%
	//	서블릿에서 설정한 attribute "list" 를 받아오기
	List<EmaillistVo> list = (List<EmaillistVo>)request.getAttribute("list");
	//	Object -> List<EmaillistVo> 다운캐스팅
	%>
	<!-- 리스트 -->
	<!-- vo 객체의 getter를 이용, 리스트를 표시 -->

	<% for (EmaillistVo vo: list) { %>
	<table border="1" cellpadding="5" cellspacing="2">
		<tr>
			<th>성</th>
			<td><%= vo.getLastName() %></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><%= vo.getFirstName() %></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><%= vo.getEmail() %></td>
		</tr>
		<tr>
			<td colspan="2">
			<!-- delete.jsp에서 dao 불러와서 delete 메서드로 현재 행의 이메일 주소 레코드 삭제 -->
			<a href="<%=request.getContextPath() %>/emaillist/delete.jsp?no=<%= vo.getNo() %>">
			삭제</a>
			</td>
		</tr>
	</table>
	<br />
	<% } %>

	<p>
		<!-- /HelloWorld/emaillist/form.jsp 
		ContextPath는 설정 or 환경에따라 변경될 수 있으므로 현재 ContextPath를 확인해서 동적으로 링크 생성
		-->
		<a href="<%= request.getContextPath()%>/el?a=form">추가 이메일 등록</a>
	</p>

</body>
</html>