package com.entry;

/**
 * ʵ���� javabean pojo vo ʵ�������������ͬ
 */
public class Account {
	private String acc; // ����������ֶ�����ͬ, ������ͬ
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
