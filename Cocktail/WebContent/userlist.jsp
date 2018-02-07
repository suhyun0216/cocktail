<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<% request.setCharacterEncoding("utf-8");%>
<%response.setContentType("text/html; charset=utf-8"); %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
	function user(btn){
		var m_role = $(btn).parent().siblings().eq(4).children().val();
		var m_enabled = $(btn).parent().siblings().eq(6).children().val();
		var m_seq = $(btn).parent().parent().children().children().val();
		
// 		alert(m_seq);
		
		location.href = "MemberController.do?command=userstatus&m_seq="+m_seq+"&m_role="+m_role+"&m_enabled="+m_enabled;
	}
</script>
<style type="text/css">
.userlist{
		width: 80%;
		border: 1px solid black;
		border-collapse: collapse;
		margin: 10px 10px 10px 10px;
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
<table border="1" class="userlist">
	<tr><td colspan="8" class="a">회원 목록보기</td></tr>
	<tr><td colspan="8" height="10px"></td></tr>
	<tr>
		<th>회원번호</th>
		<th>이름</th>
		<th>아이디</th>
		<th>이메일</th>
		<th>등급</th>
		<th>가입일</th>
		<th colspan="2">상태</th>
	</tr>
	<c:forEach items="${mlist}" var="mdto">
	<tr>
		<td><input type="hidden" name="a" value="${mdto.m_seq }" > ${mdto.m_seq }</td>
		<td>${mdto.m_name }</td>
		<td>${mdto.m_id }</td>
		<td>${mdto.m_email }</td>
		<td>
			<select name="m_role">
				<option ${mdto.m_role=='일반'?"selected":"" }>일반</option>
				<option ${mdto.m_role=='관리자'?"selected":"" }>관리자</option>
			</select>
		</td>
		<td><fmt:formatDate value="${mdto.m_regdate }" pattern="yy/MM/dd hh:mm:ss"/></td>
		<td>
			<select name="m_enabled">
				<option ${mdto.m_enabled=='Y'?"selected":"" }>Y</option>
				<option ${mdto.m_enabled=='N'?"selected":"" }>N</option>
			</select>
		</td>
		<td height="40px"><input class="btn btn-primary btn-xs" type="button" value="변경" onclick="user(this)" /></td>
	</tr>
	</c:forEach>
</table>
</form>
</body>
</html>