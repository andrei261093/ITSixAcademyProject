package itsix.academy.perfect_school.model;



import java.io.Serializable;
import java.util.List;

public interface ICompetence extends Serializable{

	List<IPackage> getPackages();

	void addPackage(IPackage _package);

	void deletePackage(IPackage selectedPackage);

}
