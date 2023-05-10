<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- model2 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 변경</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script type="text/javascript">
	function inchk(f){
		if(f.pass.value == ""){
			alert("현재비밀번호를 입력하세요");
			f.pass.focus();
			return false;
		}
		if(f.pass.value == ""){
			alert("변경비밀번호를 입력하세요");
			f.chpass.focus();
			return false;
		}
		if(f.pass.value == ""){
			alert("변경비밀번호 재입력하세요");
			f.chapss2.focus();
			return false;
		}
		if(f.chgpass.value != f.chgpass2.value){
			alert("변경 비밀번호와 변경비밀번호재입력하세요");
			f.chapass.focus();
			f.chapass2.focus();
			return false;
		}
		return true;
	}
</script>
</head>
<body>
<form action="password" method="post" name="f"
		onsubmit="return inchk(this)">
<table><caption>비밀번호 변경</caption>
	<tr><th>현재비밀번호</th>
		<td><input type="password" name="pass"></td></tr>
	<tr><th>변경비밀번호</th>
		<td><input type="password" name="chgpass"></td></tr>
	<tr><th>변경비밀번호재입력</th>
		<td><input type="password" name="chgpass2"></td></tr>
	<tr><td colspan="2">
		<input type="submit" value="비밀번호변경">
		<input type="reset" value="초기화"></td></tr>
</table></form>
</body>
</html>