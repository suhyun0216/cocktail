<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<% request.setCharacterEncoding("utf-8");%>
<%response.setContentType("text/html; charset=utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.login{
		position: relative;
		width: 20%;
		height: 30%;
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
	.b{
		height:10px;
	}
</style>
</head>
<body>
<jsp:include page="header.jsp"/>
<form action="MemberController.do?command=login" method="post">
<table border="1" class="login">
<tr><td class="a">로그인</td></tr>
<tr><td class="b"></td></tr>
<tr>
	<td>
	<br>
	아이디 : <input type="text" name="m_id">
	<br>
	<br>
	비밀번호 : <input type="password" name="m_pw">
	<br><br>
	</td>
</tr>
<tr><td height="40px"><input class="btn btn-primary btn-xs" type="submit" value="로그인"/></td></tr>
</table>
</form>
</body>
</html>