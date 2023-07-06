<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<c:set value="20230705-034" var="version" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link href="${rootPath}/static/css/home.css?${version}" rel="stylesheet">
<title>투두리스트</title>

</head>
<body>
	<header>
		<h1>TO DO List 2023</h1>
	</header>
	<section>
		<form class="inputForm" action="">
			<input id="date" placeholder=${DATE} disabled/> 
			<input id="time" placeholder=${TIME}  disabled/> 
			<input id="todo" placeholder="할일" />
		</form>
		<table class="toDoList">
			<tr class="trTag">
				<th>No.</th>
				<th>할일</th>
				<th>완료여부</th>
			</tr>
			<tr class="trTag">
				<td>1</td>
				<td>물먹기</td>
				<td><input type="checkbox"></td>
			</tr>
			<tr class="trTag">
				<td>2</td>
				<td>운동하기</td>
				<td><input type="checkbox"></td>
			</tr>
		</table>
	</section>
</body>
</html>