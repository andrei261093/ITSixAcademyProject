package itsix.academy.perfect_school.view;

import java.util.List;

import itsix.academy.perfect_school.model.ISubject;

public interface IAddSubjectToPackage {

	void updateSubjectsList(List<ISubject> subjects);

	String getText();

	void setVisible(boolean b);

	List<ISubject> getSelectedSubjects();

}
