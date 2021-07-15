package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.awt.event.ActionEvent;
import com.ssdut.spbs.dao.impl.*;
import com.ssdut.spbs.dao.*;
import com.ssdut.spbs.service.Impl.*;
import com.ssdut.spbs.service.*;
import com.ssdut.spbs.entity.*;
import java.util.*;

public class AddPBFrm extends JInternalFrame {
	private JTextField idText;
	private JTextField locInfoText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPBFrm frame = new AddPBFrm();
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
	public AddPBFrm() {
		setTitle("增设充电宝");
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 522, 375);
		
		JLabel lblNewLabel = new JLabel("请设置充电宝编号");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JLabel lblNewLabel_1 = new JLabel("请输入所在站点");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 16));
		
		idText = new JTextField();
		idText.setColumns(10);
		
		locInfoText = new JTextField();
		locInfoText.setColumns(10);
		
		JButton btnNewButton = new JButton("添加");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PowerBankServiceImpl pbsi = new PowerBankServiceImpl();
				int pbid = Integer.parseInt(idText.getText());
				String locid= locInfoText.getText();
				Time time = new Time(0);
				powerbank pb = new powerbank(pbid,1,100.0,time,locid,100.0);
				int flag=pbsi.addPB(pb);
				if(flag==-3) {
					JOptionPane.showMessageDialog(null, "该站点不存在，无法添加");
					idText.setText("");
					locInfoText.setText("");
				}
				else if(flag==-2) {
					JOptionPane.showMessageDialog(null, "该站点充电宝已满，无法添加");
					idText.setText("");
					locInfoText.setText("");
				}
				else if(flag==-1) {
					JOptionPane.showMessageDialog(null, "该编号已存在，请重新输入");
					idText.setText("");
				}
				else if(flag==0) {
					JOptionPane.showMessageDialog(null, "添加失败");
				}
				else {
					JOptionPane.showMessageDialog(null, "添加成功");
				}
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 16));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(65)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE))
							.addGap(59)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(locInfoText)
								.addComponent(idText, GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(178)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(122, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(87, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(idText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addGap(64)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(locInfoText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(59)
					.addComponent(btnNewButton)
					.addGap(75))
		);
		getContentPane().setLayout(groupLayout);

	}
}
