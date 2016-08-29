package controllers;

import java.util.List;

import model.ICompetence;
import view.IAddCompetenceGUI;
import view.IAddStudentGUI;
import view.ISelectCompetencesGUI;
import view.implementations.ScheduleGUI;

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
