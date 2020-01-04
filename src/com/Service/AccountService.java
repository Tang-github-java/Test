package com.Service;

import com.Dao.AccountDao;
import com.entry.Account;

/**
 * service 是业务层, 也叫逻辑层 也叫控制层 是MVC中的C service 命名规则的 实体类名+Service
 */
public class AccountService {
	AccountDao accountDao = new AccountDao();

	/**
	 * 添加
	 * 
	 * @param account
	 */
	public void add(Account account) {
		accountDao.add(account);
	}

//	/**
//	 * 修改
//	 * 
//	 * @param account
//	 */
//	public void update(Account account) {
//		accountDao.update(account);
//	}

//	/**
//	 * 删除
//	 * 
//	 * @param acc
//	 */
//	public void delete(String acc) {
//		accountDao.delete(acc);
//	}
//
//	/**
//	 * 查询
//	 * 
//	 * @return List<Account>
//	 */
//	public List<Account> query() {
//		return accountDao.query();
//	}

	/**
	 * 根据账户名和密码查出对象
	 * 
	 * @param acc
	 * @param pswd
	 * @return Account;
	 */
	public Account getAccountByAccAndPswd(String acc, String pswd) {
		return accountDao.getAccountByAccAndPswd(acc, pswd);
	}

//	/**
//	 * 根据账户名码查出对象
//	 * 
//	 * @param acc
//	 * @return Account;
//	 */
//	public Account get(String acc) {
//		return accountDao.get(acc);
//	}

	/**
	 * 验证账户名和密码是否正确
	 * 
	 * @param acc
	 * @param pswd
	 * @return boolean true是正确 false是错误
	 */
	public boolean isRight(String acc, String pswd) {
		Account account = getAccountByAccAndPswd(acc, pswd);
		if (null != account && acc.equals(account.getAcc()) && pswd.equals(account.getPswd())) {
			return true; // 账户名和密码是对的 返回true
		}
		return false; // 错的返回false
	}
}
