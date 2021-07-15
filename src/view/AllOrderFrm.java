package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import com.ssdut.spbs.dao.impl.*;
import com.ssdut.spbs.dao.*;
import com.ssdut.spbs.service.Impl.*;
import com.ssdut.spbs.service.*;
import com.ssdut.spbs.entity.*;
import java.util.*;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AllOrderFrm extends JInternalFrame {
	private JTable table;
    private OrderServiceImpl osi;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AllOrderFrm frame = new AllOrderFrm();
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
	public AllOrderFrm() {
		setTitle("查看所有订单信息");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 617, 431);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(20)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 358, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(24, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u7528\u6237\u7F16\u53F7", "\u501F\u51FA\u70B9\u7F16\u53F7", "\u5145\u7535\u5B9D\u7F16\u53F7", "\u521B\u5EFA\u65F6\u95F4", "\u662F\u5426\u5B8C\u6210", "\u5F52\u8FD8\u70B9\u7F16\u53F7", "\u5B8C\u6210\u65F6\u95F4", "\u8D39\u7528"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(37);
		table.getColumnModel().getColumn(1).setPreferredWidth(59);
		table.getColumnModel().getColumn(2).setPreferredWidth(73);
		table.getColumnModel().getColumn(4).setPreferredWidth(90);
		table.getColumnModel().getColumn(5).setPreferredWidth(63);
		table.getColumnModel().getColumn(7).setPreferredWidth(60);
		table.getColumnModel().getColumn(8).setPreferredWidth(42);
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);
        fillTable();
	}
	public void fillTable() {
    	DefaultTableModel dtm = (DefaultTableModel) table.getModel();
    	dtm.setRowCount(0);//设置成0行
    	//查询所有用户信息
    	osi = new OrderServiceImpl();
    	List<order> list=osi.showAllOrder();
    	for(order order1:list) {
    		Vector v = new Vector<>();
    		v.add(order1.getOrderID());
    		v.add(order1.getOrderUserID());
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
