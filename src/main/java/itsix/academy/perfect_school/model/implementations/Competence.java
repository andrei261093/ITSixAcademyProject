package itsix.academy.perfect_school.model.implementations;

import java.util.ArrayList;
import java.util.List;

import itsix.academy.perfect_school.model.ICompetence;
import itsix.academy.perfect_school.model.IPackage;

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
	public void addPackage(IPackage _package) {
		packeges.add(_package);
	}

	@Override
	public String toString() {
		return competenceName;
	}

	@Override
	public List<IPackage> getPackages() {
		return packeges;
	}

	@Override
	public void deletePackage(IPackage selectedPackage) {
		packeges.remove(selectedPackage);
	}

}
