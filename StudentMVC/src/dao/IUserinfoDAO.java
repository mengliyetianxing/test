package dao;

import java.util.List;

import pojo.User;

/**
 * userinfo���dao����
 * @author allen
 *
 */
public interface IUserinfoDAO {
	/**
	 * �����û���Ϣ
	 * @param u 
	 * @return ����ִ�е�Ӱ������
	 */
	public int addUserinfo(User u);
	
	/**
	 * ɾ���û�
	 * @param u �û����󣬱������id
	 * @return ����ִ�е�Ӱ������
	 */
	public int deleteUserinfo(User u);
	
	/**
	 * �޸��û�
	 * @param u �û����󣬱������id�����������޸�
	 * @return ����ִ�е�Ӱ������
	 */
	public int updateUserinfo(User u);
	
	/**
	 * ��ѯuserinfo����
	 * @param u �������� �������������ѯ
	 * @return ���󼯺�
	 */
	public List<User> selectUserinfo(User u);

	public List<User> selectAllUserinfo();
	
	public int selectAllUserinfoCount();
	
	public List<User> selectUserinfoByName(User u);
	
	public List<User> selectUserinfoBySql(String sql);
}












