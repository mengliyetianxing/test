package dao;

import org.springframework.stereotype.Repository;

@Repository
public class StudentDaoImpl implements IStudentDao {

	@Override
	public int intsertStudent() {
		System.out.println("������һ��ѧԱ");
		return 0;
	}

}
