package repositories;

import java.util.List;

import model.ICourse;

public interface ICoursesRepository {

	List<ICourse> getRelationsList();

	void addCourse(ICourse course);

	boolean hasThisCourse(ICourse course);

}
