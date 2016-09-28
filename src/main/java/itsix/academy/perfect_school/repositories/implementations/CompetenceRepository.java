package itsix.academy.perfect_school.repositories.implementations;



import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import itsix.academy.perfect_school.model.ICompetence;
import itsix.academy.perfect_school.model.IPackage;
import itsix.academy.perfect_school.model.ISubject;
import itsix.academy.perfect_school.repositories.ICompetenceRepository;

public class CompetenceRepository implements ICompetenceRepository{
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
	
	@Override
	public void deleteCompetence(ICompetence competence) {
		competenceList.remove(competence);
		JOptionPane.showMessageDialog(null, "Deleted!");
	}

	@Override
	public List<ICompetence> getCompetencesWithThisName(String name) {
		List<ICompetence> returnList = new ArrayList<>();

		for (ICompetence element : competenceList) {
			if (element.toString().contains(name)) {
				returnList.add(element);
			}
		}

		return returnList;
	}

}
