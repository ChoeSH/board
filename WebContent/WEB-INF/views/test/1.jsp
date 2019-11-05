<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="test" value="나나나"/>	c:set은 디폴트값이 page<br>	

${test}<br>
<%@ include file ="/WEB-INF/views/common/header.jspf" %>
<%
pageContext.setAttribute("msg", "페이지 난 가장 작음");
request.setAttribute("msg", "응답이 끝나면 사라짐");		//${msg}는 현재 jsp내에서 가장 작은 msg를 출력해서 보여준다
session.setAttribute("msg", "난 세션이 끝날때까지 유지됨");	//세션은 서버를 끄거나 세션 타임아웃까지 유지됨
application.setAttribute("msg", "난 서버 끝날때까지 유지됨");	//서버를 끄기전까지 유지됨 

//RequestDispatcher rd = request.getRequestDispatcher("/views/test/2");
//rd.forward(request, response);
%>
${msg}	