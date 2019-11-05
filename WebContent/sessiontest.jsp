<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
Date time = new Date();
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
String sessionId=session.getId();
Long creTime= session.getCreationTime();
time.setTime(creTime);
String cre = sdf.format(time);
Long modTime= session.getLastAccessedTime();
time.setTime(modTime);
String mod = sdf.format(time);

%>
sessionId : <%=sessionId %><br>
creTime : <%=cre %><br>
modTime : <%=mod %><br>
</body>
</html>