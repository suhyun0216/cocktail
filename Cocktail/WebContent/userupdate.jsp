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
<form action="MemberController.do" method="post">
<input type="hidden" name="command" value="updateinfo">
<input type="hidden" name="m_seq" value="${ldto.m_seq}">
<table border="1" class="status">
	<col width="100px">
	<col width="200px">
	<col width="400px">
	<caption>정보 수정하기</caption>
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
		<td colspan="2">
			<input type="submit" value="수정완료">
			<input type="button" value="뒤로" onclick="location.href='MemberController.do?command=getuser&m_seq=${ldto.m_seq}'">
		</td>
	</tr>
</table>
</form>
</body>
</html>