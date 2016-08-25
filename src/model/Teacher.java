package model;

public class Teacher implements ITeacher {
	String name;

	public Teacher(String name) {
		super();
		this.name = name;
	}

	@Override
	public boolean hasThisName(String teacherName) {
		return name.equals(teacherName);
	}

	@Override
	public String toString() {
		return name;
	}

}
