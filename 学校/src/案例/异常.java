package 案例;

import java.io.IOException;

public class 异常 {
	public 异常(int n, int m) throws 自定义异常 {
		try {
			System.out.println("抛出异常");
			throw new 自定义异常(9, 2);
		} catch (自定义异常 e) {
			System.out.println("异常后求和为"+e.warnInt());
		}
		try {
			throw new java.io.IOException("故意抛出的异常");
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			throw new java.lang.NullPointerException("故意抛出的异常");
		} catch (Exception e) {

			e.printStackTrace();
		}
		try {
			throw new java.lang.ArithmeticException("故意抛出的异常");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		try {
			@SuppressWarnings("unused")
			异常 t = new 异常(7, 7);
		} catch (自定义异常 e) {
			e.printStackTrace();
		}
	}
}
