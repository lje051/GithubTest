<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>ID : ${boardDTO.id}</p>
	<p>title : ${boardDTO.title}</p>
	<p>contents : ${boardDTO.contents}</p>
	<p>ref : ${boardDTO.ref}</p>
	<p>depth : ${boardDTO.depth}</p>
	
	<a href="replyWrite?num=${boardDTO.num}&ref=${boardDTO.ref}&depth=${boardDTO.depth}&step=${boardDTO.step}">답글달기</a>
	<a href="boardDelete?num=${boardDTO.num}">글삭제</a>

</body>
</html>