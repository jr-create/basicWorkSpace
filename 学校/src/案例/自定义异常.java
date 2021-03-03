package 案例;

@SuppressWarnings("serial")
public class 自定义异常 extends Exception {
	int sum;
	public 自定义异常(int n,int m){
		n=100;
		m=103;
		sum=n+m;
	}
	public int warnInt(){
		return sum;
	}
}
