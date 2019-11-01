<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="/WEB-INF/views/common/header.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
난 index야<br>
<%
if(user==null){
%>
<a href="/views/user/login">로그인 페이지로</a><br>
<a href="/views/test">테스트 페이지로</a><br>
<%
}else{
%>
<%=user.get("uiName")%>님 안녕하세요~<br><br>
<a href="/views/board/list"><button>게시판 페이지로</button></a><br>
<%
}
%>
</body>
</html>