<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 리스트</title>
<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
<script src="/resources/js/bootstrap.js"></script>
<script src="/resources/js/bootstrap.bundle.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/2.9.2/umd/popper.min.js" integrity="sha512-2rNj2KJ+D8s1ceNasTIex6z4HWyOnEYLVC3FigGOmyQCZc2eBXKgOxQmo3oKLHyfcj53uz4QMsRCWNbLd32Q1g==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<link rel="stylesheet" href="/resources/css/bootstrap.css"> 
<link rel="stylesheet" href="/resources/css/bootstrap-grid.css"> 
<link rel="stylesheet" href="/resources/css/bootstrap-reboot.css">
</head>
<body>
	<h3>게시물 리스트</h3>
	<div class="container">
		<table class="table">
			<thead>
				<tr>
					<th scope="col">번호</th>
					<th scope="col">제목</th>
					<th scope="col">작성자</th>
					<th scope="col">작성일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${boardInfoList}" var="board">
				<tr>
				<td>${board.biNum}</td>
				<td>${board.biTitle}</td>
				<td>${board.uiNum}</td>
				<td>${board.credat}</td>
				</tr>
				</c:forEach>
				<tr>
					<td colspan="4" align="right"><button type="button" class="btn btn-primary" onclick="">등록</button></td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>