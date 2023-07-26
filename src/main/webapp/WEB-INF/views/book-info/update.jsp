<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서수정</title>
</head>
<body>
<h3>도서수정</h3>
<form method="POST" action="/book-info/update">
<input type="hidden" name="biNum" value="${bookInfo.biNum}">
<input type="text" name="biTitle" placeholder="제목" value="${bookInfo.biTitle}"><br>
<input type="text" name="biAuth" placeholder="저자" value="${bookInfo.biAuth}"><br>
<button>수정</button>
<button type="reset">취소</button>
</form>

</body>
</html>