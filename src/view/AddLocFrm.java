package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.ssdut.spbs.dao.impl.*;
import com.ssdut.spbs.dao.*;
import com.ssdut.spbs.service.Impl.*;
import com.ssdut.spbs.service.*;
import com.ssdut.spbs.entity.*;
import java.util.*;

public class AddLocFrm extends JInternalFrame {
	private JTextField locidText;
	private JTextField locInfoText;
	private JTextField TotalnumText;
	private JTextField MaxVolumeText;
    private LocServiceImpl lsi;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddLocFrm frame = new AddLocFrm();
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
	public AddLocFrm() {
		setTitle("增设站点");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 611, 429);
		
		JLabel lblNewLabel = new JLabel("请输入站点信息");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JLabel lblNewLabel_1 = new JLabel("站点编号：");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		locidText = new JTextField();
		locidText.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("具体位置信息：");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 18));
		
		locInfoText = new JTextField();
		locInfoText.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("充电宝总数：");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 18));
		
		TotalnumText = new JTextField();
		TotalnumText.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("最大容量：");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 18));
		
		MaxVolumeText = new JTextField();
		MaxVolumeText.setColumns(10);
		
		JButton btnNewButton = new JButton("添加");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lsi=new LocServiceImpl();
				loc loc1=new loc();
				loc1.setLocID(locidText.getText());
				loc1.setLocInfo(locInfoText.getText());
				loc1.setTotalNum(Integer.parseInt(TotalnumText.getText()));
				loc1.setMaxVolume(Integer.parseInt(MaxVolumeText.getText()));
				loc1.setLendTime(0);
				loc1.setAvailNum(Integer.parseInt(TotalnumText.getText()));
				boolean bl=lsi.addLoc(loc1);
				if(bl==true) {
					JOptionPane.showMessageDialog(null, "添加站点成功");
					locidText.setText("");
					locInfoText.setText("");
					TotalnumText.setText("");
					MaxVolumeText.setText("");
				}
				else {
					JOptionPane.showMessageDialog(null, "添加失败");
					locidText.setText("");
					locInfoText.setText("");
					TotalnumText.setText("");
					MaxVolumeText.setText("");
				}
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 18));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(210)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(47)
									.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(locidText, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblNewLabel_2)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(23)
									.addComponent(lblNewLabel_3)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(TotalnumText, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblNewLabel_4)
									.addGap(16)))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(MaxVolumeText)
								.addComponent(locInfoText, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(75, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(228)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(274, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(58)
					.addComponent(lblNewLabel)
					.addGap(48)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(locidText, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2)
						.addComponent(locInfoText, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(56)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(TotalnumText, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(MaxVolumeText, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4))
					.addGap(49)
					.addComponent(btnNewButton)
					.addContainerGap(79, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}

}
