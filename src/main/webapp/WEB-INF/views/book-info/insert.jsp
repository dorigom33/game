<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서등록</title>
</head>
<body>
	<h3>도서등록</h3>
	<form method="POST" action="insert">
		<input type="text" name="biTitle" placeholder="제목"><br> 
		<input type="text" name="biAuth" placeholder="저자"><br>
		<button>등록</button>
		<button type="reset">취소</button>
	</form>
</body>
</html>