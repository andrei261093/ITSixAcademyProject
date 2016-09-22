package itsix.academy.perfect_school.model;



import java.util.List;

public interface ICompetence {

	List<IPackage> getPackages();

	void addPackage(IPackage _package);

	void deletePackage(IPackage selectedPackage);

}
