package com.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.EncryptUtils;
import com.Service.AccountService;

/**
 * servlet和 jsp 一起是 数据试图层,也就是页面层, 也叫 View 层, 也就是MVC 中的V 层 <br />
 * jsp 是纯数据展示 servlet 是拿到数据与后台做接触 jsp只和servlet接触(交互) <br/>
 * 试图层 只接收数据,和把数据放到页面去 , 不做逻辑处理,不做数据处理
 * 
 * @author Administrator
 * 
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp); // 调用自己类中的doPost方法
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 在这里写业务
		try {
			String acc = req.getParameter("acc");
			String pswd = req.getParameter("pswd");
			String yzm = req.getParameter("yzm");

			System.out.println("33jklajfoazjfal;");

			String reng = (String) req.getSession().getAttribute("reng");
			String aa = req.getParameter("aa");
			EncryptUtils encryptUtils = new EncryptUtils();// 得到加密类对象
			String AESKey = encryptUtils.getAESKey(encryptUtils.encryptToSHA(pswd));// aes加密
			String str11 = encryptUtils.encryptToAES(AESKey, pswd);
			System.out.println("AES加密后为:" + str11);
			AccountService accountService = new AccountService();
			if (aa == null || aa.equals("")) {
				boolean isr = accountService.isRight(acc, str11);// 验证账户名和密码是否正确
				if (isr) { // 正确
					HttpSession session = req.getSession();
					session.setAttribute("acc", acc);// 创建session 并赋值
					req.getRequestDispatcher("wel.jsp").forward(req, resp);
				} else { // 错误
					req.setAttribute("aa", 1);
					req.getRequestDispatcher("login.jsp").forward(req, resp);
				}
			} else {
				if (reng.equalsIgnoreCase(yzm)) {// equalsIgnoreCase 不区分大小写进行比较
					boolean isr = accountService.isRight(acc, str11);// 验证账户名和密码是否正确
					if (isr) { // 正确
						HttpSession session = req.getSession();
						session.setAttribute("acc", acc);// 创建session 并赋值
						req.getRequestDispatcher("wel.jsp").forward(req, resp);
					} else { // 错误
						req.setAttribute("aa", 1);
						req.getRequestDispatcher("login.jsp").forward(req, resp);
					}
				} else {
					req.setAttribute("aa", 2);
					req.getRequestDispatcher("login.jsp").forward(req, resp);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
