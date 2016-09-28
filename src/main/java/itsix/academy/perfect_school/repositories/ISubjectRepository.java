package itsix.academy.perfect_school.repositories;

import java.io.Serializable;
import java.util.List;

import itsix.academy.perfect_school.model.ISubject;

public interface ISubjectRepository extends Serializable{

	boolean addSubject(ISubject subject);

	List<ISubject> getSubjectList();

	List<ISubject> getSubjectsThatContainsThisStringInName(String name);

	void delete(ISubject selectedJListSubject);

}
