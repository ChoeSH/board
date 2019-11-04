<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="/WEB-INF/views/common/header.jspf" %>
<%
List<Map<String,String>> list = null;
if(request.getAttribute("list")!=null){
	list = (List<Map<String,String>>)request.getAttribute("list");
}
%>
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
	<tr>
<%
if(list==null || list.size()==0){
%>
	<tr>
		<td colspan="4">게시물이 없습니다.</td>
	</tr>

<%
}else{
	for(Map<String,String> board:list){
	%>
		<tr>
			<td><%=board.get("bi_num") %></td>
			<td><%=board.get("bi_title") %></td>
			<td><%=board.get("ui_num") %></td>
			<td><%=board.get("credat") %></td>
			<td><%=board.get("cretim") %></td>
		</tr>
	<%
	}
}
%>  
</table>
<button onclick="goPage('/views/board/insert')">글쓰기</button>

<script>
	function goPage(url){
		location.href=url;
	}
</script>

</body>
</html>