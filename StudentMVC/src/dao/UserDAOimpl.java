package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import pojo.User;

public class UserDAOimpl implements IUserinfoDAO {
	Connection con;
	PreparedStatement ps;
	ResultSet res;
	@Override
	public int addUserinfo(User u) {
		con = JDBCFactory.getConn();
		String sql = "insert into useres values(seq_useres.nextval,?,?,?,?,?,?,?,?)";
		try {
			con.setAutoCommit(false);
			ps = con.prepareStatement(sql);
			ps.setString(1, u.getName());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getSex());
			ps.setString(4, u.getLove());
			ps.setTimestamp(5, new Timestamp(new SimpleDateFormat("yyyy-MM-dd").parse(u.getBirthday()).getTime()));
			ps.setString(6, u.getAddress());
			ps.setString(7, u.getBz());
			ps.setString(8, u.getCid());
			con.commit();
			return ps.executeUpdate();
		}catch (Exception e) {
			try {
				if(con!=null) {
					con.rollback();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			JDBCFactory.closeAll(con, ps, null);
		}
		
		
		return 0;
	}

	@Override
	public int deleteUserinfo(User u) {
		try {
			con = JDBCFactory.getConn();
			con.setAutoCommit(false);
			String sql = "delete from useres where u_id = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, Integer.valueOf(u.getUid()));
			int ki = ps.executeUpdate();
			con.commit();
			return ki;
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
		return 0;
	}

	@Override
	public int updateUserinfo(User u) {
		try {
			con = JDBCFactory.getConn();
			con.setAutoCommit(false);
			String sql = "update useres set u_name = ?,u_password = ?,u_sex = ?,u_love = ?,u_birthday = ?,u_bz = ?,c_id = ? where u_id = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, u.getName());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getSex());
			ps.setString(4, u.getLove());
			Long time = (new SimpleDateFormat("yyyy-MM-dd").parse(u.getBirthday())).getTime();
			ps.setTimestamp(5, new Timestamp(time));
			ps.setString(6, u.getBz());
			ps.setInt(7, Integer.valueOf(u.getCid()));
			ps.setInt(8, Integer.valueOf(u.getUid()));
			int ki = ps.executeUpdate();
			con.commit();
			return ki;
		} catch (Exception e) {
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
		return 0;
	}
	
	@Override
	public List<User> selectUserinfo(User u) {
		try {
			List<User> li = new ArrayList<User>();
			con = JDBCFactory.getConn();
			con.setAutoCommit(false);
			String sql = "select * from useres where u_name = ? and u_password = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, u.getName());
			ps.setString(2, u.getPassword());
			res = ps.executeQuery();
			while(res.next()) {
				li.add(new User(res.getString(2),res.getString(3)));
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

	@Override
	public List<User> selectAllUserinfo() {
		try {
			List<User> li = new ArrayList<User>();
			con = JDBCFactory.getConn();
			con.setAutoCommit(false);
			String sql = "select * from useres";
			ps = con.prepareStatement(sql);
			res = ps.executeQuery();
			while(res.next()) {
				User user = new User();
				user.setUid(res.getString(1));
				user.setName(res.getString(2));
				user.setPassword(res.getString(3));
				user.setSex(res.getString(4));
				user.setLove(res.getString(5));
				user.setBirthday(res.getString(6).substring(0, 10));
				if("2".equals(res.getString(9))) {
					user.setCid("Ò×É§");
				}else if("2".equals(res.getString(9))) {
					user.setCid("ÎâÉ§");
				}
				li.add(user);
			}
			con.commit();
			return li;
		} catch (Exception e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<User> selectUserinfoByName(User u) {
		try {
			List<User> li = new ArrayList<User>();
			con = JDBCFactory.getConn();
			con.setAutoCommit(false);
			String sql = "select * from useres where u_name = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, u.getName());
			res = ps.executeQuery();
			while(res.next()) {
				User user = new User();
				user.setUid(res.getString(1));
				user.setName(res.getString(2));
				user.setPassword(res.getString(3));
				user.setSex(res.getString(4));
				user.setLove(res.getString(5));
				user.setBirthday(res.getString(6).substring(0, 10));
				if("2".equals(res.getString(9))) {
					user.setCid("Ò×É§");
				}else if("2".equals(res.getString(9))) {
					user.setCid("ÎâÉ§");
				}
				li.add(user);
			}
			con.commit();
			return li;
		} catch (Exception e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<User> selectUserinfoBySql(String sql) {
		try {
			List<User> li = new ArrayList<User>();
			con = JDBCFactory.getConn();
			ps = con.prepareStatement(sql);
			res = ps.executeQuery();
			while(res.next()) {
				User user = new User();
				user.setUid(res.getString(1));
				user.setName(res.getString(2));
				user.setPassword(res.getString(3));
				user.setSex(res.getString(4));
				user.setLove(res.getString(5));
				user.setBirthday(res.getString(6).substring(0, 10));
				if("2".equals(res.getString(9))) {
					user.setCid("Ò×É§");
				}else if("2".equals(res.getString(9))) {
					user.setCid("ÎâÉ§");
				}
				li.add(user);
			}
			return li;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int selectAllUserinfoCount() {
		try {
			con = JDBCFactory.getConn();
			String sql = "select count(1) from useres";
			ps = con.prepareStatement(sql);
			res = ps.executeQuery();
			while (res.next()) {
				return res.getInt(1);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
