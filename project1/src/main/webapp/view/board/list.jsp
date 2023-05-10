<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 목록</title>
<script type="text/javascript">
    function listsubmit(page) {
    	f = document.sf;  //검색 form 태그
    	f.pageNum.value=page;
    	f.submit();
    }
</script>    
</head>
<body>
<h2>${boardName}</h2>
<table>
	<c:if test="${boardcount == 0}">
		<tr>
			<td colspan="5">등록된 게시글이 없습니다.</td>
		</tr>	
	</c:if>
	<c:if test="${boardcount > 0}">
		<tr>
			<td colspan="5" style="text-align:right">글개수:${boardcount}
			<c:if test="${boardid!=1}">
			<a href="popularList?boardid=${boardid}">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[인기글]</a>
			</c:if>
			</td>
			
		</tr>
		<tr>
			<th width="5%">글번호</th>
			<th width="10%">분류</th>
			<th width="40%">제목</th>
			<th width="15%">글쓴이</th>
			<th width="20%">작성일</th>
			<th width="5%">조회수</th>
			<th width="5%">추천수</th>
		</tr>
		
		<c:forEach var="b" items="${list}">
 		<tr>
 			<td>${boardnum}</td>
 			<c:set var="boardnum" value="${boardnum - 1}" />

<td>
    <c:choose>
        <c:when test="${b.category_num == 1}">
            유머
        </c:when>
        <c:when test="${b.category_num == 2}">
            썰
        </c:when>
        <c:when test="${b.category_num == 3}">
            공포
        </c:when>
        <c:when test="${b.category_num == 4}">
            감동
        </c:when>
        <c:when test="${b.category_num == 5}">
            뉴스
        </c:when>
        <c:when test="${b.category_num == 6}">
            루머
        </c:when>
        <c:when test="${b.category_num == 7}">
            움짤
        </c:when>
        <c:when test="${b.category_num == 8}">
            분석
        </c:when>
        <c:when test="${b.category_num == 9}">
            레시피
        </c:when>
        <c:when test="${b.category_num == 10}">
            맛집
        </c:when>
        <c:when test="${b.category_num == 11}">
            자랑
        </c:when>
    </c:choose>
</td>
		<td style="text-align: left">
        <a href="info?board_num=${b.board_num}">
        <c:if test="${not empty b.thumbnail}">
            <img src="${b.thumbnail}" style="width: 50px; height: 50px; margin-right: 10px;">
        </c:if>&nbsp;&nbsp;&nbsp;&nbsp;
        ${b.title}&nbsp;&nbsp;<span style="color:orange;">[${b.commcnt}]</span>
        </a>
        
    </td>
 		<td>

 		<c:if test="${sessionScope.login == b.member_id}">
 			<a href="../member/info?member_id=${b.member_id}">${b.member_id}</a>	
 		</c:if>
 		<c:if test="${sessionScope.login != b.member_id}">
 			<a href="../member/finfo?member_id=${b.member_id}">${b.member_id}</a>
 		</c:if>
 		<c:choose>
        	<c:when test="${b.level == 1}">
            	<img src="../image/1.gif">
        	</c:when>
        	<c:when test="${b.level == 2}">
            	<img src="../image/2.gif">
        	</c:when>
        	<c:when test="${b.level == 3}">
            	<img src="../image/3.gif">
        	</c:when>
        	<c:when test="${b.level == 4}">
            	<img src="../image/4.gif">
        	</c:when>
        	<c:when test="${b.level == 5}">
        		<img src="../image/5.gif">
        	</c:when>
        	<c:when test="${b.level == 6}">
        		<img src="../image/6.gif">
        	</c:when>
        	<c:when test="${b.level == 7}">
        		<img src="../image/7.gif">
        	</c:when>
        	<c:when test="${b.level == 8}">
        		<img src="../image/7.gif">
        	</c:when>
        	<c:when test="${b.level == 9}">
        		<img src="../image/8.gif">
        	</c:when>
        	<c:when test="${b.level == 10}">
        		<img src="../image/9.gif">
        	</c:when>        
    	</c:choose>	

 		</td>
				<%-- 오늘 등록된 게시물 날짜 format대로 출력하기 --%>
 <fmt:formatDate value="${today}" pattern="yyyy-MM-dd" var="t" /> 
 <fmt:formatDate value="${b.regdate}" pattern="yyyy-MM-dd" var="r" /> 
 <td><c:if test="${t==r}">
     <fmt:formatDate value="${b.regdate}" pattern="HH:mm:ss" />
	 </c:if>
		 <c:if test="${t!=r}">
     <fmt:formatDate value="${b.regdate}" pattern="yyyy-MM-dd HH:mm" />
   </c:if>
        	</td>
		 		<td>${b.readcnt}</td>
		 		<td>${b.recommendcnt}</td>
			</tr>
		</c:forEach>
		<%-- 페이지 처리하기 --%>
 		<tr>
 			<td colspan="5" class="w3-center">
      	<c:if test="${pageNum <= 1}">[이전]</c:if>
      	<c:if test="${pageNum > 1}">
      		<a href="javascript:listsubmit(${pageNum-1})">[이전]</a>
      	</c:if>
      	<c:forEach var="a" begin="${startpage}" end="${endpage}">
        	<c:if test="${a == pageNum}">[${a}]</c:if>
        	<c:if test="${a != pageNum}">
          	<a href="javascript:listsubmit(${a})">[${a}]</a>
        	</c:if>
      	</c:forEach>
      	<c:if test="${pageNum >= maxpage}">[다음]</c:if>
      	<c:if test="${pageNum < maxpage}">
      		<a href="javascript:listsubmit(${pageNum+1})">[다음]</a>
      	</c:if>
 			</td>
 		</tr>  
	</c:if>
	<tr><td colspan="5" style="text-align:right">
	<p align="right"><a href="writeForm">[글쓰기]</a></p>
</table>
<div>
	<form action="list?boardid=${boardid}" method="post" name="sf">
   	<input type="hidden" name="pageNum" value="1" >
   	<select name="column" >
     	<option value="">선택</option>
     	<option value="member_id">글쓴이</option>
	 	 	<option value="title">제목</option>
		 	<option value="content">내용</option>
    	<option value="title,content">제목+내용</option>
   	</select>
    <script type="text/javascript">
			document.sf.column.value='${param.column}'
    </script>
		<input type="text" placeholder="검색" name="find" value="${param.find}">
		<button type="submit">Search</button>
	</form>
</div>
</body>
</html>