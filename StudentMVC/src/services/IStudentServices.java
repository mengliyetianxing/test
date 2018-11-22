package services;

import java.util.List;

import pojo.SplitPage;
import pojo.User;

public interface IStudentServices {
	public User login(String name,String password);
	
	public int addUs(User u);
	
	public List<User> selectUsers();
	
	public SplitPage<User> selectUsers(int pageIndex,int pageCount);
	
	public List<User> selectUsersByName(String name);
	
	public int updateuseres(User u);
	
	public int deleteuseres(User u);
}
