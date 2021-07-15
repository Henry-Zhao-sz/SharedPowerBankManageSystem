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
import javax.swing.JPasswordField;
import javax.swing.JTextArea;

public class SelectSpeUser2 extends JInternalFrame {
	private JTextField userNameText;
	private JTextField usertimeText;
	private JTextField LocAtimeText;
	private JTextField LocCtimeText;
	private JTextField userphoneText;
	private JTextField userbalanceText;
	private JTextField LocBtimeText;
	private JTextField LocDtimeText;
	private UserServiceImpl usi;
	private JPasswordField UserPwdText;
	private JTextField useridInfo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectSpeUser2 frame = new SelectSpeUser2();
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
	public SelectSpeUser2() {
		setTitle("查询指定用户信息");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 587, 409);
		
		JLabel lblNewLabel = new JLabel("请输入您的用户名");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		
		userNameText = new JTextField();
		userNameText.setColumns(10);
		
		JButton btnNewButton = new JButton("查询");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String uname = userNameText.getText();
				String pwd = new String(UserPwdText.getPassword());
				userDaoImpl udi=new userDaoImpl();
				user user1 = udi.queryByUnameAndUpass(uname, pwd);
				if(user1!=null) {
					useridInfo.setText(Integer.toString(user1.getUserID()));
					useridInfo.setFont(new Font("宋体",Font.BOLD,12));
					userphoneText.setText(user1.getUserPhone());
					userphoneText.setFont(new Font("宋体",Font.BOLD,12));
					usertimeText.setText(Integer.toString(user1.getUseTimes()));
					usertimeText.setFont(new Font("宋体",Font.BOLD,12));
					userbalanceText.setText(Double.toString(user1.getUserBalance()));
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
					useridInfo.setText("无");
					useridInfo.setFont(new Font("宋体",Font.BOLD,12));
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
		
		JLabel lblNewLabel_2 = new JLabel("请输入您的用户密码");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JLabel lblNewLabel_3 = new JLabel("使用次数");
		
		JLabel lblNewLabel_4 = new JLabel("A区使用次数");
		
		JLabel lblNewLabel_5 = new JLabel("C区使用次数");
		
		usertimeText = new JTextField();
		usertimeText.setColumns(10);
		
		LocAtimeText = new JTextField();
		LocAtimeText.setColumns(10);
		
		LocCtimeText = new JTextField();
		LocCtimeText.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("用户编号");
		
		JLabel lblNewLabel_7 = new JLabel("用户电话");
		
		JLabel lblNewLabel_8 = new JLabel("账户余额");
		
		JLabel lblNewLabel_9 = new JLabel("B区使用次数");
		
		JLabel lblNewLabel_10 = new JLabel("D区使用次数");
		
		userphoneText = new JTextField();
		userphoneText.setColumns(10);
		
		userbalanceText = new JTextField();
		userbalanceText.setColumns(10);
		
		LocBtimeText = new JTextField();
		LocBtimeText.setColumns(10);
		
		LocDtimeText = new JTextField();
		LocDtimeText.setColumns(10);
		
		UserPwdText = new JPasswordField();
		
		useridInfo = new JTextField();
		useridInfo.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(53)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel_5)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(LocCtimeText, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel_4)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(LocAtimeText, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(useridInfo, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
										.addComponent(usertimeText, 109, 109, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(85)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel)
								.addComponent(lblNewLabel_2))
							.addGap(9)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(59)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_8, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel_9, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
								.addComponent(lblNewLabel_10, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(userphoneText, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
								.addComponent(userbalanceText, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
								.addComponent(LocDtimeText, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
								.addComponent(LocBtimeText)))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(UserPwdText, GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
								.addComponent(userNameText, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE))
							.addGap(18)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGap(85))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(36)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel)
								.addComponent(userNameText, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_2)
								.addComponent(UserPwdText, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
							.addGap(34))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnNewButton)
							.addGap(65)))
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_7)
						.addComponent(userphoneText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_6)
						.addComponent(useridInfo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_8)
						.addComponent(userbalanceText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3)
						.addComponent(usertimeText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
