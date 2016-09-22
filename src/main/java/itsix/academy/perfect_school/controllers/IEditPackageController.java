package itsix.academy.perfect_school.controllers;

import itsix.academy.perfect_school.model.ICompetence;
import itsix.academy.perfect_school.model.IPackage;
import itsix.academy.perfect_school.publisherSubscriber.IPublisher;

public interface IEditPackageController extends IPublisher{

	void editPackage(IPackage _package);

	void moveUP();

	void moveDown();

	void addSubjects();

	void deleteSubject();

	void save();

	void showAddSubjectsGUI();

	void searchSubjects();

	void addPackage(ICompetence iCompetence);

	void addPackageToRepository();

}
