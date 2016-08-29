package repositories;

import java.util.List;

import model.ISubject;

public interface ISubjectRepository {

	void addSubject(ISubject subject);

	ISubject getSubjectByName(String subjectName);

	List<ISubject> getSubjectList();

	boolean hasThisSubject(ISubject newSubject);

}
