package Я��Σ��Ʒ;

@SuppressWarnings("serial")
public class DangerException extends Exception{//�Զ����쳣
	String message;
	public DangerException(){
		message="Σ��Ʒ";
	}
	public void toShow(){
		System.out.println(message+"");
	}
}
