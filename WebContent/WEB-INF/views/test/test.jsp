<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<tr>
<th>이름</th>
<th>나이</th>
</tr>
<c:forEach var="list" items="${list}">
<tr>
<th>${list.name}</th>
<th>${list.age }</th>
</tr>
<c:set var="sum" value="0"/>
</c:forEach>
<c:forEach var="i" begin="0" end="100" step="2">
<c:set var="sum" value="${sum+i}"/>
</c:forEach>
${sum}
</table>
</body>
</html>