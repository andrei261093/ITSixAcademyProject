package controllers;

import model.Course;
import model.ICourse;
import repositories.CompetenceRepository;
import repositories.CoursesRepository;
import repositories.ICompetenceRepository;
import repositories.ICoursesRepository;
import repositories.IStudentRepository;
import repositories.ISubjectRepository;
import repositories.ITeachersRepository;
import repositories.StudentRepository;
import repositories.SubjectRepository;
import repositories.TeachersRepository;
import view.IAddMenuGUI;

public class AddMenuController implements IAddMenuController {
	IAddMenuGUI addMenuGUI;

	ICompetenceRepository competenceRepository;
	ICoursesRepository courseRepository;
	ISubjectRepository subjectRepository;
	ITeachersRepository teachersRepository;
	IStudentRepository studentsRepository;

	public AddMenuController(ICompetenceRepository competenceRepository, ICoursesRepository courseRepository,
			ISubjectRepository subjectRepository, ITeachersRepository teachersRepository,
			IStudentRepository studentsRepository) {
		super();
		this.competenceRepository = competenceRepository;
		this.courseRepository = courseRepository;
		this.subjectRepository = subjectRepository;
		this.teachersRepository = teachersRepository;
		this.studentsRepository = studentsRepository;
	}

	@Override
	public void setAddMenuGUI(IAddMenuGUI addMenuGUI) {
		this.addMenuGUI = addMenuGUI;
	}

	@Override
	public void updateAll() {
		addMenuGUI.updateTeachersComboBox(teachersRepository.getTeachers());
		addMenuGUI.updateSubjectsCombobox(subjectRepository.getSubjectList());
		// addMenuGUI.updateRoomComboBox();

	}

	@Override
	public void showAddMenuGUI() {
		addMenuGUI.setVisible(true);
		
	}

	@Override
	public void saveTeacher() {
		ICourse newCourse = new Course(addMenuGUI.getSelectedSubject(), addMenuGUI.getSelectedTeacher(), addMenuGUI.getSelectedDay(), addMenuGUI.getSelectedHour(), addMenuGUI.getSelectedRoom());
		if(!courseRepository.hasThisCourse(newCourse)){
			courseRepository.addCourse(newCourse);
			System.out.println("curs adaugat");
		}else{
			System.out.println("mai e cursul asta");
		}
	}

}
