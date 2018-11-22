package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import pojo.Classinfo;
import pojo.User;

public class ClassinfoDAOimpl implements IClassinfoDAO {
	Connection con;
	PreparedStatement ps;
	ResultSet res;
	@Override
	public int addClassinfo(Classinfo u) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int deleteClassinfo(Classinfo u) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int updateClassinfo(Classinfo u) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public List<Classinfo> selectClassinfo() {
		try {
			List<Classinfo> li = new ArrayList<Classinfo>();
			con = JDBCFactory.getConn();
			con.setAutoCommit(false);
			String sql = "select * from CLASSINFO";
			ps = con.prepareStatement(sql);
			res = ps.executeQuery();
			while(res.next()) {
				li.add(new Classinfo(Integer.valueOf(res.getString(1)),res.getString(2)));
			}
			return li;
		}catch (Exception e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			JDBCFactory.closeAll(con, ps, res);
		}
		return null;
	}
	
}
