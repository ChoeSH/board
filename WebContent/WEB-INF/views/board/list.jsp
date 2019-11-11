<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jspf"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일자</th>
			<th>작성시간</th>
		</tr>
		<c:if test="${empty list}">
			<tr>
				<td colspan="4">게시물이 없습니다.</td>
			</tr>
		</c:if>
		<c:forEach var="board" items="${list}">
			<tr>
				<td>${board.bi_num}</td>
				<td><a href="/board/view?bi_num=${board.bi_num}">${board.bi_title}</td>
				<td>${board.ui_num}</td>
				<td>${board.credat}</td>
				<td>${board.cretim}</td>
			</tr>
		</c:forEach>
	</table>
	<button onclick="goPage('/views/board/insert')">글쓰기</button>

	<script>
	window.onload = function(){
		var xhr=XMLHttpRequest();
		xhr.open('GET','/board/list');
		xhr.onreadystatechange = function(){
			if(xhr.readyState==4){
				if(xhr.status==200){
					var list = JSON.parse(xhr.responseText);	//json으로 java와 javascript 통신하는것이 다수
					html = '';
					for(var i=0;i<list.length;i++){
					html = '<tr>';
					html+='<td>'+list[i].bi_Num+'</td>';
					html+='<td>'+list[i].bi_Title+'</td>';
					html+='<td>'+list[i].bi_Name+'</td>';
					html+='<td>'+list[i].credat+'</td>';
					html+='<td>'+list[i].cretim+'</td>';
					html+='</tr>';
					}
					document.getElementById('tBody').innerHTML=html;	
				}
			}
		}
		xhr.send();
	}
		function goPage(url) {
			location.href = url;
		}
	</script>

</body>
</html>