<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 삭제</title>
</head>
<body>
	<h2>게시물 삭제</h2>
	<form action="delete" method="post">
		<input type="hidden" name="board_num" value="${param.board_num}">
		<label>비밀번호:</label>
		<input type="password" class="from-control" name="pass">
		<div id="center" style="padding: 3px;">
			<button type="submit">게시물삭제</button>
		</div>
	</form>
</body>
</html>