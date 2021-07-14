package view;

import java.awt.EventQueue;

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
import com.ssdut.spbs.dao.impl.*;
import com.ssdut.spbs.dao.*;
import com.ssdut.spbs.service.Impl.*;
import com.ssdut.spbs.service.*;
import com.ssdut.spbs.entity.*;
import java.util.*;
import java.text.DecimalFormat;

public class SelectSpeUser extends JInternalFrame {
	private JTextField userInfoText;
	private JTextField useridText;
	private JTextField userpwdText;
	private JTextField usertimeText;
	private JTextField LocAtimeText;
	private JTextField LocCtimeText;
	private JTextField usernameText;
	private JTextField userphoneText;
	private JTextField userbalanceText;
	private JTextField LocBtimeText;
	private JTextField LocDtimeText;
	private UserServiceImpl usi;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectSpeUser frame = new SelectSpeUser();
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
	public SelectSpeUser() {
		setTitle("查询指定用户信息");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 587, 409);
		
		JLabel lblNewLabel = new JLabel("请输入要查询用户的编号");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		
		userInfoText = new JTextField();
		userInfoText.setColumns(10);
		
		JButton btnNewButton = new JButton("查询");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int userid= Integer.parseInt(userInfoText.getText());
				usi=new UserServiceImpl();
				user user1 = usi.showSpeUser(userid);
				if(user1!=null) {
					useridText.setText(Integer.toString(user1.getUserID()));
					useridText.setFont(new Font("宋体",Font.BOLD,12));
					usernameText.setText(user1.getUserName());
					usernameText.setFont(new Font("宋体",Font.BOLD,12));
					userpwdText.setText(user1.getUserPwd());
					userpwdText.setFont(new Font("宋体",Font.BOLD,12));
					userphoneText.setText(user1.getUserPhone());
					userphoneText.setFont(new Font("宋体",Font.BOLD,12));
					usertimeText.setText(Integer.toString(user1.getUseTimes()));
					usertimeText.setFont(new Font("宋体",Font.BOLD,12));
					DecimalFormat df=new DecimalFormat("#.00");
					userbalanceText.setText(df.format(user1.getUserBalance()));
					userbalanceText.setFont(new Font("宋体",Font.BOLD,12));
					LocAtimeText.setText(Integer.toString(user1.getUseTimesLocA()));
					LocAtimeText.setFont(new Font("宋体",Font.BOLD,12));
					LocBtimeText.setText(Integer.toString(user1.getUseTimesLocB()));
					LocBtimeText.setFont(new Font("宋体",Font.BOLD,12));
					LocCtimeText.setText(Integer.toString(user1.getUseTimesLocC()));
					LocCtimeText.setFont(new Font("宋体",Font.BOLD,12));
					LocDtimeText.setText(Integer.toString(user1.getUseTimesLocD()));
					LocDtimeText.setFont(new Font("宋体",Font.BOLD,12));
				}
				else {
					useridText.setText("无");
					useridText.setFont(new Font("宋体",Font.BOLD,12));
					usernameText.setText("无");
					usernameText.setFont(new Font("宋体",Font.BOLD,12));
					userpwdText.setText("无");
					userpwdText.setFont(new Font("宋体",Font.BOLD,12));
					userphoneText.setText("无");
					userphoneText.setFont(new Font("宋体",Font.BOLD,12));
					usertimeText.setText("无");
					usertimeText.setFont(new Font("宋体",Font.BOLD,12));
					userbalanceText.setText("无");
					userbalanceText.setFont(new Font("宋体",Font.BOLD,12));
					LocAtimeText.setText("无");
					LocAtimeText.setFont(new Font("宋体",Font.BOLD,12));
					LocBtimeText.setText("无");
					LocBtimeText.setFont(new Font("宋体",Font.BOLD,12));
					LocCtimeText.setText("无");
					LocCtimeText.setFont(new Font("宋体",Font.BOLD,12));
					LocDtimeText.setText("无");
					LocDtimeText.setFont(new Font("宋体",Font.BOLD,12));
				}
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 15));
		
		JLabel lblNewLabel_1 = new JLabel("用户账号");
		
		JLabel lblNewLabel_2 = new JLabel("用户密码");
		
		JLabel lblNewLabel_3 = new JLabel("使用次数");
		
		JLabel lblNewLabel_4 = new JLabel("A区使用次数");
		
		JLabel lblNewLabel_5 = new JLabel("C区使用次数");
		
		useridText = new JTextField();
		useridText.setColumns(10);
		
		userpwdText = new JTextField();
		userpwdText.setColumns(10);
		
		usertimeText = new JTextField();
		usertimeText.setColumns(10);
		
		LocAtimeText = new JTextField();
		LocAtimeText.setColumns(10);
		
		LocCtimeText = new JTextField();
		LocCtimeText.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("用户姓名");
		
		JLabel lblNewLabel_7 = new JLabel("用户电话");
		
		JLabel lblNewLabel_8 = new JLabel("账户余额");
		
		JLabel lblNewLabel_9 = new JLabel("B区使用次数");
		
		JLabel lblNewLabel_10 = new JLabel("D区使用次数");
		
		usernameText = new JTextField();
		usernameText.setColumns(10);
		
		userphoneText = new JTextField();
		userphoneText.setColumns(10);
		
		userbalanceText = new JTextField();
		userbalanceText.setColumns(10);
		
		LocBtimeText = new JTextField();
		LocBtimeText.setColumns(10);
		
		LocDtimeText = new JTextField();
		LocDtimeText.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(53)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_5)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(LocCtimeText, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_4)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(LocAtimeText, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(usertimeText))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(userpwdText))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(useridText))
						.addComponent(lblNewLabel))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(userInfoText, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
							.addGap(29)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(59)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_8, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel_9, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
								.addComponent(lblNewLabel_10, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(userphoneText, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
										.addComponent(userbalanceText, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
										.addComponent(usernameText, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)))
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(LocDtimeText, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
										.addComponent(LocBtimeText))))))
					.addGap(85))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(userInfoText, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(useridText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_6)
						.addComponent(usernameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(userpwdText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_7)
						.addComponent(userphoneText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(usertimeText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_8)
						.addComponent(userbalanceText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(LocAtimeText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_9)
						.addComponent(LocBtimeText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5)
						.addComponent(LocCtimeText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_10)
						.addComponent(LocDtimeText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(32, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}
}
