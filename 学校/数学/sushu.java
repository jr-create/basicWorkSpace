

import java.util.Scanner;

public class sushu {
	/* private static boolean isPrimer(int n) {
	        for (int i = 2; i < n; i++) {
	            if (n % i == 0) return false;
	        }
	        return true;
	    }

		int n=0;
		Scanner j=new Scanner(System.in);
		int j1=j.nextInt();
		System.out.println(isPrimer(j1));
	}*/
	public static void main(String[] args){
		int i,m;
		double k;
		System.out.println("请输入大于1的数");
		Scanner j=new Scanner(System.in);
		i=j.nextInt(); 
		k=Math.sqrt(i);  //判别i是否为素数，只需使2~根号i之间的每一个整数去除
		for(m=2;m<=k;m++)
			if(i%m==0)break;
		if(m>k)
			System.out.println("是素数 "+i);
		else   System.out.println("不是素数"+i);
	}
}
