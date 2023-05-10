<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 탈퇴</title>
<script type="text/javascript">
	function inputcheck(f){
		if(f.pass.value == ""){
			alert("비밀번호를 입력하세요");
			f.pass.focus();
			return false;
		}
	}
</script>
</head>
<body>
<form action="delete" method="post" onsubmit="return inputcheck(this)">
	<input type="hidden" name="member_id" value="${param.member_id }">
	<table class="table"><caption>회원비밀번호 입력</caption>
	<tr><th>비밀번호</th>
		<td><input type="password" name="pass"></td></tr>
	<tr><td colspan="2">
		<input type="submit" value="탈퇴하기"></td></tr>
	</table>
	</form>
</body>
</html>
