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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



public class AllUserFrm extends JInternalFrame {
    private UserServiceImpl usi=new UserServiceImpl();
    private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AllUserFrm frame = new AllUserFrm();
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
	public AllUserFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("当前所有用户信息");
		setBounds(100, 100, 555, 368);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 510, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(19, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5E8F\u53F7", "\u7528\u6237\u8D26\u53F7", "\u7528\u6237\u59D3\u540D", "\u7528\u6237\u5BC6\u7801", "\u7528\u6237\u7535\u8BDD", "\u4F7F\u7528\u6B21\u6570", "\u4F7F\u7528\u65F6\u95F4", "\u8D26\u6237\u4F59\u989D"
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
    	List<user> list=usi.showAllUser();
    	for(user user1:list) {
    		Vector v = new Vector<>();
    		v.add(dtm.getRowCount()+1);
    		v.add(user1.getUserID());
    		v.add(user1.getUserName());
    		v.add(user1.getUserPwd());
    		v.add(user1.getUserPhone());
    		v.add(user1.getUseTimes());
    		v.add(user1.getUseTimeLong());
    		v.add(user1.getUserBalance());
    		dtm.addRow(v);
    		}
    }
  
}
