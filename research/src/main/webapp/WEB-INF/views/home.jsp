<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>설문조사</title>
</head>
<body>
	<div align="center">
		<div><h2>여기서 시작</h2></div>
		<c:if test="${!empty email }">
			<div>
				<h1>${vo.email }${msg }</h1>
			</div>
		</c:if>
		<div>
			<a href="survey">설문조사 하기</a><br>
			<a href="memberList">회원목록</a><br>
			<a href="member/memberInsert">회원가입</a><br>
		</div>
	</div>
</body>
</html>