package itsix.academy.perfect_school.model;

public interface ICourse {

	String getHour();

	String getDay();

	boolean hasThisSubject(ISubject subject);

	ITeacher getTeacher();

	boolean hasThisSubjectAndTeacher(ISubject subject, ITeacher teacher);

	boolean hasThisTeacher(ITeacher teacher);

	boolean hasDay(String day);

	boolean hasHour(String hour);

	String getRoom();

	ISubject getSubject();

}
