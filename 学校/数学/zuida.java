import java.util.Scanner;


public class zuida {

	public static void main(String[] args) {
		int a,b,t,r;
		Scanner j=new Scanner(System.in);
		a=j.nextInt();
		b=j.nextInt();
		if(a<b)
		{
			t=b;
			b=a;
			a=t;
		}
		r=a%b;
		int n=a*b;
		while(r!=0)
		{
			a=b;
			b=r;
			r=a%b;
		}
		System.out.println("�������Ϊ:"+b+"��С������Ϊ:"+n/b);

	}

}
