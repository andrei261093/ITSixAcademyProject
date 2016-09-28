package itsix.academy.perfect_school.model.implementations;

import itsix.academy.perfect_school.model.ISubject;

public class Subject implements ISubject {
	String name;
	String code = "";

	public Subject(String name, String code) {
		super();
		this.name = name;
		this.code = code;
	}

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

	@Override
	public boolean hasThisCode(String code) {
		return this.code.equals(code);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subject other = (Subject) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String getCode() {
		return code;
	}

}
