package repositories;

import model.IStudent;

public interface IStudentRepository {

	void addStudent(IStudent newStudent);

	boolean hasThisStudent(IStudent student);

	IStudent getStudentBySSN(String ssn);

	void updateStudent(String ssn, IStudent student);

}
