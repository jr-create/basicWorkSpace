package °¸Àý;
class Father{
	 int money =12;
	float height;
	int seeMoney(){
		return money;
	}
}
class Son extends Father{
	int height;
	int lookMoney(){
		int m=seeMoney();
		return m;
	}
}
public class Exercise5 {
	public static void main(String args[]){
		Son ss=new Son();
		ss.money=2;
		ss.height=178;
		System.out.println(ss.lookMoney());
	}
}
