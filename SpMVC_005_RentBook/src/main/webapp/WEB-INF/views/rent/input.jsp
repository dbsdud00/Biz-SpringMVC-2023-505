<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${rootPath}/static/css/input.css" rel="stylesheet" >
</head>
<body>
	<%
	/*
		현재 member/input.jsp 는 /member/insert 와 /member/update 에서 
		사요아는 form 입력화면이다.
		insert 에서는 MEMBER 객체를 새로만들어(데이터가 모두 blank) input.jsp 에 
		보내고 있으며, update 에서는 bcode 를 가지고 findById() method 를 호출하여
		데이터를 SELECT 하고 그 데이터를 input.jsp 로 보내고 있다.
		
		MEMBER.m_code 데이터는 insert 일때는 empty(blank) 이고 update 일때는 아니다.
	*/
	%>
	<h1>회원정보 추가</h1>
	<f:form modelAttribute="RENT">
		<div>
			<label>대출일</label>
			<f:input path="rent_date" />
		</div>
		<div>
			<label>반납일</label>
			<f:input path="rent_return_date" />
		</div>
		<div>
			<label>도서코드</label>
			<f:input path="rent_bcode" />
		</div>
		<div>
			<label>회원코드</label>
			<f:input path="rent_mcode" />
		</div>
		<div>
			<label>도서반납여부</label>
			<f:input path="rent_return_yn" />
		</div>
		<div>
			<label>포인트</label>
			<f:input path="rent_point" />
		</div>
		<div>
			<label>대여금액</label>
			<f:input path="rent_price" />
		</div>
		<div>
			<a href="${rootPath}/rent">리스트로</a>
			<button type="submit">저장하기</button>
			<button type="reset">리셋</button>
		</div>
	</f:form>
</body>
</html>