package itsix.academy.perfect_school.view;



public interface IAddStudentGUI {
	public void setVisible(boolean ok);

	String getFirstName();

	String getLastName();

	String getTelephone();

	String getEmail();

	String getSSN();

	String getAddres();

	void clearInputs();

	boolean inputsAreValid();
}
