package repositories;

import java.util.ArrayList;
import java.util.List;

import model.ISubject;

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

}
