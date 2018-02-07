<%@page import="com.hk.dtos.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<% request.setCharacterEncoding("utf-8");%>
<%response.setContentType("text/html; charset=utf-8"); %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
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
		background-color: #B4EDD8;
	}
	th{
		background-color: #60C1A6;
		height: 30px;
		text-align: center;
	}
	a{
		font-weight: bold;
		text-decoration: none;
		color:#F388C3;
	}
	a:hover{
		text-decoration: none;
		color:#4C4E76;
	}
	.user{
		width: 30px; height: 30px;
	}
	.seecock{
		background-color: #B4EDD8;
	}
	.menu{
		position: relative;
		left: 30%;
		padding: 10px;
	}
	h1{
		margin: 0 auto;
		font-style: italic;
	}
	input{
		margin-left: 10px;
	}
	.cock{
	width: 200px; height: 120px;
	}
	
</style>
</head>
<body>
<header>
	
<form action="MemberController.do?command=loginform" method="post">
<table class="menu">
	<tr height="10px;"></tr>
	<tr>
	<td colspan="1" rowspan="2"><img alt="로고" src="img/cock.png" class="cock"></td>
		<td colspan="4">
			<h1><a href="MemberController.do?command=main">Cocktail</a></h1>
		</td>
	</tr>
	<tr>
		<th class="seecock"><a href="MemberController.do?command=cocklist">칵테일 목록보기</a></th>
		<c:choose>
			<c:when test="${empty ldto}">
				<td><input class="btn btn-primary btn-xs" type="submit" value="로그인" ></td>
				<td><input class="btn btn-primary btn-xs" type="button" value="회원가입" onclick="location.href='MemberController.do?command=registform'"></td>
			</c:when>
				
			<c:when test="${ldto.m_role=='일반'}">
				<td width=10px></td>
				<td><img alt="유저" src="img/user.png" class="user"></td>
				<td>${ldto.m_name}</td>
				<td><input class="btn btn-primary btn-xs" type="button" value="내 정보보기" onclick="location.href='MemberController.do?command=getuser&m_seq=${ldto.m_seq}'" ></td>
				<td><input class="btn btn-primary btn-xs" type="button" value="로그아웃" onclick="location.href='MemberController.do?command=logout'" ></td>
			</c:when>
			
			<c:when test="${ldto.m_role=='관리자'}">
				<td width=10px></td>
				<td><img alt="유저" src="img/user.png" class="user"></td>
				<td>${ldto.m_name}</td>
				<td><input class="btn btn-primary btn-xs" type="button" value="내 정보보기" onclick="location.href='MemberController.do?command=getuser&m_seq=${ldto.m_seq}'" ></td>
				<td><input class="btn btn-primary btn-xs" type="button" value="회원목록보기" onclick="location.href='MemberController.do?command=userlist'"></td>
				<td><input class="btn btn-primary btn-xs" type="button" value="로그아웃" onclick="location.href='MemberController.do?command=logout'" ></td>
			</c:when>
		</c:choose>
		
	</tr>
	
</table>
</form>


</header>
</body>
</html>