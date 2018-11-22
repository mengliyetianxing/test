package dao;

import java.util.List;

import pojo.Classinfo;

/**
 * Classinfoinfo���dao����
 * @author allen
 *
 */
public interface IClassinfoDAO {
	/**
	 * �����û���Ϣ
	 * @param u 
	 * @return ����ִ�е�Ӱ������
	 */
	public int addClassinfo(Classinfo u);
	
	/**
	 * ɾ���û�
	 * @param u �û����󣬱������id
	 * @return ����ִ�е�Ӱ������
	 */
	public int deleteClassinfo(Classinfo u);
	
	/**
	 * �޸��û�
	 * @param u �û����󣬱������id�����������޸�
	 * @return ����ִ�е�Ӱ������
	 */
	public int updateClassinfo(Classinfo u);
	
	/**
	 * ��ѯClassinfo����
	 * @param u �������� �������������ѯ
	 * @return ���󼯺�
	 */
	public List<Classinfo> selectClassinfo();

}












