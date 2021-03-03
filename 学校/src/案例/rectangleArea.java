package 案例;

import java.util.*;

public class rectangleArea {
	@SuppressWarnings("resource")
	public static void main(String args[]){
		Scanner reader=new Scanner(System.in);
		System.out.println("请输入矩形长宽:");
		int rlong= reader.nextInt();
		int rwide=reader.nextInt();
		int area=rlong*rwide;
		int perimeter=2*rlong+2*rwide;
		System.out.println("矩形面积为："+area);
		System.out.println("矩形周长为："+perimeter);
	}
}
