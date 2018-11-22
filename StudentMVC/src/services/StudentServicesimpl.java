package services;

import java.util.List;

import dao.IUserinfoDAO;
import dao.UserDAOimpl;
import myUtil.DAOUtil;
import oracle.net.aso.s;
import pojo.SplitPage;
import pojo.User;

public class StudentServicesimpl implements IStudentServices {
	IUserinfoDAO udi = new UserDAOimpl();
	@Override
	public User login(String name, String password) {
		User u = new User(name, password);
		List<User> li = udi.selectUserinfo(u);
		if(li!=null&&li.size()>0) {
			return li.get(0);
		}
		return null;
	}
	@Override
	public int addUs(User u) {
		return udi.addUserinfo(u);
	}
	@Override
	public List<User> selectUsers() {
		return udi.selectAllUserinfo();
	}
	@Override
	public int updateuseres(User u) {
		
		return udi.updateUserinfo(u);
	}
	@Override
	public int deleteuseres(User u) {
		
		return udi.deleteUserinfo(u);
	}
	@Override
	public List<User> selectUsersByName(String name) {
		User u = new User();
		u.setName(name);
		return udi.selectUserinfoByName(u);
	}
	@Override
	public SplitPage<User> selectUsers(int pageIndex, int pageCount) {
		String sql = "select * from useres";
		SplitPage<User> sp = new SplitPage<User>();
		List<User> list = udi.selectUserinfoBySql(DAOUtil.splitPageSql(sql, pageIndex, pageCount));
		sp.setList(list);
		sp.setPageIndex(pageIndex);
		sp.setPageCount(pageCount);
		sp.setCount(udi.selectAllUserinfoCount());
		return sp;
	}

}
