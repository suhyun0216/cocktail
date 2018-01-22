<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<% request.setCharacterEncoding("utf-8");%>
<%response.setContentType("text/html; charset=utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div id="regist">
<form action="MemberController.do" method="post">
<input type="hidden" name="command" value="regist">
<table border="1">
	<caption>회원가입</caption>
	<tr>
		<td>이름</td>
		<td>
			<input type="text" name="m_name">
		</td>
	</tr>
	<tr>
		<td>아이디</td>
		<td>
			<input type="text" name="m_id" id="idchk" required="required" value='${param.isS=="y"?param.user:""}'>
			<input type="button" value="중복체크" onclick="idCheck(idchk.value)">
		</td>
	</tr> 
	<tr>
		<td>패스워드</td>
		<td><input type="password" name="m_pw" ></td>
	</tr>
	<tr>
		<td>이메일</td>
		<td>
			<input type="text" name="m_email">
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="회원가입">
		</td>
	</tr>
</table>
</form>
</div>
</body>
</html>