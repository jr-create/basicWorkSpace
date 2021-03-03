package 案例;
//编写一个Java应用程序，该程序在命令行窗口中输出数组的引用以及元素的值
public class InputArray {
	public static void main(String args[]){
		int [] a={100,200,300};
		System.out.println(a.length);
		System.out.println(a);
		int b[][]={{1},{1,1},{1,2,1},{1,3,3,1},{1,4,6,4,1}};
		System.out.println(b);
		System.out.println(b[4][2]);
		b[4]=a;
		System.out.println(b[4][2]);
	}
}
