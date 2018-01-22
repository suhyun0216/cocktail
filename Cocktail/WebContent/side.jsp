<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<% request.setCharacterEncoding("utf-8");%>
<%response.setContentType("text/html; charset=utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.side{
	position: absolute;
	left: 80%;
	top: 200px;
	height:300px;
	border: 1px solid black;
	border-collapse: collapse;
}
select{
	margin-left: 5%;
}
</style>
</head>
<body>
<table border="1" class="side">
	<col width="200px" >
	<tr>
		<th>탑테일10</th>
	</tr>
	<tr>
		<td>
			<a href="#">마르가리타</a>
			<br><a href="#">깔루아밀크</a>
			<br><a href="#">미도리샤워</a>
		</td>
	</tr>
	<tr>
		<th>베이스 검색</th>
	</tr>
	<tr>
		<td>
			<select>
				<option>진</option>
				<option>럼</option>
				<option>데킬라</option>
			</select>		
		</td>
	</tr>
</table>
</body>
</html>