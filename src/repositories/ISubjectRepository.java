package repositories;

import model.ISubject;

public interface ISubjectRepository {

	void addSubject(ISubject subject);

	ISubject getSubjectByName(String subjectName);

}
