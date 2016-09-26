package itsix.academy.perfect_school.repositories;



import java.io.Serializable;
import java.util.List;

import itsix.academy.perfect_school.model.ITeacher;

public interface ITeachersRepository extends Serializable{

	void addTeacher(ITeacher teacher);

	ITeacher getTeacherByName(String subjectName);

	List<ITeacher> getTeachers();

	boolean hasThisTeacher(ITeacher newTeacher);

	void delete(ITeacher teacher);

}
