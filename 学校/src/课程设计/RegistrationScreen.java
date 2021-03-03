package �γ����;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class RegistrationScreen extends JFrame implements ActionListener {
	//	****************���ں���
	Date now=new Date();
//	*****����ע��ģ��
	static Register register=new Register();
	//	********************************
	private JPanel contentPane;
	JButton in, out;
	JTextField name, password,tel;
	JComboBox<String> comBox;
	JLabel label_4;
	public RegistrationScreen() {
		setBounds(750,340, 479, 411);
		setTitle("ע�����");
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(204, 255, 255));
		setResizable(false);//�̶����ڲ�������
		init();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public void init() {
		//		*****************��ť����
		in = new JButton("ע��");
		in.registerKeyboardAction(this, 
				KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0),JComponent.WHEN_IN_FOCUSED_WINDOW);
		in.setBounds(57,257, 113, 27);
		out = new JButton("�˳�");
		out.registerKeyboardAction(this, 
				KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE,0),JComponent.WHEN_IN_FOCUSED_WINDOW);
		out.setBounds(260, 257, 113, 27);
		contentPane.add(in);
		contentPane.add(out);
		in.addActionListener(this);
		out.addActionListener(this);
		//		************************��ѡ����
		comBox = new JComboBox<String>();
		comBox.setFont(new Font("����", Font.PLAIN, 17));
		comBox.addItem("������");
		comBox.addItem("����");
		comBox.addItem("������");
		comBox.addItem("�г���");
		comBox.setBounds(160, 160, 179, 37);
		contentPane.add(comBox);
		//		******************************��ǩ����
		JLabel label = new JLabel("�û���:");
		label.setFont(new Font("����", Font.PLAIN, 17));
		label.setBounds(80, 35, 60, 60);
		contentPane.add(label);
		JLabel label_1 = new JLabel("��  ��:");
		label_1.setFont(new Font("����", Font.PLAIN, 17));
		label_1.setBounds(81, 97, 65, 60);
		contentPane.add(label_1);
		JLabel label_2 = new JLabel("��  ��:");
		label_2.setFont(new Font("����", Font.PLAIN, 17));
		label_2.setBounds(81, 150, 65, 60);
		contentPane.add(label_2);
		JLabel label_3 = new JLabel("��  ��:");
		label_3.setFont(new Font("����", Font.PLAIN, 17));
		label_3.setBounds(81, 200, 65, 60);
		contentPane.add(label_3);
		label_4 = new JLabel("���ص�¼����");
		label_4.setForeground(Color.BLUE);
		label_4.setFont(new Font("����", Font.PLAIN, 15));
		label_4.setBounds(270, 310, 100, 27);
		contentPane.add(label_4);
		label_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				LoginInterface b = new LoginInterface();	
				b.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				label_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		//		*****************************�ı�����
		name = new JTextField();
		name.setBounds(160, 40, 179, 32);
		name.setFont(new Font("����", Font.PLAIN, 17));
		contentPane.add(name);
		name.setColumns(10);
		password = new JTextField();
		password.setBounds(160, 100, 179, 32);
		password.setFont(new Font("����", Font.PLAIN, 17));
		contentPane.add(password);
		password.setColumns(10);
		tel = new JTextField();
		tel.setBounds(160, 210, 179, 32);
		tel.setFont(new Font("����", Font.PLAIN, 17));
		contentPane.add(tel);
		tel.setColumns(10);
	}
	//	********************�¼�
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == in) {
			HandleInsertData h=new HandleInsertData();
			//			**********************************
			String id=name.getText();
			String pass=password.getText();
			SimpleDateFormat d2=new SimpleDateFormat("yyyy-MM-dd");
			String birth=d2.format(now);
			String dep=(String) comBox.getSelectedItem();
			String telephone=tel.getText();
			try{
				register.setID(id);
				register.setPassword(pass);
				register.setBirth(birth);
				register.settelephone(telephone);;
				register.setdepartment(dep);;
			}catch(Exception ee){
				ee.printStackTrace();
			}
			h.writeRegisterModel(register);
			password.setText(null);
		}
		else if (e.getSource() == out) {
			int n = JOptionPane.showConfirmDialog(this, "ȷ���˳���", "ȷ����",
					JOptionPane.YES_NO_OPTION);
			if (n == JOptionPane.YES_OPTION) {
				System.exit(-1);
			}
			if (n == JOptionPane.NO_OPTION) {
				password.setText(null);
			}
		}
	}
}
