package itsix.academy.perfect_school.view;



import java.util.List;

import itsix.academy.perfect_school.model.ISubject;
import itsix.academy.perfect_school.model.ITeacher;

public interface IManagementGUI {

	void updateTeachersComboBox(List<ITeacher> teachers);

	void updateSubjectsCombobox(List<ISubject> subjectList);

	void setVisible(boolean b);

	ISubject getSelectedSubject();

	ITeacher getSelectedTeacher();

	String getSelectedDay();

	String getSelectedHour();

	String getSelectedRoom();

	String getTeachersFirstName();

	String getTeachersLastName();

	String getTeachersEmail();

	String getTeachersAddress();

	String getTeachersTelephone();

	void clearInputs();

	String getSubjectName();

	String getSubjectCode();

}
