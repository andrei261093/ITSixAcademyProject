package itsix.academy.perfect_school.view;



import java.util.List;

import itsix.academy.perfect_school.model.ICompetence;
import itsix.academy.perfect_school.model.IPackage;
import itsix.academy.perfect_school.model.IRoom;
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

	IRoom getSelectedRoom();

	String getTeachersFirstName();

	String getTeachersLastName();

	String getTeachersEmail();

	String getTeachersAddress();

	String getTeachersTelephone();

	void clearInputs();

	String getSubjectName();

	String getSubjectCode();

	void updateRoomsComboBox(List<IRoom> rooms);

	String getInputRoomName();

	void updateCompetenceList(List<ICompetence> competences);

	ICompetence getSelectedListCompetence();

	void updatePackagesList(ICompetence competence);

	IPackage getSelectedPackage();

	boolean isACompetenceSelected();

	boolean isAPackageSelected();

	void updateRoomsList(List<IRoom> rooms);

	IRoom getSelectedJListRoom();

	boolean isARoomSelected();

	void updateTeachersList(List<ITeacher> teachers);

	ITeacher getSelectedJListTeacher();

	boolean isATeacherSelected();

	void updateSubjectsList(List<ISubject> subjects);

	ISubject getSelectedJListSubject();

	boolean isASubjectSelected();

}
