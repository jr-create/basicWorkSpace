package ����;

import java.io.IOException;

public class �쳣 {
	public �쳣(int n, int m) throws �Զ����쳣 {
		try {
			System.out.println("�׳��쳣");
			throw new �Զ����쳣(9, 2);
		} catch (�Զ����쳣 e) {
			System.out.println("�쳣�����Ϊ"+e.warnInt());
		}
		try {
			throw new java.io.IOException("�����׳����쳣");
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			throw new java.lang.NullPointerException("�����׳����쳣");
		} catch (Exception e) {

			e.printStackTrace();
		}
		try {
			throw new java.lang.ArithmeticException("�����׳����쳣");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		try {
			@SuppressWarnings("unused")
			�쳣 t = new �쳣(7, 7);
		} catch (�Զ����쳣 e) {
			e.printStackTrace();
		}
	}
}
