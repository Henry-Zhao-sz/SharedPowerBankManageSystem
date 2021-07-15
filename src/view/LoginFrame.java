package view;

import java.awt.*;
import com.ssdut.spbs.dao.*;
import com.ssdut.spbs.dao.impl.*;
import com.ssdut.spbs.entity.*;
import com.ssdut.spbs.service.*;
import com.ssdut.spbs.service.Impl.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField userNameText;
	private JPasswordField PwdText;
	private JComboBox userTypeBox;
    private BaseServiceImpl bsi  = new BaseServiceImpl();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		setTitle("登录");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 552, 404);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("共享充电宝管理系统");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 25));
		lblNewLabel.setBounds(154, 43, 254, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("用户名");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(108, 109, 58, 35);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("密码");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(124, 173, 58, 35);
		contentPane.add(lblNewLabel_2);
		
		userNameText = new JTextField();
		userNameText.setBounds(213, 114, 151, 27);
		contentPane.add(userNameText);
		userNameText.setColumns(10);
		
		PwdText = new JPasswordField();
		PwdText.setBounds(213, 177, 151, 29);
		contentPane.add(PwdText);
		
		JLabel lblNewLabel_3 = new JLabel("权限");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(124, 241, 58, 27);
		contentPane.add(lblNewLabel_3);
		
		userTypeBox = new JComboBox();
		userTypeBox.setFont(new Font("宋体", Font.PLAIN, 16));
		userTypeBox.setModel(new DefaultComboBoxModel(new String[] {"用户", "管理员"}));
		userTypeBox.setBounds(213, 243, 101, 23);
		contentPane.add(userTypeBox);
		
		JButton btnNewButton = new JButton("登录");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginActionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 15));
		btnNewButton.setBounds(69, 299, 97, 35);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("注册");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegActionPerformed(e);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 15));
		btnNewButton_1.setBounds(217, 299, 97, 35);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("重置");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResetActionPerformed(e);
			}
		});
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 15));
		btnNewButton_2.setBounds(366, 299, 97, 35);
		contentPane.add(btnNewButton_2);
		this.setLocationRelativeTo(null);  // 居中显示
	}

	/**
	 * 对注册事件的处理
	 * @param e
	 */
	protected void RegActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.dispose();//销毁当前窗体
		new RegFrm().setVisible(true); //显示窗体
	}

	/**
	 * 对重置事件的处理
	 * @param e
	 */
	protected void ResetActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		reset();
	}
	
	/**
	 * 重置
	 */
	public void reset() {
		this.userNameText.setText("");
		this.PwdText.setText("");
		
	}

	/**
	 * 对登录事件的处理
	 * @param e
	 */
	protected void LoginActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String name = this.userNameText.getText();
		String pwd = new String(this.PwdText.getPassword());
		//判断用户名和密码均不为空
		if(name.length()==0) {
			JOptionPane.showMessageDialog(null, "用户名不能为空");
			return;
		}
		if(pwd.length()==0) {
			JOptionPane.showMessageDialog(null, "密码不能为空");
			return;
		}
		String qxValue = (String)this.userTypeBox.getSelectedItem();
		if(qxValue.equals("用户")) {
			user user1=bsi.checkLogin(name, pwd);
		    if(user1!=null) {
			     dispose();
			     new UserFrm().setVisible(true);
		    }
		    else {
			     JOptionPane.showMessageDialog(null, "登录失败,用户名或密码错误");
		    }
		}
		else {
			admin admin1=bsi.checkAdminLogin(name, pwd);
			if(admin1!=null) {
			     dispose();
				 new AdminFrm().setVisible(true);
		    }
		    else {
			     JOptionPane.showMessageDialog(null, "登录失败,用户名或密码错误");
		    }
		}
		
	}
}
