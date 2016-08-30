package itsix.academy.perfect_school.view;



import java.util.List;

import itsix.academy.perfect_school.model.IStage;

public interface IEditStudentGUI {

	String getFirstName();

	String getLastName();

	String getTelephone();

	String getEmail();

	String getAddress();

	String getSSN();

	void setFirstName(String name);

	void setLastName(String name);

	void setTelephone(String telephone);

	void setEmail(String email);

	void setAddress(String address);

	void updateComboBox(List<IStage> stageList);

	void setVisible(boolean b);

	IStage getSelectedStage();

	void clearCombobox();

	void buttonsSetEnabled(boolean b);

	void inputsSetEnabled(boolean b);

}
