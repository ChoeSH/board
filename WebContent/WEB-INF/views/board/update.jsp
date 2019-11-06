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
${board} 
<form method="post" action="/board/update">
		<table border="1">
			<tr>
				<th>제목</th>
				<td><input type="text" name="bi_title" value="${board.bi_title}"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><%=user.get("uiId")%></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="bi_content">${board.bi_content}</textarea></td>
			</tr>
			<tr>
				<th colspan="2"><button>수정하기</button></th>
			</tr>
		</table>
		<input type="hidden" name="bi_num" value="${board.bi_num }">
		</form>
</body>
</html>