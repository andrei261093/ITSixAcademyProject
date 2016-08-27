package controllers;

import java.util.List;

import model.ICompetence;
import view.ClassScheduleGUI;
import view.IAddCompetenceGUI;
import view.IAddStudentGUI;
import view.ISelectCompetencesGUI;

public interface IAddStudentController {

	public void showSelectCompetenceGUI();
	
	public void setCompetenceGUI(IAddCompetenceGUI competenceGUI);
	
	public void setSelectCompetenceGUI(ISelectCompetencesGUI selectCompetenceGUI);

	public void setCompetencesList(List<ICompetence> selectedList);
	
	public void setAddStudentGUI(IAddStudentGUI addStudentGUI);

	public void populateTree();

	public void makeStages();

	public void dispalyStages();

	public void populateList();

	public void displayTeachers();

	public void highlightTable();

	public void addCourseToTable();

	public void removeSelectedTableCourseFromStudentsCourses();

	public void removeCourseFromTable();

	public void setScheduleGUI(ClassScheduleGUI scheduleGUI);

	public void showScheduleGUI();

	public void saveStage();

	public void showAddCompetenceGUI();

	void showAddStudentGUI();

	

}
