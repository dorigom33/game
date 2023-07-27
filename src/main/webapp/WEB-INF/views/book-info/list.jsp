<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서리스트</title>
</head>
<body>
<h3>도서 리스트</h3>
<c:forEach items="${bookInfoList}" var="bookInfo">
	${bookInfo.biNum},<a href="book-info/view?biNum=${bookInfo.biNum}">${bookInfo.biTitle}</a><br>
</c:forEach>
<a href="book-info/insert">등록</a>
</body>
</html>