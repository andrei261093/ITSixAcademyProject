package itsix.academy.perfect_school.model;

public interface ITeacher {

	boolean hasThisName(String teacherName);

	String getAddress();

	String getFirstName();

	String getLastName();

	String getEmail();

	String getTelephone();

	void setFirstName(String firstName);

	void setLastName(String lastName);

	void setEmail(String email);

	void setAddress(String address);

	void setTelephone(String telephone);

}
