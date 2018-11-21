package dao;

import org.springframework.stereotype.Repository;

@Repository
public class StudentDaoImpl implements IStudentDao {

	@Override
	public int intsertStudent() {
		System.out.println("插入了一个学员");
		return 0;
	}

}
