package itsix.academy.perfect_school.repositories;


import java.io.Serializable;

import itsix.academy.perfect_school.model.IStudent;

public interface IStudentRepository extends Serializable{

	void addStudent(IStudent newStudent);

	boolean hasThisStudent(String string);

	IStudent getStudentBySSN(String ssn);

	void updateStudent(String ssn, IStudent student);

}
