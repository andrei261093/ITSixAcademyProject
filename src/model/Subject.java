package model;

public class Subject implements ISubject {
	String name;

	public Subject(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public boolean hasThisName(String subjectName) {
		return this.name.equals(subjectName);
	}
	
	
	
}
