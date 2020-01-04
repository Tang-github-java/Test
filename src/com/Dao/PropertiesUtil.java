package com.Dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public final class PropertiesUtil {
	/**
	 * getValue()���������ļ���name�õ�value
	 * 
	 * @param key �����ļ���name
	 * @return value �����ļ�value
	 * @throws IOException
	 */
	public static String getValue(String key) throws IOException {
		Properties prop = new Properties();
		// ���������ļ������Ƶõ������ļ�·��
		String filePath = PropertiesUtil.class.getClassLoader().getResource("abc.properties").getPath();// jdbc.properties�����ļ�������
		InputStream in = new FileInputStream(filePath);// �ļ�������
		prop.load(in);// ��ȡ
		String value = prop.getProperty(key).trim();
		return value;// ����value
	}

	/**
	 * setValue()�������ļ���ֵ
	 * 
	 * @param key   �����ļ���name
	 * @param value �����ļ�value
	 * @throws Exception
	 */

	public static void setValue(String key, String value) throws Exception {
		Properties prop = new Properties();
		// ���������ļ����ƣ��õ������ļ���·��
		String filePath = PropertiesUtil.class.getClassLoader().getResource("abc.properties").getPath();// jdbc.properties�����ļ�������
		InputStream in = new FileInputStream(filePath);// ������
		prop.load(in);
		in.close();// �ر�
		OutputStream fos = new FileOutputStream("D:\\EclipseT\\MyPiece\\src\\abc.properties");
		prop.setProperty("name", "addd");// ��ֵ
		prop.store(fos, "ldkjgldjl");
//		prop.store(fos, value);
		fos.close();
	}

	public static void main(String[] args) throws Exception {
		PropertiesUtil.setValue("2", "3");
	}

}
