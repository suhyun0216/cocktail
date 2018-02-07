<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<% request.setCharacterEncoding("utf-8");%>
<%response.setContentType("text/html; charset=utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.a{
	background-color: #F7D7ED;
	border-bottom-color: white;
	color:#19958B;
	font-weight: bold;
	font-size: 25px;
	}
.status{
	position: relative;
	width: 30%;
	padding: 10px;
	border: 1px solid black;
	border-collapse: collapse;
	margin: 10px auto;
	text-align: center;
}	
	
</style>
</head>
<body>
<jsp:include page="header.jsp"/>
<form action="MemberController.do" method="post">
<input type="hidden" name="command" value="updateinfo">
<input type="hidden" name="m_seq" value="${ldto.m_seq}">
<table border="1" class="status">
	<col width="100px">
	<col width="200px">
	<col width="400px">
	<tr><td colspan="2" class="a">정보수정하기</td></tr>
	<tr><td colspan="2" height="10px"></td></tr>
	<tr>
		<th>아이디</th>
		<td>${ldto.m_id}</td>
	</tr>
	<tr>
		<th>이름</th>
		<td>
			<input type="text" name="m_name" value="${ldto.m_name}">
		</td>
	</tr>
	<tr>
		<th>패스워드</th>
		<td><input type="password" name="m_pw" ></td>
	</tr>
	<tr>
		<th>이메일</th>
		<td>
			<input type="text" name="m_email" value="${ldto.m_email}"/>
		</td>
	</tr>
	<tr>
		<td colspan="2" height="40px">
			<input class="btn btn-primary btn-xs" type="submit" value="수정완료">
			<input class="btn btn-primary btn-xs" type="button" value="뒤로" onclick="location.href='MemberController.do?command=getuser&m_seq=${ldto.m_seq}'">
		</td>
	</tr>
</table>
</form>
</body>
</html>