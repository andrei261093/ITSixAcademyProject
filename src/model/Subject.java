package model;

public class Subject implements ISubject {
	String name;

	public Subject(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name;
	}
	
	
	
}
