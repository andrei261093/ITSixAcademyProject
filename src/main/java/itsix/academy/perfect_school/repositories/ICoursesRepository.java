package itsix.academy.perfect_school.repositories;



import java.io.Serializable;
import java.util.List;

import itsix.academy.perfect_school.model.ICourse;
import itsix.academy.perfect_school.model.IRoom;
import itsix.academy.perfect_school.model.ITeacher;

public interface ICoursesRepository extends Serializable{

	List<ICourse> getCoursesList();

	void addCourse(ICourse course);

	boolean hasThisCourse(ICourse course);

	void delete(ICourse course);

	boolean isRoomEmpty(IRoom room, String hour, String day);

	boolean isTeacherFree(ITeacher teacher, String hour, String day);

}
