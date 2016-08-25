package repositories;

import java.util.List;

import model.ITeacher;

public interface ITeachersRepository {

	void addTeacher(ITeacher teacher);

	ITeacher getSubjectByName(String subjectName);

	List<ITeacher> getTeachers();

}
