package repositories;

import java.util.List;

import model.ICompetence;

public interface ICompetenceRepository {

	List<ICompetence> getCompetences();

	void addCompetence(ICompetence competence);

}
