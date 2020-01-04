package com.entry;

/**
 * 实体类 javabean pojo vo 实体类名与表名相同
 */
public class Account {
	private String acc; // 属性名与表字段名相同, 类型相同
	private String pswd;

	public String getAcc() {
		return acc;
	}

	public void setAcc(String acc) {
		this.acc = acc;
	}

	public String getPswd() {
		return pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	}

	@Override
	public String toString() {
		return "Account [acc=" + acc + ", pswd=" + pswd + "]";
	}

}
