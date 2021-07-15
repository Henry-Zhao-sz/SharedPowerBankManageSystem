package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.ssdut.spbs.dao.impl.*;
import com.ssdut.spbs.dao.*;
import com.ssdut.spbs.service.Impl.*;
import com.ssdut.spbs.service.*;
import com.ssdut.spbs.entity.*;
import java.util.*;

public class UserTopupFrm extends JInternalFrame {
	private JTextField unameText;
	private JTextField MoneyText;
	private JPasswordField uPwdText;
    private UserServiceImpl usi;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserTopupFrm frame = new UserTopupFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserTopupFrm() {
		setIconifiable(true);
		setClosable(true);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 438, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 271, Short.MAX_VALUE)
		);
		getContentPane().setLayout(groupLayout);
		setTitle("用户充值");
		setBounds(100, 100, 450, 300);
		
		JLabel lblNewLabel = new JLabel("请输入用户名");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		
		JLabel lblNewLabel_1 = new JLabel("请输入密码");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 15));
		
		JLabel lblNewLabel_2 = new JLabel("请输入要充值的金额");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 15));
		
		unameText = new JTextField();
		unameText.setColumns(10);
		
		MoneyText = new JTextField();
		MoneyText.setColumns(10);
		
		uPwdText = new JPasswordField();
		
		JButton btnNewButton = new JButton("充值");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usi = new UserServiceImpl();
				String name = unameText.getText();
				String pwd = new String(uPwdText.getPassword());
				if(usi.topTheUp(name, pwd)==1) {
					double money = Double.parseDouble(MoneyText.getText());
				    if(usi.topUp(money, name, pwd)!=0) {
				    	JOptionPane.showMessageDialog(null, "充值成功");
						unameText.setText("");
						uPwdText.setText("");
						MoneyText.setText("");
				    }
				}
				else {
					JOptionPane.showMessageDialog(null, "充值失败");
				}
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 15));
		GroupLayout groupLayout1 = new GroupLayout(getContentPane());
		groupLayout1.setHorizontalGroup(
			groupLayout1.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout1.createSequentialGroup()
					.addGroup(groupLayout1.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout1.createSequentialGroup()
							.addGroup(groupLayout1.createParallelGroup(Alignment.LEADING, false)
								.addGroup(Alignment.TRAILING, groupLayout1.createSequentialGroup()
									.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblNewLabel)
									.addGap(45))
								.addGroup(Alignment.TRAILING, groupLayout1.createSequentialGroup()
									.addGap(27)
									.addGroup(groupLayout1.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
									.addGap(33)))
							.addGroup(groupLayout1.createParallelGroup(Alignment.LEADING, false)
								.addComponent(unameText)
								.addComponent(uPwdText)
								.addComponent(MoneyText, GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)))
						.addGroup(groupLayout1.createSequentialGroup()
							.addGap(149)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(76, Short.MAX_VALUE))
		);
		groupLayout1.setVerticalGroup(
			groupLayout1.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout1.createSequentialGroup()
					.addGap(39)
					.addGroup(groupLayout1.createParallelGroup(Alignment.BASELINE)
						.addComponent(unameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addGap(40)
					.addGroup(groupLayout1.createParallelGroup(Alignment.BASELINE)
						.addComponent(uPwdText, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addGap(39)
					.addGroup(groupLayout1.createParallelGroup(Alignment.BASELINE)
						.addComponent(MoneyText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2))
					.addGap(28)
					.addComponent(btnNewButton)
					.addContainerGap(38, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout1);

	}
}
