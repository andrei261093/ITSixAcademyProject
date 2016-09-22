package itsix.academy.perfect_school.controllers;

import itsix.academy.perfect_school.model.ITeacher;

public interface ITeacherInfoController {

	void updateTeacher();

	void setEditable();

	void showInfo(ITeacher teacher);

}
