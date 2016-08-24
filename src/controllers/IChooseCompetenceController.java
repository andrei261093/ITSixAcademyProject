package controllers;

import java.util.List;

import model.ICompetence;
import view.IChooseCompetenceGUI;
import view.ISelectCompetencesGUI;

public interface IChooseCompetenceController {

	public void showSelectCompetenceGUI();
	
	public void setCompetenceGUI(IChooseCompetenceGUI competenceGUI);
	public void setSelectCompetenceGUI(ISelectCompetencesGUI selectCompetenceGUI);

	public void setCompetencesList(List<ICompetence> selectedList);

	public void populateTree();

}
