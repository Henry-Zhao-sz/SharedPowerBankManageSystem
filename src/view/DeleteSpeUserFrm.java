package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.ssdut.spbs.dao.impl.*;
import com.ssdut.spbs.dao.*;
import com.ssdut.spbs.service.Impl.*;
import com.ssdut.spbs.service.*;
import com.ssdut.spbs.entity.*;
import java.util.*;

public class DeleteSpeUserFrm extends JInternalFrame {
	private JTextField useridText;
	private JTextField idText;
	private JTextField phoneText;
	private JTextField nameText;
	private JTextField balanceText;
    private UserServiceImpl usi;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteSpeUserFrm frame = new DeleteSpeUserFrm();
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
	public DeleteSpeUserFrm() {
		setTitle("删除指定用户");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 600, 433);
		
		JLabel lblNewLabel = new JLabel("请输入要删除的用户编号");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		
		useridText = new JTextField();
		useridText.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("用户编号");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 16));
		
		idText = new JTextField();
		idText.setColumns(10);
		
		JButton btnNewButton = new JButton("删除");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usi=new UserServiceImpl();
				String userid=useridText.getText();
				user user1=usi.showSpeUser(Integer.parseInt(userid));
				if(user1!=null) {
					idText.setText(Integer.toString(user1.getUserID()));
					nameText.setText(user1.getUserName());
					phoneText.setText(user1.getUserPhone());
					balanceText.setText(Double.toString(user1.getUserBalance()));
					if(usi.removeSpeUser(Integer.parseInt(userid))==1) {
						JOptionPane.showMessageDialog(null, "删除用户成功，信息如下所示");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "删除失败");
				}
				
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JLabel lblNewLabel_1_1 = new JLabel("用户姓名");
		lblNewLabel_1_1.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JLabel lblNewLabel_1_2 = new JLabel("用户电话");
		lblNewLabel_1_2.setFont(new Font("宋体", Font.PLAIN, 16));
		
		phoneText = new JTextField();
		phoneText.setColumns(10);
		
		nameText = new JTextField();
		nameText.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("账户余额");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 16));
		
		balanceText = new JTextField();
		balanceText.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(173, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(useridText, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
							.addGap(43)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_2))
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(balanceText, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
										.addComponent(nameText, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))))))
					.addGap(88))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(85)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(phoneText, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(idText, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)))
					.addGap(324))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap(185, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1)
								.addComponent(idText, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(45)
							.addComponent(lblNewLabel)
							.addGap(29)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(useridText, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton))
							.addPreferredGap(ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
							.addComponent(nameText, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addGap(5)))
					.addGap(61)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(phoneText, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel_2)
							.addComponent(balanceText, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)))
					.addGap(100))
		);
		getContentPane().setLayout(groupLayout);

	}

}
