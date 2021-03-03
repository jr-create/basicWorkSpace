package image;
import java.awt.*;
/**
 * 文档注释
 * 方法和变量的标识符第一个单词小写，第二个单词以及后面首字母大写
 */
import javax.swing.*;
public class BallGame extends JFrame {
	Image ball=Toolkit.getDefaultToolkit().getImage("D:\\eclipsesdt\\小球.png");
	Image desk=Toolkit.getDefaultToolkit().getImage("D:\\eclipsesdt\\球桌.jpg");
	double x=100;//小球的横坐标 	成员变量会自动赋值
	double y=100;//小球的纵坐标
//	boolean right=true;
	double 	 degree=3.14/3;//弧度此处是60度
	/**
	 * java 入门学习
	 */
	static int b=1;//静态变量 	属于类 也叫类变量
	final int MAX=12;//常量  标识符 全部要大字母    不可更改
//	加载图片
	public void paint(Graphics g){
		System.out.println("画一次");
		g.drawImage(desk, 0,0,null);
		g.drawImage(ball, (int)x, (int )y,null);
		/*
		if(right){
		x=x+10;
		}
		else{x-=10;}
		if(x>856-40-30){//40是桌子边宽30是球直径
			right=false;
		}
		if(x<40) right=true;
		*/
		x=x+20*Math.cos(degree);
		y=y+20*Math.sin(degree);//20是速度
		if(y>500-40-30||y<40+40)//500是窗口宽度40是桌边框最后一个40是标题栏的宽度
			degree=-degree;
		if(x<0+40||x>856-40-30)
			degree=3.14-degree;
	}
//	窗口加载
	void launchFrame(){
		setSize(856,500);
		setLocation(50,50);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		while(true){
			repaint();
			try{
				Thread.sleep(40);//40ms
			}catch(Exception e){e.printStackTrace();}
			
		}
	}
	/**文档注释
	 * 这是程序入口
	 * @param args参数名称
	 */
	
	public static void main(String []args){
		int a;//局部变量需要赋初值
		a=1;
		System.out.println(a);
		BallGame game=new BallGame();
		game.launchFrame();
		
	}

}
