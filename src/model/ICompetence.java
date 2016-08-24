package model;

import java.util.List;

public interface ICompetence {

	List<ISubjectPackage> getPackages();

	void addPackage(ISubjectPackage _package);

}
