package 扫雷;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
public class saolei implements MouseListener,ActionListener{
	JPanel p=new JPanel();
	JFrame frame = new JFrame("src/扫雷");
	@SuppressWarnings("rawtypes")
	JComboBox combobox = new JComboBox();
	JButton reset = new JButton("重新开始"),button1=new JButton("扫雷英雄榜"),button2=new JButton("退出");
	JPanel container = new JPanel();
	JMenuBar menubar=new JMenuBar();
	JMenu menu=new JMenu("菜单");
	JMenuItem item1=new JMenuItem("总雷数:");
	//游戏数据结构
	Saoleiconstant constant = new Saoleiconstant();
	JButton[][] buttons = new JButton[constant.row][constant.col];//定义按钮
	int[][] counts = new int [constant.row][constant.col];//定义整型数组保存按钮下方雷数
	int leeiCount=20;
	JTextField	 j=new JTextField(3);
	//创建构造方法
	public saolei() {
		//显示窗口
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

		//添加重来、选择难度按钮
		addtopButton();

		//添加雷区按钮
		addButtons();

		//埋雷
		addLei();

		//添加雷的计数
		calcNeiboLei();

		j.setText("总雷数:"+String.valueOf(leeiCount));
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
		combobox.addItem("新手难度");
		combobox.addItem("初级难度");
		combobox.addItem("中级难度");
		combobox.addItem("高级难度");
		combobox.addItem("大师难度");
		combobox.setBackground(Color.GREEN);
		combobox.setOpaque(true);
		combobox.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent e) {
				String item = e.getItem().toString(); 
				if(item == "新手难度") {
					leeiCount = 20;
					j.setText("总雷数:"+String.valueOf(leeiCount));
					menubar.add(j);
					ResetGame();
				} else if(item == "初级难度") {
					leeiCount = 43;
					j.setText("总雷数:"+String.valueOf(leeiCount));
					menubar.add(j);
					ResetGame();
				} else if(item == "中级难度"){
					leeiCount = 63;
					j.setText("总雷数:"+String.valueOf(leeiCount));
					menubar.add(j);
					ResetGame();
				} else if(item == "高级难度"){
					leeiCount = 99;
					j.setText("总雷数:"+String.valueOf(leeiCount));
					menubar.add(j);
					ResetGame();
				} else if(item == "大师难度") {
					leeiCount = 119;
					j.setText("总雷数:"+String.valueOf(leeiCount));
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
				buttons[i][j].setMargin(new Insets(0,0,0,0));//让按钮随按钮上的图案变化
				//buttons[i][j].setText(counts[i][j] + "");
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton)e.getSource();
		if(button.equals(reset)) {
			ResetGame();//重新开始游戏
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
		if (e.getButton() == MouseEvent.BUTTON3) {//判断鼠标右击动作
			for(int i=0;i<constant.row;i++) {
				for(int j=0;j<constant.col;j++) {
					if(button.equals(buttons[i][j])) {
						if((buttons[i][j].isEnabled() == true)) {
							//buttons[i][j].setEnabled(false);
							buttons[i][j].setMargin(new Insets(0,0,0,0));//让按钮随按钮上的图案变化
							buttons[i][j].setText("？");
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
		JOptionPane.showMessageDialog(frame,"Yeah,你赢了！");	
	}

	//使用递归方法打开格子
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
					buttons[i][j].setText("雷");
					buttons[i][j].setBackground(Color.red);
					buttons[i][j].setEnabled(false);
				} else {
					buttons[i][j].setMargin(new Insets(0,0,0,0));
					buttons[i][j].setText(count + "");
					buttons[i][j].setEnabled(false);

				}
			}
		}
		JOptionPane.showMessageDialog(frame,"sorry,你输了！");

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



