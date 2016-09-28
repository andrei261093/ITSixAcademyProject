package itsix.academy.perfect_school.repositories.implementations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.JOptionPane;

import itsix.academy.perfect_school.model.ICourse;
import itsix.academy.perfect_school.model.IRoom;
import itsix.academy.perfect_school.model.ITeacher;
import itsix.academy.perfect_school.repositories.ICoursesRepository;

public class CoursesRepository implements ICoursesRepository {
	List<ICourse> coursesList = new ArrayList<>();

	@Override
	public List<ICourse> getCoursesList() {
		sortSubjectsList();
		return coursesList;
	}

	@Override
	public void addCourse(ICourse course) {
		coursesList.add(course);
	}

	@Override
	public boolean isRoomEmpty(IRoom room, String hour, String day) {
		for (ICourse course : coursesList) {
			if (course.hasThisDay(day) && course.hasThisHour(hour) && course.hasThisRoom(room)) {
				JOptionPane.showMessageDialog(null, "Room is occupied!");
				return false;
			}
		}

		return true;
	}

	@Override
	public boolean isTeacherFree(ITeacher teacher, String hour, String day) {
		for (ICourse course : coursesList) {
			if (course.hasThisDay(day) && course.hasThisHour(hour) && course.hasThisTeacher(teacher)) {
				JOptionPane.showMessageDialog(null,
						"Mr. " + teacher.getLastName() + " has another course at that time!");
				return false;
			}
		}

		return true;
	}

	@Override
	public boolean hasThisCourse(ICourse course) {
		boolean ok = false;
		for (ICourse currentCourse : coursesList) {
			if (currentCourse.equals(course)) {
				ok = true;
			}
		}
		return ok;
	}

	@Override
	public void delete(ICourse course) {
		coursesList.remove(course);
	}

	private void sortSubjectsList() {
		Collections.sort(coursesList, new Comparator<ICourse>() {
			@Override
			public int compare(ICourse s1, ICourse s2) {
				return s1.toString().compareToIgnoreCase(s2.toString());
			}
		});
	}

}
