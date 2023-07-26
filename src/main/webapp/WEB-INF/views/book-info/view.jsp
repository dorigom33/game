<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 상세정보</title>
</head>
<body>
<form action="/book-info/delete" method="POST">
<input type="hidden" name="biNum" value="${bookInfo.biNum}">
<h3>도서 상세정보</h3>
제목 : ${bookInfo.biTitle}<br>
저자 : ${bookInfo.biAuth}<br>
<button type="button" onclick="location.href='/book-info/update?biNum=${bookInfo.biNum}'">수정</button>
<button>삭제</button>
</form>

</body>
</html>