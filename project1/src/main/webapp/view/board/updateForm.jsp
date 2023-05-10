<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
<script>
function inputcheck() {
  var f = document.f;
  var isChecked = false;
  var count = 0; // 체크된 항목의 개수를 저장할 변수
  var checkedValue = null; // 체크된 항목의 value 값을 저장할 변수
  for (var i = 0; i < f["category_num"].length; i++) {
    if (f["category_num"][i].checked) {
      isChecked = true;
      count++;
      checkedValue = f["category_num"][i].value;
    }
  }
  // 체크된 항목이 없을 경우
  if (!isChecked) {
    alert("하나 이상의 항목을 선택해주세요.");
    return false;
  }
  // 체크된 항목이 2개 이상일 경우
  if (count > 1) {
    alert("하나의 항목만 선택해주세요.");
    return false;
  }
  if (f.title.value == "") {
    alert("제목을 적어주세요.");
    f.title.focus();
    return false;
  }
  f.submit();
}
function inputout() {
  alert("게시글 등록을 취소하였습니다.");
  location.href = 'list'
}
</script>
</head>
<body>
<form action="update" method="post" name="f">
	<input type="hidden" name="board_num" value="${b.board_num}">
	<input type="hidden" name="boardid" value="${b.boardid}">
	<div class="container">
	<c:if test="${b.boardid == 2 }">
   <table>
      <tr>
         <td>
            유머<input type="checkbox" name="category_num" value="1">&nbsp;&nbsp;&nbsp;
            썰<input type="checkbox" name="category_num" value="2">&nbsp;&nbsp;&nbsp;
            공포<input type="checkbox" name="category_num" value="3">&nbsp;&nbsp;&nbsp;
            감동<input type="checkbox" name="category_num" value="4">&nbsp;&nbsp;&nbsp;
         </td>
      </tr>
</c:if>      
<c:if test="${b.boardid == 3}">
   <table>
      <tr>
         <td>
            뉴스<input type="checkbox" name="category_num" value="5">&nbsp;&nbsp;&nbsp;
            루머<input type="checkbox" name="category_num" value="6">&nbsp;&nbsp;&nbsp;
            움짤<input type="checkbox" name="category_num" value="7">&nbsp;&nbsp;&nbsp;
            분석<input type="checkbox" name="category_num" value="8">&nbsp;&nbsp;&nbsp;
         </td>
      </tr>
     </table>
</c:if>

<c:if test="${b.boardid == 4}"> 
   <table>
      <tr>
         <td>
            레시피<input type="checkbox" name="category_num" value="9">&nbsp;&nbsp;&nbsp;
            맛집<input type="checkbox" name="category_num" value="10">&nbsp;&nbsp;&nbsp;
            자랑<input type="checkbox" name="category_num" value="11">&nbsp;&nbsp;&nbsp;
         </td>
      </tr>
      </table>
</c:if>   
		<table>
			<tr>
				
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="title" value="${b.title}"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td>
					<textarea rows="5" cols="68" name="content">${b.content}</textarea>
				</td>
			</tr>
			<script>
				CKEDITOR.replace("content", {
					filebrowserImageUploadUrl : "imgupload"
				})
			</script>
			<tr>
				<td colspan="2"><a href="javascript:document.f.submit()">[게시물수정]</a></td>
			</tr>
		</table>
	</div>
</form>	
</body>
</html>