package ����;

import java.util.*;
import java.math.*;
public class ���ƻ�ת {
	@SuppressWarnings("resource")
	public static void main(String args[]) {
		Scanner scanner;
		long j=7400000000L;//ϵͳĬ��int����Ҫ��L
		float f=0.1f;//ϵͳĬ��Ϊdouble����Ҫ��F float ����ȷһ����Ҫ�Ƚ� ���Ҫ�Ƚ�java.math���е�BigDecimal
		double d=1.0/10;
		System.out.println(f==d);
		BigDecimal bd1=BigDecimal.valueOf(f);
		BigDecimal bd2=BigDecimal.valueOf(d);
		System.out.println(bd1.equals(bd2));//�Ƚϸ�����
		System.out.println('a'+'b');//��ӡ������
		System.out.println(""+'a'+'b');//��ӡ����ab ""��ת���ַ�
//		ģȡ���Ƿ��ź������������ͬ  ����7%3=1 -7%3= -1  7%-3=1
		System.out.println(0+'b');//����ַ����������
//		��� b1 ��b2 ��ͬtrue��false ���false һ��false��һ��true ���true
		System.out.println(f!=d^f!=d);//������
//		! ��  ȡ��
//		&&��·��  || ��·�� һ��Ϊfalse ��ֱ�ӷ���false       & �� | ��һ��Ϊfalse ����Ҫ������
//		int  b2=3/0;//�쳣by zero
		boolean t=1>2&&2>3/0;//��&&����·�룩��������쳣 ��&���룩�ͻᷢ���쳣 ��Ϊǰ��Ϊfalse &&���������к��� &�����к���
		scanner = new Scanner(System.in);
		System.out.println("������ʮ������");
		String i = scanner.next();
		try {
			System.out.println("������ҪתΪ������");
			int n = scanner.nextInt();
			int num = Integer.valueOf(i);// ���ַ���ǿ��ת��Ϊ����
			System.out.printf("%d����ת%d���ƣ�%s", num, n, Integer.toString(num, n));
		} catch (Exception e) {
			System.out.println("ʮ������תʮ���ƣ�" + Integer.parseInt(i, 16));// ����׳��쳣������False
		}
	}
}
