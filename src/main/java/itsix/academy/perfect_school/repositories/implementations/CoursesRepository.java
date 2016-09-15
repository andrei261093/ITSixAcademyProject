package itsix.academy.perfect_school.repositories.implementations;



import java.util.ArrayList;
import java.util.List;

import itsix.academy.perfect_school.model.ICourse;
import itsix.academy.perfect_school.repositories.ICoursesRepository;

public class CoursesRepository implements ICoursesRepository {
	List<ICourse> coursesList = new ArrayList<>();

	@Override
	public List<ICourse> getCoursesList() {
		return coursesList;
	}

	@Override
	public void addCourse(ICourse course) {
		coursesList.add(course);
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
}
