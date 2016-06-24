<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		var curPage=1;
		$(document).on('click', '.go', function(){
			var num = $(this).attr("name");
			location.href="freeBoardView?num="+num;
		});
		
		$("#b1").click(function(){
			curPage++;
			$.ajax({
				url:"freeRestList",
				type:"GET",
				data:{
					curPage:curPage,
					perPage:5
				},
				success: function(data){
					var result='';
					$(data).each(function(){
						result=result+"<tr>";
						result=result+"<td>"+this.num+"</td>";
						result=result+'<td class="go" name="'+this.num+'">'+this.title+"</td>";
						result=result+"<td>"+this.reg_date+"</td>";
						result=result+"</tr>"
					});
					$("table").append(result);
				},
				error: function(e){
					alert("error");
				}
			});
		});
	});
</script>
<style type="text/css">
	.go { cursor: pointer; }
</style>
</head>
<body>
	<table>
		<tr>
			<td>NUMBER</td><td>TITLE</td><td>DATE</td>
			<c:forEach items="${freeList}" var="board">
				<tr>
					<td>${board.num}</td>
					<td class="go" name="${board.num}">${board.title}</a>
					
					</td>
					<td>${board.reg_date}</td>
					
				</tr>
				
			</c:forEach>
		</table>
	
	<input type="button" id="b1" value="더보기">
</body>
</html>