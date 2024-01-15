// -*- coding: utf-8 -*-
package hospital.frame;

import java.awt.*;
import java.awt.event.*;

public class MainFunction implements ActionListener {

	private Frame frmX = new Frame("yb2301_his管理系统");

	// 管理系统选择界面
	private Label welcomeLabel = new Label("欢迎yb2301_his管理系统");
	private Button patientInfoButton = new Button("病人资料管理");
	private Button priceButton = new Button("相关价格管理");
	private Button chufangButton = new Button("医生处方管理");
	private Button empButton = new Button("医院员工管理");

	public MainFunction() {
		// 选择界面配置
		welcomeLabel.setBounds(90, 50, 200, 30);
		patientInfoButton.setBounds(50, 120, 150, 40);
		priceButton.setBounds(210, 120, 150, 40);
		chufangButton.setBounds(50, 200, 150, 40);
		empButton.setBounds(210, 200, 150, 40);

		// Setting fonts for better visibility
		Font buttonFont = new Font("Arial", Font.PLAIN, 16);
		welcomeLabel.setFont(new Font("Arial", Font.BOLD, 18));
		patientInfoButton.setFont(buttonFont);
		priceButton.setFont(buttonFont);
		chufangButton.setFont(buttonFont);
		empButton.setFont(buttonFont);

		frmX.add(welcomeLabel);
		frmX.add(patientInfoButton);
		frmX.add(priceButton);
		frmX.add(chufangButton);
		frmX.add(empButton);

		patientInfoButton.addActionListener(this);
		priceButton.addActionListener(this);
		chufangButton.addActionListener(this);
		empButton.addActionListener(this);

		frmX.setLayout(null);
		frmX.setBackground(new Color(255, 223, 186)); // Light Orange
		frmX.setBounds(400, 150, 450, 300); // Adjusted size
		frmX.setVisible(true);

		// 实现窗口关闭按扭的事件
		frmX.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		frmX.setResizable(false);// 固定窗口的大小
	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == patientInfoButton) {
			new PatientFrame();
		}
		if (source == priceButton) {
			new MedicineFrame();
		}
		if (source == chufangButton) {
			new ChufangFrame();
		}
		if (source == empButton) {
			new EmpFrame();
		}
	}
}
