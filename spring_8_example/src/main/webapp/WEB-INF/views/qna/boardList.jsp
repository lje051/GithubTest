<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	var message = '${message}';
	if(message != ''){
		alert(message);
	}
</script>
</head>
<body>
	<table>
		<tr>
			<td>NUMBER</td><td>TITLE</td><td>DATE</td><td>REF</td>
			<c:forEach items="${boardList}" var="board">
				<tr>
					<td>${board.num}</td>
					<td>
					<c:forEach begin="1" end="${board.depth}">
						&nbsp;&nbsp;
					</c:forEach>
					<a href="boardView?num=${board.num}"> ${board.title}</a>
					
					</td>
					<td>${board.reg_date}</td>
					<td>${board.ref}</td>
				</tr>
			</c:forEach>
		</tr>
	</table>
	
	<a href="boardWrite">글쓰기</a>

</body>
</html>