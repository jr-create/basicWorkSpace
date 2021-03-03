package ColumnVolume;

public class Application {
	public static void main(String args[]){
		Pillar pillar;
		Geometry bottom =null;
		pillar=new Pillar(bottom,100);
		System.out.println("体积"+pillar.getVolume());
		bottom =new Rectangle(12,99);
		pillar = new Pillar(bottom,59);
		System.out.println("体积"+pillar.getVolume());
		bottom =new Circle(3);
		pillar =new Pillar (bottom,32);
		System.out.println("体积"+pillar.getVolume());
	}
}
