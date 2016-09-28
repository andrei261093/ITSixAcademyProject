package itsix.academy.perfect_school.model;

import java.io.Serializable;

public interface ISubject extends Serializable{

	boolean hasThisName(String subjectName);

	String getCode();

	boolean hasThisCode(String code);

}
