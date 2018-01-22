<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<% request.setCharacterEncoding("utf-8");%>
<%response.setContentType("text/html; charset=utf-8"); %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	img{width: 330px; height:450px;}
	.detail{
		width: 80%;
		height : 100%;
		border: 1px solid black;
		border-collapse: collapse;
	}
</style>
</head>
<body>
<jsp:include page="header.jsp"/>
<h3>칵테일 목록</h3>
<form action="MemberController.do" method="post">
<input type="hidden" name="command" value="liked" >
<input type="hidden" name="cock_seq" value="${cdto.cock_seq}" >
<input type="hidden" name="liked" value="${cdto.liked}" >
<table border="1" class="detail">
<col width="330px">
<col width="200px">
<col width="200px">
<tr>
	<th>${cdto.cock_name}</th>
	<th>상세설명</th>
	<th>제조법</th>
</tr>
<tr>
	<td rowspan="3"><img alt="칵테일" src="img/${cdto.cock_seq}.jpg"/></td>
	<td >${cdto.explain}</td>
	<td rowspan="2">${cdto.make}</td>
</tr>
<tr>
	<th >재료</th>
</tr>
<tr>
	<td rowspan="2">
		<c:choose>
			<c:when test="${cdto.base!='없음'}">
				${cdto.base}:${cdto.base_amt}
			</c:when>
			<c:when test="${cdto.base=='없음'}">
				베이스 없음
			</c:when>
		</c:choose>
		<br>
		<c:choose>
			<c:when test="${cdto.leq !='없음'}">
				${cdto.leq} : ${cdto.leq_amt}
			</c:when>
			<c:when test="${cdto.leq=='없음'}">
				리큐르 없음
			</c:when>
		</c:choose>
		<br>
		<c:choose>
			<c:when test="${cdto.drink !='없음'}">
				${cdto.drink} : ${cdto.drink_amt}
			</c:when>
			<c:when test="${cdto.drink=='없음'}">
				음료 없음
			</c:when>
		</c:choose>
		<br>
		<c:choose>
			<c:when test="${cdto.syrup !='없음'}">
				${cdto.syrup} : ${cdto.syrup_amt}
			</c:when>
			<c:when test="${cdto.syrup=='없음'}">
				시럽 없음
			</c:when>
		</c:choose>
		<br>
		<c:choose>
			<c:when test="${cdto.etc !='없음'}">
				${cdto.etc} : ${cdto.etc_amt}
			</c:when>
			<c:when test="${cdto.etc=='없음'}">
			</c:when>
		</c:choose>
		<br>색상 : ${cdto.color}
		<br>맛 : ${cdto.taste}
		<br>도수 : ${cdto.alchol}
	</td>
	<td>
		<input type="submit" value="맛있어요+${cdto.liked}">
		<input type="button" value="목록으로" onclick="location.href = 'MemberController.do?command=cocklist'">
	</td>
</tr>
</table>
</form>
<jsp:include page="side.jsp"/>
</body>
</html>