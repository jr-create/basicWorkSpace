

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
		System.out.println("���������1����");
		Scanner j=new Scanner(System.in);
		i=j.nextInt(); 
		k=Math.sqrt(i);  //�б�i�Ƿ�Ϊ������ֻ��ʹ2~����i֮���ÿһ������ȥ��
		for(m=2;m<=k;m++)
			if(i%m==0)break;
		if(m>k)
			System.out.println("������ "+i);
		else   System.out.println("��������"+i);
	}
}
