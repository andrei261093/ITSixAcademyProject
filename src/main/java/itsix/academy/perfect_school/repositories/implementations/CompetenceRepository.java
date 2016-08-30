package itsix.academy.perfect_school.repositories.implementations;



import java.util.ArrayList;
import java.util.List;

import itsix.academy.perfect_school.model.ICompetence;
import itsix.academy.perfect_school.repositories.ICompetenceRepository;

public class CompetenceRepository implements ICompetenceRepository {
	List<ICompetence> competenceList = new ArrayList<>();

	public CompetenceRepository() {
		super();

	}

	@Override
	public List<ICompetence> getCompetences() {
		// TODO Auto-generated method stub
		return competenceList;
	}

	@Override
	public void addCompetence(ICompetence competence) {
		competenceList.add(competence);
	}

}
