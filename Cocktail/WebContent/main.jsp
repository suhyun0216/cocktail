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
.main{
	position: relative;
	width: 80%;
	height : 100%;
	padding: 10px;
	border: 1px solid black;
	border-collapse: collapse;
	margin: 10px 10px 10px 10px;
}
img{
	width: 300px; height:450px;
	}
	
select{
	width: 200px;
}
.a{
	background-color: #F7D7ED;
	border-bottom-color: white;
	color:#19958B;
	font-weight: bold;
	font-size: 25px;
	}
	
</style>
</head>
<body>
<jsp:include page="header.jsp"/>
<table border="1" class="main" >
	<col width="320px">
	<form action="MemberController.do" method="post">
	<input type="hidden" name="command" value="searchingre">
	<tr><th colspan="2" class="a">메인</th></tr>
	<tr><td colspan="2" height="10px"></td></tr>
	<tr>
		<th>운영자 추천 칵테일</th>
		<th colspan="4">재료에 따른 칵테일 검색</th>
	</tr>
	<tr>
		<td rowspan="3"><a href="MemberController.do?command=cockdetail&cock_seq=1"><img alt="칵테일" src="img/img.jpg" ></a></td>
		<td>
			<select name="base">
				<option value="">베이스 선택</option>
				<c:forEach items="${bases}" var="base">
				<option  value="${base.ingre_name}">${base.ingre_name}</option>
				</c:forEach>
			</select>		
		
			<select name="leq">
				<option value="">리큐르 선택</option>
				<c:forEach items="${leq}" var="leq">
				<option  value="${leq.ingre_name}">${leq.ingre_name}</option>
				</c:forEach>
			</select>		
		
			<select name="drink">
				<option value="">음료 선택</option>
				<c:forEach items="${drink}" var="drink">
				<option  value="${drink.ingre_name}">${drink.ingre_name}</option>
				</c:forEach>
			</select>		
		
			<select name="syrup">
				<option value="">시럽 선택</option>
				<c:forEach items="${syrup}" var="syrup">
				<option  value="${syrup.ingre_name}">${syrup.ingre_name}</option>
				</c:forEach>
			</select>		
			<input class="btn btn-info btn-xs" type="submit" value="검색" >
		</td>
	</tr>
	</form>
<form action="MemberController.do" method="post">
	<input type="hidden" name="command" value="searchcham">
	<tr>
		<th colspan="4">취향에 따른 칵테일 검색</th>
	</tr>
	<tr>
		<td>
			<select name="base">
				<option value="">베이스 선택</option>
				<c:forEach items="${bases}" var="base">
				<option value="${base.ingre_name}">${base.ingre_name}</option>
				</c:forEach>
			</select>			
		
			<select name="color">
				<option value="">색상 선택</option>
				<c:forEach items="${color}" var="color">
				<option value="${color.ingre_name}">${color.ingre_name}</option>
				</c:forEach>
			</select>		
		
			<select name="taste">
				<option value="">맛 선택</option>
				<c:forEach items="${taste}" var="taste">
				<option value="${taste.ingre_name}">${taste.ingre_name}</option>
				</c:forEach>	
			</select>		
		
			<select name="alchol">
				<option value="">도수 선택</option>
				<c:forEach items="${alchol}" var="alchol">
				<option  value="${alchol.ingre_name}">${alchol.ingre_name}</option>
				</c:forEach>
			</select>		
			<input class="btn btn-info btn-xs" type="submit" value="검색"/>
		</td>
	</tr>
</form>
</table>
<jsp:include page="side.jsp"/>
</body>
</html>