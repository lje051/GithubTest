<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#save").click(function(){
			var path='';
			var num = '${boardDTO.num}';
			var ref = '${boardDTO.ref}';
			if(num !='' && ref != ''){
				path ='replyWrite';
			}else if(num != ''){
				path='boardUpdate';
			}else {
				path='boardWrite';
			}
			$("#frm").attr("action", path);
			$("#frm").submit();
			
		})
	})
	
</script>

</head>
<body>
	<form id="frm" action="boardWrite" method="post">
		<input type="hidden" name="num" value="${boardDTO.num}">
		<input type="text" name="id" value="${boardDTO.id}">
		<input type="text" name="title" value="${boardDTO.title}">
		<textarea rows="" cols="" name="contents" value="${boardDTO.contents}"></textarea>
		<input type="hidden" name="ref" value=${boardDTO.ref}>
		<input type="button" id="save" value="write">
	</form>

</body>
</html>