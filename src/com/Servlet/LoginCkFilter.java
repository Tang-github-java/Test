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
		// ����
		System.out.println("����");
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		// �õ�ҳ���url
		String url = request.getRequestURI();// �ж��Ƿ���login.jsp����LoginServlet��β

		if (url.endsWith("login.jsp") || url.endsWith("login") || url.endsWith("yanzhenma")) {// endsWith()
																								// �������ڲ����ַ����Ƿ���ָ���ĺ�׺������
			System.out.println("�ǵ�¼���� ������   ����ִ������ ");// �������ô�ͼ���ִ��
			filterChain.doFilter(request, response);
		} else {
			// ����,�õ�Session,��Session������û���û���Ϣ
			HttpSession session = request.getSession();
			Object obj = session.getAttribute("account");

			// String obj = (String) request.getSession().getAttribute("test");
			// System.out.println(obj + "<----session ��ֵ");
			// ���sessionΪnull,��˵��û��¼

			if (null == obj || "".equals(obj)) {
				// ���ص�¼ҳ��
				System.out.println("session Ϊ�� ��ת�� ��¼");
				response.sendRedirect("login.jsp");
			} else {
				System.out.println("��seission ����ִ������");
				// ���session��Ϊnull��˵���û��Ѿ���¼
				filterChain.doFilter(request, response);
			}
		}

		// ƽʱ��
		// System.out.println("ƽʱ��");
		// ��仰����ҷ����ִ�����ǵ�����
		// filterChain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("��ʼ��");
		// ��ʼ��
	}
}
