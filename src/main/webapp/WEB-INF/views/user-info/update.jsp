<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>회원수정</h3>
<form action="/user-info/update" method="POST">
	<input type="hidden" name="uiNum" value="${userInfo.uiNum }">
	<input type="text" name="uiId" placeholder="아이디"><br>
	<input type="text" name="uiName" placeholder="이름"><br> 
	<input type="password" name="uiPwd" placeholder="비밀번호"><br>
	<textarea name="uiDesc" placeholder="소개"></textarea><br> 
	<input type="date" name="uiBirth" placeholder="생년월일"><br>
	<button>수정</button>
</form>
</body>
</html>