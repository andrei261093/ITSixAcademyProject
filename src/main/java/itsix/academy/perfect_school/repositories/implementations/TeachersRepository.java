package itsix.academy.perfect_school.repositories.implementations;

import java.util.ArrayList;
import java.util.List;

import itsix.academy.perfect_school.model.ITeacher;
import itsix.academy.perfect_school.repositories.ITeachersRepository;

public class TeachersRepository implements ITeachersRepository {
	List<ITeacher> teachersList = new ArrayList<>();

	@Override
	public void addTeacher(ITeacher subject) {
		teachersList.add(subject);
	}

	@Override
	public ITeacher getTeacherByName(String subjectName) {
		for (ITeacher teacher : teachersList) {
			if (teacher.hasThisName(subjectName)) {
				return teacher;
			}
		}
		return null;
	}

	@Override
	public List<ITeacher> getTeachers() {
		return teachersList;
	}

	@Override
	public boolean hasThisTeacher(ITeacher newTeacher) {
		boolean ok = false;
		for (ITeacher teacher : teachersList) {
			if (teacher.equals(newTeacher)) {
				ok = true;
			}
		}
		return ok;
	}

	@Override
	public void delete(ITeacher teacher) {
		teachersList.remove(teacher);
	}

}
