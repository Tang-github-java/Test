package com.Service;

import com.Dao.AccountDao;
import com.entry.Account;

/**
 * service ��ҵ���, Ҳ���߼��� Ҳ�п��Ʋ� ��MVC�е�C service ��������� ʵ������+Service
 */
public class AccountService {
	AccountDao accountDao = new AccountDao();

	/**
	 * ���
	 * 
	 * @param account
	 */
	public void add(Account account) {
		accountDao.add(account);
	}

//	/**
//	 * �޸�
//	 * 
//	 * @param account
//	 */
//	public void update(Account account) {
//		accountDao.update(account);
//	}

//	/**
//	 * ɾ��
//	 * 
//	 * @param acc
//	 */
//	public void delete(String acc) {
//		accountDao.delete(acc);
//	}
//
//	/**
//	 * ��ѯ
//	 * 
//	 * @return List<Account>
//	 */
//	public List<Account> query() {
//		return accountDao.query();
//	}

	/**
	 * �����˻���������������
	 * 
	 * @param acc
	 * @param pswd
	 * @return Account;
	 */
	public Account getAccountByAccAndPswd(String acc, String pswd) {
		return accountDao.getAccountByAccAndPswd(acc, pswd);
	}

//	/**
//	 * �����˻�����������
//	 * 
//	 * @param acc
//	 * @return Account;
//	 */
//	public Account get(String acc) {
//		return accountDao.get(acc);
//	}

	/**
	 * ��֤�˻����������Ƿ���ȷ
	 * 
	 * @param acc
	 * @param pswd
	 * @return boolean true����ȷ false�Ǵ���
	 */
	public boolean isRight(String acc, String pswd) {
		Account account = getAccountByAccAndPswd(acc, pswd);
		if (null != account && acc.equals(account.getAcc()) && pswd.equals(account.getPswd())) {
			return true; // �˻����������ǶԵ� ����true
		}
		return false; // ��ķ���false
	}
}
