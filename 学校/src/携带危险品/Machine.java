package Я��Σ��Ʒ;


public class Machine {
	public void checkBag (Goods goods) throws DangerException{
		if(goods.isDanger()){
			DangerException danger=new DangerException();
			throw danger;
		}
		else{
			System.out.println(goods.getName()+"����Σ��Ʒ");
		}
	}
}
