<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
$(function(){
	$("#reply").on('click',function(){
		$.ajax({
			url :"replyList/1/5/${board.num}",
			type:"post",
			success:function(result){
				alert(result);
				$(result).each(function(){
					alert(this.rContents);
					alert(this.rId);
				});
			}
			
		});
		
	});
	
	
	$("#replywrite").on('click', function(){
		var id=$("#id").val();
		var contents=$("#contents").val();
		var num='${board.num}';
		alert(id);
		alert(contents);
		alert(num);
		
		$.ajax({
			url:"replyWrite",
			type:"POST",
			headers:{
				"Content-Type":"application/json",
				"x-http-method-override": "POST"
			},
			datatype:"text",
			data:JSON.stringify({
				rid:id,
				rContents:contents,
				rnum:num
			}),
			success:function(data){
				alert(data.rid);
				alert(data.rContents);
				alert(data.r_date);
			}
		});//ajax끝
		

		
	});//클릭의 끝
	
});

</script>



</head>
<body>
	<!-- 상세페이지  -->
	<p>ID : ${board.id}</p>
	<p>TITLE : ${board.title}</p>
	<p>CONTENTS : ${board.contents}</p>
	<p>COUNTS : ${board.counts}</p>
	<div>
		ID : <input type="text" id="id">
	CONTENS: <textarea rows="10" cols="30" id="contents"></textarea>
		<input type="button" value="댓글달기" id="replywrite">
	</div>
	
	<input type="button" value="댓글보기" id="reply">
	
	<div></div>
</body>
</html>