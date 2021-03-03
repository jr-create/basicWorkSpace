package ����2;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
@SuppressWarnings("serial")
public class Panel1 extends JFrame implements ActionListener{
	JPanel jpanel;
	JButton jb1, jb2, jb3;
	JTextArea jta = null;
	JScrollPane jscrollPane;
	public Panel1() {
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		jta = new JTextArea(10, 15);
		jta.setTabSize(4);
		jta.setFont(new Font("�꿬��", Font.BOLD, 16));
		jta.setLineWrap(true);// �����Զ����й���
		jta.setWrapStyleWord(true);// ������в����ֹ���
		jta.setBackground(Color.pink);

		jscrollPane = new JScrollPane(jta);
		jpanel = new JPanel();
		jpanel.setLayout(new GridLayout(1, 3));

		jb1 = new JButton("����");
		jb1.addActionListener(this);
		jb2 = new JButton("ճ��");
		jb2.addActionListener(this);
		jb3 = new JButton("����");
		jb3.addActionListener(this);
	 
			jpanel.add(jb1);
			jpanel.add(jb2);
			jpanel.add(jb3);
	 
			contentPane.add(jscrollPane, BorderLayout.CENTER);
			contentPane.add(jpanel, BorderLayout.SOUTH);
	 
			setSize(400, 300);
			setLocation(400, 200);
			setVisible(true);
	 
			addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					System.exit(0);
				}
			});
		}
		// ���ǽӿ�ActionListener�ķ���actionPerformed
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == jb1) {
				jta.copy();
			} else if (e.getSource() == jb2) {
				jta.paste();
			} else if (e.getSource() == jb3) {
				jta.cut();
			}
		}
	
	public static void main(String args[]){
		@SuppressWarnings("unused")
		Panel1 p=new Panel1();
	}
}
