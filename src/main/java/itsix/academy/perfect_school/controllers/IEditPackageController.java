package itsix.academy.perfect_school.controllers;

import itsix.academy.perfect_school.model.IPackage;

public interface IEditPackageController {

	void editPackage(IPackage _package);

	void moveUP();

	void moveDown();

	void addSubjects();

	void deleteSubject();

	void save();

	void showAddSubjectsGUI();

	void searchSubjects();

}
