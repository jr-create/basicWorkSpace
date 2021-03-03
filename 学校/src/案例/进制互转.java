package 案例;

import java.util.*;
import java.math.*;
public class 进制互转 {
	@SuppressWarnings("resource")
	public static void main(String args[]) {
		Scanner scanner;
		long j=7400000000L;//系统默认int类型要加L
		float f=0.1f;//系统默认为double类型要加F float 不精确一定不要比较 如果要比较java.math包中的BigDecimal
		double d=1.0/10;
		System.out.println(f==d);
		BigDecimal bd1=BigDecimal.valueOf(f);
		BigDecimal bd2=BigDecimal.valueOf(d);
		System.out.println(bd1.equals(bd2));//比较浮点型
		System.out.println('a'+'b');//打印出是数
		System.out.println(""+'a'+'b');//打印出是ab ""是转义字符
//		模取余是符号和左边数符号相同  例：7%3=1 -7%3= -1  7%-3=1
		System.out.println(0+'b');//会把字符变成整数型
//		异或 b1 和b2 相同true或false 结果false 一个false和一个true 结果true
		System.out.println(f!=d^f!=d);//异或测试
//		! 非  取反
//		&&短路与  || 短路或 一个为false 则直接返回false       & 与 | 或一个为false 还需要看后面
//		int  b2=3/0;//异常by zero
		boolean t=1>2&&2>3/0;//用&&（短路与）不会出现异常 用&（与）就会发生异常 以为前面为false &&不会再运行后面 &还运行后面
		scanner = new Scanner(System.in);
		System.out.println("请输入十进制数");
		String i = scanner.next();
		try {
			System.out.println("请输入要转为几进制");
			int n = scanner.nextInt();
			int num = Integer.valueOf(i);// 把字符串强制转换为数字
			System.out.printf("%d进制转%d进制：%s", num, n, Integer.toString(num, n));
		} catch (Exception e) {
			System.out.println("十六进制转十进制：" + Integer.parseInt(i, 16));// 如果抛出异常，返回False
		}
	}
}
