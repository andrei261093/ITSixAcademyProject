package itsix.academy.perfect_school.repositories;



import java.io.Serializable;
import java.util.List;

import itsix.academy.perfect_school.model.ICompetence;

public interface ICompetenceRepository extends Serializable{

	List<ICompetence> getCompetences();

	void addCompetence(ICompetence competence);

	void deleteCompetence(ICompetence competence);

	List<ICompetence> getCompetencesWithThisName(String inputCompetenceName);

}
