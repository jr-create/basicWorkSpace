package ����;
import java.util.*;
public class PascalTriangle {
	public static void main(String args[]){
		@SuppressWarnings("resource")
		Scanner reader=new Scanner(System.in);
		System.out.print("�������������������");
		int num=reader.nextInt();
		int i,k,j;
		String yh[][]=new String[num][num];
		 for(i=0;i<num;i++)
		        yh[i][0] = yh[i][i] ="1";  
//	 ���ߵ�������Ϊ1����Ϊ����ѭ����1��ʼ������Ϊa[i][1]Ϊ��һ����
		    for(i=2;i<num;i++)
		        for(j=1;j<=i-1;j++)
		            yh[i][j]=String.valueOf(Integer.valueOf(yh[i-1][j-1])+Integer.valueOf(yh[i-1][j])); 
//		    �����ߵ����ⶼ������������֮�� 
		    for(i=0;i<num;i++)
		        for(k=i+1;k<num;k++)
		            yh[i][k]=" ";
//		    �������
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
