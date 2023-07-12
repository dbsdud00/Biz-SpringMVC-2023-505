<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<c:set value="2023-07-11-005" var="version" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${rootPath}/static/css/detail.css?${version}"
	rel="stylesheet" />
</head>
<body>
	<section>
		<div class="detail date">
			<div>
				작성일자 : ${bbs.b_date}
			</div>
			<div>
				작성시각 : ${bbs.b_time}
			</div>
		</div>
		<div class="detail username">
			작성자 : ${bbs.b_username}
		</div>
		<div class="detail subject">
			제목 : ${bbs.b_subject}
		</div>
		<div class="detail content">
			내용 : ${bbs.b_content}
		</div>
	</section>
</body>
</html>