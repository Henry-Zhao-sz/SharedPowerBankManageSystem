package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.ssdut.spbs.dao.impl.*;
import com.ssdut.spbs.dao.*;
import com.ssdut.spbs.service.Impl.*;
import com.ssdut.spbs.service.*;
import com.ssdut.spbs.entity.*;
import java.util.*;

public class SelectSpeUseOrderFrm extends JInternalFrame {
	private JTextField userIDText;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectSpeUseOrderFrm frame = new SelectSpeUseOrderFrm();
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
	public SelectSpeUseOrderFrm() {
		setTitle("查询指定用户的订单");
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 611, 418);
		
		JLabel lblNewLabel = new JLabel("请输入要查询的用户编号");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		
		userIDText = new JTextField();
		userIDText.setColumns(10);
		
		JButton btnNewButton = new JButton("查询");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int userid = Integer.parseInt(userIDText.getText());
				UserServiceImpl usi=new UserServiceImpl();
				orderDaoImpl odi = new orderDaoImpl();
				user user1 = usi.showSpeUser(userid);
				if(user1==null) {
					JOptionPane.showMessageDialog(null, "查询失败，无此用户");
				}
				else {
					List<order> list = odi.queryByUserID(userid);
					DefaultTableModel dtm = (DefaultTableModel) table.getModel();
			    	dtm.setRowCount(0);//设置成0行
			    	//查询所有充电宝信息
			    	for(order order1:list) {
			    		Vector v = new Vector<>();
			    		v.add(order1.getOrderID());
                        v.add(order1.getOrderLendLocID());
                        v.add(order1.getOrderPbID());
                        v.add(order1.getOrderCreateTime());
                        v.add(order1.getOrderHasFinished());
                        v.add(order1.getOrderRevertLocID());
                        v.add(order1.getOrderFinishTime());
                        v.add(order1.getOrderCost());
			    		dtm.addRow(v);
			    		}
				}
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 15));
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 551, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(22, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(44)
					.addComponent(lblNewLabel)
					.addGap(52)
					.addComponent(userIDText, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(84))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(44, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(userIDText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addGap(32)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(47, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u8BA2\u5355\u7F16\u53F7", "\u501F\u51FA\u5730", "\u5145\u7535\u5B9D\u7F16\u53F7", "\u521B\u5EFA\u65F6\u95F4", "\u662F\u5426\u5B8C\u6210", "\u5F52\u8FD8\u5730", "\u5B8C\u6210\u65F6\u95F4", "\u8D39\u7528"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(58);
		table.getColumnModel().getColumn(1).setPreferredWidth(52);
		table.getColumnModel().getColumn(4).setPreferredWidth(58);
		table.getColumnModel().getColumn(5).setPreferredWidth(50);
		table.getColumnModel().getColumn(7).setPreferredWidth(39);
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);

	}
}
