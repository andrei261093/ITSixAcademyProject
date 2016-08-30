package itsix.academy.perfect_school.repositories;



import java.util.List;

import itsix.academy.perfect_school.model.ITeacher;

public interface ITeachersRepository {

	void addTeacher(ITeacher teacher);

	ITeacher getTeacherByName(String subjectName);

	List<ITeacher> getTeachers();

	boolean hasThisTeacher(ITeacher newTeacher);

}
