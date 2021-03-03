package 案例;
import java.util.*;
public class PascalTriangle {
	public static void main(String args[]){
		@SuppressWarnings("resource")
		Scanner reader=new Scanner(System.in);
		System.out.print("请输入杨辉三角行数：");
		int num=reader.nextInt();
		int i,k,j;
		String yh[][]=new String[num][num];
		 for(i=0;i<num;i++)
		        yh[i][0] = yh[i][i] ="1";  
//	 两边的数令它为1，因为现在循环从1开始，就认为a[i][1]为第一个数
		    for(i=2;i<num;i++)
		        for(j=1;j<=i-1;j++)
		            yh[i][j]=String.valueOf(Integer.valueOf(yh[i-1][j-1])+Integer.valueOf(yh[i-1][j])); 
//		    除两边的数外都等于上两顶数之和 
		    for(i=0;i<num;i++)
		        for(k=i+1;k<num;k++)
		            yh[i][k]=" ";
//		    输出数据
		    for(i=0;i<num;i++){
		        for(k=0;k<num-i;k++)
		            System.out.print("   ");  
		        for(j=0;j<num;j++){ 
		        	System.out.print("     ");
		        	System.out.print(yh[i][j]);
		        	}
			 System.out.println();
		 }
	}
	
}
