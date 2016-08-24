package repositories;

import java.util.ArrayList;
import java.util.List;


import model.Competence;
import model.ICompetence;
import model.ISubject;
import model.ISubjectPackage;
import model.Subject;
import model.SubjectPackage;

public class CompetenceRepository implements ICompetenceRepository {
	List<ICompetence> competenceList = new ArrayList<>();
	
	
	
	
	public CompetenceRepository() {
		super();
		ISubject subiect1 = new Subject("matematica");
		ISubject subiect2 = new Subject("romana");
		ISubject subiect3 = new Subject("fizica");
		
		ISubject subiect4 = new Subject("sport");
		ISubject subiect5 = new Subject("desen");
		ISubject subiect6 = new Subject("religie");
		
		
		List <ISubject> lista = new ArrayList<>();
		lista.add(subiect3);
		lista.add(subiect2);
		lista.add(subiect1);
		
		List <ISubject> lista2 = new ArrayList<>();
		lista2.add(subiect4);
		lista2.add(subiect5);
		lista2.add(subiect6);
		
		ISubjectPackage _package = new SubjectPackage(lista, "pachet 1");
		ISubjectPackage _package2 = new SubjectPackage(lista2, "pachet 2");
		
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
