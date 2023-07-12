<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<c:set value="2023-07-11-035" var="version" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link href="${rootPath}/static/css/home.css?${version}" rel="stylesheet" />
</head>
<body>
	<header>이미지 갤러리</header>
	<article>
		<table>
			<tr>
				<th>번호</th>
				<th>작성일자</th>
				<th>작성시각</th>
				<th>작성자</th>
				<th>제목</th>
				<th>조회수</th>
			</tr>
			<c:forEach items="${BBS_LIST}" var="bbs">
				<tr>
					<td>${bbs.b_seq}</td>
					<td>${bbs.b_date}</td>
					<td>${bbs.b_time}</td>
					<td>
					<a href="${rootPath}/search/user?username=${bbs.b_username}">
					${bbs.nickname}
					</a></td>
					<td>
					<a href="${rootPath}/search/detail?seq=${bbs.b_seq}">
					${bbs.b_subject}
					</a>
					</td>
					<td>${bbs.b_count}</td>
				</tr>
			</c:forEach>
		</table>
	</article>
	<footer> </footer>
</body>
</html>