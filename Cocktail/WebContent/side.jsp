<%@page import="com.hk.daos.CocktailDao"%>
<%@page import="com.hk.dtos.CocktailDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<% request.setCharacterEncoding("utf-8");%>
<%response.setContentType("text/html; charset=utf-8"); %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.side{
	position: absolute;
	left: 82%;
	top: 200px;
	height:300px;
	border: 1px solid black;
	border-collapse: collapse;
	
}
select{
	margin-left: 5%;
}
.base{
	width: 120px;
}
.side td{
	text-align: center;
	font-size: 15px;
	height: 40px;
}
</style>
</head>
<body>
<form action="MemberController.do" method="post">
<input type="hidden" name="command" value="searchbase">
<table border="1" class="side">
	<col width="200px" >

	<tr>
		<th>탑테일10</th>
	</tr>
	<tr>
		<td>
			<c:forEach items="${top}" var="cdto">
			<a href="MemberController.do?command=cockdetail&cock_seq=${cdto.cock_seq}">${cdto.cock_name}</a><br>
			</c:forEach>
		</td>
	</tr>
	<tr>
		<th>베이스 검색</th>
	</tr>
	<tr>
		<td>
			<select name="base" class="base">
				<option>베이스 선택</option>
				<c:forEach items="${bases}" var="base">
					<option>${base.ingre_name}</option>
				</c:forEach>
			</select>		
			<input class="btn btn-info btn-xs" type="submit" value="검색">
		</td>
	</tr>
</table>
</form>
</body>
</html>