package view;
import com.ssdut.spbs.dao.impl.*;
import com.ssdut.spbs.dao.*;
import com.ssdut.spbs.service.Impl.*;
import com.ssdut.spbs.service.*;
import com.ssdut.spbs.entity.*;
import java.util.*;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;

public class AllLocFrm extends JInternalFrame {
	private JTable table;
    private LocServiceImpl lsi=new LocServiceImpl();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AllLocFrm frame = new AllLocFrm();
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
	public AllLocFrm() {
		setIconifiable(true);
		setClosable(true);
		setTitle("当前所有站点信息");
		setBounds(100, 100, 555, 368);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 515, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(18, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(36, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5E8F\u53F7", "\u7AD9\u70B9\u7F16\u53F7", "\u4F4D\u7F6E\u4FE1\u606F", "\u53EF\u7528\u6570\u91CF", "\u5145\u7535\u5B9D\u603B\u6570", "\u6700\u5927\u5BB9\u91CF", "\u501F\u51FA\u6B21\u6570"
			}
		));
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);
		fillTable();
	}
	
	public void fillTable() {
    	DefaultTableModel dtm = (DefaultTableModel) table.getModel();
    	dtm.setRowCount(0);//设置成0行
    	//查询所有用户信息
    	List<loc> list=lsi.showAllLoc();
    	for(loc loc1:list) {
    		Vector v = new Vector<>();
    		v.add(dtm.getRowCount()+1);
    		v.add(loc1.getLocID());
    		v.add(loc1.getLocInfo());
    		v.add(loc1.getAvailNum());
    		v.add(loc1.getTotalNum());
    		v.add(loc1.getMaxVolume());
    		v.add(loc1.getLendTime());
    		dtm.addRow(v);
    		}
    }
	
}
