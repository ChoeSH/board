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
<form method="post" action="/board/insert" onsubmit="return checkForm()">

			제목 :<input type="text" name="bi_title" id="bi_title"><br>
			작성자 : <%=user.get("uiId") %><br>
			내용 :<br><textarea rows="6" cols="40" name="bi_content" id="bi_content"></textarea>
			<br>
			<button>글쓰기</button>
</form>
<script>
function checkForm(){
	var biTitle = document.getElementById('bi_title').value;
	if(biTitle.trim().length<2){
		alert('제목은 2글자 이상입니다.');
		document.getElementById('bi_title').value = '';
		document.getElementById('bi_title').focus();
		return false;
	}
	var biContentObj = document.getElementById('bi_content');
	if(biContentObj.value.trim().length<2){
		alert('게시물 내용은 2글자 이상입니다.');
		biContentObj.value = '';
		biContentObj.focus();
		return false;
	}
	return true;
}
</script>
</body>
</html>