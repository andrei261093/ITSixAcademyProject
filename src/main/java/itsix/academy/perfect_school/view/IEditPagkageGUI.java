package itsix.academy.perfect_school.view;

import java.util.List;

import itsix.academy.perfect_school.model.IPackage;
import itsix.academy.perfect_school.model.ISubject;

public interface IEditPagkageGUI {

	void updateSubjectsList(List<ISubject> subjects);

	void setVisible(boolean b);

	int getSelectedSubjectIndex();

	void setListSelection(int index);

	ISubject getSelectedSubject();

	String getPackageName();

	void showNameInput(boolean b);

}
