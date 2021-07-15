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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.ssdut.spbs.dao.impl.*;
import com.ssdut.spbs.dao.*;
import com.ssdut.spbs.service.Impl.*;
import com.ssdut.spbs.service.*;
import com.ssdut.spbs.entity.*;
import java.util.*;

public class SelectSpeRegionPB2 extends JInternalFrame {
	private JTextField idInfoText;
	private JTable table;
    private PowerBankServiceImpl psi=new PowerBankServiceImpl();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectSpeRegionPB2 frame = new SelectSpeRegionPB2();
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
	public SelectSpeRegionPB2() {
		setTitle("查看指定站点充电宝");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 552, 397);
		
		JLabel lblNewLabel = new JLabel("请输入区域编号");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		
		idInfoText = new JTextField();
		idInfoText.setColumns(10);
		
		JButton btnNewButton = new JButton("查询");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String regionid=idInfoText.getText();
				if(!regionid.equals("A")&&!regionid.equals("B")&&!regionid.equals("C")&&!regionid.equals("D")) {
					JOptionPane.showMessageDialog(null, "不存在此区域");
				}
				else {
					List<powerbank> list = psi.showSpePB(regionid);
					DefaultTableModel dtm = (DefaultTableModel) table.getModel();
			    	dtm.setRowCount(0);//设置成0行
			    	//查询所有充电宝信息
			    	for(powerbank pb1:list) {
			    		Vector v = new Vector<>();
			    		v.add(Integer.toString(pb1.getPbID()));
			    		
						v.add(Integer.toString(pb1.getBlState()));
						if(pb1.getBlState()==1) {
							v.add(Double.toString(pb1.getRestPower())); 
						}
						else {
							v.add("不可知");
						}
						v.add(Double.toString(100-pb1.getHealthState())+"days+"+pb1.getUseTimeLong().toString());
						v.add(pb1.getPbLoc());
						v.add(Double.toString(pb1.getHealthState()));
			    		dtm.addRow(v);
			    		}
				}
				
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 15));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel_1 = new JLabel("A/B/C/D");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(54, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addGap(57))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(36)))
					.addComponent(idInfoText, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addGap(40)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(114, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(31, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 480, GroupLayout.PREFERRED_SIZE)
					.addGap(29))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(47)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewButton)
								.addComponent(idInfoText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(36)
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_1)))
					.addGap(16)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(25, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u501F\u8FD8\u72B6\u6001", "\u5269\u4F59\u7535\u91CF", "\u4F7F\u7528\u65F6\u95F4", "\u6240\u5728\u7AD9\u70B9", "\u7535\u6C60\u5065\u5EB7"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(36);
		table.getColumnModel().getColumn(1).setPreferredWidth(58);
		table.getColumnModel().getColumn(2).setPreferredWidth(58);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(59);
		table.getColumnModel().getColumn(5).setPreferredWidth(60);
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);

	}

}
