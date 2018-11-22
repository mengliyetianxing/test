package dao;
/**
 * jdbc�Ĺ����࣬�����������ݿ����� �Լ��ر����ݿ���Դ
 * @author allen
 *
 */

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCFactory {
	
//	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
//	private static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
//	private static final String USERNAME = "c##java08";
//	private static final String PASSWORD = "java123";
	
	private static String DRIVER;
	private static String URL;
	private static String USERNAME;
	private static String PASSWORD;
	static{
		//������ʼ������
		Properties pro = new Properties();
		InputStream in = JDBCFactory.class.getResourceAsStream("jdbc.properties");
		try {
			pro.load(in);
			DRIVER = pro.getProperty("jdbc.oracle.driver");
			URL = pro.getProperty("jdbc.oracle.url");
			USERNAME = pro.getProperty("jdbc.oracle.username");
			PASSWORD = pro.getProperty("jdbc.oracle.password");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConn(){
		try {
			// ͨ����������ȡ����jar��
			// �����Ǽ������jar���Ƿ����
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// ��ȡ���ݿ�����
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void closeAll(Connection conn,Statement st,ResultSet rs){
		//���ݿ���Դ�Ĺر�
		try {
			if(rs!=null)
				rs.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			if(st!=null)
				st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(conn!=null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}














