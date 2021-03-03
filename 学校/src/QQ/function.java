package QQ;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import 课程设计.*;
@SuppressWarnings("serial")
public class function extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField_1;
	JButton button ,button1,button2;
	JCheckBox CheckBox,checkBox;
	@SuppressWarnings("rawtypes")
	JComboBox comboBox,comboBox1;
	static Point origin=new Point();//
	public static void main(String[] args) {
		function frame = new function();
		frame.setVisible(true);
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public function() {
		setUndecorated(true);//没有窗口边框
		Dimension d=Toolkit.getDefaultToolkit().getScreenSize();//计算电脑分辨率
		setBounds((d.width-531)/2,(d.height-407)/2, 531, 407);//在电脑中间显示
		//		窗口图标
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\eclipsesdt\\QQ\\500133.gif"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		button2 = new JButton("登录");
		button2.setForeground(new Color(255, 255, 255));
		button2.setFont(new Font("宋体", Font.BOLD, 20));
		button2.setBackground(new Color(0, 255, 255));
		button2.setBounds(118, 340, 299, 47);
		contentPane.add(button2);
		button2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Login login=new Login();
				String regex="[a-zA-Z|0-9|_]+";//限制字符
				String account=comboBox.getSelectedItem().toString();
				String str = comboBox.getSelectedItem().toString();//获取文本框的数据
				String str1 = textField_1.getText();
				String str2 ="123";
				login.setID(str);//将数据
				login.setPassword(str1);
				login.setDepartment(str2);
				HandleLogin handleLogin=new HandleLogin();//
				handleLogin.queryVerify(login);//
				System.out.println(login.getLoginSuccess());
				if(account.matches(regex)&&login.getLoginSuccess()==true) {
					dispose();
					QQface frame = new QQface();//QQ主界面
					frame.setVisible(true);
				}
				else {  
					pa dialog = new pa();//提示错误界面
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				}
			}
		});
		textField_1 = new JPasswordField();
		textField_1.setBounds(118, 254,300, 39);
		contentPane.add(textField_1);
		comboBox = new JComboBox();
		comboBox.setEditable(true);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"247549095", "1535246"}));
		comboBox.setBounds(118, 205, 300, 39);
		comboBox.setBackground(new Color(255, 255, 255));
		contentPane.add(comboBox);
		comboBox1 = new JComboBox();
		comboBox1.setModel(new DefaultComboBoxModel(new String[] {"游客", "普通用户","管理员"}));
		comboBox1.setEditable(false);
		comboBox1.setBounds(419, 205,80, 39);
		comboBox1.setBackground(new Color(255, 255, 255));
		contentPane.add(comboBox1);

		CheckBox = new JCheckBox("记住密码");
		CheckBox.setSelected(true);
		textField_1.setText("123");
		CheckBox.setBackground(new Color(255, 255, 255));
		CheckBox.setBounds(235, 300, 95, 27);
		contentPane.add(CheckBox);

		checkBox = new JCheckBox("自动登录");
		checkBox.setBackground(new Color(255, 255, 255));
		checkBox.setBounds(118, 300, 95, 27);
		contentPane.add(checkBox);
		//		QQ界面
		JLabel label_5 = new JLabel("");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setIcon(new ImageIcon("D:\\eclipsesdt\\QQ\\qq2.GIF"));
		label_5.setBounds(0, 0, 531, 407);
		contentPane.add(label_5);
		//		注册界面
		JLabel label_4 = new JLabel("");
		label_4.setBackground(new Color(0, 0, 128));
		label_4.setFont(new Font("宋体", Font.PLAIN, 20));
		label_4.setForeground(new Color(192, 192, 192));
		label_4.setBounds(0, 376, 84, 23);
		contentPane.add(label_4);
		label_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RegistrationScreen b = new RegistrationScreen();	
				b.setVisible(true);
			}
			public void mouseEntered(MouseEvent e) {}
		});
		//		找回密码事件
		final JLabel label_2 = new JLabel("");
		label_2.setEnabled(false);
		label_2.setFont(new Font("宋体", Font.PLAIN, 20));
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				password dialog = new password();
				dialog.SQL();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
			public void mouseEntered(MouseEvent e) {}
		});
		label_2.setForeground(Color.BLUE);
		label_2.setBounds(346, 304, 84, 23);
		contentPane.add(label_2);
		//		退出按钮
		button = new JButton("");
		button.setContentAreaFilled(false);//设置按钮透明
		button.setBounds(493, 0, 33, 33);
		contentPane.add(button);
		button.addActionListener(this);
		//		最小化
		button1 = new JButton("");
		button1.setContentAreaFilled(false);//设置按钮透明
		button1.setBounds(453, 0, 33, 33);
		contentPane.add(button1);
		button1.addActionListener(this);
		this.addMouseMotionListener(new MouseMotionListener(){
			public void mouseDragged(MouseEvent e) {
				Point p=getLocation();
				setLocation(p.x+e.getX()-origin.x,p.y+e.getY()-origin.y);
			}
			public void mouseMoved(MouseEvent e) {
			}
		});
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button)dispose();
		if(e.getSource()==button1)setExtendedState(JFrame.ICONIFIED);
	}
}
