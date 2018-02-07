<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<% request.setCharacterEncoding("utf-8");%>
<%response.setContentType("text/html; charset=utf-8"); %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.result{
	position: relative;
	width: 30%;
	padding: 10px;
	border: 1px solid black;
	border-collapse: collapse;
	margin: 10px auto;
	text-align: center;
	}
	.result td{
		height: 30px;
		font-size: 15px;
	}
</style>
</head>
<body>
<jsp:include page="header.jsp"/>
<table border="1" class="result">
	<tr>
		<th><h4>검색결과</h4></th>
	</tr>
	<c:choose>
		<c:when test="${empty ingre }">
			<tr>
				<td>-----검색 결과가 없습니다-----</td>
			</tr>
		</c:when>
		<c:otherwise>
			<c:forEach items="${ingre}" var="ingre">
			<tr>
				<td><a href="MemberController.do?command=cockdetail&cock_seq=${ingre.cock_seq}">${ingre.cock_name}</a></td>
			</tr>
			</c:forEach>
			<tr>
				<td>
					<input class="btn btn-primary btn-xs" type="button" value="뒤로" onclick="location.href='MemberController.do?command=main'" height="40px">
				</td>
			</tr>
		</c:otherwise>
	</c:choose>
</table>
<jsp:include page="side.jsp"/>
</body>
</html>