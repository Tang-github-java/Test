package com.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.EncryptUtils;
import com.Service.AccountService;
import com.entry.Account;

@WebServlet("/add") // 一定要有 这是url 整个项目都不能重复
public class AccountAddServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 业务

		try {
			String acc = req.getParameter("acc");
			String pswd = req.getParameter("pswd");
			System.out.println(123);
			EncryptUtils encryptUtils = new EncryptUtils();// 得到加密类对象

			// aes加密
			String AESKey = encryptUtils.getAESKey(encryptUtils.encryptToSHA(pswd));
			// 生成一个AES算法的密匙
			String str11 = encryptUtils.encryptToAES(AESKey, pswd);
			System.out.println("AES加密后为:" + str11);
			// 使用这个密匙解密
			String strd = encryptUtils.decryptByAES(AESKey, str11);
			System.out.println("AES解密后为：" + strd);

			// des加密
//			String DESKey = encryptUtils.getDESKey(encryptUtils.encryptToSHA(pswd));
//			System.out.println(DESKey + "回电话");
//			String str11 = encryptUtils.encryptToDES(DESKey, pswd);
//			System.out.println("DES加密后为:" + str11);

			// String str11 = encryptUtils.encryptToDES("pswd8888", pswd);
			// System.out.println("DES加密后为:" + str11);
			// String pswda = encryptUtils.encryptToMD5(pswd);

			Account account = new Account();
			account.setAcc(acc);
			account.setPswd(str11);
			// 创建业务类对象
			AccountService accountService = new AccountService();
			// 添加
			accountService.add(account);

//			List<Account> list = accountService.query();
//			req.setAttribute("list", list); // 把要在页面展示的数据用request带过去
			req.getRequestDispatcher("wel.jsp").forward(req, resp);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
