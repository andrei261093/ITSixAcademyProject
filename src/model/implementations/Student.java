package model.implementations;

import java.util.ArrayList;
import java.util.List;

import model.IStage;
import model.IStudent;

public class Student implements IStudent {
	List<IStage> stageList = new ArrayList<>();
	String firstName;
	String lastName;
	String telephone;
	String address;
	String email;
	String ssn;

	public Student(String firstName, String lastName, String telephone, String address, String email, String ssn) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.telephone = telephone;
		this.address = address;
		this.email = email;
		this.ssn = ssn;
	}

	@Override
	public void setStages(List<IStage> stageList) {
		this.stageList = stageList;
	}

	@Override
	public List<IStage> getStages() {
		return stageList;
	}
	
	@Override
	public boolean hasThisSSN(String ssn){
		return this.ssn.equals(ssn);
	}
	@Override
	public String getFirstName() {
		return firstName;
	}
	@Override
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@Override
	public String getLastName() {
		return lastName;
	}
	@Override
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Override
	public String getTelephone() {
		return telephone;
	}
	@Override
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	@Override
	public String getAddress() {
		return address;
	}
	@Override
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String getEmail() {
		return email;
	}
	@Override
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String getSsn() {
		return ssn;
	}
	@Override
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	// Equals override
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((ssn == null) ? 0 : ssn.hashCode());
		result = prime * result + ((stageList == null) ? 0 : stageList.hashCode());
		result = prime * result + ((telephone == null) ? 0 : telephone.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (ssn == null) {
			if (other.ssn != null)
				return false;
		} else if (!ssn.equals(other.ssn))
			return false;
		if (stageList == null) {
			if (other.stageList != null)
				return false;
		} else if (!stageList.equals(other.stageList))
			return false;
		if (telephone == null) {
			if (other.telephone != null)
				return false;
		} else if (!telephone.equals(other.telephone))
			return false;
		return true;
	}

}
