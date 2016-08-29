package controllers.implementations;

import javax.swing.JOptionPane;

import controllers.IAddMenuController;
import model.ICourse;
import model.ISubject;
import model.ITeacher;
import model.implementations.Course;
import model.implementations.Subject;
import model.implementations.Teacher;
import repositories.ICompetenceRepository;
import repositories.ICoursesRepository;
import repositories.IStudentRepository;
import repositories.ISubjectRepository;
import repositories.ITeachersRepository;
import repositories.implementations.CompetenceRepository;
import repositories.implementations.CoursesRepository;
import repositories.implementations.StudentRepository;
import repositories.implementations.SubjectRepository;
import repositories.implementations.TeachersRepository;
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
	public void saveCourse() {
		ICourse newCourse = new Course(addMenuGUI.getSelectedSubject(), addMenuGUI.getSelectedTeacher(),
				addMenuGUI.getSelectedDay(), addMenuGUI.getSelectedHour(), addMenuGUI.getSelectedRoom());
		if (!courseRepository.hasThisCourse(newCourse)) {
			courseRepository.addCourse(newCourse);
		} else {
			JOptionPane.showMessageDialog(null, "The course exists already!");
		}
	}

	@Override
	public void saveTeacher() {
		ITeacher newTeacher = new Teacher(addMenuGUI.getTeachersFirstName(), addMenuGUI.getTeachersLastName(),
				addMenuGUI.getTeachersEmail(), addMenuGUI.getTeachersAddress(), addMenuGUI.getTeachersTelephone());
		
		if (!teachersRepository.hasThisTeacher(newTeacher)) {
			teachersRepository.addTeacher(newTeacher);
			addMenuGUI.clearInputs();
		}else{
			JOptionPane.showMessageDialog(null, "The teacher exists already!");
		}
	}

	@Override
	public void saveSubject() {
		ISubject newSubject = new Subject(addMenuGUI.getSubjectName() , addMenuGUI.getSubjectCode());
		
		if (!subjectRepository.hasThisSubject(newSubject)) {
			subjectRepository.addSubject(newSubject);
			addMenuGUI.clearInputs();
		}else{
			JOptionPane.showMessageDialog(null, "The subject exists already!");
		}
	}

}
