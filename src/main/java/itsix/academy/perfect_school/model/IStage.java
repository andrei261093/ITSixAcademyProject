package itsix.academy.perfect_school.model;

import java.io.Serializable;
import java.util.List;

public interface IStage extends Serializable{

	public void addSubject(ISubject subject);

	public void deleteSubject(ISubject subject);

	public List<ISubject> getSubjectList();

	public boolean hasNoSubjects();

	void setCourses(List<ICourse> courses);

	List<ICourse> getCourses();

	void deleteSubjects(List<ISubject> deleteList);

	void addSubjects(List<ISubject> newSubjectsList);

	boolean hasThisSubject(ISubject subject);

}
