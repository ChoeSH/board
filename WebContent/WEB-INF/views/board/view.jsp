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
${user }
${board }
	<table border="1">
		<tr>
			<th>제목</th>
			<td>${board.bi_title}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${board.bi_content}</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${board.ui_id}</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td>${board.credat}</td>
		</tr>
		<tr>
			<th>작성시간</th>
			<td>${board.cretim}</td>
		</tr>
		<tr>
			<th colspan="2">
				<button onclick="goPage('/board/list')">리스트가기</button>
		<c:if test="${user.ui_num==board.ui_num }">
				<button onclick="goPage('/board/update?bi_num=${board.bi_num}')">수정하기</button>
				<button onclick="goPage('/board/delete?bi_num=${board.bi_num}')">삭제하기</button>
			</c:if>
			</th>
		</tr>
	</table>
	<script>
	function goPage(url){
		location.href=url;
	}
	
	</script>
</body>
</html>