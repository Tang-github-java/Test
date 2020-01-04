<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
<title>主页</title>
</head>
<body>

 <%-- <mytag:Hello msg="s" count="1">dd</mytag:Hello> --%>
	<!-- 防止非法访问 -->
<!-- 	凡是  ..getAttribute  设置的值都是可以用el表达式的,     -->
	<%
		String acc = (String)session.getAttribute("acc");
		if (null == acc) { //没有登录或已经超时,都需要重新登录 
			response.sendRedirect("login.jsp");
			return; //一定要return;
		}
	%>
<%-- 	<c:if test="${acc == null}"> --%>
<%-- 		<jsp:forward page="login.jsp"> --%>
<%-- 	</c:if>  --%>
 	欢迎 ${acc} 登录  <br /><br /> 
	<%
		//List<Account> list =  (List<Account>)request.getAttribute("list");
		//所有的setAttr.... 的值都是Object 类型,所以用getAttr...得到的就是Object,要强转		
	%>
	
	
	<table border = "1" style = "border-collapse: collapse;">
		<tr>
			<th>账户名</th>
			<th>密码</th>
			<th>操作</th>
		</tr>
	 
		<c:forEach var= "ac" items="${list}">
			<tr>
				<td>${ac.acc }</td>
				<td>${ac.pswd }</td>
<%-- 				<td> <a href="get?acc=${ac.acc }">修改</a>  --%>
<%-- 					 <a href="delete?acc=${ac.acc }">删除</a> </td> --%>
			</tr>
		</c:forEach>
	</table>
	<br/>
<!-- 		为了杜绝jAva代码在jsp页面出面(jsp页面是做展示的,是不能写其他代码) -->
<!-- 		使用jstl必须导入: -->
<!-- 		jstl-1.2.jar -->
<!-- 		standard-1.1.2.jar -->
<!-- 		2在页面需要: -->
<!-- 		导入jstl的库  c    fmt    fn -->
<!-- 	<br/> -->
</body>
</html>