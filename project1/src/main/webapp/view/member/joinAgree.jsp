<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>개인정보 약관</title>
<script type="text/javascript">
function is_checked(){
const agreeCheckbox = document.getElementsByName("agreeCheckbox");
const signupButton = document.getElementById("signupButton");

agreeCheckbox[0].addEventListener("change", function() {
  if (this.checked) {
    signupButton.disabled = false;
  } else {
    signupButton.disabled = true;
  }
});
}
function signUp() {

	  const agreeCheckbox = document.getElementsByName("agreeCheckbox");

	  if (agreeCheckbox[0].checked) {
	    return true;
	  }
		alert("가입하기 전에 개인정보처리방침에 동의해야 합니다.");
	  return false;
	}

</script>
<style type="text/css">
   h2{
      color : white;
      align : center;
   }
   .scrolltable {
        display: block;
        overflow: auto;
   }

</style>
</head>
<body onload="is_checked();">
	<div class="container">
		<h2 align="center">개인정보 약관 동의서</h2>
		<hr>
		<table class='scrolltable' style="width:800px; height:300px; margin:auto;">
			<tr><th> 개인정보 수집 동의서 </th></tr>
			<tr><td> 개인정보 동의해라개인정보 동의해라개인정보 동의해라
			개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라
			개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라
			개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라
			개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라
			개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라
			개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라
			개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라
			개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라
			개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라
			개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라
			개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라
			개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라
			개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라
			개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라
			개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라
			개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라
			개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라
			개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라
			개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라
			개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라
			개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라
			개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라
			개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라
			개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라
			개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라
			개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라
			개인정보 동의해라개인정보 동의해라개인정보 동의해라
			개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라
			개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라
			개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라
			개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라
			개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라
			 </td></tr>
		</table>
		<br>
		<div >
  <div style="text-align:center;">
 <form action="joinForm" onsubmit="return signUp();">
        동의<input type='checkbox'name="agreeCheckbox" value="Agree"/>
  <br>
    <button type="submit" class="btn btn-dark" id="signupButton">동의 및 회원가입</button>
    </form>
  </div>
</div>
      <hr>
   </div>
</body>
</html>