package repositories;

import java.util.ArrayList;
import java.util.List;

import model.ISubject;
import model.ITeacher;

public class TeachersRepository implements ITeachersRepository {
	List<ITeacher> teachersList = new ArrayList<>();

	@Override
	public void addTeacher(ITeacher subject) {
		teachersList.add(subject);
	}

	@Override
	public ITeacher getSubjectByName(String subjectName) {
		for (ITeacher teacher : teachersList) {
			if (teacher.hasThisName(subjectName)) {
				return teacher;
			}
		}
		return null;
	}
	
	@Override
	public List<ITeacher> getTeachers(){
		return teachersList;
	}

}
