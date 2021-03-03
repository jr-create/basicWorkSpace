package QQ;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class QQface extends JFrame implements ActionListener{
	private JPanel contentPane;
	JButton button,button1;

	public QQface() {
		setUndecorated(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\eclipsesdt\\QQ\\500133.gif"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension d=Toolkit.getDefaultToolkit().getScreenSize();//计算电脑分辨率
		setBounds((d.width-345)/2,(d.height-650)/2, 345,650);//在电脑中间显示
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("D:\\eclipsesdt\\QQ\\qq4.GIF"));
		lblNewLabel.setBounds(0, 0,348,650);
		contentPane.add(lblNewLabel);
		
		
//		退出按钮
		button = new JButton("");
		button.setContentAreaFilled(false);//设置按钮透明
		button.setBounds(310, 0, 33, 33);
		contentPane.add(button);
		button.addActionListener(this);
		button1 = new JButton("");
		button1.setContentAreaFilled(false);//设置按钮透明
		button1.setBounds(270, 0, 33, 33);
		contentPane.add(button1);
		button1.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button)dispose();
		if(e.getSource()==button1)setExtendedState(JFrame.ICONIFIED);
	}
}
