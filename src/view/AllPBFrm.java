package view;

import java.awt.EventQueue;
import java.util.List;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import com.ssdut.spbs.dao.impl.*;
import com.ssdut.spbs.dao.*;
import com.ssdut.spbs.service.Impl.*;
import com.ssdut.spbs.service.*;
import com.ssdut.spbs.entity.*;
import java.util.*;

public class AllPBFrm extends JInternalFrame {
	private JTable table;
	private PowerBankServiceImpl psi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AllPBFrm frame = new AllPBFrm();
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
	public AllPBFrm() {
		setTitle("所有充电宝");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 693, 507);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 658, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(13, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 436, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(23, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u501F\u8FD8\u72B6\u6001", "\u5269\u4F59\u7535\u91CF", "\u4F7F\u7528\u65F6\u957F", "\u6240\u5728\u7AD9\u70B9", "\u7535\u6C60\u5065\u5EB7"
			}
		));
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);
        fillTable();
	}
	
	public void fillTable() {
    	DefaultTableModel dtm = (DefaultTableModel) table.getModel();
    	dtm.setRowCount(0);//设置成0行
    	//查询所有充电宝信息
    	psi = new PowerBankServiceImpl();
    	List<powerbank> list=psi.showAllPB();
    	for(powerbank pb1:list) {
    		Vector v = new Vector<>();
    		v.add(pb1.getPbID());
    		v.add(pb1.getBlState());
    		v.add(pb1.getRestPower());
    		v.add(Double.toString(100-pb1.getHealthState())+"days+"+pb1.getUseTimeLong().toString());
    		v.add(pb1.getPbLoc());
    		v.add(pb1.getHealthState());
    		dtm.addRow(v);
    		}
    }
	
}
