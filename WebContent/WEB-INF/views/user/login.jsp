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
<form method = "post" action="/user/login">
	아이디 <input type="text" name="uiId" id="uiId"><br>
	비밀번호 <input type="password" name="uiPwd" id="uiPwd"><br>
	<button>로그인</button>
</form>
<br><a href="/views/user/signup"><button>회원가입</button></a>
</body>
</html>