package hospital.util;

import java.sql.Connection;
import java.sql.DriverManager;

// ��ȡ���ݿ�����
public class JdbcUtil {

	public static Connection getConnection() {
		Connection con = null;
		String driverName = "com.mysql.cj.jdbc.Driver";
		String dbURL = "jdbc:mysql://124.71.219.185:3306/yb2301_his";
		String userName = "root"; // Replace with your MySQL username
		String userPwd = "uestc2022!"; // Replace with your MySQL password
		try {
			Class.forName(driverName);
			con = DriverManager.getConnection(dbURL, userName, userPwd);
		} catch (Exception e) {
			System.out.println("��ȡ����ʧ��." + e.getMessage());
		}
		return con;
	}
}
