package model;

import java.util.ArrayList;
import java.util.List;

public class Competence implements ICompetence {
	List<IPackage> packeges;
	String competenceName;

	public Competence(List<IPackage> packeges, String name) {
		super();
		this.packeges = packeges;
		this.competenceName = name;
	}

	public Competence(String name) {
	this.competenceName = name;
	packeges = new ArrayList<>();
	}
	
	@Override
	public void addPackage(IPackage _package){
		packeges.add(_package);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return competenceName;
	}

	@Override
	public List<IPackage> getPackages() {
		// TODO Auto-generated method stub
		return packeges;
	}
	
	
	
	
	
	
}
