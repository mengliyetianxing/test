package dao;

import org.springframework.stereotype.Repository;

@Repository
public class StudentServicesImplMysql implements IStudentDao {

	@Override
	public int intsertStudent() {
		System.out.println("����ʹ��mysql����ѧԱ");
		return 0;
	}

}
