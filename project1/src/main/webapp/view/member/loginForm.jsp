<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<style>

</style>
<script type="text/javascript">
   function input_check(f) {
	   if(f.member_id.value.trim() == '') {
		   alert("아이디를 입력하세요")
		   f.member_id.focus()
		   return false
	   }
	   if(f.pass.value.trim() == '') {
		   alert("비밀번호를 입력하세요")
		   f.pass.focus()
		   return false
	   }
	   return true
   }
   function win_open(page) {
	   let op="width=500,height=350,left=50,top=150"
	   open(page+"","",op)
   }
</script>
</head>
<body>
<form action="login" method="post" name="f"
     onsubmit="return input_check(this)" id="login-form">
     <div class="container" style="text-align:center; margin-top:200px; ">
     <h2 align="center"  >로그인</h2>
     <div class="form-group">
     	<label for="usr"></label>
     		<input type="text" class="form-control" id="usr" name="member_id" placeholder="아이디" ><br><br>
     	<label for="pwd" ></label>
     		<input type="password" class="form-control" id="pwd" name="pass" placeholder="비밀번호"><br><br>
     </div>
     <div id="center" style="padding:3px;">
     	<button type="submit" class="btn btn-dark">로그인</button>
     	<button type="button" onclick="win_open('idForm')" class="btn btn-dark">아이디찾기</button>
     	<button type="button" onclick="win_open('pwForm')" class="btn btn-dark">비밀번호찾기</button>
     </div></div>
   
     </form></body></html>