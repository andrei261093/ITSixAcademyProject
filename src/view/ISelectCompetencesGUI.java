package view;

import java.util.List;

import model.ICompetence;

public interface ISelectCompetencesGUI {

	void setVisible(boolean b);

	void populateList(List<ICompetence> competences);

}
