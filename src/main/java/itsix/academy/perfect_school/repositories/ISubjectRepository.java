package itsix.academy.perfect_school.repositories;



import java.util.List;

import itsix.academy.perfect_school.model.ISubject;

public interface ISubjectRepository {

	void addSubject(ISubject subject);

	ISubject getSubjectByName(String subjectName);

	List<ISubject> getSubjectList();

	boolean hasThisSubject(ISubject newSubject);

}
