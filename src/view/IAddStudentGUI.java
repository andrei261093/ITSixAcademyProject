package view;

public interface IAddStudentGUI {
	public void setVisible(boolean ok);

	void initialize();

	String getFirstName();

	String getLastName();

	String getTelephone();

	String getEmail();

	String getSSN();

	String getAddres();

	void clearInputs();
}
