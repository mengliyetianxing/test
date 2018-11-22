package services;

import java.util.List;

import dao.ClassinfoDAOimpl;
import dao.IClassinfoDAO;
import pojo.Classinfo;

public class ClassinfoServicesimpl implements IClassinfoServices {
	IClassinfoDAO cdi = new ClassinfoDAOimpl();
	@Override
	public List<Classinfo> getAllClass() {
		return cdi.selectClassinfo();
	}

}
