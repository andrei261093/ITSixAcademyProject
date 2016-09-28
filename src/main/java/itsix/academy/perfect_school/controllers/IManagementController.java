package itsix.academy.perfect_school.controllers;

import itsix.academy.perfect_school.publisherSubscriber.ISubscriber;
import itsix.academy.perfect_school.view.IManagementGUI;

public interface IManagementController extends ISubscriber {

	void updateAll();

	void setAddMenuGUI(IManagementGUI addMenuGUI);

	void showAddMenuGUI();

	void saveCourse();

	void saveTeacher();

	void saveSubject();

	void saveRoom();

	void editPackage();

	void addPackage();

	void addNewCompetence();

	void createCompetence();

	void deleteCompetence();

	void deletePackage();

	void deleteCourses();

	void deleteRoom();

	void deleteTeacher();

	void deleteSubject();

	void showTeacherInfo();

	void searchCompetence();

}
