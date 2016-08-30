package repositories;

import model.IStudent;

public interface IStudentRepository {

	void addStudent(IStudent newStudent);

	boolean hasThisStudent(String string);

	IStudent getStudentBySSN(String ssn);

	void updateStudent(String ssn, IStudent student);

}
