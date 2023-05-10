<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script type="text/javascript">
   function input_check(f) {
	   if(f.member_id.value.trim() == "") {
		   alert("아이디를 입력하세요")
		   f.member_id.focus()
		   return false;
	   }
	   if(f.pass.value.trim() == "") {
		   alert("비밀번호를 입력하세요")
		   f.pass.focus()
		   return false;
	   }
	   return true;
   }
</script>
<style type="text/css">
	div{
		text-align:center;
	}
</style>
</head>
<body>

<form action="join" method="post" name="f" onsubmit="return input_check(this)">
<input type="hidden" name="picture" value="">
<div class="container">
	<h2 align="center">회원가입</h2>
	<div class="row">
		<div class="col-3 bg-light" id="center">
	</div>
	<div class="col-9">
		<div class="form-group">
			<br><label for="id">아이디:</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="text" class="form-control" name="member_id" id="id" style="width:250px"> <br>
			<br><label for="pwd">비밀번호:</label>&nbsp;
				<input type="password" class="form-control" name="pass" id="pwd" style="width:250px"> <br>
		</div>
	</div>
</div>
<br>
	<div class="form-group">
		<label for="tel">전화번호:</label>&nbsp;
			<input type="text" class="form-control" name="tel" id="tel" style="width:250px">
	</div>
	<br>
		<div class="form-group">
			<label for="email">이메일:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="text" class="form-control" name="email" id="email" style="width:250px"><br>
	</div>
	<br>
		<div id="center" style="padding:3px;">
			<button type="submit" class="btn btn-dark">회원가입</button>
			<button type="reset" class="btn btn-dark">다시작성</button>
	</div>
</div>
</form>
</body>
</html>