// -*- coding: utf-8 -*-
package hospital.frame;

import hospital.util.JdbcUtil;

import java.awt.*;
import java.awt.event.*;
import java.awt.Button;
import java.awt.Label;
import java.awt.TextField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class EmpFrame implements ActionListener {
	Statement stmt = null;
	String sql;
	Frame frm4 = new Frame("yb2301_his����ϵͳ");

	// ҽԺְԱ�������
	Label labe12 = new Label("    ��ҽԺ����Ա��������ע�⣺��ѯ��ɾ��������������");
	Label labe13 = new Label("    ��        ��:");
	Label labe14 = new Label("    �������:");
	Label labe15 = new Label("    ��       ��:");
	Label labe16 = new Label("    ��       ��:");
	Label labe17 = new Label("    ��ϵ�绰:");
	Label labe18 = new Label("    ְ       ��:");
	Label labe19 = new Label("    ѧ       ��:");
	Label labe20 = new Label("    ��������:");
	Label labe21 = new Label("    ��������:");

	TextField lst51 = new TextField();
	TextField lst52 = new TextField();
	TextField lst53 = new TextField();
	TextField lst54 = new TextField();
	TextField lst55 = new TextField();
	TextField lst56 = new TextField();
	TextField lst57 = new TextField();
	TextField lst58 = new TextField();
	TextArea txa2 = new TextArea();

	Button qry = new Button("E ��ѯ");
	Button del = new Button("E ɾ��");
	Button add = new Button("E ¼��");

	public void clearFrame() {
		lst51.setText("");
		lst52.setText("");
		lst53.setText("");
		lst54.setText("");
		lst55.setText("");
		lst56.setText("");
		lst57.setText("");
		lst58.setText("");
		txa2.setText("");
	}



	public EmpFrame() {

		// ҽԺԱ���������
		labe12.setBounds(50, 55, 375, 20);
		labe13.setBounds(50, 80, 80, 20);
		labe14.setBounds(50, 115, 80, 20);
		labe15.setBounds(50, 145, 80, 20);
		labe16.setBounds(340, 175, 80, 20);
		labe17.setBounds(50, 175, 80, 20);
		labe18.setBounds(340, 205, 80, 20);
		labe19.setBounds(50, 205, 80, 20);
		labe20.setBounds(50, 235, 80, 20);
		labe21.setBounds(50, 315, 80, 20);
		lst51.setBounds(140, 85, 120, 20);
		lst52.setBounds(140, 115, 120, 20);
		lst53.setBounds(140, 145, 120, 20);
		lst54.setBounds(420, 175, 120, 20);
		lst55.setBounds(140, 175, 120, 20);
		lst56.setBounds(420, 205, 120, 20);
		lst57.setBounds(140, 205, 120, 20);
		lst58.setBounds(140, 235, 400, 70);
		txa2.setBounds(70, 335, 475, 135);
		qry.setBounds(340, 475, 50, 20);
		del.setBounds(215, 475, 50, 20);
		add.setBounds(90, 475, 50, 20);
		frm4.add(labe12);
		frm4.add(labe13);
		frm4.add(labe14);
		frm4.add(labe15);
		frm4.add(labe16);
		frm4.add(labe17);
		frm4.add(labe18);
		frm4.add(labe19);
		frm4.add(labe20);
		frm4.add(labe21);
		frm4.add(lst51);
		frm4.add(lst52);
		frm4.add(lst53);
		frm4.add(lst54);
		frm4.add(lst55);
		frm4.add(lst56);
		frm4.add(lst57);
		frm4.add(lst58);
		// frm4.add(lst59);
		frm4.add(txa2);
		frm4.add(qry);
		frm4.add(del);
		frm4.add(add);
		qry.addActionListener(this);
		del.addActionListener(this);
		add.addActionListener(this);

		frm4.setLayout(null);
		frm4.setBounds(500, 200, 610, 540);
		frm4.setBackground(Color.ORANGE);
		frm4.setVisible(true);

		// ʵ�ִ��ڹرհ�Ť���¼�
		frm4.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				frm4.dispose();
			}
		});

		frm4.setResizable(false);// �̶����ڵĴ�С

		try {
			stmt = JdbcUtil.getConnection().createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent e) {
		Object soruce = e.getSource();
		ResultSet rs = null;
		String _name = lst51.getText().trim();
		if (soruce == qry) {

			try {
				sql = "select * from CS2301_Doctor where Dname='"
						+ lst51.getText().trim() + "'";
				rs = stmt.executeQuery(sql);
				if (rs.next()) {
					lst51.setText(rs.getString(1));
					lst52.setText(rs.getString(2));
					lst53.setText(rs.getString(5));
					lst54.setText(rs.getString(7));
					lst55.setText(rs.getString(4));
					lst56.setText(rs.getString(3));
					lst57.setText(rs.getString(6));
					lst58.setText(rs.getString(9));
					txa2.setText(rs.getString(8));
				} else {
					JOptionPane
							.showMessageDialog(null, "û�в�ѯ����" + _name + "����");
				}

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (soruce == del) {

			try {
				if (_name.equals("")) {
					JOptionPane.showMessageDialog(null, "��������Ҫ��ѯ��������");
					return;
				}
				sql = "delete from CS2301_Doctor where Dname='"
						+ lst51.getText().trim() + "'";
				int result = stmt.executeUpdate(sql);
				if (result == 0) {
					JOptionPane
							.showMessageDialog(null, "û�в�ѯ������" + _name + "��");
				} else {
					JOptionPane.showMessageDialog(null, "ɾ����" + _name + "���ɹ���");
					clearFrame();
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		} else if (soruce == add) {
			try {

				if (_name.equals("")) {
					JOptionPane.showMessageDialog(null, "��������Ϊ�գ�");
					return;
				} else if (lst52.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "��Ų���Ϊ�գ�");
					return;
				}
				sql = "select * from CS2301_Doctor where Dno='"
						+ lst51.getText().trim() + "'";
				rs = stmt.executeQuery(sql);
				if (rs.next()) {
					JOptionPane.showMessageDialog(null, "��š�"
							+ lst51.getText().trim() + "���Ѿ����ڣ����������룡");
					return;
				}
				sql = "insert into CS2301_Doctor(Dname,Dno,Dsex,Dposition,Dtelephone,Dage,Drecord,Dexperience,Djudgement) values('"
						+ lst51.getText().trim()
						+ "','"
						+ lst52.getText().trim()
						+ "','"
						+ lst53.getText().trim()
						+ "','"
						+ lst54.getText().trim()
						+ "','"
						+ lst55.getText().trim()
						+ "','"
						+ lst56.getText().trim()
						+ "','"
						+ lst57.getText().trim()
						+ "','"
						+ lst58.getText().trim()
						+ "','"
						+ txa2.getText().trim() + "')";
				stmt.executeUpdate(sql);
				JOptionPane.showMessageDialog(null, "¼����Ϣ�ɹ���");
				clearFrame();
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}

	}

}
