package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.*;
import com.ssdut.spbs.dao.*;
import com.ssdut.spbs.dao.impl.*;
import com.ssdut.spbs.entity.*;
import com.ssdut.spbs.service.*;
import com.ssdut.spbs.service.Impl.*;

public class RegFrm extends JFrame {

	private JPanel contentPane;
	private JTextField IDtext;
	private JTextField nameText;
	private JPasswordField PwdText;
	private JTextField phoneText;
    private BaseServiceImpl bsi=new BaseServiceImpl();
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegFrm frame = new RegFrm();
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
	public RegFrm() {
		setTitle("用户注册");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 624, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("用户注册");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 25));
		
		JLabel lblNewLabel_1 = new JLabel("账户编号");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel lblNewLabel_2 = new JLabel("用户姓名");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel lblNewLabel_3 = new JLabel("用户密码");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel lblNewLabel_4 = new JLabel("手机号码");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 18));
		
		IDtext = new JTextField();
		IDtext.setColumns(10);
		
		nameText = new JTextField();
		nameText.setColumns(10);
		
		PwdText = new JPasswordField();
		
		phoneText = new JTextField();
		phoneText.setColumns(10);
		
		JButton btnNewButton = new JButton("注册");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegActionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 18));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(115)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_4, GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblNewLabel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
									.addGap(180))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(29)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(IDtext, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
										.addComponent(PwdText)
										.addComponent(nameText)
										.addComponent(phoneText))
									.addGap(190))))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(238)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(265, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(34)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addGap(29)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_2)
								.addComponent(nameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(IDtext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(39)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_3)
						.addComponent(PwdText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(40)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(phoneText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4))
					.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(20))
		);
		contentPane.setLayout(gl_contentPane);
		this.setLocationRelativeTo(null);  // 居中显示
	}

	/**
	 * 注册事件的处理
	 * @param e
	 */
	protected void RegActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String userid=this.IDtext.getText();
		String userName=this.nameText.getText();
		String usePwd=new String(this.PwdText.getPassword());  
	    String userPhone=this.phoneText.getText();
	    user user1=new user();
	    user1.setUserID(Integer.parseInt(userid));
	    user1.setUserName(userName);
	    user1.setUserPwd(usePwd);
	    user1.setUserPhone(userPhone);
	    
	    if(userid.length()==0) {
			JOptionPane.showMessageDialog(null, "用户编号不能为空");
			return;
		}
	    if(userName.length()==0) {
			JOptionPane.showMessageDialog(null, "用户名不能为空");
			return;
		}
		if(usePwd.length()==0) {
			JOptionPane.showMessageDialog(null, "密码不能为空");
			return;
		}
		if(userPhone.length()==0) {
			JOptionPane.showMessageDialog(null, "电话不能为空");
			return;
		}
	    if(bsi.checkRegValid(Integer.parseInt(userid))==1) {
	    	JOptionPane.showMessageDialog(null, "用户编号与已有用户重复，请重新输入");
	    	IDtext.setText("");
	    	nameText.setText("");
	    	PwdText.setText("");
	    	phoneText.setText("");
	    }
	    else {
	    	boolean bl=bsi.register(user1);
	    if(bl==true) {   //注册成功
	    	JOptionPane.showMessageDialog(null, "注册成功");
	    	try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	dispose();
	    	new LoginFrame().setVisible(true);
	    } else {
	    	JOptionPane.showMessageDialog(null, "注册失败");
	    }
	    }
	    
	}
}
