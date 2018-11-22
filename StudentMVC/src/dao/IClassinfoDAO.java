package dao;

import java.util.List;

import pojo.Classinfo;

/**
 * Classinfoinfo表的dao操作
 * @author allen
 *
 */
public interface IClassinfoDAO {
	/**
	 * 新增用户信息
	 * @param u 
	 * @return 返回执行的影响行数
	 */
	public int addClassinfo(Classinfo u);
	
	/**
	 * 删除用户
	 * @param u 用户对象，必须包含id
	 * @return 返回执行的影响行数
	 */
	public int deleteClassinfo(Classinfo u);
	
	/**
	 * 修改用户
	 * @param u 用户对象，必须包含id并且主键不修改
	 * @return 返回执行的影响行数
	 */
	public int updateClassinfo(Classinfo u);
	
	/**
	 * 查询Classinfo对象
	 * @param u 条件对象 可以组合条件查询
	 * @return 对象集合
	 */
	public List<Classinfo> selectClassinfo();

}












