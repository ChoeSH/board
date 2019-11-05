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
<c:set var="str" value="abcd" scope="request"/>
<c:if test="${str eq 'abc' }">
str은 abc
</c:if>
<c:if test="${str ne 'abc' }">
str은 abc가 아니다
</c:if>
<br>
<c:choose>
<c:when test="${str =='abc' }">
str은 abc이다
</c:when>
<c:otherwise>
str은 abc가 절대 아니다.
</c:otherwise>
</c:choose>

</body>
</html>