package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import dao.IStudentDao;
@Service
public class StudentServices {
	@Autowired
	@Qualifier("studentServicesImplMysql")
	IStudentDao iSD;
	
	public void setiSD(IStudentDao iSD) {
		this.iSD = iSD;
	}

	public void insertStudent() {
		System.out.println("准备插入一个学员");
		iSD.intsertStudent();
	}
}
