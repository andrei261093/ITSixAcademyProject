package itsix.academy.perfect_school.repositories.implementations;



import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import itsix.academy.perfect_school.model.ICourse;
import itsix.academy.perfect_school.model.ISubject;
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
	public void delete(ICourse course){
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
