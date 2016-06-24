<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="replyWrite" method="post">
		<input type="text" name="id">
		<input type="text" name="title">
		<textarea rows="" cols=""name="contents"></textarea>
		<input type="hidden" name="ref" value="${boardDTO.ref}">
		<input type="hidden" name="step" value="${boardDTO.step}">
		<input type="hidden" name="depth" value="${boardDTO.depth}">
		<input type="submit" value="write">
	
	</form>

</body>
</html>