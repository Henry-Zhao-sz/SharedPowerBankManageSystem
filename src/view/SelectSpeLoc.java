package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.ssdut.spbs.dao.impl.*;
import com.ssdut.spbs.dao.*;
import com.ssdut.spbs.service.Impl.*;
import com.ssdut.spbs.service.*;
import com.ssdut.spbs.entity.*;
import java.util.*;


public class SelectSpeLoc extends JInternalFrame {
	private JTextField infoTextBox;
	private JTextField locIDtext;
	private JTextField locInfoText;
	private JTextField availNumText;
	private JTextField TotalNumText;
	private JTextField MaxVolumeText;
	private JTextField LendTimeText;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private LocServiceImpl lsi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectSpeLoc frame = new SelectSpeLoc();
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
	public SelectSpeLoc() {
		setIconifiable(true);
		setClosable(true);
		setTitle("查询指定站点");
		setBounds(100, 100, 649, 428);
		
		infoTextBox = new JTextField();
		infoTextBox.setColumns(10);
		
		JButton btnNewButton = new JButton("查询");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String locid= infoTextBox.getText();
				lsi=new LocServiceImpl();
				loc loc1=lsi.showSpeLoc(locid);
				if(loc1!=null) {
					locIDtext.setText(loc1.getLocID());
					locIDtext.setFont(new Font("宋体",Font.BOLD,20));
					locInfoText.setText(loc1.getLocInfo());
					locInfoText.setFont(new Font("宋体",Font.BOLD,20));
					availNumText.setText(Integer.toString(loc1.getAvailNum()));
					availNumText.setFont(new Font("宋体",Font.BOLD,20));
					TotalNumText.setText(Integer.toString(loc1.getTotalNum()));
					TotalNumText.setFont(new Font("宋体",Font.BOLD,20));
					MaxVolumeText.setText(Integer.toString(loc1.getAvailNum()));
					MaxVolumeText.setFont(new Font("宋体",Font.BOLD,20));
					LendTimeText.setText(Integer.toString(loc1.getLendTime()));
					LendTimeText.setFont(new Font("宋体",Font.BOLD,20));
				}
				else {
					locIDtext.setText("无");
					locInfoText.setText("无");
					availNumText.setText("无");
					TotalNumText.setText("无");
					MaxVolumeText.setText("无");
					availNumText.setText("无");
					LendTimeText.setText("无");
				}
				
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JLabel lblNewLabel = new JLabel("请输入要查询的站点编号");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		
		locIDtext = new JTextField();
		locIDtext.setColumns(10);
		
		locInfoText = new JTextField();
		locInfoText.setColumns(10);
		
		availNumText = new JTextField();
		availNumText.setColumns(10);
		
		TotalNumText = new JTextField();
		TotalNumText.setColumns(10);
		
		MaxVolumeText = new JTextField();
		MaxVolumeText.setColumns(10);
		
		LendTimeText = new JTextField();
		LendTimeText.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("站点编号");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 15));
		
		JLabel lblNewLabel_2 = new JLabel("具体位置信息");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 15));
		
		lblNewLabel_3 = new JLabel("可用数量");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 15));
		
		lblNewLabel_4 = new JLabel("充电宝总数");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 15));
		
		lblNewLabel_5 = new JLabel("最大容量");
		lblNewLabel_5.setFont(new Font("宋体", Font.PLAIN, 15));
		
		lblNewLabel_6 = new JLabel("借出次数");
		lblNewLabel_6.setFont(new Font("宋体", Font.PLAIN, 15));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(53)
							.addComponent(lblNewLabel)
							.addGap(18)
							.addComponent(infoTextBox, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(31)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(availNumText, 155, 155, 155)
								.addComponent(MaxVolumeText, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
								.addComponent(locIDtext, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
									.addGap(4))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
									.addGap(12)))))
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(LendTimeText, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
								.addComponent(TotalNumText, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
								.addComponent(locInfoText, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE))
							.addGap(56))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
							.addGap(92))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(44)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(infoTextBox, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addGap(43)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(locInfoText, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
							.addComponent(lblNewLabel_2))
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_1)
							.addComponent(locIDtext, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)))
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(availNumText, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addComponent(TotalNumText, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
						.addComponent(lblNewLabel_3)
						.addComponent(lblNewLabel_4))
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(LendTimeText)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(MaxVolumeText, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
							.addComponent(lblNewLabel_5)
							.addComponent(lblNewLabel_6)))
					.addContainerGap(72, Short.MAX_VALUE))
		);
		
		getContentPane().setLayout(groupLayout);

	}
}
