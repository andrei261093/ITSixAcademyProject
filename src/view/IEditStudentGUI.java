package view;

import java.util.List;

import model.IStage;

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

}
