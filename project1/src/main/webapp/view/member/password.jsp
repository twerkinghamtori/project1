<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script>
	alert("${msg}")
	if(${opener}){
		opener.location.href="${url}"
		self.close()
	} else {
		location.href="${url}"
	}
</script>