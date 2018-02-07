<%@page import="com.hk.dtos.ReplyDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<% request.setCharacterEncoding("utf-8");%>
<%response.setContentType("text/html; charset=utf-8"); %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<%
	List<ReplyDto> rlist = (List<ReplyDto>)request.getAttribute("rlist"); 
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.user{width: 30px; height: 30px;}
	.reply td{
		height: 35px;
	
	}
	.reply{
		margin: 20px auto;
	}
	.c{
		text-align: center;
	}
</style>
</head>
<body>
<table border="1" class="reply">
<form action="MemberController.do" method="post">
<input type="hidden" name="command" value="insertreply">
<input type="hidden" name="rep_cock_seq" value="${cdto.cock_seq}">
<input type="hidden" name="rep_id" value="${ldto.m_name}">
<c:choose>
	<c:when test="${!empty ldto}">
	<tr>
		<td>
			<img alt="유저" src="img/user.png" class="user">
			${ldto.m_name}
		</td>
		<td><textarea rows="3" cols="60" name="rep_content"></textarea></td>
		<td colspan="2">
			<input class="btn btn-primary btn-xs" type="submit" value="덧글작성">
		</td>
	</tr>
	</c:when>
</c:choose>
</form>
<form action="MemberController.do" method="post">
<c:choose>
	<c:when test="${empty rlist}">
		<tr><td colspan="3" class="c">------작성된 댓글 없음-------</td></tr>
	</c:when>
		<c:when test="${ldto.m_role=='관리자'}">
		<c:forEach items="${rlist}" var="rdto">
	<input type="hidden" name="command" value="delreply">
	<input type="hidden" name="rep_seq" value="${rdto.rep_seq}">
	<input type="hidden" name="rep_cock_seq" value="${cdto.cock_seq}">
				<tr>
					<td>
						<img alt="유저" src="img/user.png" class="user">
						${rdto.rep_id}
					</td>
					<td width="500px">${rdto.rep_content}</td>
					<td><fmt:formatDate value="${rdto.rep_regdate}" pattern="yy/MM/dd HH:mm:ss"/></td>
					<td>
						<input class="btn btn-warning btn-xs" type="submit" value="삭제">
					</td>
				</tr>
			</c:forEach>
	</c:when>
	<c:otherwise>
		<c:forEach items="${rlist}" var="rdto">
	<input type="hidden" name="command" value="delreply">
	<input type="hidden" name="rep_seq" value="${rdto.rep_seq}">
	<input type="hidden" name="rep_cock_seq" value="${cdto.cock_seq}">
			<tr class="reply">
				<td width="100px">
					<img alt="유저" src="img/user.png" class="user">
					${rdto.rep_id}
				</td>
				<td width="500px">${rdto.rep_content}</td>
				<td colspan="2"><fmt:formatDate value="${rdto.rep_regdate}" pattern="yy/MM/dd HH:mm:ss"/></td>
			</tr>
		</c:forEach>
	</c:otherwise>
</c:choose>
</form>
</table>
</body>
</html>