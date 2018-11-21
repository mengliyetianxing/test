package dao;

import org.springframework.stereotype.Repository;

@Repository
public class StudentServicesImplMysql implements IStudentDao {

	@Override
	public int intsertStudent() {
		System.out.println("正在使用mysql插入学员");
		return 0;
	}

}
