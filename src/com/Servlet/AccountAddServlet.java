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

@WebServlet("/add") // һ��Ҫ�� ����url ������Ŀ�������ظ�
public class AccountAddServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ҵ��

		try {
			String acc = req.getParameter("acc");
			String pswd = req.getParameter("pswd");
			System.out.println(123);
			EncryptUtils encryptUtils = new EncryptUtils();// �õ����������

			// aes����
			String AESKey = encryptUtils.getAESKey(encryptUtils.encryptToSHA(pswd));
			// ����һ��AES�㷨���ܳ�
			String str11 = encryptUtils.encryptToAES(AESKey, pswd);
			System.out.println("AES���ܺ�Ϊ:" + str11);
			// ʹ������ܳ׽���
			String strd = encryptUtils.decryptByAES(AESKey, str11);
			System.out.println("AES���ܺ�Ϊ��" + strd);

			// des����
//			String DESKey = encryptUtils.getDESKey(encryptUtils.encryptToSHA(pswd));
//			System.out.println(DESKey + "�ص绰");
//			String str11 = encryptUtils.encryptToDES(DESKey, pswd);
//			System.out.println("DES���ܺ�Ϊ:" + str11);

			// String str11 = encryptUtils.encryptToDES("pswd8888", pswd);
			// System.out.println("DES���ܺ�Ϊ:" + str11);
			// String pswda = encryptUtils.encryptToMD5(pswd);

			Account account = new Account();
			account.setAcc(acc);
			account.setPswd(str11);
			// ����ҵ�������
			AccountService accountService = new AccountService();
			// ���
			accountService.add(account);

//			List<Account> list = accountService.query();
//			req.setAttribute("list", list); // ��Ҫ��ҳ��չʾ��������request����ȥ
			req.getRequestDispatcher("wel.jsp").forward(req, resp);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
