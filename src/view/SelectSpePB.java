package view;

import java.awt.EventQueue;
import com.ssdut.spbs.dao.impl.*;
import com.ssdut.spbs.dao.*;
import com.ssdut.spbs.service.Impl.*;
import com.ssdut.spbs.service.*;
import com.ssdut.spbs.entity.*;
import java.util.*;
import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SelectSpePB extends JInternalFrame {
	private JTextField idInfo;
	private JTextField pbidText;
	private JTextField blstateText;
	private JTextField restpowerText;
	private JTextField locinfoText;
	private JTextField timeLongText;
	private JTextField healthText;
    private PowerBankServiceImpl psi;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectSpePB frame = new SelectSpePB();
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
	public SelectSpePB() {
		setTitle("查看指定充电宝");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 576, 442);
		
		JLabel lblNewLabel = new JLabel("请输入充电宝编号：");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		
		idInfo = new JTextField();
		idInfo.setColumns(10);
		
		JButton btnNewButton = new JButton("查询");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pbid = idInfo.getText();
				psi = new PowerBankServiceImpl();
				powerbank pb=psi.showPBWithID(Integer.parseInt(pbid));
				if(pb!=null) {
					pbidText.setText(Integer.toString(pb.getPbID()));
					blstateText.setText(Integer.toString(pb.getBlState()));
					if(pb.getBlState()==1) {
						restpowerText.setText(Double.toString(pb.getRestPower())); 
					}
					else {
						restpowerText.setText("不可知");
					}
					timeLongText.setText(Double.toString(100-pb.getHealthState())+"days+"+pb.getUseTimeLong().toString());
					locinfoText.setText(pb.getPbLoc());
					healthText.setText(Double.toString(pb.getHealthState()));
				}
				else {
					pbidText.setText("无");
					blstateText.setText("无");
					restpowerText.setText("无"); 
					timeLongText.setText("无");
					locinfoText.setText("无");
					healthText.setText("无");
				}
				
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 15));
		
		JLabel lblNewLabel_1 = new JLabel("编号");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JLabel lblNewLabel_2 = new JLabel("借还状态");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 16));
		
		pbidText = new JTextField();
		pbidText.setColumns(10);
		
		blstateText = new JTextField();
		blstateText.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("剩余电量");
		lblNewLabel_1_1.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JLabel lblNewLabel_1_2 = new JLabel("位置信息");
		lblNewLabel_1_2.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JLabel lblNewLabel_1_3 = new JLabel("使用时长");
		lblNewLabel_1_3.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JLabel lblNewLabel_1_4 = new JLabel("电池健康");
		lblNewLabel_1_4.setFont(new Font("宋体", Font.PLAIN, 16));
		
		restpowerText = new JTextField();
		restpowerText.setColumns(10);
		
		locinfoText = new JTextField();
		locinfoText.setColumns(10);
		
		timeLongText = new JTextField();
		timeLongText.setColumns(10);
		
		healthText = new JTextField();
		healthText.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(56)
							.addComponent(lblNewLabel)
							.addGap(28)
							.addComponent(idInfo, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
							.addGap(41)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap(92, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
										.addComponent(lblNewLabel_1_2))
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addGap(19)))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(pbidText, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
								.addComponent(restpowerText, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
								.addComponent(locinfoText, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
							.addGap(50)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_1_4)
									.addGap(12)
									.addComponent(healthText, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(timeLongText, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_2)
									.addGap(12)
									.addComponent(blstateText, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(30, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(52)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(idInfo, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addGap(66)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(blstateText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(pbidText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addGap(58)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_1)
						.addComponent(lblNewLabel_1_3)
						.addComponent(timeLongText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(restpowerText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(60)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_2)
						.addComponent(lblNewLabel_1_4)
						.addComponent(locinfoText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(healthText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(82, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}
}
