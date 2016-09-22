package itsix.academy.perfect_school.view;

import java.util.List;

import itsix.academy.perfect_school.model.ICourse;

public interface IDeleteCoursesGUI {

	void updateTable(List<ICourse> courses);

	void setVisible(boolean b);

	ICourse getSelectedCourse();

}
