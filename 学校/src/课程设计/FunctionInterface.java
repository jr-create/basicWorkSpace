package �γ����;

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
	
	private JPanel contentPane;//�����
	private JTextField nameField;// ����
	private JTextField numberField;// ���
	private JTextField ageField;// ����
	private JTextField telField;// �绰
	private JTextField monField;// ����
	JTextField findField,find1Field,delField,del1Field,filtField,filt1Field;//�ı���
	JTextArea find2Field;
	private JTable table;//��
	private JButton addButton, addButton1, addButton2, addButton3, addButton4,addButton5,addButton6;//���ܰ�ť
	private DefaultTableModel dtm;//��ģ�͸�
	JComboBox<String> comBox,partBox,com1Box;//ְλ��ѡ��
	JRadioButton radioM,radioF;//�Ա�ѡ��
	ButtonGroup group;//��ϵ�ѡ��
	// �����ļ�
	@SuppressWarnings("unchecked")
	public FunctionInterface(){ 
		// ��������
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\eclipsesdt\\QQ\\500133.gif"));
		setTitle("��˾Ա������");

		Dimension screeSize=Toolkit.getDefaultToolkit().getScreenSize();//��ʾ��Ļ��С
		System.out.println(screeSize.width+"  "+screeSize.height);
		setBounds((screeSize.width-1600)/2,(screeSize.height-850)/2,1600, 850);//��ʾ��Ļ����
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(new JScrollPane(contentPane));
		contentPane.setLayout(null);
		setVisible(true);//���ӻ�
		setResizable(false);//���ɱ��
		validate();//���
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//���ڹرպ��ͷſռ�
		//		**********************************ѡ�
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.RIGHT);
		tabbedPane.setBounds(730,40, 860,800);
		tabbedPane.setFont(new Font("����", Font.BOLD, 20));
		final JPanel tpane1 = new JPanel();
		tabbedPane.addTab("���", null, tpane1, null);
		tpane1.setLayout(null);
		JPanel tpane2 = new JPanel();
		tabbedPane.addTab("ͳ��", null, tpane2, null);
		tpane2.setLayout(null);
		JPanel tpane3 = new JPanel();
		tabbedPane.addTab("��ѯ", null, tpane3, null);
		tpane3.setLayout(null);
		JPanel tpane4 = new JPanel();
		tabbedPane.addTab("ɾ��", null, tpane4, null);
		tpane4.setLayout(null);
		JPanel tpane5 = new JPanel();
		tabbedPane.addTab("�޸�", null, tpane5, null);
		tpane5.setLayout(null);
		contentPane.add(tabbedPane);
	
		//**********************************
		//************************��ǩ�ռ�
		// �û���ǩ
		JLabel lblNewLabel = new JLabel("��  �ţ�");
		lblNewLabel.setBounds(140, 22, 100, 15);
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 16));
		tpane1.add(lblNewLabel);
		// �û���ǩ
		JLabel lblNewLabel_1 = new JLabel("��  ����");
		lblNewLabel_1.setBounds(340,22,100, 15);
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 16));
		tpane1.add(lblNewLabel_1);
		// �û���ǩ
		JLabel lblNewLabel_2 = new JLabel("��  �䣺");
		lblNewLabel_2.setBounds(540, 22,100, 15);
		lblNewLabel_2.setFont(new Font("����", Font.PLAIN, 16));
		tpane1.add(lblNewLabel_2);
		// �Ա��ǩ
		JLabel lblNewLabel_7 = new JLabel("��  ��");
		lblNewLabel_7.setBounds(140, 100,100, 15);
		lblNewLabel_7.setFont(new Font("����", Font.PLAIN, 16));
		tpane1.add(lblNewLabel_7);
		// �绰��ǩ
		JLabel lblNewLabel_3 = new JLabel("��  ����");
		lblNewLabel_3.setBounds(340, 100,100, 15);
		lblNewLabel_3.setFont(new Font("����", Font.PLAIN, 16));
		tpane1.add(lblNewLabel_3);
		// ���ű�ǩ
		JLabel lblNewLabel_4 = new JLabel("��  �ţ�");
		lblNewLabel_4.setBounds(540, 100,100, 15);
		lblNewLabel_4.setFont(new Font("����", Font.PLAIN, 16));
		tpane1.add(lblNewLabel_4);
		// ���ű�ǩ
		JLabel lblNewLabel_5 = new JLabel("ְ  λ��");
		lblNewLabel_5.setBounds(140, 180,100, 15);
		lblNewLabel_5.setFont(new Font("����", Font.PLAIN, 16));
		tpane1.add(lblNewLabel_5);
		// ���ű�ǩ
		final JLabel lblNewLabel_6 = new JLabel("ʱ�����ɣ�");
		lblNewLabel_6.setBounds(350, 180, 124, 15);
		lblNewLabel_6.setFont(new Font("����", Font.PLAIN, 16));
		tpane1.add(lblNewLabel_6);
		// *******ͳ�Ʊ�ǩ
		JLabel lblNewLabel_8 = new JLabel("��˾������Ϊ��");
		lblNewLabel_8.setBounds(40, 18, 120, 50);
		lblNewLabel_8.setFont(new Font("����", Font.PLAIN, 16));
		tpane2.add(lblNewLabel_8);
		JLabel lblNewLabel_9 = new JLabel("��˾ƽ������Ϊ��");
		lblNewLabel_9.setBounds(280, 20, 150, 50);
		lblNewLabel_9.setFont(new Font("����", Font.PLAIN, 16));
		tpane2.add(lblNewLabel_9);
		JLabel lblNewLabel_10 = new JLabel("��˾�ܹ���Ϊ��");
		lblNewLabel_10.setBounds(550, 20, 120, 50);
		lblNewLabel_10.setFont(new Font("����", Font.PLAIN, 16));
		tpane2.add(lblNewLabel_10);
		JLabel lblNewLabel_101 = new JLabel("��Ա������Ϊ��");
		lblNewLabel_101.setBounds(40,80, 120, 50);
		lblNewLabel_101.setFont(new Font("����", Font.PLAIN, 16));
		tpane2.add(lblNewLabel_101);
		JLabel lblNewLabel_102 = new JLabel("ŮԱ������Ϊ��");
		lblNewLabel_102.setBounds(294,80, 120, 50);
		lblNewLabel_102.setFont(new Font("����", Font.PLAIN, 16));
		tpane2.add(lblNewLabel_102);
		JLabel lblNewLabel_103 = new JLabel("��߹���Ϊ��");
		lblNewLabel_103.setBounds(55,140, 110, 50);
		lblNewLabel_103.setFont(new Font("����", Font.PLAIN, 16));
		tpane2.add(lblNewLabel_103);
		JLabel lblNewLabel_104 = new JLabel("��͹���Ϊ��");
		lblNewLabel_104.setBounds(310,140, 110, 50);
		lblNewLabel_104.setFont(new Font("����", Font.PLAIN, 16));
		tpane2.add(lblNewLabel_104);
		JLabel lblNewLabel_105 = new JLabel("����������Ϊ��");
		lblNewLabel_105.setBounds(40,200, 120, 50);
		lblNewLabel_105.setFont(new Font("����", Font.PLAIN, 16));
		tpane2.add(lblNewLabel_105);
		// *******��ѯ��ǩ
		JLabel lblNewLabel_11 = new JLabel("�������ţ�");
		lblNewLabel_11.setBounds(50, 120, 120, 60);
		lblNewLabel_11.setFont(new Font("����", Font.PLAIN, 17));
		tpane3.add(lblNewLabel_11);
		JLabel lblNewLabel_12 = new JLabel("������������");
		lblNewLabel_12.setBounds(285,120, 120, 60);
		lblNewLabel_12.setFont(new Font("����", Font.PLAIN, 17));
		tpane3.add(lblNewLabel_12);
		JLabel lblNewLabel_13 = new JLabel("Ա������Ϣ��");
		lblNewLabel_13.setBounds(50,195, 120, 60);
		lblNewLabel_13.setFont(new Font("����", Font.PLAIN, 17));
		tpane3.add(lblNewLabel_13);
		JLabel lblNewLabel_131 = new JLabel("������Ա���ı�Ż�����");
		lblNewLabel_131.setBounds(50,70, 350, 60);
		lblNewLabel_131.setFont(new Font("����", Font.PLAIN, 20));
		tpane3.add(lblNewLabel_131);
		//		ɾ����ǩ
		JLabel lblNewLabel_14 = new JLabel("�������ţ�");
		lblNewLabel_14.setBounds(300,120, 120, 60);
		lblNewLabel_14.setFont(new Font("����", Font.PLAIN, 17));
		tpane4.add(lblNewLabel_14);
		JLabel lblNewLabel_15 = new JLabel("������������");
		lblNewLabel_15.setBounds(300,180, 120, 60);
		lblNewLabel_15.setFont(new Font("����", Font.PLAIN, 17));
		tpane4.add(lblNewLabel_15);
		JLabel lblNewLabel_151 = new JLabel("������Ա���ı�Ż�����");
		lblNewLabel_151.setBounds(300,70,350, 60);
		lblNewLabel_151.setFont(new Font("����", Font.PLAIN, 20));
		tpane4.add(lblNewLabel_151);
		//		***************************�޸ı�ǩ
		JLabel lblNewLabel_17 = new JLabel("�����޸ı�ţ�");
		lblNewLabel_17.setBounds(300,20,120,50);
		lblNewLabel_17.setFont(new Font("����", Font.PLAIN, 17));
		tpane5.add(lblNewLabel_17);
		JLabel lblNewLabel_16 = new JLabel("�����޸����ݣ�");
		lblNewLabel_16.setBounds(300,160,120,50);
		lblNewLabel_16.setFont(new Font("����", Font.PLAIN, 17));
		tpane5.add(lblNewLabel_16);
		JLabel lblNewLabel_161 = new JLabel("�����޸����ͣ�");
		lblNewLabel_161.setBounds(300,80,120,50);
		lblNewLabel_161.setFont(new Font("����", Font.PLAIN, 17));
		tpane5.add(lblNewLabel_161);
		// *****************�ı���ռ�
		// ����ı������
		numberField = new JTextField();
		numberField.setColumns(10);
		tpane1.add(numberField);
		numberField.setBounds(200,15, 120, 30);
		// �����ı������
		nameField = new JTextField();
		nameField.setColumns(10);
		tpane1.add(nameField);
		nameField.setBounds(400, 15, 120, 30);

		// �����ı������
		ageField = new JTextField();
		tpane1.add(ageField);
		ageField.setBounds(600,15, 120, 30);

		// �Ա�ѡ��
		group=new ButtonGroup();
		radioM=new JRadioButton("��",true);
		radioF=new JRadioButton("Ů",false);
		group.add(radioM);
		group.add(radioF);
		tpane1.add(radioM);
		tpane1.add(radioF);
		radioM.setBounds(200,90, 50, 30);
		radioM.setFont(new Font("����", Font.BOLD, 20));
		radioF.setBounds(260,90, 50, 30);
		radioF.setFont(new Font("����", Font.BOLD, 20));

		// �绰�ı������
		telField = new JTextField();
		tpane1.add(telField);
		telField.setBounds(400, 90, 120, 30);

		// ���Ÿ�ѡ��
		partBox = new JComboBox<String>();
		partBox.addItem("������");
		partBox.addItem("������");
		partBox.addItem("�г���");
		partBox.addItem("����");
		tpane1.add(partBox);
		partBox.setBounds(600, 90, 120, 30);
		partBox.setFont(new Font("����", Font.PLAIN, 16));
		// ְλ������
		comBox = new JComboBox<String>();
		comBox.addItem("������Ա");
		comBox.addItem("����");
		comBox.addItem("������Ա");
		comBox.addItem("���۾���");
		comBox.addItem("����Ա��");
		tpane1.add(comBox);
		comBox.setBounds(200,170, 120, 30);
		comBox.setFont(new Font("����", Font.PLAIN, 16));
		// �����ı������
		monField = new JTextField();
		tpane1.add(monField);
		monField.setBounds(450,170, 120, 30);
//		***************************************�������¼�
		comBox.addItemListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent e) {
				String item = e.getItem().toString(); 
				if (item=="������Ա"||item=="���۾���"||item=="������Ա") {
					monField.setEditable(true);
				}
				else{
					monField.setEditable(false);
				}

			}
		});
		// *********ͳ���ı���
		final JTextField peoField = new JTextField();
		tpane2.add(peoField);
		peoField.setFont(new Font("����", Font.PLAIN, 17));
		peoField.setBounds(150,28, 120, 30);

		final JTextField moneyField = new JTextField();
		tpane2.add(moneyField);
		moneyField.setFont(new Font("����", Font.PLAIN, 17));
		moneyField.setBounds(400, 28, 120, 30);

		final JTextField allmonField = new JTextField();
		tpane2.add(allmonField);
		allmonField.setFont(new Font("����", Font.PLAIN, 17));
		allmonField.setBounds(660, 28, 120, 30);

		final JTextField boynumField = new JTextField();
		tpane2.add(boynumField);
		boynumField.setFont(new Font("����", Font.PLAIN, 17));
		boynumField.setBounds(150, 89, 120, 30);

		final JTextField girdnumField = new JTextField();
		tpane2.add(girdnumField);
		girdnumField.setFont(new Font("����", Font.PLAIN, 17));
		girdnumField.setBounds(400,89, 120, 30);

		final JTextField maxmonField = new JTextField();
		tpane2.add(maxmonField);
		maxmonField.setFont(new Font("����", Font.PLAIN, 17));
		maxmonField.setBounds(150,152, 120, 30);

		final JTextField minmonField = new JTextField();
		tpane2.add(minmonField);
		minmonField.setFont(new Font("����", Font.PLAIN, 17));
		minmonField.setBounds(400,152, 120, 30);

		final JTextField denumField = new JTextField();
		tpane2.add(denumField);
		denumField.setBounds(150,210, 400, 30);
		denumField.setFont(new Font("����", Font.PLAIN, 17));
		peoField.setEditable(false);
		moneyField.setEditable(false);
		allmonField.setEditable(false);
		boynumField.setEditable(false);
		maxmonField.setEditable(false);
		minmonField.setEditable(false);
		girdnumField.setEditable(false);
		denumField.setEditable(false);
		// *******************��ѯ�ı���
		findField = new JTextField();
		tpane3.add(findField);
		findField.setFont(new Font("����", Font.PLAIN, 17));
		findField.setBounds(150,132, 120, 33);

		find1Field = new JTextField();
		tpane3.add(find1Field);
		find1Field.setBounds(390, 132, 120, 33);

		find2Field = new JTextArea();
		tpane3.add(find2Field);
 		find2Field.setFont(new Font("����", Font.PLAIN,20));
		find2Field.setBounds(150,200, 600,80);
		find2Field.setEditable(false);
		//		************************ɾ���ı���
		delField = new JTextField();
		tpane4.add(delField);
		delField.setBounds(400, 133, 120, 30);

		del1Field = new JTextField();
		tpane4.add(del1Field);
		del1Field.setBounds(400,193, 120, 30);
		//		******************************�޸��ı���
		filtField = new JTextField();
		filtField.setColumns(10);
		tpane5.add(filtField);
		filtField.setBounds(420,30, 120, 30);
		//		
		com1Box = new JComboBox<String>();
		com1Box.addItem("���");
		com1Box.addItem("����");
		com1Box.addItem("�Ա�");
		com1Box.addItem("����");
		com1Box.addItem("�绰");
		com1Box.addItem("����");
		com1Box.addItem("ְλ");
		com1Box.addItem("����");
		tpane5.add(com1Box);
		com1Box.setBounds(420,87, 120, 30);
		com1Box.setFont(new Font("����", Font.PLAIN, 16));
		//		
		filt1Field = new JTextField();
		filt1Field.setColumns(10);
		tpane5.add(filt1Field);
		filt1Field.setBounds(420,170, 120, 30);
		// *********************��ť�ռ�
		// ������Ӱ�ť
		addButton = new JButton("���");
		tpane1.add(addButton);
		addButton.setBounds(350,300, 93, 28);
		addButton.setFont(new Font("����", Font.PLAIN, 17));
	
		// ���ݱ��水ť
		addButton1 = new JButton("���浽���ݿ�");
		addButton1.setBackground(new Color(0, 206, 209));
		contentPane.add(addButton1);
		addButton1.setBounds(730, 0,860,40);
		addButton1.setFont(new Font("����", Font.PLAIN, 17));
		// ����ͳ�ư�ť
		addButton2 = new JButton("ͳ��");
		tpane2.add(addButton2);
		addButton2.setBounds(350,300, 93, 28);
		addButton2.setFont(new Font("����", Font.PLAIN, 17));
		// ���ݲ�ѯ��ť
		addButton3 = new JButton("��ѯ");
		tpane3.add(addButton3);
		addButton3.setBounds(350,300, 93, 28);
		addButton3.setFont(new Font("����", Font.PLAIN, 17));
		// ����ɾ����ť
		addButton4 = new JButton("ɾ��");
		tpane4.add(addButton4);
		addButton4.setBounds(350,300, 93, 28);
		addButton4.setFont(new Font("����", Font.PLAIN, 17));
		//		���ݶ�ȡ��ť
		addButton5 = new JButton("��ȡ���ݿ�����");
		addButton5.setBackground(new Color(0, 206, 209));
		contentPane.add(addButton5);
		addButton5.setBounds(0, 0,730,40);
		addButton5.setFont(new Font("����", Font.PLAIN, 17));
		addButton6 = new JButton("�޸�");
		tpane5.add(addButton6);
		addButton6.setBounds(350,300, 93, 28);
		addButton6.setFont(new Font("����", Font.PLAIN, 17));
		//      ****************************************************���������
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane);
		scrollPane.setBounds(0, 40, 730, 800);
		// ����������������
		table = new JTable();
		// �ñ��Ĭ��ģ��
		String columns[] = {"���",
				"����", "����", "�Ա�", "�绰", "����", "ְλ", "����" };
		dtm = new DefaultTableModel(new Object[][] {},columns);
		table.setModel(dtm);
		table.setFont(new Font("����", Font.PLAIN, 18));
		@SuppressWarnings({ "rawtypes" })
		RowSorter sorter = new TableRowSorter(dtm);
		table.setRowSorter(sorter);//����Զ�����
		table.setEnabled(false);
		JTableHeader header=table.getTableHeader();//���ͷ���ø߶�
		header.setFont(new Font("΢���ź�",Font.PLAIN,16));     
		table.setRowHeight(30);//���ñ���еĸ߶�
		header.setBackground(new Color(102, 255, 255));//���ñ�ͷ��ɫ
		table.getColumnModel().getColumn(0).setPreferredWidth(110);//�����еĿ�� 
		table.getColumnModel().getColumn(2).setPreferredWidth(40);
		table.getColumnModel().getColumn(3).setPreferredWidth(40);
		table.getColumnModel().getColumn(4).setPreferredWidth(130);   
		// ������ѡ��С[���˴���������������Ҫ������ѡ��С]
		//scrollPane.setPreferredSize(new Dimension(500, 900));
		// �����Զ����ֹ�����
		scrollPane.setAutoscrolls(true);
		scrollPane.setViewportView(table);//
		//		 ***************************************������Ӱ�ť�¼�
		ActionListener j = null;
		
		addButton.addActionListener(j=new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String number = numberField.getText();// �ֱ�ȡ���ı��������
				String name = nameField.getText();
				String age = ageField.getText();
				String sex ;
				if(radioM.isSelected()==true)sex ="��";
				else sex="Ů";
				String tel = telField.getText();
				String part = partBox.getSelectedItem().toString();
				String pos = comBox.getSelectedItem().toString();// �ֱ�ȡ���ı��������
				String mon =null;
				String mon1=monField.getText();//ʣ�๤��
				try {
					if (pos.equals("����")){
						int sum=8000;
						mon =String.valueOf(sum);
					}
					if (pos.equals("������Ա")) {
						int i = Integer.valueOf(mon1);
						int sum = i * 132;
						mon = String.valueOf(sum);
					}
					if (pos.equals("���۾���")) {
						int i = Integer.valueOf(mon1);
						int sum = i + 7000;
						mon = String.valueOf(sum);
					}
					if (pos.equals("��ͨԱ��")){
						int sum=5000;
						mon =String.valueOf(sum);
					}
					if (pos.equals("������Ա")) {
						int i = Integer.valueOf(mon1);
						int sum = 2000 + i;
						mon = String.valueOf(sum);
					}
				} catch (NumberFormatException ee) {
					JOptionPane.showMessageDialog(null, "��������Ϊ�գ�", "��ʾ",
							JOptionPane.WARNING_MESSAGE);
					return ;
				}
				int i,p = 0;
				for (i = 0; i <dtm.getRowCount(); i++) {
					@SuppressWarnings("rawtypes")
					String s1=((Vector) dtm.getDataVector().elementAt(i)).elementAt(0).toString();//���
					if ((number.equals(s1))) {
						p=1;
					}
				}			
				if(p!=1&&(number.length()!=0&&name.length()!=0&&age.length()!=0&&sex.length()!=0&&tel.length()!=0))
				{
					dtm.addRow(new String[] { number, name, age, sex,tel, part, pos, mon });
					ageField.setText(null);telField.setText(null);
					monField.setText(null);
					JOptionPane.showMessageDialog(null, "��ӳɹ���", "��ʾ",
							JOptionPane.WARNING_MESSAGE);
				}
				else{
					JOptionPane.showMessageDialog(null, "�������ݴ���",
							"��ʾ", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
//		��ť�������¼�
		addButton.registerKeyboardAction(j, 
				KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0),JComponent.WHEN_IN_FOCUSED_WINDOW);
		// ���水ť�¼�
		addButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dtm.getRowCount()!=0){
					try {
						Connection con;
						// ���ݿ�
						con=JDBC.connect("students","root","ren@0072");
						if(con==null)System.out.println("Ϊ��");
						else{
							System.out.println("���ӳɹ�");
						}
						PreparedStatement preSql = null;
						int column = dtm.getColumnCount();		// �������
						int row = dtm.getRowCount();		// �������
						// value�����ű���е���������
						String[][] value = new String[row][column];
						for(int i = 0; i < row; i++){
							for(int j = 0; j < column; j++){
								value[i][j] = dtm.getValueAt(i, j).toString();
							}
						}
						// ɾ��m������������
						preSql = con.prepareStatement("delete from mess where true");
						preSql.executeUpdate();
						// ��value�����е��������δ�ŵ�mess��
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
							preSql.executeUpdate();//  �ڴ� PreparedStatement ������ִ�� SQL ���
						}
						preSql.close();
						con.close();
					} 
					catch (Exception ee) {
						ee.printStackTrace();
						JOptionPane.showMessageDialog(null, "���ִ���",
								"��ʾ", JOptionPane.WARNING_MESSAGE);
					}
					finally{JOptionPane.showMessageDialog(null, "������ϣ�",
							"��ʾ", JOptionPane.WARNING_MESSAGE);
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "��Ϊ�գ�",
							"��ʾ", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		//ͳ�ư�ť�¼�
		addButton2.addActionListener(new ActionListener() {
			@SuppressWarnings("rawtypes")
			public void actionPerformed(ActionEvent e) {
				//				 *************************************�����¼�
				if(dtm.getRowCount()!=0){
					int s = dtm.getRowCount();
					int sum = 0;
					int boy=0,gird=0;
					String s1 = String.valueOf(s);
					peoField.setText(s1);//����
					int maxmon=0,im1 = 0;//�����
					String minmon=((Vector) dtm.getDataVector().elementAt(0)).elementAt(7).toString();//��С����
					// ƽ������
					im1=Integer.valueOf(minmon);
					int d=0,d1=0,d2=0,d3=0;
					for (int i = 0; i < dtm.getRowCount(); i++) {
						String m = ((Vector) dtm.getDataVector().elementAt(i)).elementAt(7).toString();
						String sex=((Vector) dtm.getDataVector().elementAt(i)).elementAt(3).toString();
						String de=((Vector) dtm.getDataVector().elementAt(i)).elementAt(5).toString();
						try{
							if(de.matches("������"))d++;
							if(de.matches("����"))d1++;
							if(de.matches("������"))d2++;
							if(de.matches("�г���"))d3++;
							if(sex.matches("��"))boy++;
							else gird++;
							int im=Integer.valueOf(m);
							if(im>maxmon) maxmon=im;
							if(im<im1) im1=im;
							sum = sum + Integer.parseInt(m);
						}
						catch(Exception eee){
							eee.printStackTrace();
							JOptionPane.showMessageDialog(null, "���ִ���",
									"��ʾ", JOptionPane.WARNING_MESSAGE);break;
						}
					}
					try{
						int aver=sum/s;
						s1 = String.valueOf(aver);
						moneyField.setText(s1);//ƽ������
						// **�ܹ���
						s1 = String.valueOf(sum);
						allmonField.setText(s1);//�ܹ���
						//�����
						s1 = String.valueOf(maxmon);
						maxmonField.setText(s1);
						//��С����
						s1 = String.valueOf(im1);
						minmonField.setText(s1);
						//��Ů����
						boynumField.setText(String.valueOf(boy));
						girdnumField.setText(String.valueOf(gird));
						//����������
						s1 = String.valueOf(d);
						denumField.setText("������:"+s1+"������:"+String.valueOf(d2)+
								"�г���:"+String.valueOf(d3)+"����:"+String.valueOf(d1));
					}catch(Exception ee){
						JOptionPane.showMessageDialog(null, "��Ϊ�գ�",
								"��ʾ", JOptionPane.WARNING_MESSAGE);
					}
				}else{
					JOptionPane.showMessageDialog(null, "��Ϊ�գ�",
							"��ʾ", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		// ɾ����ť�¼�
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
							JOptionPane.showMessageDialog(null, "ɾ���ɹ���",
									"��ʾ", JOptionPane.WARNING_MESSAGE);
							del1Field.setText(null);break;
						}
					}
					if(p!=1){JOptionPane.showMessageDialog(null, "�����޴��ˣ�",
							"��ʾ", JOptionPane.WARNING_MESSAGE);
					delField.setText(null);	del1Field.setText(null);
					}
				}catch(Exception ee){}
			}
		});
		//		****************************��ѯ��ť�¼�
		addButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//				dtm.fireTableChanged(null);//ˢ�±��
				String number=findField.getText();
				String name=find1Field.getText();int p=0;
				for(int i=0;i<dtm.getRowCount();i++){
					@SuppressWarnings("rawtypes")
					String s=((Vector)dtm.getDataVector().elementAt(i)).elementAt(1).toString();
					@SuppressWarnings("rawtypes")
					String s1=((Vector)dtm.getDataVector().elementAt(i)).elementAt(0).toString();
					if(number.equals(s1)||name.equals(s)){
						table.setRowSelectionInterval(i, i);
						find2Field.setText("���  ���� ���� �Ա� �绰    ����  ְλ  ����"+
						"\n"+dtm.getDataVector().elementAt(i).toString());p=1;break;
					}
				}
				findField.setText(null);
				find1Field.setText(null);
				if(p!=1){
					JOptionPane.showMessageDialog(null, "���޴��ˣ�","��ʾ", JOptionPane.WARNING_MESSAGE);
					find1Field.setText(null);
				}
			}
		});
		//		***********************************	��ȡ��ť�¼�
		addButton5.addActionListener(new ActionListener() {int i=0;
		public void actionPerformed(ActionEvent e) {
			if(i==0){
				try {Connection con;
				// ���ݿ�
				con=JDBC.connect("students","root","ren@0072");
				if(con==null)System.out.println("Ϊ��");
				else{
					System.out.println("���ӳɹ�");
				}
				PreparedStatement preSql;
				ResultSet rs;
				// Ҫִ�е�SQL���
				String sql = "select * from mess";//
				preSql=con.prepareStatement(sql);
				// ResultSet�࣬������Ż�ȡ�Ľ������
				rs = preSql.executeQuery(sql);
				while(rs.next()){
					String	id = rs.getString("���");
					// ��ȡ����������������
					String name = rs.getString("����");
					// ��ȡ����ѧ�ɼ�����������
					String age = rs.getString("����");
					// ��ȡ�����ĳɼ�����������
					String sex = rs.getString("�Ա�");
					String tel=rs.getString("�绰");
					String mon=rs.getString("����");
					String depart=rs.getString("����");
					String pos=rs.getString("ְλ");
					dtm.addRow(new String[] { id, name, age, sex,tel, depart, pos, mon });
				}
				preSql.close();
				con.close();
				}catch(NullPointerException ee){
					JOptionPane.showMessageDialog(null, "�ļ���ȡ��ϣ�","��ʾ", JOptionPane.WARNING_MESSAGE);
				}
				catch(Exception eee){
					eee.printStackTrace();
					JOptionPane.showMessageDialog(null, "�ļ�Ϊ�գ�","��ʾ", JOptionPane.WARNING_MESSAGE);
				}	
				i=i+1;
			}
			else{
				JOptionPane.showMessageDialog(null, "��ťֻ��ֻ��һ�Σ�","��ʾ", JOptionPane.WARNING_MESSAGE); 
				return ;
			} 
		}
		});
		//		***************************�༭��ť�¼�
		addButton6.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent e) {

				//dtm.fireTableChanged(null);//ˢ�±��
				int i,j=0,p1=1;
				String f=filtField.getText();
				String f2=filt1Field.getText();
				String f1=com1Box.getSelectedItem().toString();

				int p=0;
				for(i=0;i<dtm.getRowCount();i++){
					@SuppressWarnings("rawtypes")
					String s1=((Vector)dtm.getDataVector().elementAt(i)).elementAt(0).toString();
					if(f1.equals("���"))j=0;
					if(f1.equals("����"))j=1;
					if(f1.equals("����"))j=2;
					if(f1.equals("�Ա�"))j=3;
					if(f1.equals("�绰"))j=4;
					if(f1.equals("����"))j=5;
					if(f1.equals("ְλ"))j=6;
					if(f1.equals("����"))j=7;
					if(f1.equals("���")&&f2.equals(s1)){
						p1=0;
					}
					if(f.equals(s1)){
						dtm.setValueAt(f2,i,j);//�滻���е�����
						JOptionPane.showMessageDialog(null, "�޸ĳɹ���","��ϲ", JOptionPane.WARNING_MESSAGE);
						break;
					}
				}
				if(p1==0){
					JOptionPane.showMessageDialog(null, "���д��ˣ�","��ʾ", JOptionPane.WARNING_MESSAGE);
					filtField.setText(null);
					return ;
				}
				if(i==dtm.getRowCount()){
					JOptionPane.showMessageDialog(null, "���޴��ˣ�","��ʾ", JOptionPane.WARNING_MESSAGE);
				}

			}
		});
	}
}
