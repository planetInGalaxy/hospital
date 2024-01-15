// -*- coding: utf-8 -*-

package hospital.login;

import hospital.frame.MainFunction;
import hospital.util.JdbcUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;

public class Login implements ActionListener {
	private Statement stmt = null;
	private JFrame frmD = new JFrame("yb2301_his管理系统");

	// 管理系统登陆界面
	private JLabel l1 = new JLabel("欢迎访问yb2301_his管理系统");
	private JLabel l2 = new JLabel("帐号:");
	private JLabel l3 = new JLabel("密码:");
	private JLabel l4 = new JLabel("帐户号不存在！");
	private JTextField t1 = new JTextField();
	private JPasswordField t2 = new JPasswordField();
	private JButton b1 = new JButton("登录");
	private JButton b2 = new JButton("取消");

	public static void main(String args[]) {
		new Login();
	}

	public Login() {
		// 登陆界面配置
		l1.setBounds(200, 30, 300, 40);
		l2.setBounds(200, 80, 50, 30);
		l3.setBounds(200, 130, 50, 30);
		l4.setBounds(220, 180, 150, 30);
		t1.setBounds(260, 80, 150, 30);
		t2.setBounds(260, 130, 150, 30);
		b1.setBounds(220, 220, 80, 30);
		b2.setBounds(320, 220, 80, 30);

		// Style adjustments
		//l1.setFont(new Font("Arial", Font.BOLD, 18));
		l1.setFont(new Font("SimSun", Font.PLAIN, 16));
		l1.setForeground(Color.BLUE);

		// Adding components to the frame
		frmD.add(l1);
		frmD.add(l2);
		frmD.add(l3);
		frmD.add(t1);
		frmD.add(t2);
		frmD.add(b1);
		frmD.add(b2);

		// Setting layout manager to null
		frmD.setLayout(null);

		// Frame settings
		frmD.setBounds(600, 300, 600, 300);
		frmD.getContentPane().setBackground(Color.WHITE);
		frmD.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmD.setResizable(false);
		frmD.setVisible(true);
		t2.setEchoChar('*');

		// 实现窗口关闭按钮的事件
		frmD.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		try {
			stmt = JdbcUtil.getConnection().createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Adding action listeners
		b1.addActionListener(this);
		b2.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

		if (source == b1) {
			String name = t1.getText();
			String pass = new String(t2.getPassword());
			if (!"".equals(name.trim()) && !"".equals(pass.trim())) {
				if ("admin".equals(name.trim()) && "2301".equals(pass.trim())) {
					new MainFunction();
					frmD.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "用户名或密码错误，请重新输入！", "系统提示", JOptionPane.ERROR_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, "请输入完整登录信息！", "系统提示", JOptionPane.ERROR_MESSAGE);
			}
		}

		if (source == b2) {
			System.exit(0);
		}
	}
}
