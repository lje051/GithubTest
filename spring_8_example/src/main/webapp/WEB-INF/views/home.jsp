<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#b1").on('click', function(){
			var id = $("#id").val();
			var contents=$("#contents").val();
			$.ajax({
				url:"rest",
				type:"POST",
				datatype : "text",
				headers:{"Content-Type":"application/json", "X-HTTP-Method-Override":"POST"},
				data:JSON.stringify({rContents : contents, rid : id}),
				success:function(data){
					alert(data.rid);
					alert(data.rContents);
				},
				error:function(e){
					alert(e);
				}
				
			});
		});
	});
</script>	
	
</head>
<body>
<h1>
	Hello world!  
</h1>
<p>third edit</p><p>fourth edit</p>
<P>  The time on the server is ${serverTime}. </P>
<a href="freeboard/test1">test1</a>
<a href="freeboard/test2">test2</a>
<a href="freeboard/freeboardList">freeboardList</a>
<input type="text" id="id" value="choa">
<input type="text" id="contents" value="dddd">
<input type="button" id="b1" name="click">
</body>
</html>
