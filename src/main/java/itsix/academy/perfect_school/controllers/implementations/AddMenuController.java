package itsix.academy.perfect_school.controllers.implementations;



import javax.swing.JOptionPane;

import itsix.academy.perfect_school.controllers.IAddMenuController;
import itsix.academy.perfect_school.model.ICourse;
import itsix.academy.perfect_school.model.ISubject;
import itsix.academy.perfect_school.model.ITeacher;
import itsix.academy.perfect_school.model.implementations.Course;
import itsix.academy.perfect_school.model.implementations.Subject;
import itsix.academy.perfect_school.model.implementations.Teacher;
import itsix.academy.perfect_school.repositories.ICompetenceRepository;
import itsix.academy.perfect_school.repositories.ICoursesRepository;
import itsix.academy.perfect_school.repositories.IStudentRepository;
import itsix.academy.perfect_school.repositories.ISubjectRepository;
import itsix.academy.perfect_school.repositories.ITeachersRepository;
import itsix.academy.perfect_school.view.IManagementGUI;

public class AddMenuController implements IAddMenuController {
	IManagementGUI addMenuGUI;

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
	public void setAddMenuGUI(IManagementGUI addMenuGUI) {
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
			JOptionPane.showMessageDialog(null, "Course Saved!");
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
			JOptionPane.showMessageDialog(null, "Teacher Saved!");
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
			JOptionPane.showMessageDialog(null, "Subject Saved!");
		}else{
			JOptionPane.showMessageDialog(null, "The subject exists already!");
		}
	}

}
