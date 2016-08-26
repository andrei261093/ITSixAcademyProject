package controllers;

import java.util.List;

import model.ICompetence;
import view.ClassScheduleGUI;
import view.IChooseCompetenceGUI;
import view.ISelectCompetencesGUI;

public interface IChooseCompetenceController {

	public void showSelectCompetenceGUI();
	
	public void setCompetenceGUI(IChooseCompetenceGUI competenceGUI);
	public void setSelectCompetenceGUI(ISelectCompetencesGUI selectCompetenceGUI);

	public void setCompetencesList(List<ICompetence> selectedList);

	public void populateTree();

	public void makeStages();

	public void dispalyStages();

	public void populateList();

	public void displayTeachers();

	public void highlightTable();

	public void addCourseToTable();

	public void removeCourseFromFinalStudentList();

	public void removeCourseFromTable();

	public void setScheduleGUI(ClassScheduleGUI scheduleGUI);

	public void showScheduleGUI();

	public void saveStage();

}
