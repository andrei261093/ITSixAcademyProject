package itsix.academy.perfect_school.repositories;

import java.io.Serializable;

public interface IMainRepository extends Serializable {
	public ICompetenceRepository getCompetenceR();

	public ICoursesRepository getCourseR();

	public IRoomsRepository getRoomsR();

	public ISubjectRepository getSubjectR();

	public IStudentRepository getStudentsR();

	public ITeachersRepository getTeachersR();
}
