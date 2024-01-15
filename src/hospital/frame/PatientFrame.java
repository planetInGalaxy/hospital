// -*- coding: utf-8 -*-
package hospital.frame;
import hospital.util.JdbcUtil;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class PatientFrame implements ActionListener {
	Statement stmt = null;
	String sql;
	Frame frm1 = new Frame("yb2301_his����ϵͳ");

	// ����ϵͳ�������Ͻ���
	// �����˻�������
	Label labe1 = new Label("    �����˻������ϣ�  ��ע�⣺��ѯ��ɾ�������벡����������");
	Button btn1 = new Button("���˱��");
	Button btn2 = new Button("����");
	Button btn3 = new Button("�Ա�");
	Button btn4 = new Button("��������");
	Button btn5 = new Button("������");
	Button btn6 = new Button("����");
	Button btn7 = new Button("סԺ���");
	Button btn8 = new Button("Ԥ��סԺ��(Ԫ)");

	Button addA = new Button("��¼��");
	Button delA = new Button("��ɾ��");
	// Button updateA = new Button("������");
	Button qryA = new Button("����ѯ");

	TextField txf1 = new TextField();
	TextField txf2 = new TextField();
	TextField txf3 = new TextField();
	TextField txf4 = new TextField();
	TextField txf5 = new TextField();
	TextField txf6 = new TextField();
	TextField txf7 = new TextField();
	TextField txf8 = new TextField();

	// �²��˾�ҽ����
	Label labe2 = new Label("    �²��˾�ҽ��������ע�⣺��ѯ��ɾ�������벡��������");
	Button btnl1 = new Button("���˱��");
	Button btnl2 = new Button("��������");
	Button btnl3 = new Button("��ҽ����");
	Button btnl4 = new Button("����ҽ��");
	Button btnl5 = new Button("����");
	Button btnl6 = new Button("�������");
	Button btnl7 = new Button("��ҩ���");

	Button addB = new Button("��¼��");
	Button delB = new Button("��ɾ��");
	Button qrbB = new Button("�²�ѯ");

	TextField lst11 = new TextField();
	TextField lst12 = new TextField();
	TextField lst13 = new TextField();
	TextField lst14 = new TextField();
	TextField lst15 = new TextField();
	TextField lst16 = new TextField();
	TextField lst17 = new TextField();

	// �ò����շѹ���
	Label labe3 = new Label("    �ò����շѹ�����ע�⣺��ѯ��ɾ�������벡�˱�ţ�������λ��Ԫ");
	Button btnk1 = new Button("���˱��");
	Button btnk2 = new Button("ҩ�����");
	Button btnk3 = new Button("�Һŷ�");
	Button btnk4 = new Button("���÷�");
	Button btnk5 = new Button("�����");

	Button addC = new Button("��¼��");
	Button delC = new Button("��ɾ��");
	Button qryC = new Button("�ò�ѯ");

	TextField lst21 = new TextField();
	TextField lst22 = new TextField();
	TextField lst23 = new TextField();
	TextField lst24 = new TextField();
	TextField lst25 = new TextField();



	
	public void clearFrameA(){
		 txf1.setText("");
		 txf2.setText("");
		 txf3.setText("");
		 txf4.setText("");
		 txf5.setText("");
		 txf6.setText("");
		 txf7.setText("");
		 txf8.setText("");
	}
	public void clearFrameB(){

		 lst11.setText("");
		 lst12.setText("");
		 lst13.setText("");
		 lst14.setText("");
		 lst15.setText("");
		 lst16.setText("");
		 lst17.setText("");
	}
	public void clearFrameC(){
		 lst21.setText("");
		 lst22.setText("");
		 lst23.setText("");
		 lst24.setText("");
		 lst25.setText("");
	}
	public PatientFrame() {
		addA.addActionListener(this);
		delA.addActionListener(this);
		// updateA.addActionListener(this);
		qryA.addActionListener(this);
		addB.addActionListener(this);
		delB.addActionListener(this);
		// updateB.addActionListener(this);
		qrbB.addActionListener(this);
		addC.addActionListener(this);
		delC.addActionListener(this);
		// udpateC.addActionListener(this);
		qryC.addActionListener(this);

		// �������Ϲ������
		// 1����
		labe1.setBounds(0, 55, 1024, 20);
		btn1.setBounds(5, 75, 95, 15);
		txf1.setBounds(5, 90, 95, 20);
		btn2.setBounds(100, 75, 80, 15);
		txf2.setBounds(100, 90, 80, 20);
		btn3.setBounds(180, 75, 40, 15);
		txf3.setBounds(180, 90, 40, 20);
		btn4.setBounds(220, 75, 100, 15);
		txf4.setBounds(220, 90, 100, 20);
		btn5.setBounds(320, 75, 120, 15);
		txf5.setBounds(320, 90, 120, 20);
		btn6.setBounds(440, 75, 80, 15);
		txf6.setBounds(440, 90, 80, 20);
		btn7.setBounds(520, 75, 100, 15);
		txf7.setBounds(520, 90, 100, 20);
		btn8.setBounds(620, 75, 100, 15);
		txf8.setBounds(620, 90, 100, 20);
		addA.setBounds(105, 115, 50, 20);
		delA.setBounds(260, 115, 50, 20);
// updateA.setBounds(415, 105, 50, 20);
		qryA.setBounds(415, 115, 50, 20);


		
		frm1.add(labe1);
		frm1.add(btn1);
		frm1.add(btn2);
		frm1.add(btn3);
		frm1.add(btn4);
		frm1.add(btn5);
		frm1.add(btn6);
		frm1.add(btn7);
		frm1.add(btn8);
		frm1.add(addA);
		frm1.add(delA);
		// frm1.add(updateA);
		frm1.add(qryA);

		frm1.add(txf1);
		frm1.add(txf2);
		frm1.add(txf3);
		frm1.add(txf4);
		frm1.add(txf5);
		frm1.add(txf6);
		frm1.add(txf7);
		frm1.add(txf8);

		// 2����
		labe2.setBounds(0, 145, 1024, 20);
		btnl1.setBounds(5, 165, 95, 15);
		btnl2.setBounds(100, 165, 80, 15);
		btnl3.setBounds(180, 165, 60, 15);
		btnl4.setBounds(240, 165, 80, 15);
		btnl5.setBounds(320, 165, 40, 15);
		btnl6.setBounds(360, 165, 80, 15);
		btnl7.setBounds(440, 165, 280, 15);
		addB.setBounds(105, 210, 50, 20);
		delB.setBounds(260, 210, 50, 20);
		// updateB.setBounds(415, 210, 50, 20);
		qrbB.setBounds(415, 210, 50, 20);
		lst11.setBounds(5, 180, 95, 20);
		lst12.setBounds(100, 180, 80, 20);
		lst13.setBounds(180, 180, 60, 20);
		lst14.setBounds(240, 180, 80, 20);
		lst15.setBounds(320, 180, 40, 20);
		lst16.setBounds(360, 180, 80, 20);
		lst17.setBounds(440, 180, 280, 20);

		frm1.add(labe2);
		frm1.add(btnl1);
		frm1.add(btnl2);
		frm1.add(btnl3);
		frm1.add(btnl4);
		frm1.add(btnl5);
		frm1.add(btnl6);
		frm1.add(btnl7);
		frm1.add(addB);
		frm1.add(delB);
		// frm1.add(updateB);
		frm1.add(qrbB);

		frm1.add(lst11);
		frm1.add(lst12);
		frm1.add(lst13);
		frm1.add(lst14);
		frm1.add(lst15);
		frm1.add(lst16);
		frm1.add(lst17);

		// 3����
		labe3.setBounds(0, 270, 1024, 20);
		btnk1.setBounds(5, 290, 95, 15);
		btnk2.setBounds(100, 290, 120, 15);
		btnk3.setBounds(220, 290, 120, 15);
		btnk4.setBounds(340, 290, 120, 15);
		btnk5.setBounds(460, 290, 120, 15);
		// btnk6.setBounds(580,290,140,15);
		addC.setBounds(105, 335, 50, 20);
		delC.setBounds(260, 335, 50, 20);
		// udpateC.setBounds(415, 335, 50, 20);
		qryC.setBounds(415, 335, 50, 20);
		lst21.setBounds(5, 305, 95, 20);
		lst22.setBounds(100, 305, 120, 20);
		lst23.setBounds(220, 305, 120, 20);
		lst24.setBounds(340, 305, 120, 20);
		lst25.setBounds(460, 305, 120, 20);
		// lst26.setBounds(580,305,140,20);

		frm1.add(labe3);
		frm1.add(btnk1);
		frm1.add(btnk2);
		frm1.add(btnk3);
		frm1.add(btnk4);
		frm1.add(btnk5);
		// frm1.add(btnk6);
		frm1.add(addC);
		frm1.add(delC);
		// frm1.add(udpateC);
		frm1.add(qryC);
		frm1.add(lst21);
		frm1.add(lst22);
		frm1.add(lst23);
		frm1.add(lst24);
		frm1.add(lst25);
		// frm1.add(lst26);

		frm1.setLayout(null);
		frm1.setBounds(500, 200, 725, 395);
		frm1.setBackground(Color.ORANGE);
		frm1.setVisible(true);

		// ʵ�ִ��ڹرհ�Ť���¼�
		frm1.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				frm1.dispose();
			}
		});

		frm1.setResizable(false);// �̶����ڵĴ�С

		try {
			stmt = JdbcUtil.getConnection().createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void actionPerformed(ActionEvent e) {
		Object soruce = e.getSource();
		ResultSet rs = null;
		if (soruce == addA) {
			try {
				if (txf1.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "���˱�Ų���Ϊ�գ�");
					return;
				} else if (txf2.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "��������Ϊ�գ�");
					return;
				}

				sql = "select * from CS2301_patient where Pno='"
						+ txf1.getText().trim() + "'";
				rs = stmt.executeQuery(sql);
				if (rs.next()) {
					JOptionPane.showMessageDialog(null, "���˱�š�"
							+ txf1.getText().trim() + "���Ѿ����ڣ����������룡");
					return;
				}
				sql = "insert into CS2301_patient(Pno,Pname,Psex,Pbirthday,Pplace,Pbirthplace,Pcondition,Pbudget) values('"
						+ txf1.getText().trim()
						+ "','"
						+ txf2.getText().trim()
						+ "','"
						+ txf3.getText().trim()
						+ "','"
						+ txf4.getText().trim()
						+ "','"
						+ txf5.getText().trim()
						+ "','"
						+ txf6.getText().trim()
						+ "','"
						+ txf7.getText().trim()
						+ "','"
						+ txf8.getText().trim()
						+ "')";
				stmt.executeUpdate(sql);
				JOptionPane.showMessageDialog(null, "¼����Ϣ�ɹ���");
				clearFrameA();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (soruce == delA) {
			try {

				if (txf2.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "��������Ҫɾ���Ĳ���������");
					return;
				}

				sql = "delete from CS2301_patient where Pname='"
						+ txf2.getText().trim() + "'";
				int result = stmt.executeUpdate(sql);
				if (result == 0) {
					JOptionPane.showMessageDialog(null, "û�в�ѯ����"
							+ txf2.getText().trim() + "��");
				} else {
					JOptionPane.showMessageDialog(null, "��ɾ����"
							+ txf2.getText().trim() + "������Ϣ");
					clearFrameA();
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (soruce == qryA) {
			try {

				if (txf2.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "��������Ҫ��ѯ�Ĳ���������");
					return;
				}

				sql = "select * from CS2301_patient where Pname='"
						+ txf2.getText().trim() + "'";
				rs = stmt.executeQuery(sql);
				if (rs.next()) {
					txf1.setText(rs.getString(1));
					txf2.setText(rs.getString(2));
					txf3.setText(rs.getString(3));
					txf4.setText(rs.getString(4));
					txf5.setText(rs.getString(5));
					txf6.setText(rs.getString(6));
					txf7.setText(rs.getString(7));
					txf8.setText(rs.getString(8));
				} else {
					JOptionPane.showMessageDialog(null, "û�в�ѯ����"
							+ txf2.getText().trim() + "������Ϣ��");
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		} else if (soruce == addB) {
			try {

				
				if (lst11.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "���˱�Ų���Ϊ�գ�");
					return;
				} else if (lst12.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "��������Ϊ�գ�");
					return;
				}
				
				sql = "select * from CS2301_hospitalize where Pname='"
					+ lst12.getText().trim() + "'";
				rs = stmt.executeQuery(sql);
				if (rs.next()) {
					JOptionPane.showMessageDialog(null, "���˱�š�"
							+ lst12.getText().trim() + "���Ѿ����ڣ����������룡");
					return;
				}

				sql = "insert into CS2301_hospitalize(Pno,Pname,Dsubject,Dmdoctor,Dcause,Dpresno,Dpill) values('"
						+ lst11.getText().trim()
						+ "','"
						+ lst12.getText().trim()
						+ "','"
						+ lst13.getText().trim()
						+ "','"
						+ lst14.getText().trim()
						+ "','"
						+ lst15.getText().trim()
						+ "','"
						+ lst16.getText().trim()
						+ "','"
						+ lst17.getText().trim() + "')";
				stmt.executeUpdate(sql);

				JOptionPane.showMessageDialog(null, "¼����Ϣ�ɹ���");
				clearFrameB();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (soruce == delB) {
			try {

				if (lst12.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "��������Ҫɾ���Ĳ���������");
					return;
				}

				sql = "delete from CS2301_hospitalize where Pname='"
						+ lst12.getText().trim() + "'";
				int result = stmt.executeUpdate(sql);
				if (result == 0) {
					JOptionPane.showMessageDialog(null, "û�в�ѯ����"
							+ lst12.getText().trim() + "��");
				} else {
					JOptionPane.showMessageDialog(null, "��ɾ����"
							+ lst12.getText().trim() + "������Ϣ");
					clearFrameB();
				}

			} catch (Exception e1) {
				e1.printStackTrace();
			}

		} else if (soruce == qrbB) {
			try {

				if (lst12.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "��������Ҫ��ѯ�Ĳ���������");
					return;
				}

				sql = "select * from CS2301_hospitalize where Pname='"
						+ lst12.getText().trim() + "'";
				rs = stmt.executeQuery(sql);
				if (rs.next()) {
					lst11.setText(rs.getString(1));
					lst12.setText(rs.getString(2));
					lst13.setText(rs.getString(3));
					lst14.setText(rs.getString(4));
					lst15.setText(rs.getString(5));
					lst16.setText(rs.getString(6));
					lst17.setText(rs.getString(7));
				} else {
					JOptionPane.showMessageDialog(null, "û�в�ѯ����"
							+ lst12.getText().trim() + "������Ϣ��");
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (soruce == addC) {
			try {

				if (lst21.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "���˱�Ų���Ϊ�գ�");
					return;
				}
				
				sql = "select * from CS2301_Charge where Pno='"
					+ lst21.getText().trim() + "'";
				rs = stmt.executeQuery(sql);
				if (rs.next()) {
					JOptionPane.showMessageDialog(null, "���˱�š�"
							+ lst21.getText().trim() + "���Ѿ����ڣ����������룡");
					return;
				}

				sql = "insert into CS2301_Charge(Pno,Cmedicine,Creg,Cdisposal,Cexamine) values('"
						+ lst21.getText().trim()
						+ "','"
						+ lst22.getText().trim()
						+ "','"
						+ lst23.getText().trim()
						+ "','"
						+ lst24.getText().trim()
						+ "','"
						+ lst25.getText().trim() + "')";
				stmt.executeUpdate(sql);
				JOptionPane.showMessageDialog(null, "¼����Ϣ�ɹ���");
				clearFrameC();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (soruce == delC) {
			try {

				if (lst21.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "��������Ҫɾ���Ĳ��˱�ţ�");
					return;
				}
				sql = "delete from CS2301_Charge where Pno='" + lst21.getText().trim()
						+ "'";

				int result = stmt.executeUpdate(sql);
				if (result == 0) {
					JOptionPane.showMessageDialog(null, "û�в�ѯ����"
							+ lst21.getText().trim() + "��");
				} else {
					JOptionPane.showMessageDialog(null, "��ɾ����"
							+ lst21.getText().trim() + "������Ϣ");
					clearFrameC();
				}

			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}

		else if (soruce == qryC) {
			try {

				if (lst21.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "��������Ҫ��ѯ�Ĳ��˱�ţ�");
					return;
				}
				sql = "select * from CS2301_Charge where Pno='"
						+ lst21.getText().trim() + "'";
				rs = stmt.executeQuery(sql);
				if (rs.next()) {
					lst21.setText(rs.getString(1));
					lst22.setText(rs.getString(2));
					lst23.setText(rs.getString(3));
					lst24.setText(rs.getString(4));
					lst25.setText(rs.getString(5));
				} else {
					JOptionPane.showMessageDialog(null, "û�в�ѯ����"
							+ lst21.getText().trim() + "������Ϣ��");
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
}
