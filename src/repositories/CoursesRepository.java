package repositories;

import java.util.ArrayList;
import java.util.List;

import model.ICourse;

public class CoursesRepository implements ICoursesRepository {
	List<ICourse> coursesList = new ArrayList<>();

	@Override
	public List<ICourse> getRelationsList() {
		return coursesList;
	}

	@Override
	public void addCourse(ICourse course) {
		coursesList.add(course);
	}

	@Override
	public boolean hasThisCourse(ICourse course) {
		for (ICourse currentCourse : coursesList) {
			System.out.println(currentCourse + " - " + course);
			if (currentCourse.equals(course)) {
				return true;
			}
		}
		return false;
	}
}
