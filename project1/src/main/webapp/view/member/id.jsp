<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script type="text/javascript">
	function idsend(member_id){		
	opener.document.f.member_id.value=member_id;
	self.close();
	}
</script>
</head>
<body>
<div class="container">
	<table class="table">
  <tr><th>아이디</th>
    <td>${member_id}**</td>
  </tr>
  <tr><td colspan="2">
     <input type="button" value="아이디전송" 
     onclick="idsend('idsend('${member_id}')">
  </td></tr>
</table>
</div>
</body>
</html>
