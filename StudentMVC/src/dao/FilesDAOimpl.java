package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojo.Files;

public class FilesDAOimpl implements IFilesDAO {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	@Override
	public int addFiles(Files f) {
		try {
			con = JDBCFactory.getConn();
			con.setAutoCommit(false);
			String sql = "insert into files values (seq_files.nextval,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, f.getFname());
			ps.setString(2, f.getFdes());
			int ki = ps.executeUpdate();
			con.commit();
			return ki;
		}catch (Exception e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			JDBCFactory.closeAll(con, ps, rs);
		}
		return 0;
	}

	@Override
	public int deleteFiles(Files f) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateFiles(Files f) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int selectFiles(Files f) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Files> selectAllFiles() {
		List<Files> li = new ArrayList<Files>();
		try {
			con = JDBCFactory.getConn();
			con.setAutoCommit(false);
			String sql = "select * from files";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Files files = new Files();
				files.setFid(rs.getString(1));
				files.setFname(rs.getString(2));
				files.setFdes(rs.getString(3));
				li.add(files);
			}
			con.commit();
			return li;
		}catch (Exception e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return null;
	}

}
