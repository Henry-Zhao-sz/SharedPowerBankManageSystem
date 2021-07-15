package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
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

public class SelectSpeRegion extends JInternalFrame {
	private JTextField locRegionInfo;
	private JTable table;
	private LocServiceImpl lsi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectSpeRegion frame = new SelectSpeRegion();
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
	public SelectSpeRegion() {
		setIconifiable(true);
		setClosable(true);
		setTitle("查询指定区域的站点");
		setBounds(100, 100, 521, 375);
		
		JLabel lblNewLabel = new JLabel("请输入你要查询的区域");
		
		locRegionInfo = new JTextField();
		locRegionInfo.setColumns(10);
		
		JButton btnNewButton = new JButton("查询");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lsi = new LocServiceImpl();
				String locReg=locRegionInfo.getText();
				List<loc> list=lsi.showSpeRegion(locReg);
				DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		    	dtm.setRowCount(0);//设置成0行
		    	//查询所有用户信息
		    	for(loc loc1:list) {
		    		Vector v = new Vector<>();
		    		v.add(loc1.getLocID());
		    		v.add(loc1.getLocInfo());
		    		v.add(loc1.getAvailNum());
		    		v.add(loc1.getTotalNum());
		    		v.add(loc1.getMaxVolume());
		    		v.add(loc1.getLendTime());
		    		dtm.addRow(v);
		    		}
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel_1 = new JLabel("A/B/C/D");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(34)
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(67)
									.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)))
							.addGap(30)
							.addComponent(locRegionInfo, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
							.addGap(43)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(39)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(locRegionInfo, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton)
						.addComponent(lblNewLabel))
					.addGap(30)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(80, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(70, Short.MAX_VALUE)
					.addComponent(lblNewLabel_1)
					.addGap(261))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7AD9\u70B9\u7F16\u53F7", "\u7AD9\u70B9\u4F4D\u7F6E\u4FE1\u606F", "\u53EF\u7528\u6570\u91CF", "\u5145\u7535\u5B9D\u603B\u6570", "\u6700\u5927\u5BB9\u91CF", "\u501F\u51FA\u6B21\u6570"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(89);
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);

	}
}
