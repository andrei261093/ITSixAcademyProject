package itsix.academy.perfect_school.repositories.implementations;

import itsix.academy.perfect_school.model.IStudent;
import itsix.academy.perfect_school.repositories.ICompetenceRepository;
import itsix.academy.perfect_school.repositories.ICoursesRepository;
import itsix.academy.perfect_school.repositories.IMainRepository;
import itsix.academy.perfect_school.repositories.IRoomsRepository;
import itsix.academy.perfect_school.repositories.IStudentRepository;
import itsix.academy.perfect_school.repositories.ISubjectRepository;
import itsix.academy.perfect_school.repositories.ITeachersRepository;

public class MainRepository implements IMainRepository {
	ICompetenceRepository competenceR;
	ICoursesRepository courseR;
	IRoomsRepository roomsR;
	ISubjectRepository subjectR;
	IStudentRepository studentsR;
	ITeachersRepository teachersR;
	


	public MainRepository(ICompetenceRepository competenceR, ICoursesRepository courseR, IRoomsRepository roomsR,
			ISubjectRepository subjectR, IStudentRepository studentsR, ITeachersRepository teachersR) {
		super();
		this.competenceR = competenceR;
		this.courseR = courseR;
		this.roomsR = roomsR;
		this.subjectR = subjectR;
		this.studentsR = studentsR;
		this.teachersR = teachersR;
	}
	
	public ICompetenceRepository getCompetenceR() {
		return competenceR;
	}

	public ICoursesRepository getCourseR() {
		return courseR;
	}

	public IRoomsRepository getRoomsR() {
		return roomsR;
	}

	public ISubjectRepository getSubjectR() {
		return subjectR;
	}

	public IStudentRepository getStudentsR() {
		return studentsR;
	}

	public ITeachersRepository getTeachersR() {
		return teachersR;
	}
}
