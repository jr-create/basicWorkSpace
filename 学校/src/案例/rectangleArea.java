package ����;

import java.util.*;

public class rectangleArea {
	@SuppressWarnings("resource")
	public static void main(String args[]){
		Scanner reader=new Scanner(System.in);
		System.out.println("��������γ���:");
		int rlong= reader.nextInt();
		int rwide=reader.nextInt();
		int area=rlong*rwide;
		int perimeter=2*rlong+2*rwide;
		System.out.println("�������Ϊ��"+area);
		System.out.println("�����ܳ�Ϊ��"+perimeter);
	}
}
