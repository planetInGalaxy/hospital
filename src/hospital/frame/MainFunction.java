// -*- coding: utf-8 -*-
package hospital.frame;

import java.awt.*;
import java.awt.event.*;

public class MainFunction implements ActionListener {

	private Frame frmX = new Frame("yb2301_his����ϵͳ");

	// ����ϵͳѡ�����
	private Label welcomeLabel = new Label("��ӭyb2301_his����ϵͳ");
	private Button patientInfoButton = new Button("�������Ϲ���");
	private Button priceButton = new Button("��ؼ۸����");
	private Button chufangButton = new Button("ҽ����������");
	private Button empButton = new Button("ҽԺԱ������");

	public MainFunction() {
		// ѡ���������
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

		// ʵ�ִ��ڹرհ�Ť���¼�
		frmX.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		frmX.setResizable(false);// �̶����ڵĴ�С
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
