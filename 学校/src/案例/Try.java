package ����;

public class Try extends Lader{
	public static void main(String args[]){
		int x;
		Try dt=new Try();
		x=dt.getSum(222,222,222);
		System.out.println(x);
	}

	public int getSum(int ... x) {
		int sum = 0;
		for (int i = 0; i < x.length; i++) {
			sum = sum + x[i];
		}
		return sum;
	}
	public Try(){
		Lader.�µ� = 100;
		Lader laderOne = new Lader();
		Lader laderTwo = new Lader();
		laderOne.�����ϵ�(28);
		laderTwo.�����ϵ�(66);
		System.out.println("One�ϵ�"+laderOne.��ȡ�ϵ�());
		System.out.println("Two�ϵ�"+laderTwo.��ȡ�ϵ�());
		System.out.println("One�µ�"+laderOne.��ȡ�µ�());
		System.out.println("Two�µ�"+laderTwo.��ȡ�µ�());
		Character dou=new Character('s');
		System.out.println(dou.charValue());
		char []s={'d','d','g','c','d','t'};
		String t="nihoadfw";
		String b=new String(s,2,4);
		System.out.println(b);
		if(b==t)
			System.out.println(s);
		else
			System.out.println("error");
		String ster= " abcde d dd ";
		String str =ster.substring(1,3);
		System.out.println(str);
	}
}
