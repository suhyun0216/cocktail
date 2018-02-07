<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<% request.setCharacterEncoding("utf-8");%>
<%response.setContentType("text/html; charset=utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.regist{
	position: relative;
	width: 40%;
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
</style>
</head>
<body>
<jsp:include page="header.jsp"/>
<div id="regist">
<form action="MemberController.do" method="post">
<input type="hidden" name="command" value="regist">
<table border="1" class="regist">
	<tr><td class="a">회원가입</td></tr>
	<tr><td height="10px"></td></tr>
	<tr>
		<td>
		<br>
			아이디 :
			<input type="text" name="m_id" id="idchk" required="required" value='${param.isS=="y"?param.user:""}'>
			<input class="btn btn-primary btn-xs" type="button" value="중복체크" onclick="idCheck(idchk.value)">
		<br><br>
			패스워드:
			<input type="password" name="m_pw" >
		<br><br>
			이름:
			<input type="text" name="m_name">
		<br><br>
			이메일:
			<input type="text" name="m_email">
			<br><br>
		</td>
	</tr>
	<tr>
		<td height="40px">
			<input class="btn btn-primary btn-xs" type="submit" value="회원가입">
		</td>
	</tr>
</table>
</form>
</div>
</body>
</html>