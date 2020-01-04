<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录页面</title>
<script type="text/javascript">
function aa()
{    //   刷新验证码
	//这里会重新请求servlet产生一个新的验证码．为什么这里没有换．
	//因为这里有缓存，请求过一次servlet，不会再请求．
	var imgNode= document.getElementById("vimg");
	imgNode.src= "yanzhenma?t="+ Math.random();
	//imgNode.src= "yanzhengma?t=0.12333";
}
//页面加载完成会执行这个方法
function bb()
{
	//这里判断是否需要显示验证码
	var aa = document.getElementById("aa").value;
	if(aa != null && aa != "") //如果 aa= 空  不显示验证码 
	{
		document.getElementById("div").style.display="";//display显示     ""空
	}else
	{
		document.getElementById("div").style.display="none";//aa有值就隐藏  验证码
	}
	//这里判断提示错误
	if(aa == "1")
		{
		alert("用户名或密码错误");//弹窗显示  
		}
	else if(aa == "2")
		{
		  alert("验证码错误");	
		}
}
</script>
</head>
<body onload="bb()"  bgcolor="pink"><!-- 当页面载入完毕后执行Javascript代码： -->
  <form action="login" method="post">
		<div align="center">
			<table border="1">
				<tbody>
					<tr>
						<td>用户名</td>
						<td><input type="text" name="acc"></td>
					</tr>
					<tr>
						<td>密码</td>
						<td><input type="password" name="pswd"></td>
					</tr>
					   <tr>
						<td colspan="2" align="center">
						<input value="登录"	type="submit">
						<input value="重置" type="reset"></td>
					  </tr>
				</tbody>
			</table>
		</div>
		    <div id="div" style="display: none"  align="center">
                <input type="hidden" id="aa" name="aa" value="${aa}">
                           验证码：<input type="text" name="yzm" id="yzm">
                <img alt="" id="vimg" src="yanzhenma" onclick="aa()"><br><!-- //yanzhengma 是调用  servlet验证码 -->
           </div>
	</form>
</body>
</html>



