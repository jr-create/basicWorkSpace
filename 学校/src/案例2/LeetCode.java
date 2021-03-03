package 案例2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;


public class LeetCode {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// int n=scanner.nextInt();
		// System.out.println(reverse(n));//整数反转
		String string = scanner.nextLine();
		System.out.println(reverseWords(string));

	}

	public static int reverse(int x) {// 整数反转
		long d3 = System.currentTimeMillis();
		int rev = 0;
		while (x != 0) {
			int pop = x % 10;
			x /= 10;
			if (rev > Integer.MAX_VALUE / 10
					|| (rev == Integer.MAX_VALUE / 10 && pop > 7))
				return 0;
			if (rev < Integer.MIN_VALUE / 10
					|| (rev == Integer.MIN_VALUE / 10 && pop < -8))
				return 0;
			rev = rev * 10 + pop;
			System.out.println(x + "余数" + pop);
		}
		long d4 = System.currentTimeMillis();
		System.out.println(d3 - d4);
		return rev;
	}

	public static String reverseWords(String s) {
//		StringBuilder sb = new StringBuilder();
		StringBuffer sb=new StringBuffer();
		int length = s.length();
		int i = 0;
		while (i < length) {
			
			int start = i;
			while (i < length && s.charAt(i) != ' ') {
				i++;
			}
			for (int j = start; j < i; j++) {
				sb.append(s.charAt(start + i - 1 - j));
			}
			while (i < length && s.charAt(i) == ' ') {
				i++;
				sb.append(' ');
			}
		}
		return sb.toString();
	}
}
