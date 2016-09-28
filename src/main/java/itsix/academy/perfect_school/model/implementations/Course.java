package itsix.academy.perfect_school.model.implementations;

import itsix.academy.perfect_school.model.ICourse;
import itsix.academy.perfect_school.model.IRoom;
import itsix.academy.perfect_school.model.ISubject;
import itsix.academy.perfect_school.model.ITeacher;

public class Course implements ICourse {
	ISubject subject;
	ITeacher teacher;
	String dayOfWeek;
	String time;
	IRoom room;

	public Course(ISubject subject, ITeacher teacher, String dayOfWeek, String time, IRoom room) {
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
	public boolean hasThisDay(String day) {
		return this.dayOfWeek.equals(day);
	}

	@Override
	public boolean hasThisHour(String hour) {
		return this.time.equals(hour);
	}

	@Override
	public IRoom getRoom() {
		return room;
	}

	@Override
	public ISubject getSubject() {
		return subject;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dayOfWeek == null) ? 0 : dayOfWeek.hashCode());
		result = prime * result + ((room == null) ? 0 : room.hashCode());
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
		result = prime * result + ((teacher == null) ? 0 : teacher.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (dayOfWeek == null) {
			if (other.dayOfWeek != null)
				return false;
		} else if (!dayOfWeek.equals(other.dayOfWeek))
			return false;
		if (room == null) {
			if (other.room != null)
				return false;
		} else if (!room.equals(other.room))
			return false;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		if (teacher == null) {
			if (other.teacher != null)
				return false;
		} else if (!teacher.equals(other.teacher))
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		return true;
	}

	@Override
	public boolean hasThisRoom(IRoom room) {
		return this.room.equals(room);
	}
	
	


}
