<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${rootPath}/static/css/home.css" rel="stylesheet">
<link href="${rootPath}/static/css/input.css" rel="stylesheet">
</head>
<body>
	<header>
		<h1>회원 정보 관리</h1>
	</header>
	<section>

		<table class="member">
			<tr>
				<th>회원코드</th>
				<th>회원이름</th>
				<th>전화번호</th>
				<th>주소</th>
			</tr>
			<c:forEach items="${MEMBERS}" var="MEMBER" >
				<tr>
					<td>${MEMBER.m_code}</td>
					<td><a href="${rootPath}/member/${MEMBER.m_code}/detail">${MEMBER.m_name}</a></td>
					<td>${MEMBER.m_tel}</td>
					<td>${MEMBER.m_addr}</td>
				</tr>
			</c:forEach>

		</table>
		<div class="member button">
			<a href="${rootPath}/">처음으로</a> <a href="${rootPath}/member/input">회원정보
				추가</a>
		</div>
	</section>
	<footer>
		<address>CopyRight &copy; All Right Reserved</address>
	</footer>
</body>
</html>