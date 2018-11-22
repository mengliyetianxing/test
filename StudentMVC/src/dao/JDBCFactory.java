package dao;
/**
 * jdbc的工厂类，负责生产数据库链接 以及关闭数据库资源
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
		//用来初始化数据
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
			// 通过类名来获取驱动jar包
			// 作用是检查驱动jar包是否加入
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// 获取数据库链接
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void closeAll(Connection conn,Statement st,ResultSet rs){
		//数据库资源的关闭
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














