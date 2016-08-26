package model;

import java.util.List;

public class Package implements IPackage {
	List<ISubject> subjects;
	String name;

	public Package(List<ISubject> subjects,String name) {
		super();
		this.subjects = subjects;
		this.name = name;
	}

	@Override
	public List<ISubject> getSubjects() {
		return subjects;
	}

	@Override
	public String toString() {
		return name;
	}

}
