package view;

import java.util.List;

import model.ISubject;
import model.ITeacher;

public interface IAddMenuGUI {

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

}
