<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	index.jsp
<p>내 세션 아이디 : 	<%=session.getId() %></p>
<p>내 세션 타임아웃 : <%=session.getMaxInactiveInterval() %></p>
	<c:if test="${user!=null}">
${user.uiName}님 안녕하세요.
<button onclick="location.href='/user-info/logout'">로그아웃</button>
	</c:if>
	<c:if test="${user==null}">
	<button onclick="location.href='/user-info/login'">로그인</button>
	</c:if>
	<a href="/user-info/list">유저리스트</a>
</body>
</html>