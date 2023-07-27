<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 상세정보</title>
<jsp:include page="/WEB-INF/views/common/head.jsp" />
</head>
<body>
	<h3>게시물 상세정보</h3>
	<div class="container">
		<form action="/board-info/delete" method="POST">
			<input type="hidden" name="biNum" value="${board.biNum}">
			<table class="table">
				<thead>
					<tr>
						<th scope="col">번호</th>
						<td>${board.biNum}</td>
					</tr>
					<tr>
						<th scope="col">제목</th>
						<td>${board.biTitle}</td>
					</tr>
					<tr>
						<th scope="col">작성자</th>
						<td>${board.uiNum}</td>
					</tr>
					<tr>
						<th scope="col">내용</th>
						<td>${board.biContent}</td>
					</tr>
					<tr>
						<th scope="col">작성일</th>
						<td>${board.credat}</td>
					</tr>
					<c:if test="${user.uiNum == board.uiNum}">
						<tr>
							<th colspan="2">

								<button type="button" onclick="goPage('/board-info/update?biNum=${board.biNum}')">수정</button>
								<button>삭제</button>
							</th>
						</tr>
					</c:if>
				</thead>
			</table>
		</form>
		<Script>
			function goPage(url) {
				location.href = url;
			}
		</Script>
	</div>
</body>
</html>