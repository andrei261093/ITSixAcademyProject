package itsix.academy.perfect_school.model;

import java.util.List;

public interface IStudent {

	void setStages(List<IStage> stageList);

	List<IStage> getStages();

	boolean hasThisSSN(String ssn);

	void setSsn(String ssn);

	String getSsn();

	void setEmail(String email);

	String getEmail();

	void setAddress(String address);

	String getAddress();

	void setTelephone(String telephone);

	String getTelephone();

	void setLastName(String lastName);

	String getLastName();

	void setFirstName(String firstName);

	String getFirstName();

}
