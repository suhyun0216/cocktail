<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<% request.setCharacterEncoding("utf-8");%>
<%response.setContentType("text/html; charset=utf-8"); %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.status{
	margin: 0 auto;
	width: 300px;
	height : 100%;
	padding: 10px;
	border: 1px solid black;
	border-collapse: collapse;
}
</style>
</head>
<body>
<jsp:include page="header.jsp"/>
<form action="MemberController.do" method="post">
<input type="hidden" name="command" value="deluser">
<input type="hidden" name="m_seq" value="${ldto.m_seq}">
<table border="1" class="status">
	<col width="100px">
	<col width="200px">
	<col width="400px">
	<caption>내 정보</caption>
	<tr>
		<th>아이디</th>
		<td>${ldto.m_id}</td>
	</tr>
	<tr>
		<th>이름</th>
		<td>${ldto.m_name}</td>
	</tr>
	<tr>
		<th>이메일주소</th>
		<td>${ldto.m_email}</td>
	</tr>
	<tr>
		<th>가입일</th>
		<td><fmt:formatDate value="${ldto.m_regdate}" pattern="yy년 MM월 dd일"/></td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="button" value="정보수정" onclick="location.href='MemberController.do?command=updateuser&m_seq=${ldto.m_seq}'">
			<input type="submit" value="회원탈퇴">
			<input type="button" value="뒤로" onclick="location.href = 'main.jsp'">
		</td>
	</tr>
</table>
</form>
<jsp:include page="side.jsp"/>
</body>
</html>