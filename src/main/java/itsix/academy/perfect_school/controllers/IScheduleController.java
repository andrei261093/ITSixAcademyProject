package itsix.academy.perfect_school.controllers;

import itsix.academy.perfect_school.model.ICourse;
import itsix.academy.perfect_school.model.IStage;

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
