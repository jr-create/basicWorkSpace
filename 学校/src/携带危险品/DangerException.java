package 携带危险品;

@SuppressWarnings("serial")
public class DangerException extends Exception{//自定义异常
	String message;
	public DangerException(){
		message="危险品";
	}
	public void toShow(){
		System.out.println(message+"");
	}
}
