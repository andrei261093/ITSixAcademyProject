package model;

import java.util.List;

public interface IStage {

	public void addSubject(ISubject subject);

	public void deleteSubject(ISubject subject);

	public List<ISubject> getSubjectList();

	public boolean hasNoSubjects();

}
