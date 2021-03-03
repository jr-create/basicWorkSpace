package ɨ��;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
public class saolei implements MouseListener,ActionListener{
	JPanel p=new JPanel();
	JFrame frame = new JFrame("src/ɨ��");
	@SuppressWarnings("rawtypes")
	JComboBox combobox = new JComboBox();
	JButton reset = new JButton("���¿�ʼ"),button1=new JButton("ɨ��Ӣ�۰�"),button2=new JButton("�˳�");
	JPanel container = new JPanel();
	JMenuBar menubar=new JMenuBar();
	JMenu menu=new JMenu("�˵�");
	JMenuItem item1=new JMenuItem("������:");
	//��Ϸ���ݽṹ
	Saoleiconstant constant = new Saoleiconstant();
	JButton[][] buttons = new JButton[constant.row][constant.col];//���尴ť
	int[][] counts = new int [constant.row][constant.col];//�����������鱣�水ť�·�����
	int leeiCount=20;
	JTextField	 j=new JTextField(3);
	//�������췽��
	public saolei() {
		//��ʾ����
		frame.setSize(600,700);//600*700
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		// *******************************************
		button1.setBackground(Color.green);
		button2.setBackground(Color.green);
		//		****************************************
		frame.add(container);
		//menubar.add(item1);
		menubar.add(menu);
		menubar.add(button1);
		
		button1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){

			//	frame f=new frame();

			}
		});
		button2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
			}
		});
		//*****************************
		frame.add(menubar,BorderLayout.NORTH);;
		//		************************************

		//���������ѡ���ѶȰ�ť
		addtopButton();

		//���������ť
		addButtons();

		//����
		addLei();

		//����׵ļ���
		calcNeiboLei();

		j.setText("������:"+String.valueOf(leeiCount));
		menubar.add(j);
		menubar.add(button2);
		frame.setVisible(true);
		
	}

	void addtopButton() {
		//item1.removeAll();
		menubar.add(reset);
		reset.setBackground(Color.green);
		reset.setOpaque(true);
		reset.addActionListener(this);
		combobox.addItem("�����Ѷ�");
		combobox.addItem("�����Ѷ�");
		combobox.addItem("�м��Ѷ�");
		combobox.addItem("�߼��Ѷ�");
		combobox.addItem("��ʦ�Ѷ�");
		combobox.setBackground(Color.GREEN);
		combobox.setOpaque(true);
		combobox.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent e) {
				String item = e.getItem().toString(); 
				if(item == "�����Ѷ�") {
					leeiCount = 20;
					j.setText("������:"+String.valueOf(leeiCount));
					menubar.add(j);
					ResetGame();
				} else if(item == "�����Ѷ�") {
					leeiCount = 43;
					j.setText("������:"+String.valueOf(leeiCount));
					menubar.add(j);
					ResetGame();
				} else if(item == "�м��Ѷ�"){
					leeiCount = 63;
					j.setText("������:"+String.valueOf(leeiCount));
					menubar.add(j);
					ResetGame();
				} else if(item == "�߼��Ѷ�"){
					leeiCount = 99;
					j.setText("������:"+String.valueOf(leeiCount));
					menubar.add(j);
					ResetGame();
				} else if(item == "��ʦ�Ѷ�") {
					leeiCount = 119;
					j.setText("������:"+String.valueOf(leeiCount));
					menubar.add(j);
					ResetGame();
				}

			}

		});
		menubar.add(combobox);
	}
	void addLei() {
		Random rand = new Random();
		int randRow,randCol;
		for(int i=0; i<leeiCount; i++) {
			randRow = rand.nextInt(constant.row);
			randCol = rand.nextInt(constant.col);
			if(counts[randRow][randCol] == constant.LEICODE) {
				i--;
			} else {
				counts[randRow][randCol] = constant.LEICODE;
				//buttons[randRow][randCol].setText("X");
			}
		}
	}

	void addButtons() {
		//	frame.add(container,BorderLayout.CENTER);
		container.setLayout(new GridLayout(constant.row,constant.col));
		for(int i=0;i<constant.row;i++) {
			for(int j=0;j<constant.col;j++) {
				JButton button = new JButton();
				button.setBackground(Color.white);
				button.setOpaque(true);
				button.addActionListener(this);
				button.addMouseListener((MouseListener) this);
				buttons[i][j] = button;
				container.add(button);
			}
		}
	}

	void calcNeiboLei() {
		int count;
		for(int i=0;i<constant.row;i++) {
			for(int j=0;j<constant.col;j++) {
				count =0;
				if(counts[i][j] == constant.LEICODE) continue;
				if(i>0 && j>0 && counts[i-1][j-1] == constant.LEICODE) count++;
				if(i>0 && counts[i-1][j] == constant.LEICODE) count++;
				if(i>0 && j<19 &&counts[i-1][j+1] == constant.LEICODE) count++; 
				if(j>0 && counts[i][j-1] == constant.LEICODE) count++;
				if(j<19 && counts[i][j+1] == constant.LEICODE) count++;
				if(i<19 && j>0 && counts[i+1][j-1] == constant.LEICODE) count++;
				if(i<19 && counts[i+1][j] == constant.LEICODE) count++;
				if(i<19 && j<19 && counts[i+1][j+1] == constant.LEICODE) count++;
				counts[i][j] = count;
				buttons[i][j].setMargin(new Insets(0,0,0,0));//�ð�ť�水ť�ϵ�ͼ���仯
				//buttons[i][j].setText(counts[i][j] + "");
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton)e.getSource();
		if(button.equals(reset)) {
			ResetGame();//���¿�ʼ��Ϸ
		} else {
			int count = 0;
			for(int i=0;i<constant.row;i++) {
				for(int j=0;j<constant.col;j++) {
					if(button.equals(buttons[i][j])) {
						count = counts[i][j];
						if(count == constant.LEICODE) {
							loseGame();
						} else {
							openCell(i,j);	
							checkWin();
						}
						return;
					}	
				}
			}
		}
	}



	public void mouseClicked(MouseEvent e) {
		JButton button = (JButton)e.getSource();
		if (e.getButton() == MouseEvent.BUTTON3) {//�ж�����һ�����
			for(int i=0;i<constant.row;i++) {
				for(int j=0;j<constant.col;j++) {
					if(button.equals(buttons[i][j])) {
						if((buttons[i][j].isEnabled() == true)) {
							//buttons[i][j].setEnabled(false);
							buttons[i][j].setMargin(new Insets(0,0,0,0));//�ð�ť�水ť�ϵ�ͼ���仯
							buttons[i][j].setText("��");
							return;
						} 
					}
				}
			}	
		}
	}

	void ResetGame() {
		for(int i=0;i<constant.row;i++) {
			for(int j=0;j<constant.col;j++) {
				buttons[i][j].setText("");
				buttons[i][j].setEnabled(true);
				buttons[i][j].setBackground(Color.white);
				counts[i][j] = 0;		
			}	
		}
		addLei();
		calcNeiboLei();	

		//item1.add(new Label());

	}

	void checkWin() {
		for(int i=0;i<constant.row;i++) {
			for(int j=0;j<constant.col;j++) {
				if(buttons[i][j].isEnabled() == true && counts[i][j] != constant.LEICODE ) return;		
			}
		}
		JOptionPane.showMessageDialog(frame,"Yeah,��Ӯ�ˣ�");	
	}

	//ʹ�õݹ鷽���򿪸���
	void openCell(int i, int j) {
		if(buttons[i][j].isEnabled() == false) return;
		buttons[i][j].setBackground(Color.yellow);
		buttons[i][j].setOpaque(true);
		buttons[i][j].setEnabled(false);
		if(counts[i][j] == 0) {
			if(i>0 && j>0 && counts[i-1][j-1] != constant.LEICODE) openCell(i-1,j-1);
			if(i>0 && j<19 && counts[i-1][j] != constant.LEICODE) openCell(i-1,j);
			if(i>0 && j<19 &&counts[i-1][j+1] != constant.LEICODE) openCell(i-1,j+1); 
			if(j>0 && counts[i][j-1] != constant.LEICODE) openCell(i,j-1);
			if(j<19 && counts[i][j+1] != constant.LEICODE) openCell(i,j+1);
			if(i<19 && j>0 && counts[i+1][j-1] != constant.LEICODE) openCell(i+1,j-1);
			if(i<19 && counts[i+1][j] != constant.LEICODE) openCell(i+1,j);
			if(i<19 && j<19 && counts[i+1][j+1] != constant.LEICODE) openCell(i+1,j+1);
		} else {
			buttons[i][j].setMargin(new Insets(0,0,0,0));
			buttons[i][j].setText(counts[i][j] + "");
		}
	}

	void loseGame() {
		for(int i=0;i<constant.row;i++) {
			for(int j=0;j<constant.col;j++) {
				int count = counts[i][j];
				if(count == constant.LEICODE) {
					buttons[i][j].setMargin(new Insets(0,0,0,0));
					buttons[i][j].setText("��");
					buttons[i][j].setBackground(Color.red);
					buttons[i][j].setEnabled(false);
				} else {
					buttons[i][j].setMargin(new Insets(0,0,0,0));
					buttons[i][j].setText(count + "");
					buttons[i][j].setEnabled(false);

				}
			}
		}
		JOptionPane.showMessageDialog(frame,"sorry,�����ˣ�");

	}

	public static void main(String[] args) {
		new saolei();
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}



