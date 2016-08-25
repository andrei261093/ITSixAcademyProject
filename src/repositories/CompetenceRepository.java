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
		ISubject subiect1 = new Subject("matematica 1");
		ISubject subiect2 = new Subject("matematica 2");
		ISubject subiect3 = new Subject("matematica 3");
		
		ISubject subiect4 = new Subject("sport 1");
		ISubject subiect5 = new Subject("sport 2");
		ISubject subiect6 = new Subject("sport 3");
		
		
		List <ISubject> lista = new ArrayList<>();
		lista.add(subiect1);
		lista.add(subiect2);
		lista.add(subiect3);
		
		List <ISubject> lista2 = new ArrayList<>();
		lista2.add(subiect1);
		lista2.add(subiect5);
		lista2.add(subiect6);
		
		
		
		IPackage _package = new Package(lista, "Mate Pack");
		IPackage _package2 = new Package(lista2, "Sport Pack");
		
		ICompetence competenta = new Competence("Java");
		
		competenta.addPackage(_package);
		competenta.addPackage(_package2);
		
		ICompetence competenta2 = new Competence("Web");
		competenta2.addPackage(_package);
		competenceList.add(competenta);
		competenceList.add(competenta2);
	}




	@Override
	public List<ICompetence> getCompetences() {
		// TODO Auto-generated method stub
		return competenceList;
	}

}
