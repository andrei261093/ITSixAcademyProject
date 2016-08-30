package itsix.academy.perfect_school.repositories;


import itsix.academy.perfect_school.model.IStudent;

public interface IStudentRepository {

	void addStudent(IStudent newStudent);

	boolean hasThisStudent(String string);

	IStudent getStudentBySSN(String ssn);

	void updateStudent(String ssn, IStudent student);

}
