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
		$("#b1").on('click', function(){
			$.ajax({
				url:"./test2",
				type:"GET",
				success:function(data){
					alert(data);
					/* JSON.parse(data); */
					var hap=''
					$(data).each(function(){
						hap=hap+"<tr>"
						hap=hap+"<td>"+this.id+"</td>";
						hap=hap+"<td>"+this.title+"</td>";
						hap=hap+"</tr>"
					});
					
					$("#d1").append(hap);
					
					
				},
				error:function(e){
					alert("error");
				}
			});
		});
	});
</script>

</head>

<body>

<input type="button" id="b1" value="gooooooooooooo" >
<div>
	<table id="d1">
		<tr>
			<td>ID</td><td>TITLE</td>
		</tr>
		
		
	</table>

</div>

</body>
</html>