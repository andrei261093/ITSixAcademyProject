package itsix.academy.perfect_school.repositories;



import java.io.Serializable;
import java.util.List;

import itsix.academy.perfect_school.model.ISubject;

public interface ISubjectRepository extends Serializable{

	void addSubject(ISubject subject);

	ISubject getSubjectByName(String subjectName);

	List<ISubject> getSubjectList();

	boolean hasThisSubject(ISubject newSubject);

	List<ISubject> getSubjectsThatContainsThisStringInName(String name);

	void delete(ISubject selectedJListSubject);

}
