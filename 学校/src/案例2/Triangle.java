package ����2;

public class Triangle {
	double sideA,sideB,sideC;
	boolean isTriangle;
	public String GetArea(){
		if(isTriangle){
			double p= (sideA+sideB+sideC)/2.0;
			double area = Math.sqrt(p*(p-sideA)*(p-sideB)*(p-sideC));
			return String.valueOf(area);
		}
		else {
			return "�޷��������";
		}
	}
	public void setSide(double a,double b,double c){
		sideA=a;
		sideB=b;
		sideC=c;
	}
}
