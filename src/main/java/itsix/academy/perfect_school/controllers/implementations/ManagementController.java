package itsix.academy.perfect_school.controllers.implementations;

import javax.swing.JOptionPane;

import itsix.academy.perfect_school.controllers.IEditPackageController;
import itsix.academy.perfect_school.controllers.IManagementController;
import itsix.academy.perfect_school.model.ICourse;
import itsix.academy.perfect_school.model.IRoom;
import itsix.academy.perfect_school.model.ISubject;
import itsix.academy.perfect_school.model.ITeacher;
import itsix.academy.perfect_school.model.implementations.Course;
import itsix.academy.perfect_school.model.implementations.Room;
import itsix.academy.perfect_school.model.implementations.Subject;
import itsix.academy.perfect_school.model.implementations.Teacher;
import itsix.academy.perfect_school.repositories.ICompetenceRepository;
import itsix.academy.perfect_school.repositories.ICoursesRepository;
import itsix.academy.perfect_school.repositories.IRoomsRepository;
import itsix.academy.perfect_school.repositories.IStudentRepository;
import itsix.academy.perfect_school.repositories.ISubjectRepository;
import itsix.academy.perfect_school.repositories.ITeachersRepository;
import itsix.academy.perfect_school.view.IManagementGUI;

public class ManagementController implements IManagementController {
	IManagementGUI managementGUI;

	private ICompetenceRepository competenceRepository;
	private ICoursesRepository courseRepository;
	private ISubjectRepository subjectRepository;
	private ITeachersRepository teachersRepository;
	private IStudentRepository studentsRepository;

	private IRoomsRepository roomsRepository;

	public ManagementController(ICompetenceRepository competenceRepository, ICoursesRepository courseRepository,
			ISubjectRepository subjectRepository, ITeachersRepository teachersRepository,
			IStudentRepository studentsRepository, IRoomsRepository roomsRepository) {
		super();
		this.competenceRepository = competenceRepository;
		this.courseRepository = courseRepository;
		this.subjectRepository = subjectRepository;
		this.teachersRepository = teachersRepository;
		this.studentsRepository = studentsRepository;
		this.roomsRepository = roomsRepository;
	}

	@Override
	public void setAddMenuGUI(IManagementGUI addMenuGUI) {
		this.managementGUI = addMenuGUI;
	}

	@Override
	public void updateAll() {
		managementGUI.updateTeachersComboBox(teachersRepository.getTeachers());
		managementGUI.updateSubjectsCombobox(subjectRepository.getSubjectList());
		managementGUI.updateRoomsComboBox(roomsRepository.getRoomsList());
		managementGUI.updateCompetenceList(competenceRepository.getCompetences());

	}

	@Override
	public void showAddMenuGUI() {
		managementGUI.setVisible(true);

	}

	@Override
	public void saveCourse() {
		ICourse newCourse = new Course(managementGUI.getSelectedSubject(), managementGUI.getSelectedTeacher(),
				managementGUI.getSelectedDay(), managementGUI.getSelectedHour(), managementGUI.getSelectedRoom());
		if (!courseRepository.hasThisCourse(newCourse)) {
			courseRepository.addCourse(newCourse);
			JOptionPane.showMessageDialog(null, "Course Saved!");
		} else {
			JOptionPane.showMessageDialog(null, "The course exists already!");
		}
	}

	@Override
	public void saveTeacher() {
		ITeacher newTeacher = new Teacher(managementGUI.getTeachersFirstName(), managementGUI.getTeachersLastName(),
				managementGUI.getTeachersEmail(), managementGUI.getTeachersAddress(), managementGUI.getTeachersTelephone());

		if (!teachersRepository.hasThisTeacher(newTeacher)) {
			teachersRepository.addTeacher(newTeacher);
			managementGUI.clearInputs();
			JOptionPane.showMessageDialog(null, "Teacher Saved!");
		} else {
			JOptionPane.showMessageDialog(null, "The teacher exists already!");
		}
	}

	@Override
	public void saveSubject() {
		ISubject newSubject = new Subject(managementGUI.getSubjectName(), managementGUI.getSubjectCode());

		if (!subjectRepository.hasThisSubject(newSubject)) {
			subjectRepository.addSubject(newSubject);
			managementGUI.clearInputs();
			JOptionPane.showMessageDialog(null, "Subject Saved!");
		} else {
			JOptionPane.showMessageDialog(null, "The subject exists already!");
		}
	}

	@Override
	public void saveRoom() {
		IRoom newRoom = new Room(managementGUI.getInputRoomName());

		if (!roomsRepository.hasThisRoom(newRoom)) {
			roomsRepository.addRoom(newRoom);
			managementGUI.clearInputs();
			JOptionPane.showMessageDialog(null, "Room Saved!");
		} else {
			JOptionPane.showMessageDialog(null, "This Room already exists!");
		}

	}

	@Override
	public void updatePackagesList() {
		managementGUI.updatePackagesList(managementGUI.getSelectedListCompetence());
	}

	@Override
	public void editPackage() {
		IEditPackageController editPackageController = new EditPackageController();
		editPackageController.editPackage(managementGUI.getSelectedPackage());
	}

}
