package itsix.academy.perfect_school.repositories.implementations;



import java.util.ArrayList;
import java.util.List;

import itsix.academy.perfect_school.model.ISubject;
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
		return subjectList;
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

}
