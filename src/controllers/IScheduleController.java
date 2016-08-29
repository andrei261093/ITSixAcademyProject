package controllers;

import model.ICourse;
import model.IStage;

public interface IScheduleController {

	void displayTeachers();

	void highlightTable();

	void addCourseToTable();

	void removeSelectedTableCourseFromStudentsCourses();

	void removeCourseFromStudentsCourses(ICourse curs);

	void removeCourseFromTable();

	void editSchedule(IStage stage);

	void saveStage();

}
