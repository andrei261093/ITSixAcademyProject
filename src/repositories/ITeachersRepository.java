package repositories;

import java.util.List;

import model.ITeacher;

public interface ITeachersRepository {

	void addTeacher(ITeacher teacher);

	ITeacher getTeacherByName(String subjectName);

	List<ITeacher> getTeachers();

}
