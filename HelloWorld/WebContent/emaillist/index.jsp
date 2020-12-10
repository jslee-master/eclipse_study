<%@page import="com.bit.utils.emaillist.vo.EmaillistVo"%>
<%@page import="java.util.List"%>
<%@page import="com.bit.utils.emaillist.dao.EmaillistDaoOrcl"%>
<%@page import="com.bit.utils.emaillist.dao.EmaillistDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메일링 리스트:메인(JSP 버전)</title>
</head>
<body>
	<h1>메일링 리스트</h1>
<%
EmaillistDao dao = new EmaillistDaoOrcl();	//	DAO 객체 생성
List<EmaillistVo> list = dao.getList();
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
		<a href="<%= request.getContextPath()%>/emaillist/form.jsp">추가 이메일 등록</a>
	</p>

</body>
</html>