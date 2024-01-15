// -*- coding: utf-8 -*-
package hospital.frame;

import hospital.util.JdbcUtil;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class MedicineFrame implements ActionListener {
	Statement stmt = null;
	String sql;
	Frame frm2 = new Frame("yb2301_his����ϵͳ");

	// ҩƷ,�����շ�
	Label labe6 = new Label("    ���շѼ۸����");
	Label labe7 = new Label("    ҩ��۸�(��λ:Ԫ)(ע����ѯ��ɾ��ʱ������ҩ����)");
	Label labe8 = new Label("    ����۸�(��λ:Ԫ)(ע����ѯ��ɾ��ʱ�����뻯����)");
	Button btnh1 = new Button("ҩ�����ƣ�");
	Button btnh2 = new Button("ҩ��۸�");
	Button btnh3 = new Button("�������ͣ�");
	Button btnh4 = new Button("����۸�");

	Button qry1 = new Button("D1��ѯ");
	Button del1 = new Button("D1ɾ��");
	Button add1 = new Button("D1¼��");
	Button qry2 = new Button("D2��ѯ");
	Button del2 = new Button("D2ɾ��");
	Button add2 = new Button("D2¼��");

	Button btnh13 = new Button("ҩ����");
	Button btnh14 = new Button("������");
	TextField lst35 = new TextField();
	TextField lst31 = new TextField();
	TextField lst32 = new TextField();

	TextField lst36 = new TextField();
	TextField lst33 = new TextField();
	TextField lst34 = new TextField();



	public void clearFrameM() {
		lst35.setText("");
		lst31.setText("");
		lst32.setText("");
	}

	public void clearFrameH() {
		lst36.setText("");
		lst33.setText("");
		lst34.setText("");
	}

	public MedicineFrame() {

		// ҩƷ,����۸��ѯϵͳ
		labe6.setBounds(0, 35, 300, 20);
		labe7.setBounds(0, 55, 350, 15);
		labe8.setBounds(0, 130, 350, 15);
		btnh1.setBounds(125, 70, 100, 20);
		btnh2.setBounds(230, 70, 100, 20);
		btnh3.setBounds(125, 145, 100, 20);
		btnh4.setBounds(230, 145, 100, 20);

		add1.setBounds(380, 70, 50, 18);
		qry1.setBounds(380, 92, 50, 18);
		del1.setBounds(431, 92, 50, 18);

		add2.setBounds(380, 145, 50, 18);
		qry2.setBounds(380, 167, 50, 18);
		del2.setBounds(431, 167, 50, 18);

		lst31.setBounds(125, 90, 100, 20);
		lst32.setBounds(230, 90, 100, 20);
		lst33.setBounds(125, 165, 100, 20);
		lst34.setBounds(230, 165, 100, 20);

		btnh13.setBounds(25, 70, 100, 20);
		btnh14.setBounds(25, 145, 100, 20);
		lst35.setBounds(25, 90, 100, 20);
		lst36.setBounds(25, 165, 100, 20);
		frm2.add(btnh13);
		frm2.add(btnh14);
		frm2.add(lst35);
		frm2.add(lst36);

		frm2.add(labe6);
		frm2.add(labe7);
		frm2.add(labe8);
		frm2.add(btnh1);
		frm2.add(btnh2);
		frm2.add(btnh3);
		frm2.add(btnh4);
		frm2.add(qry1);
		frm2.add(del1);
		frm2.add(qry2);
		frm2.add(del2);
		frm2.add(add1);
		frm2.add(add2);
		frm2.add(lst31);
		frm2.add(lst32);
		frm2.add(lst33);
		frm2.add(lst34);

		qry1.addActionListener(this);
		del1.addActionListener(this);
		qry2.addActionListener(this);
		del2.addActionListener(this);
		add1.addActionListener(this);
		add2.addActionListener(this);
		btnh13.addActionListener(this);
		btnh14.addActionListener(this);

		frm2.setLayout(null);
		frm2.setBounds(500, 200, 510, 270);
		frm2.setBackground(Color.ORANGE);
		frm2.setVisible(true);

		frm2.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				frm2.dispose();
			}
		});

		frm2.setResizable(false);// �̶����ڵĴ�С

		try {
			Connection conn = JdbcUtil.getConnection();
			stmt = conn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void actionPerformed(ActionEvent e) {
		Object soruce = e.getSource();
		ResultSet rs = null;
		String mId = lst35.getText().trim();
		String hId = lst36.getText().trim();

		if (soruce == qry1) {
			try {
				if (mId.equals("")) {
					JOptionPane.showMessageDialog(null, "��������Ҫ��ѯ��ҩ���ţ�");
					return;
				}
				sql = "select * from CS2301_Medicine where Mno='" + mId + "'";
				rs = stmt.executeQuery(sql);
				if (rs.next()) {
					lst31.setText(rs.getString(2));
					lst32.setText(rs.getString(3));
					lst35.setText(rs.getString(1));
				} else {
					JOptionPane.showMessageDialog(null, "û�в�ѯ����" + mId + "����");
				}

			} catch (Exception e1) {
				e1.printStackTrace();
			}

		} else if (soruce == del1) {
			try {
				if (mId.equals("")) {
					JOptionPane.showMessageDialog(null, "��������Ҫɾ����ҩ���ţ�");
					return;
				}
				sql = "delete from CS2301_Medicine where Mno='" + mId + "'";
				int result = stmt.executeUpdate(sql);
				if (result == 0) {
					JOptionPane.showMessageDialog(null, "û�в�ѯ����" + mId + "����");
				} else {
					JOptionPane.showMessageDialog(null, "��ɾ����" + mId + "������Ϣ��");
					clearFrameM();
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (soruce == add1) {
			try {
				if (mId.equals("")) {
					JOptionPane.showMessageDialog(null, "ҩ���Ų���Ϊ�գ�");
					return;
				}

				sql = "select * from CS2301_Medicine where Mno='" + mId + "'";
				rs = stmt.executeQuery(sql);
				if (rs.next()) {
					JOptionPane.showMessageDialog(null, "ҩ���š�" + mId
							+ "���Ѿ����ڣ����������룡");
					return;
				}

				sql = "insert into CS2301_Medicine(Mno,Mname,Mprice) values('"
						+ lst35.getText().trim() + "','"
						+ lst31.getText().trim() + "','"
						+ lst32.getText().trim() + "')";
				stmt.executeUpdate(sql);
				JOptionPane.showMessageDialog(null, "¼����Ϣ�ɹ���");
				clearFrameM();
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		} else if (soruce == qry2) {
			try {

				if (hId.equals("")) {
					JOptionPane.showMessageDialog(null, "��������Ҫ��ѯ�Ļ����ţ�");
					return;
				}

				sql = "select * from Examine where Eno='" + hId + "'";
				rs = stmt.executeQuery(sql);
				if (rs.next()) {
					lst33.setText(rs.getString(2));
					lst34.setText(rs.getString(3));
					lst36.setText(rs.getString(1));
				} else {
					JOptionPane.showMessageDialog(null, "û�в�ѯ����" + hId + "����");
				}

			} catch (Exception e1) {
				e1.printStackTrace();
			}

		} else if (soruce == del2) {
			try {

				if (hId.equals("")) {
					JOptionPane.showMessageDialog(null, "��������Ҫɾ����ҩ���ţ�");
					return;
				}
				sql = "delete from Examine where Ename='"
						+ lst33.getText().trim() + "'";
				int result = stmt.executeUpdate(sql);
				if (result == 0) {
					JOptionPane.showMessageDialog(null, "û�в�ѯ����" + hId + "����");
				} else {
					JOptionPane.showMessageDialog(null, "��ɾ����" + hId + "������Ϣ��");
					clearFrameH();
				}

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (soruce == add2) {
			try {

				if (hId.equals("")) {
					JOptionPane.showMessageDialog(null, "�����Ų���Ϊ�գ�");

					return;
				}

				sql = "select * from Examine where Eno='" + hId + "'";
				rs = stmt.executeQuery(sql);
				if (rs.next()) {
					JOptionPane.showMessageDialog(null, "�����š�" + hId
							+ "���Ѿ����ڣ����������룡");
					return;
				}

				sql = "insert into Examine(Eno,Ename,Eprice) values('"
						+ lst36.getText().trim() + "','"
						+ lst33.getText().trim() + "','"
						+ lst34.getText().trim() + "')";
				stmt.executeUpdate(sql);
				JOptionPane.showMessageDialog(null, "¼����Ϣ�ɹ���");
				clearFrameH();
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}

	}

}
