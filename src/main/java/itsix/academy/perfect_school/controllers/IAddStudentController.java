package itsix.academy.perfect_school.controllers;

import java.util.List;

import itsix.academy.perfect_school.model.ICompetence;
import itsix.academy.perfect_school.view.IAddCompetenceGUI;
import itsix.academy.perfect_school.view.IAddStudentGUI;
import itsix.academy.perfect_school.view.ISelectCompetencesGUI;

public interface IAddStudentController {

	public void showSelectCompetenceGUI();

	public void setCompetenceGUI(IAddCompetenceGUI competenceGUI);

	public void setSelectCompetenceGUI(ISelectCompetencesGUI selectCompetenceGUI);

	public void setCompetencesList(List<ICompetence> selectedList);

	public void setAddStudentGUI(IAddStudentGUI addStudentGUI);

	public void populateTree();

	public void makeStages();

	public void dispalyStages();

	public void showScheduleGUI();

	public void showAddCompetenceGUI();

	void showAddStudentGUI();

	void populateList();

	public void addStudent();

}
