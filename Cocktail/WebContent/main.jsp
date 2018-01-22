<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<% request.setCharacterEncoding("utf-8");%>
<%response.setContentType("text/html; charset=utf-8"); %>
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
}
select{
	margin-left: 5%;
}
</style>
</head>
<body>
<jsp:include page="header.jsp"/>
<table border="1" class="main" >
	<tr>
		<th>운영자 추천 칵테일</th>
		<th colspan="4">재료에 따른 칵테일 검색</th>
	</tr>
	<tr>
		<td rowspan="4"><img alt="칵테일" src="img/img.jpg"></td>
		<td>
			<select >
				<option selected="selected">베이스 선택</option>
				<option value="">진</option>
				<option>럼</option>
				<option>데킬라</option>
			</select>		
		
			<select>
				<option selected="selected">리큐르 선택</option>
				<option>깔루아</option>
				<option>베일리스</option>
				<option>없음</option>
			</select>		
		
			<select>
				<option selected="selected">음료 선택</option>
				<option>오렌지쥬스</option>
				<option>크렌베리쥬스</option>
				<option>우유</option>
			</select>		
		
			<select>
				<option selected="selected">시럽 선택</option>
				<option>타바스코<option>
				<option>그레나딘</option>
				<option>없음</option>
			</select>		
		</td>
	</tr>
	<tr>
		<th colspan="4">취향에 따른 칵테일 검색</th>
	</tr>
	<tr>
		<td>
			<select>
				<option selected="selected">베이스 선택</option>
				<option>진</option>
				<option>럼</option>
				<option>데킬라</option>
			</select>		
		
			<select>
				<option selected="selected">색상 선택</option>
				<option>빨강</option>
				<option>주황</option>
				<option>파랑</option>
			</select>		
		
			<select>
				<option selected="selected">맛 선택</option>	
				<option>단맛</option>
				<option>신맛</option>
				<option>술맛</option>
			</select>		
		
			<select>
				<option selected="selected">도수 선택</option>
				<option>논알콜<option>
				<option>5도이하</option>
				<option>5~15도</option>
			</select>		
		</td>
		
	</tr>
</table>
<jsp:include page="side.jsp"/>
</body>
</html>