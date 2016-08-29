package model.implementations;

import java.util.List;

import model.IPackage;
import model.ISubject;

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
