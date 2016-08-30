package itsix.academy.perfect_school.controllers;



import itsix.academy.perfect_school.view.IManagementGUI;

public interface IAddMenuController {

	void updateAll();

	void setAddMenuGUI(IManagementGUI addMenuGUI);

	void showAddMenuGUI();

	void saveCourse();

	void saveTeacher();

	void saveSubject();

}
