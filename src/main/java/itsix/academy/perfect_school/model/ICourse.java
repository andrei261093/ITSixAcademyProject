package itsix.academy.perfect_school.model;

import java.io.Serializable;

public interface ICourse extends Serializable{

	String getHour();

	String getDay();

	boolean hasThisSubject(ISubject subject);

	ITeacher getTeacher();

	boolean hasThisSubjectAndTeacher(ISubject subject, ITeacher teacher);

	boolean hasThisTeacher(ITeacher teacher);

	boolean hasDay(String day);

	boolean hasHour(String hour);

	IRoom getRoom();

	ISubject getSubject();

}
