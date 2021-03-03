package 课程设计;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class LoginInterface extends JFrame implements ActionListener {
	private JPanel contentPane;
	JButton in, out;
	JTextField name;
	JPasswordField password;
	JComboBox<String> comBox;
	JLabel label_4,label_5;
	Login login=new Login();
	public LoginInterface() {
/*	//	无边框
		setUndecorated(true);
		Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
		//	*/	
		setBounds(750,340, 479, 411);
		setTitle("登录界面");
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(204, 255, 255));
		setResizable(false);//固定窗口不可拉伸
		init();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	void init() {
		in = new JButton("登录");
		in.registerKeyboardAction(this, 
				KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0),JComponent.WHEN_IN_FOCUSED_WINDOW);
		in.setFont(new Font("黑体", Font.PLAIN, 17));
		in.setBounds(57, 250, 113, 27);
		out = new JButton("退出");
		out.registerKeyboardAction(this, 
				KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE,0),JComponent.WHEN_IN_FOCUSED_WINDOW);
		out.setFont(new Font("黑体", Font.PLAIN, 17));
		out.setBounds(260, 250, 113, 27);
		contentPane.add(in);
		contentPane.add(out);
		in.addActionListener(this);
		out.addActionListener(this);
		//		************************复选框建立
		comBox = new JComboBox<String>();
		comBox.setFont(new Font("黑体", Font.PLAIN, 17));
		comBox.addItem("行政部");
		comBox.addItem("财务部");
		comBox.addItem("技术部");
		comBox.addItem("市场部");
		comBox.setBounds(160, 150, 179, 37);
		contentPane.add(comBox);
		//		******************************标签建立
		JLabel label = new JLabel("用户名:");
		label.setFont(new Font("黑体", Font.PLAIN, 17));
		label.setBounds(80, 35, 60, 60);
		contentPane.add(label);
		JLabel label_1 = new JLabel("密  码:");
		label_1.setFont(new Font("黑体", Font.PLAIN, 17));
		label_1.setBounds(81, 97, 65, 60);
		contentPane.add(label_1);
		JLabel label_2 = new JLabel("部  门:");
		label_2.setFont(new Font("黑体", Font.PLAIN, 17));
		label_2.setBounds(81, 145, 65, 60);
		contentPane.add(label_2);
		label_4 = new JLabel("管理员注册帐户");
		label_4.setForeground(Color.BLUE);
		label_4.setFont(new Font("黑体", Font.PLAIN, 15));
		label_4.setBounds(260, 312, 113, 23);
		contentPane.add(label_4);
		label_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				RegistrationScreen b = new RegistrationScreen();	
				b.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				label_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		label_5 = new JLabel("忘了密码？");
		label_5.setForeground(Color.BLUE);
		label_5.setFont(new Font("黑体", Font.PLAIN, 15));
		label_5.setBounds(86, 310, 84, 27);
		contentPane.add(label_5);
		label_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				password dialog = new password();
				dialog.SQL();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				label_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		//		*****************************文本框建立
		name = new JTextField();
		name.setBounds(160,40, 179, 32);
		name.setFont(new Font("黑体", Font.PLAIN, 17));
		contentPane.add(name);
		password = new JPasswordField();
		password.setBounds(160, 100, 179, 37);
		password.setFont(new Font("黑体", Font.PLAIN, 17));
		contentPane.add(password);

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == in) {
			String str = name.getText();//获取用户名的数据
			@SuppressWarnings("deprecation")
			String str1 = password.getText();//获取用户密码的数据
			String str2 =comBox.getSelectedItem().toString();//获取用户部门的数据
			login.setID(str);//将数据给模型
			login.setPassword(str1);
			login.setDepartment(str2);
			HandleLogin handleLogin=new HandleLogin();//
		handleLogin.queryVerify(login);//
			System.out.println(login.getLoginSuccess());
			if (login.getLoginSuccess()==true) {
				dispose();
				@SuppressWarnings("unused")
				FunctionInterface p3 = new FunctionInterface();
			} else {
				password.setText(null);
			}
		}
		else if (e.getSource() == out) {
			int n = JOptionPane.showConfirmDialog(this, "确定退出吗", "确定框",
					JOptionPane.YES_NO_OPTION);
			if (n == JOptionPane.YES_OPTION) {
				System.exit(-1);
			}
			if (n == JOptionPane.NO_OPTION) {
				password.setText(null);
			}
		}
	}
	public static void main(String args[]){
		LoginInterface b = new LoginInterface();
		b.setVisible(true);

	}
}
