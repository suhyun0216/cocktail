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
	padding: 10px;
	border: 1px solid black;
	border-collapse: collapse;
	margin: 10px auto;
	text-align: center;
	
}
.a{
	background-color: #F7D7ED;
	border-bottom-color: white;
	color:#19958B;
	font-weight: bold;
	font-size: 25px;
	}
th, td{
	height: 30px;
	font-size: 15px;
}
.b{
	height: 10px;
}
</style>
</head>
<body>
<jsp:include page="header.jsp"/>

<table border="1" class="list">
	<tr><th colspan="2" class="a">칵테일 목록</th></tr>
	<tr><td colspan="2" class="b"></td></tr>
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
	<c:choose>
		<c:when test="${ldto.m_role=='관리자'}">
			<tr>
				<td colspan="2" height="40px">
					<input class="btn btn-success btn-xs" type="button" value="추가" onclick="location.href='MemberController.do?command=insertform'">
				</td>
			</tr>
		</c:when>
	</c:choose>
</table>
<jsp:include page="side.jsp"/>
</body>
</html>