package itsix.academy.perfect_school.repositories.implementations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import itsix.academy.perfect_school.model.ISubject;
import itsix.academy.perfect_school.model.ITeacher;
import itsix.academy.perfect_school.repositories.ISubjectRepository;

public class SubjectRepository implements ISubjectRepository {
	List<ISubject> subjectList = new ArrayList<>();

	@Override
	public void addSubject(ISubject subject) {
		subjectList.add(subject);
	}

	@Override
	public ISubject getSubjectByName(String subjectName) {
		for (ISubject subject : subjectList) {
			if (subject.hasThisName(subjectName)) {
				return subject;
			}
		}
		return null;
	}

	@Override
	public List<ISubject> getSubjectList() {
		sortSubjectsList();
		return subjectList;
	}

	private void sortSubjectsList() {
		Collections.sort(subjectList, new Comparator<ISubject>() {
			@Override
			public int compare(ISubject s1, ISubject s2) {
				return s1.toString().compareToIgnoreCase(s2.toString());
			}
	    });
	}

	@Override
	public boolean hasThisSubject(ISubject newSubject) {
		boolean ok = false;
		for (ISubject subject : subjectList) {
			if (subject.equals(newSubject)) {
				ok = true;
			}
		}
		return ok;

	}

	@Override
	public List<ISubject> getSubjectsThatContainsThisStringInName(String name) {
		List<ISubject> returnList = new ArrayList<>();

		for (ISubject element : subjectList) {
			if (element.toString().contains(name)) {
				returnList.add(element);
			}
		}

		return returnList;
	}

}
