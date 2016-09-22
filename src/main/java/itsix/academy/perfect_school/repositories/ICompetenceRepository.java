package itsix.academy.perfect_school.repositories;



import java.util.List;

import itsix.academy.perfect_school.model.ICompetence;

public interface ICompetenceRepository {

	List<ICompetence> getCompetences();

	void addCompetence(ICompetence competence);

	void deleteCompetence(ICompetence competence);

}
