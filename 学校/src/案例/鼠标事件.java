package 案例;
import java.awt.*;
import java.awt.event.*;
class 鼠标事件 extends WindowAdapter implements MouseListener,MouseMotionListener{
	Button b1,b2;
	Frame f;
	Panel p;
	Label tf;

	public static void main(String args[ ]){
		鼠标事件 t=new 鼠标事件();
		t.go();
	}

	public void go(){
		b1=new Button("确定");
		b1.setBackground(new Color(155,200,155));
		b2=new Button("取消");
		f=new Frame("事件处理");
		p=new Panel( );
		tf=new Label("显示点击或移动鼠标的操作情况");
		tf.setFont(new Font("黑体",Font.BOLD,24));
		tf.setBackground(Color.gray);
		tf.setForeground(Color.BLUE);
		p.add(b1);
		p.add(b2);
		f.add(p,"North");
		f.add(tf,"South");
		f.setSize(700,400 );
		f.setBackground(Color.orange);
		p.setBackground(Color.blue);
		f.setVisible(true);
		f.addWindowListener(this);
		f.addMouseMotionListener(this);
		b2.addMouseMotionListener(this);
		b1.addMouseListener(this);
		p.addMouseListener(this);
		b2.addMouseListener(this);
		tf.addMouseMotionListener(this);
	}

	public void mouseDragged (MouseEvent e)
	{String s = "正在拖动鼠标，其坐标为：X="+e.getX() +" Y=" +e.getY();
	tf.setText(s);}

	public void mouseMoved (MouseEvent e)
	{String s = "正在移动鼠标，其坐标为：X="+e.getX() +" Y=" +e.getY();
	tf.setText(s);}

	public void mouseClicked (MouseEvent e) {
		}

	public void mouseEntered (MouseEvent e)
	{
		String s1="";
		if(e.getSource()==b1)
		{s1="确定";
		b1.setBackground(Color.red);}
		else s1="取消";
		String s = "鼠标已经进入了' "+s1+" '按钮，其初始进入坐标为X:"+e.getX()+" Y:"+e.getY();
		tf.setText(s);}

	public void mouseExited (MouseEvent e)
	{ String s1="";
	if(e.getSource()==b1)
	{s1="确定";
	b1.setBackground(new Color(155,200,155));}
	else s1="取消";
	String s = "鼠标已经离开了' "+s1+" '按钮";tf.setText(s);	}

	public void mousePressed (MouseEvent e)
	{String s = "你已经按下了鼠标左键";tf.setText(s);	}

	public void mouseReleased (MouseEvent e)
	{String s = "你已经松开了鼠标左键";tf.setText(s);	}

	public void windowClosing(WindowEvent e)
	{System.exit(0);}
}
