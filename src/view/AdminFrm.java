package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class AdminFrm extends JFrame {

	private JPanel contentPane;
    private JPanel table111;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminFrm frame = new AdminFrm();
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
	public AdminFrm() {
		setTitle("管理员");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 894, 664);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("管理站点情况");
		mnNewMenu.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("查看所有站点情况");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table111.removeAll();
				AllLocFrm alf=new AllLocFrm();
				alf.setVisible(true);
				table111.add(alf);
			}
		});
		
		mntmNewMenuItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("查看指定站点情况");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table111.removeAll();
				SelectSpeLoc ssl=new SelectSpeLoc();
				ssl.setVisible(true);
				table111.add(ssl);
			}
		});
		mntmNewMenuItem_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("查询指定区域的站点");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table111.removeAll();
				SelectSpeRegion ssr=new SelectSpeRegion();
				ssr.setVisible(true);
				table111.add(ssr);
			}
		});
		mntmNewMenuItem_4.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		mnNewMenu.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("添加站点");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table111.removeAll();
				AddLocFrm adlf=new AddLocFrm();
				adlf.setVisible(true);
				table111.add(adlf);
			}
		});
		mntmNewMenuItem_5.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		mnNewMenu.add(mntmNewMenuItem_5);
		
		JMenu mnNewMenu_1 = new JMenu("管理用户情况");
		mnNewMenu_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("查看所有用户");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table111.removeAll();
				AllUserFrm auf=new AllUserFrm();
				auf.setVisible(true);
				table111.add(auf);
			}
		});
		mntmNewMenuItem_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("查看指定用户");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table111.removeAll();
				SelectSpeUser ssu=new SelectSpeUser();
				ssu.setVisible(true);
				table111.add(ssu);
			}
		});
		mntmNewMenuItem_3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("删除指定用户");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table111.removeAll();
				DeleteSpeUserFrm dsuf=new DeleteSpeUserFrm();
				dsuf.setVisible(true);
				table111.add(dsuf);
			}
		});
		mntmNewMenuItem_6.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		mnNewMenu_1.add(mntmNewMenuItem_6);
		
		JMenu mnNewMenu_2 = new JMenu("管理订单情况");
		mnNewMenu_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("查看所有订单");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table111.removeAll();
				AllOrderFrm aof=new AllOrderFrm();
				aof.setVisible(true);
				table111.add(aof);
			}
		});
		mntmNewMenuItem_7.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
		mnNewMenu_2.add(mntmNewMenuItem_7);
		
		JMenuItem mntmNewMenuItem_13 = new JMenuItem("查看指定用户的订单");
		mntmNewMenuItem_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table111.removeAll();
				SelectSpeUseOrderFrm ssuof = new SelectSpeUseOrderFrm();
				ssuof.setVisible(true);
				table111.add(ssuof);
			}
		});
		
		JMenuItem mntmNewMenuItem_14 = new JMenuItem("查看指定订单");
		mntmNewMenuItem_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table111.removeAll();
				SelectSpeOrderFrm ssof=new SelectSpeOrderFrm();
				ssof.setVisible(true);
				table111.add(ssof);
			}
		});
		mntmNewMenuItem_14.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
		mnNewMenu_2.add(mntmNewMenuItem_14);
		mntmNewMenuItem_13.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
		mnNewMenu_2.add(mntmNewMenuItem_13);
		
		JMenu mnNewMenu_3 = new JMenu("管理充电宝");
		mnNewMenu_3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("查看所有充电宝");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table111.removeAll();
				AllPBFrm apf=new AllPBFrm();
				apf.setVisible(true);
				table111.add(apf);
			}
		});
		mntmNewMenuItem_8.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
		mnNewMenu_3.add(mntmNewMenuItem_8);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("查看指定充电宝");
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table111.removeAll();
				SelectSpePB ssp = new SelectSpePB();
				ssp.setVisible(true);
				table111.add(ssp);
			}
		});
		mntmNewMenuItem_10.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
		mnNewMenu_3.add(mntmNewMenuItem_10);
		
		JMenuItem mntmNewMenuItem_12 = new JMenuItem("查看指定站点充电宝");
		mntmNewMenuItem_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table111.removeAll();
				SelectSpeRegionPB ssrp = new SelectSpeRegionPB();
				ssrp.setVisible(true);
				table111.add(ssrp);
			}
		});
		mntmNewMenuItem_12.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
		mnNewMenu_3.add(mntmNewMenuItem_12);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("查看指定区域充电宝");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table111.removeAll();
				SelectSpeRegionPB2 ssr2=new SelectSpeRegionPB2();
				ssr2.setVisible(true);
				table111.add(ssr2);
			}
		});
		mntmNewMenuItem_9.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
		mnNewMenu_3.add(mntmNewMenuItem_9);
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("增设充电宝");
		mntmNewMenuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table111.removeAll();
				AddPBFrm apf=new AddPBFrm();
				apf.setVisible(true);
				table111.add(apf);
			}
		});
		mntmNewMenuItem_11.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
		mnNewMenu_3.add(mntmNewMenuItem_11);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		table111 = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(19)
					.addComponent(table111, GroupLayout.PREFERRED_SIZE, 833, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(18, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(table111, GroupLayout.PREFERRED_SIZE, 552, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(25, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		this.setLocationRelativeTo(null);  // 居中显示
	}
}
