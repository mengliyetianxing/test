package dao;

import java.util.List;

import pojo.User;

/**
 * userinfo表的dao操作
 * @author allen
 *
 */
public interface IUserinfoDAO {
	/**
	 * 新增用户信息
	 * @param u 
	 * @return 返回执行的影响行数
	 */
	public int addUserinfo(User u);
	
	/**
	 * 删除用户
	 * @param u 用户对象，必须包含id
	 * @return 返回执行的影响行数
	 */
	public int deleteUserinfo(User u);
	
	/**
	 * 修改用户
	 * @param u 用户对象，必须包含id并且主键不修改
	 * @return 返回执行的影响行数
	 */
	public int updateUserinfo(User u);
	
	/**
	 * 查询userinfo对象
	 * @param u 条件对象 可以组合条件查询
	 * @return 对象集合
	 */
	public List<User> selectUserinfo(User u);

	public List<User> selectAllUserinfo();
	
	public int selectAllUserinfoCount();
	
	public List<User> selectUserinfoByName(User u);
	
	public List<User> selectUserinfoBySql(String sql);
}












