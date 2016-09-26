package itsix.academy.perfect_school.repositories;



import java.io.Serializable;
import java.util.List;

import itsix.academy.perfect_school.model.ICourse;

public interface ICoursesRepository extends Serializable{

	List<ICourse> getCoursesList();

	void addCourse(ICourse course);

	boolean hasThisCourse(ICourse course);

	void delete(ICourse course);

}
