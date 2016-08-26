package repositories;

import java.util.ArrayList;
import java.util.List;

import model.Competence;
import model.ICompetence;
import model.ISubject;
import model.IPackage;
import model.Subject;
import model.Package;

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
