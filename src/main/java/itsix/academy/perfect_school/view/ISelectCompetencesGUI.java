package itsix.academy.perfect_school.view;



import java.util.List;

import itsix.academy.perfect_school.model.ICompetence;

public interface ISelectCompetencesGUI {

	void setVisible(boolean b);

	void populateList(List<ICompetence> competences);

}
