<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 TODO LIST</title>
<link href="${rootPath}/static/css/main.css?2023-07-06-011"
	rel="stylesheet" />
</head>
<body>
	<header>
		<h1>반가워요</h1>
	</header>
	<section class="main">
		<form class="main">
			<input name="to_sdate" type="date" placeholder="작성일자"
				value="${TODO.to_sdate}" /> <input name="to_stime" type="time"
				placeholder="작성시각" value="${TODO.to_stime}" /> <input
				name="to_content" placeholder="할 일" />
		</form>
		<table class="list">
			<c:if test="${empty TODOS }">
				<tr>
					<td>데이터가 없습니다.
					<td>
				</tr>
			</c:if>
			<c:forEach items="${TODOS}" var="TO">
				<tr>
					<td>${TO.to_sdate}</td>
					<td>${TO.to_stime}</td>
					<td>${TO.to_content}</td>
				</tr>
			</c:forEach>

		</table>
	</section>

</body>
</html>