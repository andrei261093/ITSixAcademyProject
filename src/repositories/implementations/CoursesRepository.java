package repositories.implementations;

import java.util.ArrayList;
import java.util.List;

import model.ICourse;
import repositories.ICoursesRepository;

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
		boolean ok = false;
		for (ICourse currentCourse : coursesList) {
			if (currentCourse.equals(course)) {
				ok = true;
			}
		}
		return ok;
	}
}
