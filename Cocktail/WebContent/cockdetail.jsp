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
		border: 1px solid black;
		border-collapse: collapse;
		margin: 10px 10px 10px 10px;
	}
	h3{
		text-align: center;
	}
	.a{
		background-color: #F7D7ED;
		border-bottom-color: white;
		color:#19958B;
		font-weight: bold;
		font-size: 25px;
	}
	th{
		font-size: 15px;
	}
	.b{
		height: 10px;
	}
</style>
</head>
<body>
<jsp:include page="header.jsp"/>

<form action="MemberController.do" method="post">
<input type="hidden" name="command" value="liked" >
<input type="hidden" name="cock_seq" value="${cdto.cock_seq}" >
<input type="hidden" name="liked" value="${cdto.liked}" >
<table border="1" class="detail" >
<col width="320px">
<tr><td colspan="3" class="a">${cdto.cock_name}</td></tr>
<tr><td colspan="3" class="b"></td></tr>
<tr>
	<th rowspan="4"><img alt="칵테일" src="img/${cdto.cock_seq}.jpg"/></th>
	<th>상세설명</th>
	<th>제조법</th>
</tr>
<tr height="180px">
	
	<td >${cdto.explain}</td>
	<td >${cdto.make}</td>
</tr>
<tr>
	<th>재료</th>
	<td rowspan="3">
		<input class="btn btn-warning" type="submit" value="맛있어요+${cdto.liked}">
		<input class="btn btn-success btn-xs" type="button" value="목록으로" onclick="location.href = 'MemberController.do?command=cocklist'">
		<c:choose>
			<c:when test="${ldto.m_role=='관리자' }">
				<input class="btn btn-primary btn-xs" type="button" value="수정" onclick="location.href='MemberController.do?command=updateform&cock_seq=${cdto.cock_seq}'">
				<input class="btn btn-primary btn-xs" type="button" value="삭제" onclick ="location.href='MemberController.do?command=delcock&cock_seq=${cdto.cock_seq}'">
			</c:when>
		</c:choose>
	</td>
</tr>
<tr>
	<td>
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

</tr>
</table>
</form>
<jsp:include page="replyboard.jsp"/>
<jsp:include page="side.jsp"/>
</body>
</html>