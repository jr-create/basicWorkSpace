package �γ����;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

@SuppressWarnings("serial")
public class password extends JDialog implements ActionListener {
	static Connection con;
	PreparedStatement preSql;
	ResultSet rs;
	JPanel contentPanel = new JPanel();
	private JTextField textField;
	Dimension screeSize=Toolkit.getDefaultToolkit().getScreenSize();
	private JButton okButton,exButton;
	JLabel label;
	/*public static void main(String[] args) {
		try {
			password dialog = new password();
			dialog.SQL();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	public void SQL(){
		con=JDBC.connect("students","root","ren@0072");
		if(con==null)System.out.println("Ϊ��");
		else{
			System.out.println("���ӳɹ�");
		}
	}
	public password() {
		setBounds((screeSize.width-168)/2,(screeSize.height-310)/2, 280, 168);
		setResizable(false);
	
		contentPanel.setLayout(new FlowLayout());
		add(contentPanel);
		label = new JLabel("������绰���룺");
		label.setFont(new Font("����", Font.PLAIN, 17));
		contentPanel.add(label);

		//�����		
		textField = new JTextField();
		contentPanel.add(textField);
		textField.setColumns(20);
		//		��ť�¼�
		okButton = new JButton("��ѯ");
		okButton.addActionListener(this);
		contentPanel.add(okButton);
		okButton.registerKeyboardAction(this, 
				KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0),JComponent.WHEN_IN_FOCUSED_WINDOW);
		exButton = new JButton("�˳�");
		exButton.addActionListener(this);
		contentPanel.add(exButton);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == okButton) {
			try {	
				String sqlStr ="select �绰,���� from id where �绰=?";
				String pa=textField.getText();
				preSql=con.prepareStatement(sqlStr);//����һ��PreparedStatement���󽫲�������SQL��䷢�͵����ݿ⡣
				preSql.setString(1, pa);
				String p=null;
				rs=preSql.executeQuery();
				
				if(rs.next()){
					p=rs.getString("����");System.out.println(p);
					JOptionPane.showMessageDialog(null, "����Ϊ:"+p,
							"��ʾ", JOptionPane.WARNING_MESSAGE);
				}
				else{

					JOptionPane.showMessageDialog(null, "��¼ʧ��","��ʾ",JOptionPane.WARNING_MESSAGE);
				}
				rs.close();
				preSql.close();
				con.close();
				dispose();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}//�ڴ� PreparedStatement ������ִ�� SQL ��ѯ
		}
		if (e.getSource() == exButton) dispose();
	}
}