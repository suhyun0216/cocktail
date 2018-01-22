<%@page import="com.hk.dtos.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<% request.setCharacterEncoding("utf-8");%>
<%response.setContentType("text/html; charset=utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

	function idCheck(m_id) {
		if(m_id==""){
			alert("아이디를 입력해주세요");
			document.getElementsByName("m_id")[0].focus();
		}else{
			location.href = "MemberController.do?command=idchk&m_id="+m_id;
		}
	}
</script>
<style type="text/css">
	header{
		background-color: orange;
	}
	th{
		background-color: yellow;
		height: 30px;
	}
	a{
		text-decoration: none;
		color:fuchsia;
	}
	
</style>
</head>
<body>
<header>
	<h1><a href="main.jsp">칵테일</a></h1>
<form action="MemberController.do?command=loginform" method="post">
<table>
	<tr>
		<td width="40%"></td>
		<th><a href="MemberController.do?command=cocklist">칵테일 목록보기</a></th>
		<td><input type="text" name="allsearch">검색</td>
		
		<%
			if(session.getAttribute("ldto")==null){
				%>
				<td><input type="submit" value="로그인" ></td>
				<td><input type="button" value="회원가입" onclick="location.href='MemberController.do?command=registform'"></td>
				<%
			}else{
				%>
				<td><input type="button" value="내 정보보기" onclick="location.href='MemberController.do?command=getuser&m_seq=${ldto.m_seq}'" ></td>
				<td><input type="button" value="로그아웃" onclick="location.href='MemberController.do?command=logout'" ></td>
			<%
			}
		%>
		
	</tr>
</table>
</form>


</header>
</body>
</html>