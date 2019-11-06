<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="/WEB-INF/views/common/header.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/user/list">
아이디: <input type="text" name="uiId">
<button>검색</button>
</form>
<table border="1">
	<tr>
		<th>유저번호</th>
		<th>아이디</th>
		<th>이름</th>
		<th>가입일자</th>
	</tr>
	<c:forEach var="user" items="${list}">
		<tr>
			<td>${user.uiNum }</td>
			<td>${user.uiId }</td>
			<td>${user.uiName }</td>
			<td>${user.credat }</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>