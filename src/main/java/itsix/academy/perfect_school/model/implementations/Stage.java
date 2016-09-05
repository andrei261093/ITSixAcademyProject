package itsix.academy.perfect_school.model.implementations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import itsix.academy.perfect_school.model.ICourse;
import itsix.academy.perfect_school.model.IStage;
import itsix.academy.perfect_school.model.ISubject;

public class Stage implements IStage {
	Set<ISubject> subjectList;
	List<ICourse> coursesList = new ArrayList<>();
	String name;

	// Constructors
	public Stage(String name, List<ISubject> subjectList) {
		super();
		this.subjectList.addAll(subjectList);
		this.name = name;
	}

	public Stage(String name) {
		super();
		subjectList = new HashSet();
		this.name = name;
	}

	// Functions

	@Override
	public List<ISubject> getSubjectList() {
		List<ISubject> lista = new ArrayList<>();
		lista.addAll(subjectList);
		return lista;
	}

	@Override
	public boolean hasNoSubjects() {
		return subjectList.isEmpty();
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public void setCourses(List<ICourse> courses) {
		coursesList = courses;
	}

	@Override
	public List<ICourse> getCourses() {
		return coursesList;
	}

	@Override
	public void deleteSubject(ISubject subject) {
		subjectList.remove(subject);
	}

	@Override
	public void deleteSubjects(List<ISubject> deleteList) {
		for (ISubject subject : deleteList) {
			if (subjectList.contains(subject)) {
				subjectList.remove(subject);
			} else {
				System.out.println("Materia nu a fost gasita in stagiu pt a fi stearsa!");
			}
		}
	}

	@Override
	public void addSubject(ISubject subject) {
		subjectList.add(subject);
	}
	
	@Override
	public void addSubjects(List<ISubject> newSubjectsList) {
		subjectList.addAll(newSubjectsList);
	}

}
