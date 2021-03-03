
package QQ;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class pa extends JDialog implements ActionListener{

	private JPanel contentPanel = new JPanel();
	JButton button ,button1;
	public pa() {
		setUndecorated(true);
		Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((d.width-531)/2,(d.height-407)/2,526, 399);
		contentPanel.setLayout(null);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\eclipsesdt\\QQ\\qqloginfailure.GIF"));
		lblNewLabel.setBounds(0, 0, 526, 399);
		contentPanel.add(lblNewLabel);
		JButton Button = new JButton("");
		Button.setBounds(418, 365,100,30);
		Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		Button.setContentAreaFilled(false);//设置按钮透明
		contentPanel.add(Button);
		add(contentPanel);
		button = new JButton("");
		button.setContentAreaFilled(false);//设置按钮透明
		button.setBounds(493, 0, 33, 33);
		contentPanel.add(button);
		button.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button)dispose();
		
	}

}
