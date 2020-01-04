<%@ page language="java" contentType="text/html; charset=utf-8"%>
<html>
<head>
<title>账户添加</title>
</head>
<body>
	<!-- 防止非法访问 -->
	<%
// 		String acc = (String)session.getAttribute("acc");
// 		System.out.println("--2222"+acc);
// 		if (null == acc) { //没有登录或已经超时,都需要重新登录 
// 			response.sendRedirect("login.jsp");	
// 			return; //一定要return;
// 		}
	%>
	
	<form action="add" method="post">
		账户: <input type="text" name="acc" /> <br/>
		密码: <input type="text" name="pswd" /> <br/>
		<button>保存</button> <br/>
	</form>
</body>
</html>