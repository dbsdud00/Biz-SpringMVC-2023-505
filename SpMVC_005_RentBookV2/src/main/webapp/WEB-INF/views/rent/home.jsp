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
		<h1>도서대여 처리</h1>
	</header>
	<section>

		<table class="rent">
			<tr>
				<th>도서코드</th>
				<th>도서명</th>
				<th>출판사</th>
				<th>회원코드</th>
				<th>회원명</th>
				<th>전화번호</th>

				<th>대출일</th>
				<th>반납예정일</th>
				<th>도서반납여부</th>
				<th>대여금액</th>

				<th>포인트</th>
			</tr>
			<c:forEach items="${RENTBOOKS}" var="RENTBOOK">
				<tr>
					<td>${RENTBOOK.rent_bcode}</td>
					<td>${RENTBOOK.b_name}</td>
					<td>${RENTBOOK.b_comp}</td>
					
					<td>${RENTBOOK.rent_mcode}</td>
					<td>${RENTBOOK.m_name}</td>
					<td>${RENTBOOK.m_tel}</td>
					<td>${RENTBOOK.rent_date}</td>
					<td>${RENTBOOK.rent_return_date}</td>
					<td>${RENTBOOK.rent_return_yn == 'Y' ? '반납' : '미반납'}</td>
					<td>${RENTBOOK.rent_price}</td>
					<td>${RENTBOOK.rent_point}</td>
				</tr>
			</c:forEach>

		</table>
		<div class="rent button">
			<a href="${rootPath}/">처음으로</a> <a href="${rootPath}/rent/input">도서대여</a>
			<a href="${rootPath}/rent/return">도서반납</a>
		</div>
	</section>
</body>
</html>