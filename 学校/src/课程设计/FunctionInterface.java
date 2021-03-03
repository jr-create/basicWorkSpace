package 课程设计;

import java.awt.*;
import java.sql.*;
import java.util.Vector;

import javax.swing.*;

import java.awt.event.*;

import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;
@SuppressWarnings("serial")
public class FunctionInterface extends JFrame {
	
	private JPanel contentPane;//空面板
	private JTextField nameField;// 姓名
	private JTextField numberField;// 编号
	private JTextField ageField;// 年龄
	private JTextField telField;// 电话
	private JTextField monField;// 工资
	JTextField findField,find1Field,delField,del1Field,filtField,filt1Field;//文本框
	JTextArea find2Field;
	private JTable table;//表
	private JButton addButton, addButton1, addButton2, addButton3, addButton4,addButton5,addButton6;//功能按钮
	private DefaultTableModel dtm;//表模型格
	JComboBox<String> comBox,partBox,com1Box;//职位复选框
	JRadioButton radioM,radioF;//性别单选框
	ButtonGroup group;//组合单选框
	// 建立文件
	@SuppressWarnings("unchecked")
	public FunctionInterface(){ 
		// 建立窗口
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\eclipsesdt\\QQ\\500133.gif"));
		setTitle("公司员工管理");

		Dimension screeSize=Toolkit.getDefaultToolkit().getScreenSize();//显示屏幕大小
		System.out.println(screeSize.width+"  "+screeSize.height);
		setBounds((screeSize.width-1600)/2,(screeSize.height-850)/2,1600, 850);//显示屏幕中央
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(new JScrollPane(contentPane));
		contentPane.setLayout(null);
		setVisible(true);//可视化
		setResizable(false);//不可变大
		validate();//检查
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//窗口关闭后释放空间
		//		**********************************选项卡
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.RIGHT);
		tabbedPane.setBounds(730,40, 860,800);
		tabbedPane.setFont(new Font("楷体", Font.BOLD, 20));
		final JPanel tpane1 = new JPanel();
		tabbedPane.addTab("添加", null, tpane1, null);
		tpane1.setLayout(null);
		JPanel tpane2 = new JPanel();
		tabbedPane.addTab("统计", null, tpane2, null);
		tpane2.setLayout(null);
		JPanel tpane3 = new JPanel();
		tabbedPane.addTab("查询", null, tpane3, null);
		tpane3.setLayout(null);
		JPanel tpane4 = new JPanel();
		tabbedPane.addTab("删除", null, tpane4, null);
		tpane4.setLayout(null);
		JPanel tpane5 = new JPanel();
		tabbedPane.addTab("修改", null, tpane5, null);
		tpane5.setLayout(null);
		contentPane.add(tabbedPane);
	
		//**********************************
		//************************标签空间
		// 用户标签
		JLabel lblNewLabel = new JLabel("编  号：");
		lblNewLabel.setBounds(140, 22, 100, 15);
		lblNewLabel.setFont(new Font("黑体", Font.PLAIN, 16));
		tpane1.add(lblNewLabel);
		// 用户标签
		JLabel lblNewLabel_1 = new JLabel("姓  名：");
		lblNewLabel_1.setBounds(340,22,100, 15);
		lblNewLabel_1.setFont(new Font("黑体", Font.PLAIN, 16));
		tpane1.add(lblNewLabel_1);
		// 用户标签
		JLabel lblNewLabel_2 = new JLabel("年  龄：");
		lblNewLabel_2.setBounds(540, 22,100, 15);
		lblNewLabel_2.setFont(new Font("黑体", Font.PLAIN, 16));
		tpane1.add(lblNewLabel_2);
		// 性别标签
		JLabel lblNewLabel_7 = new JLabel("性  别：");
		lblNewLabel_7.setBounds(140, 100,100, 15);
		lblNewLabel_7.setFont(new Font("黑体", Font.PLAIN, 16));
		tpane1.add(lblNewLabel_7);
		// 电话标签
		JLabel lblNewLabel_3 = new JLabel("电  话：");
		lblNewLabel_3.setBounds(340, 100,100, 15);
		lblNewLabel_3.setFont(new Font("黑体", Font.PLAIN, 16));
		tpane1.add(lblNewLabel_3);
		// 部门标签
		JLabel lblNewLabel_4 = new JLabel("部  门：");
		lblNewLabel_4.setBounds(540, 100,100, 15);
		lblNewLabel_4.setFont(new Font("黑体", Font.PLAIN, 16));
		tpane1.add(lblNewLabel_4);
		// 部门标签
		JLabel lblNewLabel_5 = new JLabel("职  位：");
		lblNewLabel_5.setBounds(140, 180,100, 15);
		lblNewLabel_5.setFont(new Font("黑体", Font.PLAIN, 16));
		tpane1.add(lblNewLabel_5);
		// 部门标签
		final JLabel lblNewLabel_6 = new JLabel("时间或提成：");
		lblNewLabel_6.setBounds(350, 180, 124, 15);
		lblNewLabel_6.setFont(new Font("黑体", Font.PLAIN, 16));
		tpane1.add(lblNewLabel_6);
		// *******统计标签
		JLabel lblNewLabel_8 = new JLabel("公司总人数为：");
		lblNewLabel_8.setBounds(40, 18, 120, 50);
		lblNewLabel_8.setFont(new Font("黑体", Font.PLAIN, 16));
		tpane2.add(lblNewLabel_8);
		JLabel lblNewLabel_9 = new JLabel("公司平均工资为：");
		lblNewLabel_9.setBounds(280, 20, 150, 50);
		lblNewLabel_9.setFont(new Font("黑体", Font.PLAIN, 16));
		tpane2.add(lblNewLabel_9);
		JLabel lblNewLabel_10 = new JLabel("公司总工资为：");
		lblNewLabel_10.setBounds(550, 20, 120, 50);
		lblNewLabel_10.setFont(new Font("黑体", Font.PLAIN, 16));
		tpane2.add(lblNewLabel_10);
		JLabel lblNewLabel_101 = new JLabel("男员工人数为：");
		lblNewLabel_101.setBounds(40,80, 120, 50);
		lblNewLabel_101.setFont(new Font("黑体", Font.PLAIN, 16));
		tpane2.add(lblNewLabel_101);
		JLabel lblNewLabel_102 = new JLabel("女员工人数为：");
		lblNewLabel_102.setBounds(294,80, 120, 50);
		lblNewLabel_102.setFont(new Font("黑体", Font.PLAIN, 16));
		tpane2.add(lblNewLabel_102);
		JLabel lblNewLabel_103 = new JLabel("最高工资为：");
		lblNewLabel_103.setBounds(55,140, 110, 50);
		lblNewLabel_103.setFont(new Font("黑体", Font.PLAIN, 16));
		tpane2.add(lblNewLabel_103);
		JLabel lblNewLabel_104 = new JLabel("最低工资为：");
		lblNewLabel_104.setBounds(310,140, 110, 50);
		lblNewLabel_104.setFont(new Font("黑体", Font.PLAIN, 16));
		tpane2.add(lblNewLabel_104);
		JLabel lblNewLabel_105 = new JLabel("各部门人数为：");
		lblNewLabel_105.setBounds(40,200, 120, 50);
		lblNewLabel_105.setFont(new Font("黑体", Font.PLAIN, 16));
		tpane2.add(lblNewLabel_105);
		// *******查询标签
		JLabel lblNewLabel_11 = new JLabel("请输入编号：");
		lblNewLabel_11.setBounds(50, 120, 120, 60);
		lblNewLabel_11.setFont(new Font("黑体", Font.PLAIN, 17));
		tpane3.add(lblNewLabel_11);
		JLabel lblNewLabel_12 = new JLabel("请输入姓名：");
		lblNewLabel_12.setBounds(285,120, 120, 60);
		lblNewLabel_12.setFont(new Font("黑体", Font.PLAIN, 17));
		tpane3.add(lblNewLabel_12);
		JLabel lblNewLabel_13 = new JLabel("员工的信息：");
		lblNewLabel_13.setBounds(50,195, 120, 60);
		lblNewLabel_13.setFont(new Font("黑体", Font.PLAIN, 17));
		tpane3.add(lblNewLabel_13);
		JLabel lblNewLabel_131 = new JLabel("请输入员工的编号或姓名");
		lblNewLabel_131.setBounds(50,70, 350, 60);
		lblNewLabel_131.setFont(new Font("黑体", Font.PLAIN, 20));
		tpane3.add(lblNewLabel_131);
		//		删除标签
		JLabel lblNewLabel_14 = new JLabel("请输入编号：");
		lblNewLabel_14.setBounds(300,120, 120, 60);
		lblNewLabel_14.setFont(new Font("黑体", Font.PLAIN, 17));
		tpane4.add(lblNewLabel_14);
		JLabel lblNewLabel_15 = new JLabel("请输入姓名：");
		lblNewLabel_15.setBounds(300,180, 120, 60);
		lblNewLabel_15.setFont(new Font("黑体", Font.PLAIN, 17));
		tpane4.add(lblNewLabel_15);
		JLabel lblNewLabel_151 = new JLabel("请输入员工的编号或姓名");
		lblNewLabel_151.setBounds(300,70,350, 60);
		lblNewLabel_151.setFont(new Font("黑体", Font.PLAIN, 20));
		tpane4.add(lblNewLabel_151);
		//		***************************修改标签
		JLabel lblNewLabel_17 = new JLabel("输入修改编号：");
		lblNewLabel_17.setBounds(300,20,120,50);
		lblNewLabel_17.setFont(new Font("黑体", Font.PLAIN, 17));
		tpane5.add(lblNewLabel_17);
		JLabel lblNewLabel_16 = new JLabel("输入修改内容：");
		lblNewLabel_16.setBounds(300,160,120,50);
		lblNewLabel_16.setFont(new Font("黑体", Font.PLAIN, 17));
		tpane5.add(lblNewLabel_16);
		JLabel lblNewLabel_161 = new JLabel("输入修改类型：");
		lblNewLabel_161.setBounds(300,80,120,50);
		lblNewLabel_161.setFont(new Font("黑体", Font.PLAIN, 17));
		tpane5.add(lblNewLabel_161);
		// *****************文本框空间
		// 编号文本输入框
		numberField = new JTextField();
		numberField.setColumns(10);
		tpane1.add(numberField);
		numberField.setBounds(200,15, 120, 30);
		// 姓名文本输入框
		nameField = new JTextField();
		nameField.setColumns(10);
		tpane1.add(nameField);
		nameField.setBounds(400, 15, 120, 30);

		// 年龄文本输入框
		ageField = new JTextField();
		tpane1.add(ageField);
		ageField.setBounds(600,15, 120, 30);

		// 性别单选框
		group=new ButtonGroup();
		radioM=new JRadioButton("男",true);
		radioF=new JRadioButton("女",false);
		group.add(radioM);
		group.add(radioF);
		tpane1.add(radioM);
		tpane1.add(radioF);
		radioM.setBounds(200,90, 50, 30);
		radioM.setFont(new Font("楷体", Font.BOLD, 20));
		radioF.setBounds(260,90, 50, 30);
		radioF.setFont(new Font("楷体", Font.BOLD, 20));

		// 电话文本输入框
		telField = new JTextField();
		tpane1.add(telField);
		telField.setBounds(400, 90, 120, 30);

		// 部门复选框
		partBox = new JComboBox<String>();
		partBox.addItem("行政部");
		partBox.addItem("技术部");
		partBox.addItem("市场部");
		partBox.addItem("财务部");
		tpane1.add(partBox);
		partBox.setBounds(600, 90, 120, 30);
		partBox.setFont(new Font("黑体", Font.PLAIN, 16));
		// 职位下拉框
		comBox = new JComboBox<String>();
		comBox.addItem("技术人员");
		comBox.addItem("经理");
		comBox.addItem("销售人员");
		comBox.addItem("销售经理");
		comBox.addItem("正常员工");
		tpane1.add(comBox);
		comBox.setBounds(200,170, 120, 30);
		comBox.setFont(new Font("黑体", Font.PLAIN, 16));
		// 工资文本输入框
		monField = new JTextField();
		tpane1.add(monField);
		monField.setBounds(450,170, 120, 30);
//		***************************************下拉框事件
		comBox.addItemListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent e) {
				String item = e.getItem().toString(); 
				if (item=="技术人员"||item=="销售经理"||item=="销售人员") {
					monField.setEditable(true);
				}
				else{
					monField.setEditable(false);
				}

			}
		});
		// *********统计文本框
		final JTextField peoField = new JTextField();
		tpane2.add(peoField);
		peoField.setFont(new Font("黑体", Font.PLAIN, 17));
		peoField.setBounds(150,28, 120, 30);

		final JTextField moneyField = new JTextField();
		tpane2.add(moneyField);
		moneyField.setFont(new Font("黑体", Font.PLAIN, 17));
		moneyField.setBounds(400, 28, 120, 30);

		final JTextField allmonField = new JTextField();
		tpane2.add(allmonField);
		allmonField.setFont(new Font("黑体", Font.PLAIN, 17));
		allmonField.setBounds(660, 28, 120, 30);

		final JTextField boynumField = new JTextField();
		tpane2.add(boynumField);
		boynumField.setFont(new Font("黑体", Font.PLAIN, 17));
		boynumField.setBounds(150, 89, 120, 30);

		final JTextField girdnumField = new JTextField();
		tpane2.add(girdnumField);
		girdnumField.setFont(new Font("黑体", Font.PLAIN, 17));
		girdnumField.setBounds(400,89, 120, 30);

		final JTextField maxmonField = new JTextField();
		tpane2.add(maxmonField);
		maxmonField.setFont(new Font("黑体", Font.PLAIN, 17));
		maxmonField.setBounds(150,152, 120, 30);

		final JTextField minmonField = new JTextField();
		tpane2.add(minmonField);
		minmonField.setFont(new Font("黑体", Font.PLAIN, 17));
		minmonField.setBounds(400,152, 120, 30);

		final JTextField denumField = new JTextField();
		tpane2.add(denumField);
		denumField.setBounds(150,210, 400, 30);
		denumField.setFont(new Font("黑体", Font.PLAIN, 17));
		peoField.setEditable(false);
		moneyField.setEditable(false);
		allmonField.setEditable(false);
		boynumField.setEditable(false);
		maxmonField.setEditable(false);
		minmonField.setEditable(false);
		girdnumField.setEditable(false);
		denumField.setEditable(false);
		// *******************查询文本框
		findField = new JTextField();
		tpane3.add(findField);
		findField.setFont(new Font("黑体", Font.PLAIN, 17));
		findField.setBounds(150,132, 120, 33);

		find1Field = new JTextField();
		tpane3.add(find1Field);
		find1Field.setBounds(390, 132, 120, 33);

		find2Field = new JTextArea();
		tpane3.add(find2Field);
 		find2Field.setFont(new Font("黑体", Font.PLAIN,20));
		find2Field.setBounds(150,200, 600,80);
		find2Field.setEditable(false);
		//		************************删除文本框
		delField = new JTextField();
		tpane4.add(delField);
		delField.setBounds(400, 133, 120, 30);

		del1Field = new JTextField();
		tpane4.add(del1Field);
		del1Field.setBounds(400,193, 120, 30);
		//		******************************修改文本框
		filtField = new JTextField();
		filtField.setColumns(10);
		tpane5.add(filtField);
		filtField.setBounds(420,30, 120, 30);
		//		
		com1Box = new JComboBox<String>();
		com1Box.addItem("编号");
		com1Box.addItem("姓名");
		com1Box.addItem("性别");
		com1Box.addItem("年龄");
		com1Box.addItem("电话");
		com1Box.addItem("部门");
		com1Box.addItem("职位");
		com1Box.addItem("工资");
		tpane5.add(com1Box);
		com1Box.setBounds(420,87, 120, 30);
		com1Box.setFont(new Font("黑体", Font.PLAIN, 16));
		//		
		filt1Field = new JTextField();
		filt1Field.setColumns(10);
		tpane5.add(filt1Field);
		filt1Field.setBounds(420,170, 120, 30);
		// *********************按钮空间
		// 数据添加按钮
		addButton = new JButton("添加");
		tpane1.add(addButton);
		addButton.setBounds(350,300, 93, 28);
		addButton.setFont(new Font("黑体", Font.PLAIN, 17));
	
		// 数据保存按钮
		addButton1 = new JButton("保存到数据库");
		addButton1.setBackground(new Color(0, 206, 209));
		contentPane.add(addButton1);
		addButton1.setBounds(730, 0,860,40);
		addButton1.setFont(new Font("黑体", Font.PLAIN, 17));
		// 数据统计按钮
		addButton2 = new JButton("统计");
		tpane2.add(addButton2);
		addButton2.setBounds(350,300, 93, 28);
		addButton2.setFont(new Font("黑体", Font.PLAIN, 17));
		// 数据查询按钮
		addButton3 = new JButton("查询");
		tpane3.add(addButton3);
		addButton3.setBounds(350,300, 93, 28);
		addButton3.setFont(new Font("黑体", Font.PLAIN, 17));
		// 数据删除按钮
		addButton4 = new JButton("删除");
		tpane4.add(addButton4);
		addButton4.setBounds(350,300, 93, 28);
		addButton4.setFont(new Font("黑体", Font.PLAIN, 17));
		//		数据读取按钮
		addButton5 = new JButton("读取数据库数据");
		addButton5.setBackground(new Color(0, 206, 209));
		contentPane.add(addButton5);
		addButton5.setBounds(0, 0,730,40);
		addButton5.setFont(new Font("黑体", Font.PLAIN, 17));
		addButton6 = new JButton("修改");
		tpane5.add(addButton6);
		addButton6.setBounds(350,300, 93, 28);
		addButton6.setFont(new Font("黑体", Font.PLAIN, 17));
		//      ****************************************************滚动窗面板
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane);
		scrollPane.setBounds(0, 40, 730, 800);
		// 将表格框添加入滚动窗
		table = new JTable();
		// 置表格默认模型
		String columns[] = {"编号",
				"姓名", "年龄", "性别", "电话", "部门", "职位", "工资" };
		dtm = new DefaultTableModel(new Object[][] {},columns);
		table.setModel(dtm);
		table.setFont(new Font("黑体", Font.PLAIN, 18));
		@SuppressWarnings({ "rawtypes" })
		RowSorter sorter = new TableRowSorter(dtm);
		table.setRowSorter(sorter);//表格自动排序
		table.setEnabled(false);
		JTableHeader header=table.getTableHeader();//表格头设置高度
		header.setFont(new Font("微软雅黑",Font.PLAIN,16));     
		table.setRowHeight(30);//设置表格行的高度
		header.setBackground(new Color(102, 255, 255));//设置表头颜色
		table.getColumnModel().getColumn(0).setPreferredWidth(110);//设置列的宽度 
		table.getColumnModel().getColumn(2).setPreferredWidth(40);
		table.getColumnModel().getColumn(3).setPreferredWidth(40);
		table.getColumnModel().getColumn(4).setPreferredWidth(130);   
		// 设置首选大小[除了窗体以外的组件都需要设置首选大小]
		//scrollPane.setPreferredSize(new Dimension(500, 900));
		// 设置自动出现滚动条
		scrollPane.setAutoscrolls(true);
		scrollPane.setViewportView(table);//
		//		 ***************************************创建添加按钮事件
		ActionListener j = null;
		
		addButton.addActionListener(j=new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String number = numberField.getText();// 分别取得文本框的内容
				String name = nameField.getText();
				String age = ageField.getText();
				String sex ;
				if(radioM.isSelected()==true)sex ="男";
				else sex="女";
				String tel = telField.getText();
				String part = partBox.getSelectedItem().toString();
				String pos = comBox.getSelectedItem().toString();// 分别取得文本框的内容
				String mon =null;
				String mon1=monField.getText();//剩余工资
				try {
					if (pos.equals("经理")){
						int sum=8000;
						mon =String.valueOf(sum);
					}
					if (pos.equals("技术人员")) {
						int i = Integer.valueOf(mon1);
						int sum = i * 132;
						mon = String.valueOf(sum);
					}
					if (pos.equals("销售经理")) {
						int i = Integer.valueOf(mon1);
						int sum = i + 7000;
						mon = String.valueOf(sum);
					}
					if (pos.equals("普通员工")){
						int sum=5000;
						mon =String.valueOf(sum);
					}
					if (pos.equals("销售人员")) {
						int i = Integer.valueOf(mon1);
						int sum = 2000 + i;
						mon = String.valueOf(sum);
					}
				} catch (NumberFormatException ee) {
					JOptionPane.showMessageDialog(null, "不可输入为空！", "提示",
							JOptionPane.WARNING_MESSAGE);
					return ;
				}
				int i,p = 0;
				for (i = 0; i <dtm.getRowCount(); i++) {
					@SuppressWarnings("rawtypes")
					String s1=((Vector) dtm.getDataVector().elementAt(i)).elementAt(0).toString();//编号
					if ((number.equals(s1))) {
						p=1;
					}
				}			
				if(p!=1&&(number.length()!=0&&name.length()!=0&&age.length()!=0&&sex.length()!=0&&tel.length()!=0))
				{
					dtm.addRow(new String[] { number, name, age, sex,tel, part, pos, mon });
					ageField.setText(null);telField.setText(null);
					monField.setText(null);
					JOptionPane.showMessageDialog(null, "添加成功！", "提示",
							JOptionPane.WARNING_MESSAGE);
				}
				else{
					JOptionPane.showMessageDialog(null, "输入数据错误！",
							"提示", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
//		按钮添加鼠标事件
		addButton.registerKeyboardAction(j, 
				KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0),JComponent.WHEN_IN_FOCUSED_WINDOW);
		// 保存按钮事件
		addButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dtm.getRowCount()!=0){
					try {
						Connection con;
						// 数据库
						con=JDBC.connect("students","root","ren@0072");
						if(con==null)System.out.println("为空");
						else{
							System.out.println("连接成功");
						}
						PreparedStatement preSql = null;
						int column = dtm.getColumnCount();		// 表格列数
						int row = dtm.getRowCount();		// 表格行数
						// value数组存放表格中的所有数据
						String[][] value = new String[row][column];
						for(int i = 0; i < row; i++){
							for(int j = 0; j < column; j++){
								value[i][j] = dtm.getValueAt(i, j).toString();
							}
						}
						// 删除m表中所有数据
						preSql = con.prepareStatement("delete from mess where true");
						preSql.executeUpdate();
						// 将value数组中的数据依次存放到mess表
						for(int i = 0; i < row; i++){
							String sql = "insert into mess values(?,?,?,?,?,?,?,?)";
							preSql = con.prepareStatement(sql);
							preSql.setString(1, value[i][0]);
							preSql.setString(2, value[i][1]);
							preSql.setString(3, value[i][2]);
							preSql.setString(4, value[i][3]);
							preSql.setString(5, value[i][4]);
							preSql.setString(6, value[i][5]);
							preSql.setString(7, value[i][6]);
							preSql.setString(8, value[i][7]);
							preSql.executeUpdate();//  在此 PreparedStatement 对象中执行 SQL 语句
						}
						preSql.close();
						con.close();
					} 
					catch (Exception ee) {
						ee.printStackTrace();
						JOptionPane.showMessageDialog(null, "出现错误！",
								"提示", JOptionPane.WARNING_MESSAGE);
					}
					finally{JOptionPane.showMessageDialog(null, "保存完毕！",
							"提示", JOptionPane.WARNING_MESSAGE);
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "表为空！",
							"提示", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		//统计按钮事件
		addButton2.addActionListener(new ActionListener() {
			@SuppressWarnings("rawtypes")
			public void actionPerformed(ActionEvent e) {
				//				 *************************************触发事件
				if(dtm.getRowCount()!=0){
					int s = dtm.getRowCount();
					int sum = 0;
					int boy=0,gird=0;
					String s1 = String.valueOf(s);
					peoField.setText(s1);//人数
					int maxmon=0,im1 = 0;//最大工资
					String minmon=((Vector) dtm.getDataVector().elementAt(0)).elementAt(7).toString();//最小工资
					// 平均工资
					im1=Integer.valueOf(minmon);
					int d=0,d1=0,d2=0,d3=0;
					for (int i = 0; i < dtm.getRowCount(); i++) {
						String m = ((Vector) dtm.getDataVector().elementAt(i)).elementAt(7).toString();
						String sex=((Vector) dtm.getDataVector().elementAt(i)).elementAt(3).toString();
						String de=((Vector) dtm.getDataVector().elementAt(i)).elementAt(5).toString();
						try{
							if(de.matches("行政部"))d++;
							if(de.matches("财务部"))d1++;
							if(de.matches("技术部"))d2++;
							if(de.matches("市场部"))d3++;
							if(sex.matches("男"))boy++;
							else gird++;
							int im=Integer.valueOf(m);
							if(im>maxmon) maxmon=im;
							if(im<im1) im1=im;
							sum = sum + Integer.parseInt(m);
						}
						catch(Exception eee){
							eee.printStackTrace();
							JOptionPane.showMessageDialog(null, "出现错误！",
									"提示", JOptionPane.WARNING_MESSAGE);break;
						}
					}
					try{
						int aver=sum/s;
						s1 = String.valueOf(aver);
						moneyField.setText(s1);//平均工资
						// **总工资
						s1 = String.valueOf(sum);
						allmonField.setText(s1);//总工资
						//最大工资
						s1 = String.valueOf(maxmon);
						maxmonField.setText(s1);
						//最小工资
						s1 = String.valueOf(im1);
						minmonField.setText(s1);
						//男女人数
						boynumField.setText(String.valueOf(boy));
						girdnumField.setText(String.valueOf(gird));
						//各部门人数
						s1 = String.valueOf(d);
						denumField.setText("行政部:"+s1+"技术部:"+String.valueOf(d2)+
								"市场部:"+String.valueOf(d3)+"财务部:"+String.valueOf(d1));
					}catch(Exception ee){
						JOptionPane.showMessageDialog(null, "表为空！",
								"提示", JOptionPane.WARNING_MESSAGE);
					}
				}else{
					JOptionPane.showMessageDialog(null, "表为空！",
							"提示", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		// 删除按钮事件
		addButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//				dtm.fireTableChanged(null);
				try{	
					String number=delField.getText();
					String name=del1Field.getText();int i,p=0;
					for(i=0;i<dtm.getRowCount();i++){
						@SuppressWarnings("rawtypes")
						String s=((Vector)dtm.getDataVector().elementAt(i)).elementAt(1).toString();
						@SuppressWarnings("rawtypes")
						String s1=((Vector)dtm.getDataVector().elementAt(i)).elementAt(0).toString();
						if(number.compareTo(s1)==0||name.compareTo(s)==0){
							dtm.removeRow(i);p=1;
							JOptionPane.showMessageDialog(null, "删除成功！",
									"提示", JOptionPane.WARNING_MESSAGE);
							del1Field.setText(null);break;
						}
					}
					if(p!=1){JOptionPane.showMessageDialog(null, "表中无此人！",
							"提示", JOptionPane.WARNING_MESSAGE);
					delField.setText(null);	del1Field.setText(null);
					}
				}catch(Exception ee){}
			}
		});
		//		****************************查询按钮事件
		addButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//				dtm.fireTableChanged(null);//刷新表格
				String number=findField.getText();
				String name=find1Field.getText();int p=0;
				for(int i=0;i<dtm.getRowCount();i++){
					@SuppressWarnings("rawtypes")
					String s=((Vector)dtm.getDataVector().elementAt(i)).elementAt(1).toString();
					@SuppressWarnings("rawtypes")
					String s1=((Vector)dtm.getDataVector().elementAt(i)).elementAt(0).toString();
					if(number.equals(s1)||name.equals(s)){
						table.setRowSelectionInterval(i, i);
						find2Field.setText("编号  姓名 年龄 性别 电话    部门  职位  工资"+
						"\n"+dtm.getDataVector().elementAt(i).toString());p=1;break;
					}
				}
				findField.setText(null);
				find1Field.setText(null);
				if(p!=1){
					JOptionPane.showMessageDialog(null, "查无此人！","提示", JOptionPane.WARNING_MESSAGE);
					find1Field.setText(null);
				}
			}
		});
		//		***********************************	读取按钮事件
		addButton5.addActionListener(new ActionListener() {int i=0;
		public void actionPerformed(ActionEvent e) {
			if(i==0){
				try {Connection con;
				// 数据库
				con=JDBC.connect("students","root","ren@0072");
				if(con==null)System.out.println("为空");
				else{
					System.out.println("连接成功");
				}
				PreparedStatement preSql;
				ResultSet rs;
				// 要执行的SQL语句
				String sql = "select * from mess";//
				preSql=con.prepareStatement(sql);
				// ResultSet类，用来存放获取的结果集！
				rs = preSql.executeQuery(sql);
				while(rs.next()){
					String	id = rs.getString("编号");
					// 获取‘姓名’这列数据
					String name = rs.getString("姓名");
					// 获取‘数学成绩’这列数据
					String age = rs.getString("年龄");
					// 获取‘语文成绩’这列数据
					String sex = rs.getString("性别");
					String tel=rs.getString("电话");
					String mon=rs.getString("工资");
					String depart=rs.getString("部门");
					String pos=rs.getString("职位");
					dtm.addRow(new String[] { id, name, age, sex,tel, depart, pos, mon });
				}
				preSql.close();
				con.close();
				}catch(NullPointerException ee){
					JOptionPane.showMessageDialog(null, "文件读取完毕！","提示", JOptionPane.WARNING_MESSAGE);
				}
				catch(Exception eee){
					eee.printStackTrace();
					JOptionPane.showMessageDialog(null, "文件为空！","提示", JOptionPane.WARNING_MESSAGE);
				}	
				i=i+1;
			}
			else{
				JOptionPane.showMessageDialog(null, "按钮只能只用一次！","提示", JOptionPane.WARNING_MESSAGE); 
				return ;
			} 
		}
		});
		//		***************************编辑按钮事件
		addButton6.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent e) {

				//dtm.fireTableChanged(null);//刷新表格
				int i,j=0,p1=1;
				String f=filtField.getText();
				String f2=filt1Field.getText();
				String f1=com1Box.getSelectedItem().toString();

				int p=0;
				for(i=0;i<dtm.getRowCount();i++){
					@SuppressWarnings("rawtypes")
					String s1=((Vector)dtm.getDataVector().elementAt(i)).elementAt(0).toString();
					if(f1.equals("编号"))j=0;
					if(f1.equals("姓名"))j=1;
					if(f1.equals("年龄"))j=2;
					if(f1.equals("性别"))j=3;
					if(f1.equals("电话"))j=4;
					if(f1.equals("部门"))j=5;
					if(f1.equals("职位"))j=6;
					if(f1.equals("工资"))j=7;
					if(f1.equals("编号")&&f2.equals(s1)){
						p1=0;
					}
					if(f.equals(s1)){
						dtm.setValueAt(f2,i,j);//替换表中的数据
						JOptionPane.showMessageDialog(null, "修改成功！","恭喜", JOptionPane.WARNING_MESSAGE);
						break;
					}
				}
				if(p1==0){
					JOptionPane.showMessageDialog(null, "已有此人！","提示", JOptionPane.WARNING_MESSAGE);
					filtField.setText(null);
					return ;
				}
				if(i==dtm.getRowCount()){
					JOptionPane.showMessageDialog(null, "查无此人！","提示", JOptionPane.WARNING_MESSAGE);
				}

			}
		});
	}
}
