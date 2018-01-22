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
<form action="MemberController.do?command=login" method="post">
<p>아이디 : <input type="text" name="m_id"></p>
<p>비밀번호 : <input type="password" name="m_pw"></p>
<input type="submit" value="로그인"/>
</form>
</body>
</html>