<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>username</th>
			<th>이름</th>
			<th>전화번호</th>
			<th>나이</th>
			<th>주소</th>
		</tr>
		<tr>
			<td>${USER.username}</td>
			<td>${USER.name}</td>
			<td>${USER.tel}</td>
			<td>${USER.age}</td>
			<td>${USER.addr}</td>
		</tr>

	</table>
</body>
</html>