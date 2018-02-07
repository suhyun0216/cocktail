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
	img{width: 300px; height:400px;}
	.detail{
		width: 80%;
		border: 1px solid black;
		border-collapse: collapse;
		margin: 10px 10px 100px 10px;
		padding: 20px;
	}
	.a{
	background-color: #F7D7ED;
	border-bottom-color: white;
	text-align: center;
	color:#19958B;
	font-weight: bold;
	font-size: 25px;
	}
	.b{
		height: 10px;
	}
</style>
</head>
<body>
<jsp:include page="header.jsp"/>
<h3>칵테일 수정하기</h3>
<form action="MemberController.do" method="post">
<input type="hidden" name="command" value="updatecock" >
<input type="hidden" name="cock_seq" value="${cdto.cock_seq}" >
<table border="1" class="detail">
<col width="300px">
<tr><td colspan="3" class="a">칵테일 수정하기</td></tr>
<tr><td colspan="3" class="b"></td></tr>
<tr>
	<th>${cdto.cock_name}</th>
	<th>상세설명</th>
	<th>제조법</th>
</tr>
<tr>
	<td rowspan="3"><img alt="칵테일" src="img/${cdto.cock_seq}.jpg"/></td>
	<td height="100px" ><textarea rows="5" cols="40" name="explain" >${cdto.explain}</textarea></td>
	<td rowspan="2"><textarea rows="5" cols="40" name="make">${cdto.make}</textarea></td>
</tr>
<tr>
	<th >재료</th>
</tr>
<tr>
	<td rowspan="2">
		베이스:
		<select name="base">
				<option >베이스 선택</option>
				<c:forEach items="${bases}" var="base">
				<option  value="${base.ingre_seq}">${base.ingre_name}</option>
				</c:forEach>
			</select>
		<br>
		베이스양:
		<input type="text" name="base_amt" value="${cdto.base_amt}">
		<br>
		리큐르:
		<select name="leq">
				<option >리큐르 선택</option>
				<c:forEach items="${leq}" var="leq">
				<option  value="${leq.ingre_seq}">${leq.ingre_name}</option>
				</c:forEach>
			</select>
		<br>
		리큐르양:
		<input type="text" name="leq_amt" value="${cdto.leq_amt}">
		<br>
		음료:
		<select name="drink">
				<option >음료 선택</option>
				<c:forEach items="${drink}" var="drink">
				<option  value="${drink.ingre_seq}">${drink.ingre_name}</option>
				</c:forEach>
			</select>
		<br>
		음료양:
		<input type="text" name="drink_amt" value="${cdto.drink_amt}">
		<br>
		시럽:
		<select name="syrup">
				<option >시럽 선택</option>
				<c:forEach items="${syrup}" var="syrup">
				<option  value="${syrup.ingre_seq}">${syrup.ingre_name}</option>
				</c:forEach>
			</select>
		<br>
		시럽양:
		<input type="text" name="syrup_amt" value="${cdto.syrup_amt}">
		<br>
		기타:
		<select name="etc">
				<option >색상 선택</option>
				<c:forEach items="${etc}" var="etc">
				<option value="${etc.ingre_seq}">${etc.ingre_name}</option>
				</c:forEach>
			</select>
		<br>
		기타양:
		<input type="text" name="etc_amt" value="${cdto.etc_amt}">
		<br>
		색상 :
		<select name="color">
				<option >색상 선택</option>
				<c:forEach items="${color}" var="color">
				<option value="${color.ingre_seq}">${color.ingre_name}</option>
				</c:forEach>
			</select>
		<br>
		맛 :
		<select name="taste">
				<option >맛 선택</option>
				<c:forEach items="${taste}" var="taste">
				<option value="${taste.ingre_seq}">${taste.ingre_name}</option>
				</c:forEach>	
			</select>
		<br>
		도수 :
		<select name="alchol">
				<option >도수 선택</option>
				<c:forEach items="${alchol}" var="alchol">
				<option  value="${alchol.ingre_seq}">${alchol.ingre_name}</option>
				</c:forEach>
			</select>	
	</td>
	<td>
		<input class="btn btn-primary btn-xs" type="submit" value="수정완료">
		<input class="btn btn-primary btn-xs" type="button" value="취소" onclick="location.href = 'MemberController.do?command=cockdetail&cock_seq=${cdto.cock_seq}'">
	</td>
</tr>
</table>
</form>
</body>
</html>