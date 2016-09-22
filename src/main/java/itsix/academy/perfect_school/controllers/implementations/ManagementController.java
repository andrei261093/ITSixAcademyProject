package itsix.academy.perfect_school.controllers.implementations;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import itsix.academy.perfect_school.controllers.IDeleteCourseController;
import itsix.academy.perfect_school.controllers.IEditPackageController;
import itsix.academy.perfect_school.controllers.IManagementController;
import itsix.academy.perfect_school.controllers.ITeacherInfoController;
import itsix.academy.perfect_school.model.ICompetence;
import itsix.academy.perfect_school.model.ICourse;
import itsix.academy.perfect_school.model.IRoom;
import itsix.academy.perfect_school.model.ISubject;
import itsix.academy.perfect_school.model.ITeacher;
import itsix.academy.perfect_school.model.implementations.Competence;
import itsix.academy.perfect_school.model.implementations.Course;
import itsix.academy.perfect_school.model.implementations.Room;
import itsix.academy.perfect_school.model.implementations.Subject;
import itsix.academy.perfect_school.model.implementations.Teacher;
import itsix.academy.perfect_school.publisherSubscriber.IInnerPublisher;
import itsix.academy.perfect_school.publisherSubscriber.ISubscriber;
import itsix.academy.perfect_school.publisherSubscriber.implementations.Publisher;
import itsix.academy.perfect_school.repositories.ICompetenceRepository;
import itsix.academy.perfect_school.repositories.ICoursesRepository;
import itsix.academy.perfect_school.repositories.IRoomsRepository;
import itsix.academy.perfect_school.repositories.IStudentRepository;
import itsix.academy.perfect_school.repositories.ISubjectRepository;
import itsix.academy.perfect_school.repositories.ITeachersRepository;
import itsix.academy.perfect_school.view.IManagementGUI;
import itsix.academy.perfect_school.view.implementations.EnterNameGUI;

public class ManagementController implements IManagementController {
	IManagementGUI managementGUI;
	EnterNameGUI enterNameGUI;

	private ICompetenceRepository competenceRepository;
	private ICoursesRepository courseRepository;
	private ISubjectRepository subjectRepository;
	private ITeachersRepository teachersRepository;

	private IRoomsRepository roomsRepository;

	private IInnerPublisher publisher;

	private IDeleteCourseController deleteCourseController;
	private ITeacherInfoController teacherInfoController;

	public ManagementController(ICompetenceRepository competenceRepository, ICoursesRepository courseRepository,
			ISubjectRepository subjectRepository, ITeachersRepository teachersRepository,
			IStudentRepository studentsRepository, IRoomsRepository roomsRepository) {
		super();
		this.competenceRepository = competenceRepository;
		this.courseRepository = courseRepository;
		this.subjectRepository = subjectRepository;
		this.teachersRepository = teachersRepository;
		this.roomsRepository = roomsRepository;
		
		enterNameGUI = new EnterNameGUI(this);
		
		List<ISubscriber> subscribers = new ArrayList<>();
		publisher = new Publisher(subscribers);
		
		deleteCourseController = new DeleteCourseController(courseRepository);
		teacherInfoController = new TeacherInfoController();
	}

	@Override
	public void setAddMenuGUI(IManagementGUI addMenuGUI) {
		this.managementGUI = addMenuGUI;
		updateAll();
	}

	@Override
	public void updateAll() {
		managementGUI.updateTeachersComboBox(teachersRepository.getTeachers());
		managementGUI.updateSubjectsCombobox(subjectRepository.getSubjectList());
		managementGUI.updateRoomsComboBox(roomsRepository.getRoomsList());
		managementGUI.updateCompetenceList(competenceRepository.getCompetences());
		managementGUI.updateRoomsList(roomsRepository.getRoomsList());
		managementGUI.updateTeachersList(teachersRepository.getTeachers());
		managementGUI.updateSubjectsList(subjectRepository.getSubjectList());
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
				managementGUI.getTeachersEmail(), managementGUI.getTeachersAddress(),
				managementGUI.getTeachersTelephone());

		if (!teachersRepository.hasThisTeacher(newTeacher)) {
			teachersRepository.addTeacher(newTeacher);
			managementGUI.clearInputs();
			updateAll();
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
			updateAll();
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
			updateAll();
		} else {
			JOptionPane.showMessageDialog(null, "This Room already exists!");
		}

	}

	@Override
	public void editPackage() {
		List<ISubscriber> subscribers = new ArrayList<>();
		IInnerPublisher publisher = new Publisher(subscribers);
		IEditPackageController editPackageController = new EditPackageController(subjectRepository, publisher);
		editPackageController.subscribe(this);
		editPackageController.editPackage(managementGUI.getSelectedPackage());
	}

	@Override
	public void addPackage() {
		if (managementGUI.isACompetenceSelected()) {
			IEditPackageController editPackageController = new EditPackageController(subjectRepository, publisher);
			editPackageController.subscribe(this);
			editPackageController.addPackage(managementGUI.getSelectedListCompetence());
		} else {
			JOptionPane.showMessageDialog(null, "Please select a Competence!");
		}
	}

	@Override
	public void updatePackagesList() {
		managementGUI.updatePackagesList(managementGUI.getSelectedListCompetence());

	}

	@Override
	public void addNewCompetence() {
		ICompetence newCompetence = new Competence(enterNameGUI.getInput());
		competenceRepository.addCompetence(newCompetence);
		enterNameGUI.setVisible(false);
		JOptionPane.showMessageDialog(null, "Saved! You can now edit your new competence!");
		managementGUI.updateCompetenceList(competenceRepository.getCompetences());
	}

	@Override
	public void createCompetence() {
		enterNameGUI.setVisible(true);
	}

	@Override
	public void deleteCompetence() {
		if (managementGUI.isACompetenceSelected()) {
			competenceRepository.deleteCompetence(managementGUI.getSelectedListCompetence());
			managementGUI.updateCompetenceList(competenceRepository.getCompetences());
			managementGUI.updatePackagesList(new Competence(""));

		} else {
			JOptionPane.showMessageDialog(null, "Please select a Competence!");
		}

	}

	@Override
	public void deletePackage() {
		if (managementGUI.isAPackageSelected()) {
			managementGUI.getSelectedListCompetence().deletePackage(managementGUI.getSelectedPackage());
			managementGUI.updatePackagesList(managementGUI.getSelectedListCompetence());

		} else {
			JOptionPane.showMessageDialog(null, "Please select a Package!");
		}
	}

	@Override
	public void deleteCourses() {
		deleteCourseController.showGUI();
	}

	@Override
	public void deleteRoom() {
		if (managementGUI.isARoomSelected()) {
			roomsRepository.delete(managementGUI.getSelectedJListRoom());
			managementGUI.updateRoomsList(roomsRepository.getRoomsList());

		} else {
			JOptionPane.showMessageDialog(null, "Please select a Room!");
		}

	}

	@Override
	public void deleteTeacher() {
		if (managementGUI.isATeacherSelected()) {
			teachersRepository.delete(managementGUI.getSelectedJListTeacher());
			updateAll();
		} else {
			JOptionPane.showMessageDialog(null, "Please select a Teacher!");
		}

	}

	@Override
	public void deleteSubject() {
		if (managementGUI.isASubjectSelected()) {
			subjectRepository.delete(managementGUI.getSelectedJListSubject());
			updateAll();
		} else {
			JOptionPane.showMessageDialog(null, "Please select a Subject!");
		}

	}

	@Override
	public void showTeacherInfo() {
		teacherInfoController.showInfo(managementGUI.getSelectedJListTeacher());

	}

}
