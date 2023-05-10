<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리</title>
<style type="text/css">
.inline-block {
	display: inline-block;
	text-align: center;
	width: 500px;
	height: 300px;
	line-height: 0.5;
}
.grid-container {
    display: grid;
    grid-template-columns: 1fr 1fr;
    grid-template-rows: 1fr 1fr;
    gap: 20px; /* Adjust as needed */
    width: 100%;
    height: 100vh; /* Adjust as needed */
}

#div1 {
    grid-area: 1 / 1 / 2 / 2;
}

#div2 {
    grid-area: 1 / 2 / 2 / 3;
}

#div3 {
    grid-area: 2 / 1 / 3 / 2;
}

#div4 {
    grid-area: 2 / 2 / 3 / 3;
}
</style>

</head>
<body>
<div class="grid-container">
	<div id = "div1" class="container inline-block" style="text-align: center;">
			<table class="container">
				<tr>
					<th>베스트게시판</th>
				</tr>
				<c:forEach items="${best}" var="board" varStatus="status">
					<c:if test="${status.index < 5}">
						<tr>
							<td>
							<c:choose>
							  <c:when test="${board.category_num == 1}">유머</c:when>
							  <c:when test="${board.category_num == 2}">썰</c:when>
							  <c:when test="${board.category_num == 3}">공포</c:when>
							  <c:when test="${board.category_num == 4}">감동</c:when>
							  <c:when test="${board.category_num == 5}">뉴스</c:when>
							  <c:when test="${board.category_num == 6}">루머</c:when>
							  <c:when test="${board.category_num == 7}">움짤</c:when>
							  <c:when test="${board.category_num == 8}">분석</c:when>
							  <c:when test="${board.category_num == 9}">레시피</c:when>
							  <c:when test="${board.category_num == 10}">맛집</c:when>
							  <c:when test="${board.category_num == 11}">자랑</c:when>
							</c:choose>
							</td>
							<td><a href="../board/info?board_num=${board.board_num}">${board.content}</a></td>
							<fmt:formatDate value="${today}" pattern="yyyy-MM-dd" var="t" />
							<fmt:formatDate value="${board.regdate}" pattern="yyyy-MM-dd"
								var="r" />
							<c:if test="${t==r}">
								<td><fmt:formatDate value="${board.regdate}"
										pattern="HH:mm:ss" /></td>
							</c:if>
							<c:if test="${t!=r}">
								<td><fmt:formatDate value="${board.regdate}"
										pattern="yyyy-MM-dd HH:mm" /></td>
							</c:if>
						</tr>
					</c:if>
				</c:forEach>
			</table>
		</div>
	</div>
		
	<div class="grid-container">
		<div id = "div2" class="container inline-block" style="text-align: center;">
			<table>
				<tr>
					<th>유머게시판</th>
				</tr>
				<c:forEach items="${humor}" var="board" varStatus="status">
					<c:if test="${status.index < 5}">
						<tr>
							<td>${board.category_num == 1 ? "유머" : board.category_num == 2 ? "썰" : board.category_num == 3? "공포" : board.category_num == 4 ? "감동" : ""}</td>
							<td><a href="../board/info?board_num=${board.board_num}">${board.content}</a></td>
							<fmt:formatDate value="${today}" pattern="yyyy-MM-dd" var="t" />
							<fmt:formatDate value="${board.regdate}" pattern="yyyy-MM-dd"
								var="r" />
							<c:if test="${t==r}">
								<td><fmt:formatDate value="${board.regdate}"
										pattern="HH:mm:ss" /></td>
							</c:if>
							<c:if test="${t!=r}">
								<td><fmt:formatDate value="${board.regdate}"
										pattern="yyyy-MM-dd HH:mm" /></td>
							</c:if>
						</tr>
					</c:if>
				</c:forEach>
			</table>
		</div>
	</div>
		
	<div class="grid-container">
	<div id = "div3" class="container inline-block" style="text-align: center;">
		<table>
			<tr>
				<th>해축게시판</th>
			</tr>
			<c:forEach items="${soccer}" var="board" varStatus="status">
				<c:if test="${status.index < 5}">
					<tr>
						<td>${board.category_num == 5 ? "뉴스" : board.category_num == 6 ? "루머" : board.category_num == 7? "움짤" : board.category_num == 8 ? "분석" : ""}</td>
						<td><a href="../board/info?board_num=${board.board_num}">${board.content}</a></td>
						<fmt:formatDate value="${today}" pattern="yyyy-MM-dd" var="t" />
						<fmt:formatDate value="${board.regdate}" pattern="yyyy-MM-dd"
							var="r" />
						<c:if test="${t==r}">
							<td><fmt:formatDate value="${board.regdate}"
									pattern="HH:mm:ss" /></td>
						</c:if>
						<c:if test="${t!=r}">
							<td><fmt:formatDate value="${board.regdate}"
									pattern="yyyy-MM-dd HH:mm" /></td>
						</c:if>
					</tr>
				</c:if>
			</c:forEach>
		</table>
	</div>
	</div>
	
	<div class="grid-container">
	<div id = "div4" class="container inline-block" style="text-align: center;">
		<table>
			<tr>
				<th>음식게시판</th>
			</tr>
			<c:forEach items="${food}" var="board" varStatus="status">
				<c:if test="${status.index < 5}">
					<tr>
						<td>${board.category_num == 9 ? "레시피" : board.category_num == 10 ? "맛집" : board.category_num == 11? "자랑" : ""}</td>
						<td><a href="../board/info?board_num=${board.board_num}">${board.content}</a></td>
						<fmt:formatDate value="${today}" pattern="yyyy-MM-dd" var="t" />
						<fmt:formatDate value="${board.regdate}" pattern="yyyy-MM-dd"
							var="r" />
						<c:if test="${t==r}">
							<td><fmt:formatDate value="${board.regdate}"
									pattern="HH:mm:ss" /></td>
						</c:if>
						<c:if test="${t!=r}">
							<td><fmt:formatDate value="${board.regdate}"
									pattern="yyyy-MM-dd HH:mm" /></td>
						</c:if>
					</tr>
				</c:if>
			</c:forEach>
		</table>
	</div>
	</div>

</body>
</html>