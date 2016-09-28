package itsix.academy.perfect_school.repositories.implementations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.JOptionPane;

import itsix.academy.perfect_school.model.ISubject;
import itsix.academy.perfect_school.model.ITeacher;
import itsix.academy.perfect_school.repositories.ISubjectRepository;

public class SubjectRepository implements ISubjectRepository {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<ISubject> subjectList = new ArrayList<>();

	@Override
	public boolean addSubject(ISubject subject) {
		if (!subjectWithThisCodeExists(subject.getCode())) {
			subjectList.add(subject);
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "Duplicate subject CODE of subject already exists!");
		}
		return false;
	}

	public boolean subjectWithThisCodeExists(String code) {
		for (ISubject subject : subjectList) {
			if (subject.hasThisCode(code)) {
				return true;
			}
		}
		return false;
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
	public List<ISubject> getSubjectsThatContainsThisStringInName(String name) {
		List<ISubject> returnList = new ArrayList<>();

		for (ISubject element : subjectList) {
			if (element.toString().contains(name) || element.getCode().contains(name)) {
				returnList.add(element);
			}
		}

		return returnList;
	}

	@Override
	public void delete(ISubject subject) {
		subjectList.remove(subject);
	}

}
