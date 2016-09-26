package itsix.academy.perfect_school.model;

import java.io.Serializable;
import java.util.List;

public interface IPackage extends Serializable{

	List<ISubject> getSubjects();

}
