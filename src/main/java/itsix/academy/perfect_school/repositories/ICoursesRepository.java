package itsix.academy.perfect_school.repositories;



import java.util.List;

import itsix.academy.perfect_school.model.ICourse;

public interface ICoursesRepository {

	List<ICourse> getRelationsList();

	void addCourse(ICourse course);

	boolean hasThisCourse(ICourse course);

}
