package 课程设计;
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
		if(con==null)System.out.println("为空");
		else{
			System.out.println("连接成功");
		}
	}
	public password() {
		setBounds((screeSize.width-168)/2,(screeSize.height-310)/2, 280, 168);
		setResizable(false);
	
		contentPanel.setLayout(new FlowLayout());
		add(contentPanel);
		label = new JLabel("请输入电话号码：");
		label.setFont(new Font("黑体", Font.PLAIN, 17));
		contentPanel.add(label);

		//密码框		
		textField = new JTextField();
		contentPanel.add(textField);
		textField.setColumns(20);
		//		按钮事件
		okButton = new JButton("查询");
		okButton.addActionListener(this);
		contentPanel.add(okButton);
		okButton.registerKeyboardAction(this, 
				KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0),JComponent.WHEN_IN_FOCUSED_WINDOW);
		exButton = new JButton("退出");
		exButton.addActionListener(this);
		contentPanel.add(exButton);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == okButton) {
			try {	
				String sqlStr ="select 电话,密码 from id where 电话=?";
				String pa=textField.getText();
				preSql=con.prepareStatement(sqlStr);//创建一个PreparedStatement对象将参数化的SQL语句发送到数据库。
				preSql.setString(1, pa);
				String p=null;
				rs=preSql.executeQuery();
				
				if(rs.next()){
					p=rs.getString("密码");System.out.println(p);
					JOptionPane.showMessageDialog(null, "密码为:"+p,
							"提示", JOptionPane.WARNING_MESSAGE);
				}
				else{

					JOptionPane.showMessageDialog(null, "登录失败","提示",JOptionPane.WARNING_MESSAGE);
				}
				rs.close();
				preSql.close();
				con.close();
				dispose();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}//在此 PreparedStatement 对象中执行 SQL 查询
		}
		if (e.getSource() == exButton) dispose();
	}
}