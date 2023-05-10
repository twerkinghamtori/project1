<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
</head>
<body>
<div class="container">
<h2 id="center">회원 목록</h2>
<table class="table talbe-hover">
	<tr>
		<th>아이디</th>
			<th>사진</th>	
					<th>전화</th>
	</tr>
		<c:forEach var = "m" items="${list}">
		<tr>
			<td>
				<a href = "info?id=${m.member_id}">${m.member_id}</a>
			</td>
			<td>
				${m.tel}
			</td>
			<td>
				<a href = "updateForm?id=${m.member_id}">
					수정
				</a>&nbsp;&nbsp;&nbsp;
					<c:if test="${m.member_id != 'admin'}">
    					<a href = "deleteForm?id=${m.member_id}">
    						강제탈퇴
    					</a>
					</c:if>
			</td>
			<td>
				<input type='checkbox' name='idchks' value="${m.member_id}"/>
				<br/>
			</td>
		</tr>
		</c:forEach>
</table>
<div id="center">
</div>
</div>
</body></html>