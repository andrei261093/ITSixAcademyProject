package itsix.academy.perfect_school.model;

import java.io.Serializable;

public interface ITeacher extends Serializable{

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
