package controllers;

import java.util.List;

import model.ICompetence;
import view.IChooseCompetenceGUI;
import view.ISelectCompetencesGUI;

public interface IChooseCompetenceController {

	void showSelectCompetenceGUI();
	
	public void setCompetenceGUI(IChooseCompetenceGUI competenceGUI);
	public void setSelectCompetenceGUI(ISelectCompetencesGUI selectCompetenceGUI);

	void setCompetencesList(List<ICompetence> selectedList);

}
