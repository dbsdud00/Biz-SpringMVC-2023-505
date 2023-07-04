<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form class="form user login" method="post">

	<fieldset>
		<legend> 로그인 </legend>
		<c:if test="${ERROR == 'F_USERNAME'}">

			<div class="error">	USERNAME 이 없습니다.</div>
		</c:if>
		<c:if test="${ERROR == 'F_PASSWORD'}">

			<div class="error">비밀번호가 잘못되었습니다.</div>
		</c:if>
		<input placeholder="USER NAME" name="username" /> <input
			placeholder="PASSWORD" name="password" />
		<button>로그인</button>
	</fieldset>
</form>

