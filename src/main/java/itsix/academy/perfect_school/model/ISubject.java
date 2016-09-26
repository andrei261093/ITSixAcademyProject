package itsix.academy.perfect_school.model;

import java.io.Serializable;
import java.util.List;

public interface ISubject extends Serializable{

	boolean hasThisName(String subjectName);

	String getCode();

}
