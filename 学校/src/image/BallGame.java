package image;
import java.awt.*;
/**
 * �ĵ�ע��
 * �����ͱ����ı�ʶ����һ������Сд���ڶ��������Լ���������ĸ��д
 */
import javax.swing.*;
public class BallGame extends JFrame {
	Image ball=Toolkit.getDefaultToolkit().getImage("D:\\eclipsesdt\\С��.png");
	Image desk=Toolkit.getDefaultToolkit().getImage("D:\\eclipsesdt\\����.jpg");
	double x=100;//С��ĺ����� 	��Ա�������Զ���ֵ
	double y=100;//С���������
//	boolean right=true;
	double 	 degree=3.14/3;//���ȴ˴���60��
	/**
	 * java ����ѧϰ
	 */
	static int b=1;//��̬���� 	������ Ҳ�������
	final int MAX=12;//����  ��ʶ�� ȫ��Ҫ����ĸ    ���ɸ���
//	����ͼƬ
	public void paint(Graphics g){
		System.out.println("��һ��");
		g.drawImage(desk, 0,0,null);
		g.drawImage(ball, (int)x, (int )y,null);
		/*
		if(right){
		x=x+10;
		}
		else{x-=10;}
		if(x>856-40-30){//40�����ӱ߿�30����ֱ��
			right=false;
		}
		if(x<40) right=true;
		*/
		x=x+20*Math.cos(degree);
		y=y+20*Math.sin(degree);//20���ٶ�
		if(y>500-40-30||y<40+40)//500�Ǵ��ڿ��40�����߿����һ��40�Ǳ������Ŀ��
			degree=-degree;
		if(x<0+40||x>856-40-30)
			degree=3.14-degree;
	}
//	���ڼ���
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
	/**�ĵ�ע��
	 * ���ǳ������
	 * @param args��������
	 */
	
	public static void main(String []args){
		int a;//�ֲ�������Ҫ����ֵ
		a=1;
		System.out.println(a);
		BallGame game=new BallGame();
		game.launchFrame();
		
	}

}
