package itsix.academy.perfect_school.model;

import java.io.Serializable;

public interface ICourse extends Serializable {

	String getHour();

	String getDay();

	ITeacher getTeacher();

	IRoom getRoom();

	ISubject getSubject();

	boolean hasThisSubjectAndTeacher(ISubject subject, ITeacher teacher);

	boolean hasThisTeacher(ITeacher teacher);

	boolean hasThisDay(String day);

	boolean hasThisHour(String hour);

	boolean hasThisSubject(ISubject subject);

	boolean hasThisRoom(IRoom room);

}
