package model;

public class Course implements ICourse {
	ISubject subject;
	ITeacher teacher;
	String dayOfWeek;
	String time;
	String room;

	public Course(ISubject subject, ITeacher teacher, String dayOfWeek, String time, String room) {
		super();
		this.subject = subject;
		this.teacher = teacher;
		this.dayOfWeek = dayOfWeek;
		this.time = time;
		this.room = room;
	}

	@Override
	public boolean hasThisSubject(ISubject subject) {
		return this.subject.equals(subject);
	}

	@Override
	public ITeacher getTeacher() {
		return teacher;
	}

	@Override
	public boolean hasThisSubjectAndTeacher(ISubject subject, ITeacher teacher) {
		return hasThisSubject(subject) && hasThisTeacher(teacher);
	}
	
	@Override
	public boolean hasThisTeacher(ITeacher teacher) {
		return this.teacher.equals(teacher);
	}

	@Override
	public String toString() {
		return subject + "";
	}

	@Override
	public String getHour() {
		return time;
	}

	@Override
	public String getDay() {
		return dayOfWeek;
	}

	@Override
	public boolean hasDay(String day) {
		return this.dayOfWeek.equals(day);
	}

	@Override
	public boolean hasHour(String hour) {
		return this.time.equals(hour);
	}

	@Override
	public String getRoom() {
		return room;
	}

	@Override
	public ISubject getSubject() {
		return subject;
	}
	
	


}
