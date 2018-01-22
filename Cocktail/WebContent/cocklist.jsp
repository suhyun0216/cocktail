<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hk.dtos.CocktailDto" %>
<% request.setCharacterEncoding("utf-8");%>
<%response.setContentType("text/html; charset=utf-8"); %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.list{
	position: relative;
	width: 50%;
	height : 100%;
	padding: 10px;
	border: 1px solid black;
	border-collapse: collapse;
	text-align: center;
}
</style>
</head>
<body>
<jsp:include page="header.jsp"/>
<h3>칵테일 목록</h3>
<table border="1" class="list">
	<tr>
		<th>칵테일 이름</th>
		<th>베이스 종류</th>
	</tr>
<c:forEach items="${lists}" var="cdto">
	<tr>
		<td><a href="MemberController.do?command=cockdetail&cock_seq=${cdto.cock_seq}">${cdto.cock_name}</a></td>
		<td>${cdto.base}</td>
	</tr>
	</c:forEach>
</table>
<jsp:include page="side.jsp"/>
</body>
</html>