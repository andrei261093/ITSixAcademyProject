package itsix.academy.perfect_school.model;

import java.util.List;

public interface IStage {

	public void addSubject(ISubject subject);

	public void deleteSubject(ISubject subject);

	public List<ISubject> getSubjectList();

	public boolean hasNoSubjects();

	void setCourses(List<ICourse> courses);

	List<ICourse> getCourses();

}
