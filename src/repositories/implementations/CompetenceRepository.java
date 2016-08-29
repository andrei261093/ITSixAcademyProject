package repositories.implementations;

import java.util.ArrayList;
import java.util.List;

import model.ICompetence;
import model.ISubject;
import model.implementations.Competence;
import model.implementations.Package;
import model.implementations.Subject;
import repositories.ICompetenceRepository;
import model.IPackage;

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
