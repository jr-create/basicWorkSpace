interface make{
	public abstract double area(double r,double a,double b);
	public abstract double zc(double r,double a,double b);
}
class circle implements make{
	
	public double area(double r,double a,double b){
		double area=r*r*3.14;
		return area;
	}
	public double zc(double r,double a,double b){
		double zc=r*2*3.14;
		return zc;
	}
}
class tangle implements make{
	@Override
	public double area(double r,double a,double b) {
		double area=a*b;
		return area;
	}
	public double zc(double r,double a,double b) {
		double zc=2*(a+b);
		return 0;
	}
}

public class area {
	public static void main(String args[]){
		make m;
		m=new circle();
		System.out.println(m.area(2,0,0));//接口回调
		m=new tangle();
		System.out.println(m.area(0, 1, 21));
	}
}
