package itsix.academy.perfect_school.controllers;



import itsix.academy.perfect_school.publisherSubscriber.ISubscriber;
import itsix.academy.perfect_school.view.IManagementGUI;

public interface IManagementController extends ISubscriber{

	void updateAll();

	void setAddMenuGUI(IManagementGUI addMenuGUI);

	void showAddMenuGUI();

	void saveCourse();

	void saveTeacher();

	void saveSubject();

	void saveRoom();

	void updatePackagesList();

	void editPackage();

	void addPackage();

}
