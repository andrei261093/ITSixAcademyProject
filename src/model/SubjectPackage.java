package model;

import java.util.List;

public class SubjectPackage implements ISubjectPackage {
	List<ISubject> subjects;
	String name;

	public SubjectPackage(List<ISubject> subjects,String name) {
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
		// TODO Auto-generated method stub
		return name;
	}

}
