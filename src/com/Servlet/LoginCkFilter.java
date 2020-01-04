package com.Servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCkFilter implements Filter {

	@Override
	public void destroy() {
		// 销毁
		System.out.println("销毁");
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		// 得到页面的url
		String url = request.getRequestURI();// 判断是否以login.jsp或者LoginServlet结尾

		if (url.endsWith("login.jsp") || url.endsWith("login") || url.endsWith("yanzhenma")) {// endsWith()
																								// 方法用于测试字符串是否以指定的后缀结束。
			System.out.println("是登录请求 不拦截   继续执行请求 ");// 如果是那么就继续执行
			filterChain.doFilter(request, response);
		} else {
			// 否则,得到Session,看Session里面有没有用户信息
			HttpSession session = request.getSession();
			Object obj = session.getAttribute("account");

			// String obj = (String) request.getSession().getAttribute("test");
			// System.out.println(obj + "<----session 的值");
			// 如果session为null,就说明没登录

			if (null == obj || "".equals(obj)) {
				// 返回登录页面
				System.out.println("session 为空 跳转到 登录");
				response.sendRedirect("login.jsp");
			} else {
				System.out.println("有seission 继续执行请求");
				// 如果session不为null就说明用户已经登录
				filterChain.doFilter(request, response);
			}
		}

		// 平时用
		// System.out.println("平时用");
		// 这句话就是曳继续执行我们的请求
		// filterChain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("初始化");
		// 初始化
	}
}
