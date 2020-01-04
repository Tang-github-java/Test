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
 * servlet�� jsp һ���� ������ͼ��,Ҳ����ҳ���, Ҳ�� View ��, Ҳ����MVC �е�V �� <br />
 * jsp �Ǵ�����չʾ servlet ���õ��������̨���Ӵ� jspֻ��servlet�Ӵ�(����) <br/>
 * ��ͼ�� ֻ��������,�Ͱ����ݷŵ�ҳ��ȥ , �����߼�����,�������ݴ���
 * 
 * @author Administrator
 * 
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp); // �����Լ����е�doPost����
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ������дҵ��
		try {
			String acc = req.getParameter("acc");
			String pswd = req.getParameter("pswd");
			String yzm = req.getParameter("yzm");

			System.out.println("33jklajfoazjfal;");

			String reng = (String) req.getSession().getAttribute("reng");
			String aa = req.getParameter("aa");
			EncryptUtils encryptUtils = new EncryptUtils();// �õ����������
			String AESKey = encryptUtils.getAESKey(encryptUtils.encryptToSHA(pswd));// aes����
			String str11 = encryptUtils.encryptToAES(AESKey, pswd);
			System.out.println("AES���ܺ�Ϊ:" + str11);
			AccountService accountService = new AccountService();
			if (aa == null || aa.equals("")) {
				boolean isr = accountService.isRight(acc, str11);// ��֤�˻����������Ƿ���ȷ
				if (isr) { // ��ȷ
					HttpSession session = req.getSession();
					session.setAttribute("acc", acc);// ����session ����ֵ
					req.getRequestDispatcher("wel.jsp").forward(req, resp);
				} else { // ����
					req.setAttribute("aa", 1);
					req.getRequestDispatcher("login.jsp").forward(req, resp);
				}
			} else {
				if (reng.equalsIgnoreCase(yzm)) {// equalsIgnoreCase �����ִ�Сд���бȽ�
					boolean isr = accountService.isRight(acc, str11);// ��֤�˻����������Ƿ���ȷ
					if (isr) { // ��ȷ
						HttpSession session = req.getSession();
						session.setAttribute("acc", acc);// ����session ����ֵ
						req.getRequestDispatcher("wel.jsp").forward(req, resp);
					} else { // ����
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
