package ColumnVolume;

public class Pillar {
	Geometry bottom;
	double height;
	Pillar (Geometry bottom,double height){
		this.bottom=bottom;
		this.height=height;
	}
	public double getVolume(){
		if(bottom==null){
			System.out.println("û�еף��޷�����");
			return -1;
		}
		else 
			return bottom.getArea()*height;
	}
}
