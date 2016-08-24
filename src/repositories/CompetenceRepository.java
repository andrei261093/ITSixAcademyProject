package repositories;

import java.util.ArrayList;
import java.util.List;

import model.Competence;
import model.ICompetence;

public class CompetenceRepository implements ICompetenceRepository {
	List<ICompetence> competenceList = new ArrayList<>();
	
	
	
	
	public CompetenceRepository() {
		super();
		ICompetence competenta = new Competence("Java");
		ICompetence competenta2 = new Competence("Web");
		competenceList.add(competenta);
		competenceList.add(competenta2);
	}




	@Override
	public List<ICompetence> getCompetences() {
		// TODO Auto-generated method stub
		return competenceList;
	}

}
