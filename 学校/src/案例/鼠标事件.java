package ����;
import java.awt.*;
import java.awt.event.*;
class ����¼� extends WindowAdapter implements MouseListener,MouseMotionListener{
	Button b1,b2;
	Frame f;
	Panel p;
	Label tf;

	public static void main(String args[ ]){
		����¼� t=new ����¼�();
		t.go();
	}

	public void go(){
		b1=new Button("ȷ��");
		b1.setBackground(new Color(155,200,155));
		b2=new Button("ȡ��");
		f=new Frame("�¼�����");
		p=new Panel( );
		tf=new Label("��ʾ������ƶ����Ĳ������");
		tf.setFont(new Font("����",Font.BOLD,24));
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
	{String s = "�����϶���꣬������Ϊ��X="+e.getX() +" Y=" +e.getY();
	tf.setText(s);}

	public void mouseMoved (MouseEvent e)
	{String s = "�����ƶ���꣬������Ϊ��X="+e.getX() +" Y=" +e.getY();
	tf.setText(s);}

	public void mouseClicked (MouseEvent e) {
		}

	public void mouseEntered (MouseEvent e)
	{
		String s1="";
		if(e.getSource()==b1)
		{s1="ȷ��";
		b1.setBackground(Color.red);}
		else s1="ȡ��";
		String s = "����Ѿ�������' "+s1+" '��ť�����ʼ��������ΪX:"+e.getX()+" Y:"+e.getY();
		tf.setText(s);}

	public void mouseExited (MouseEvent e)
	{ String s1="";
	if(e.getSource()==b1)
	{s1="ȷ��";
	b1.setBackground(new Color(155,200,155));}
	else s1="ȡ��";
	String s = "����Ѿ��뿪��' "+s1+" '��ť";tf.setText(s);	}

	public void mousePressed (MouseEvent e)
	{String s = "���Ѿ�������������";tf.setText(s);	}

	public void mouseReleased (MouseEvent e)
	{String s = "���Ѿ��ɿ���������";tf.setText(s);	}

	public void windowClosing(WindowEvent e)
	{System.exit(0);}
}
