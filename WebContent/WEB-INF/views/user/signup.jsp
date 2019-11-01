<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="/user/signup" onsubmit="return checkForm()">

id <input type="text" name="uiId" id="uiId"><br>
password <input type="password" name="uiPwd" id="uiPwd"><br>
password 확인 <input type="password" id="uiPwdcheck"><br>
이름 <input type="text" name="uiName" id="uiName"><br>

<button>회원가입</button>

</form>

<Script>
function checkForm(){
	var uiName=document.getElementById('uiName').value;
	if(uiName.trim().length<2){
		alert("이름은 2글자 이상입니다.");
		document.getElementById('uiName').value='';
		document.getElementById('uiName').focus();
		return false;
	}
	var uiIdObj = document.getElementById('uiId');
	if(uiIdObj.value.trim().length<3){
		alert("아이디는 3글자 이상입니다.");
		uiIdObj.value = '';
		uiIdObj.focus();
		return false;
	}
	
	var uiPwdObj = document.getElementById('uiPwd');
	if(uiPwdObj.value.trim().length<5){
		alert("비밀번호는 5글자 이상입니다.");
		uiIdObj.value = '';
		uiIdObj.focus();
		return false;
	}
	
	var uiPwdCheckObj = document.getElementById('uiPwdcheck');
	if(uiPwdObj.value!=uiPwdCheckObj.value){
		alert("비밀번호 체크와 비밀번호가 일치하지 않습니다.")
		uiPwdCheckObj.value='';
		uiPwdCheckObj.focus();
		return false;
	}
	return true;
}
</script>
</body>
</html>