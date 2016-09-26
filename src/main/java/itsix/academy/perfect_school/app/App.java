package itsix.academy.perfect_school.app;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import itsix.academy.perfect_school.controllers.IManagementController;
import itsix.academy.perfect_school.controllers.IAddStudentController;
import itsix.academy.perfect_school.controllers.IEditStudentController;
import itsix.academy.perfect_school.controllers.IScheduleController;
import itsix.academy.perfect_school.controllers.implementations.ManagementController;
import itsix.academy.perfect_school.controllers.implementations.AddStudentController;
import itsix.academy.perfect_school.controllers.implementations.EditStudentController;
import itsix.academy.perfect_school.controllers.implementations.ScheduleController;
import itsix.academy.perfect_school.model.ICompetence;
import itsix.academy.perfect_school.model.ICourse;
import itsix.academy.perfect_school.model.IPackage;
import itsix.academy.perfect_school.model.IRoom;
import itsix.academy.perfect_school.model.ISubject;
import itsix.academy.perfect_school.model.ITeacher;
import itsix.academy.perfect_school.model.implementations.Competence;
import itsix.academy.perfect_school.model.implementations.Course;
import itsix.academy.perfect_school.model.implementations.Package;
import itsix.academy.perfect_school.model.implementations.Room;
import itsix.academy.perfect_school.model.implementations.Subject;
import itsix.academy.perfect_school.model.implementations.Teacher;
import itsix.academy.perfect_school.repositories.ICompetenceRepository;
import itsix.academy.perfect_school.repositories.ICoursesRepository;
import itsix.academy.perfect_school.repositories.IMainRepository;
import itsix.academy.perfect_school.repositories.IParser;
import itsix.academy.perfect_school.repositories.IRoomsRepository;
import itsix.academy.perfect_school.repositories.IStudentRepository;
import itsix.academy.perfect_school.repositories.ISubjectRepository;
import itsix.academy.perfect_school.repositories.ITeachersRepository;
import itsix.academy.perfect_school.repositories.implementations.CompetenceRepository;
import itsix.academy.perfect_school.repositories.implementations.CoursesRepository;
import itsix.academy.perfect_school.repositories.implementations.MainRepository;
import itsix.academy.perfect_school.repositories.implementations.ParseObjectsFile;
import itsix.academy.perfect_school.repositories.implementations.RoomsRepository;
import itsix.academy.perfect_school.repositories.implementations.StudentRepository;
import itsix.academy.perfect_school.repositories.implementations.SubjectRepository;
import itsix.academy.perfect_school.repositories.implementations.TeachersRepository;
import itsix.academy.perfect_school.view.IAddCompetenceGUI;
import itsix.academy.perfect_school.view.IAddStudentGUI;
import itsix.academy.perfect_school.view.IMainWindowGUI;
import itsix.academy.perfect_school.view.IManagementGUI;
import itsix.academy.perfect_school.view.ISelectCompetencesGUI;
import itsix.academy.perfect_school.view.implementations.AddCompetenceGUI;
import itsix.academy.perfect_school.view.implementations.AddStudentGUI;
import itsix.academy.perfect_school.view.implementations.MainWindowGUI;
import itsix.academy.perfect_school.view.implementations.ManagementGUI;
import itsix.academy.perfect_school.view.implementations.SelectCompetencesGUI;

public class App {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

		/*
		 * ICompetenceRepository competenceRepository = new
		 * CompetenceRepository(); ICoursesRepository courseRepository = new
		 * CoursesRepository(); ISubjectRepository subjectRepository = new
		 * SubjectRepository(); ITeachersRepository teachersRepository = new
		 * TeachersRepository(); IStudentRepository studentsRepository = new
		 * StudentRepository(); IRoomsRepository roomsReporitory = new
		 * RoomsRepository();
		 * 
		 * IMainRepository mainRepository = new
		 * MainRepository(competenceRepository, courseRepository,
		 * roomsReporitory, subjectRepository, studentsRepository,
		 * teachersRepository);
		 */

		IParser parser = new ParseObjectsFile();

		IMainRepository mainRepository = parser.deserializeRepository();

		ICompetenceRepository competenceRepository = mainRepository.getCompetenceR();
		ICoursesRepository courseRepository = mainRepository.getCourseR();
		ISubjectRepository subjectRepository = mainRepository.getSubjectR();
		ITeachersRepository teachersRepository = mainRepository.getTeachersR();
		IStudentRepository studentsRepository = mainRepository.getStudentsR();
		IRoomsRepository roomsReporitory = mainRepository.getRoomsR();

		/*
		 * 
		 * ISubject oop = new Subject("oop"); ISubject vpe = new Subject("vpe");
		 * ISubject dnad = new Subject("dnad"); ISubject pc = new Subject("pc");
		 * ISubject cp = new Subject("cp"); ISubject ai = new Subject("ai");
		 * ISubject pt = new Subject("pt"); ISubject ood = new Subject("ood");
		 * ISubject nm = new Subject("nm"); ISubject ds = new Subject("ds");
		 * ISubject os = new Subject("os");
		 * 
		 * subjectRepository.addSubject(oop); subjectRepository.addSubject(vpe);
		 * subjectRepository.addSubject(dnad); subjectRepository.addSubject(pc);
		 * subjectRepository.addSubject(cp); subjectRepository.addSubject(ai);
		 * subjectRepository.addSubject(pt); subjectRepository.addSubject(nm);
		 * subjectRepository.addSubject(ds); subjectRepository.addSubject(os);
		 * subjectRepository.addSubject(ood);
		 * 
		 * ITeacher brezovan = new Teacher("Brezovan"); ITeacher spahiu = new
		 * Teacher("Spahiu"); ITeacher mariusMarian = new Teacher(
		 * "Marius Marian"); ITeacher stanescu = new Teacher("Stanescu");
		 * ITeacher udristoiu = new Teacher("Udristoiu"); ITeacher lemeni = new
		 * Teacher("Lemeni");
		 * 
		 * teachersRepository.addTeacher(brezovan);
		 * teachersRepository.addTeacher(spahiu);
		 * teachersRepository.addTeacher(mariusMarian);
		 * teachersRepository.addTeacher(udristoiu);
		 * teachersRepository.addTeacher(lemeni);
		 * teachersRepository.addTeacher(stanescu);
		 * 
		 * IRoom ACB = new Room("ACB"); IRoom c1 = new Room("C1"); IRoom c2 =
		 * new Room("C2"); IRoom s2 = new Room("S2"); IRoom c4 = new Room("C4");
		 * 
		 * roomsReporitory.addRoom(c4); roomsReporitory.addRoom(c2);
		 * roomsReporitory.addRoom(c1); roomsReporitory.addRoom(s2);
		 * roomsReporitory.addRoom(ACB);
		 * 
		 * ICourse course1 = new Course(oop, brezovan, "Luni", "14:00", ACB);
		 * ICourse course2 = new Course(os, udristoiu, "Marti", "16:00", c1);
		 * ICourse course3 = new Course(vpe, spahiu, "Vineri", "12:00", c2);
		 * ICourse course4 = new Course(vpe, spahiu, "Marti", "10:00", c4);
		 * ICourse course5 = new Course(vpe, stanescu, "Joi", "08:00", s2);
		 * ICourse course6 = new Course(dnad, lemeni, "Mirecuri", "10:00", ACB);
		 * ICourse course7 = new Course(dnad, mariusMarian, "Vineri", "18:00",
		 * ACB);
		 * 
		 * courseRepository.addCourse(course7);
		 * courseRepository.addCourse(course6);
		 * courseRepository.addCourse(course5);
		 * courseRepository.addCourse(course4);
		 * courseRepository.addCourse(course3);
		 * courseRepository.addCourse(course2);
		 * courseRepository.addCourse(course1);
		 * 
		 * List<ISubject> lista1 = new ArrayList<>(); lista1.add(cp);
		 * lista1.add(pt); lista1.add(oop); lista1.add(vpe);
		 * 
		 * List<ISubject> lista2 = new ArrayList<>(); lista2.add(cp);
		 * lista2.add(ai); lista2.add(oop); lista2.add(dnad);
		 * 
		 * IPackage package1 = new Package(lista1, "pachet 1"); IPackage
		 * package2 = new Package(lista2, "pachet 2");
		 * 
		 * ICompetence java = new Competence("Java"); java.addPackage(package1);
		 * ICompetence oopCompetence = new Competence("OOP");
		 * oopCompetence.addPackage(package2);
		 * 
		 * competenceRepository.addCompetence(java);
		 * competenceRepository.addCompetence(oopCompetence);
		 */

		IAddStudentController addStudentController = new AddStudentController(competenceRepository, courseRepository,
				studentsRepository);
		IManagementController addMenuController = new ManagementController(competenceRepository, courseRepository,
				subjectRepository, teachersRepository, studentsRepository, roomsReporitory);
		IEditStudentController editStudentController = new EditStudentController(studentsRepository, courseRepository);

		IAddCompetenceGUI competenceGUI = new AddCompetenceGUI(addStudentController);
		ISelectCompetencesGUI selectCompetenceGUI = new SelectCompetencesGUI(addStudentController);
		IAddStudentGUI addStudentGUI = new AddStudentGUI(addStudentController);
		IMainWindowGUI mainGUI = new MainWindowGUI(addStudentController, addMenuController, editStudentController,
				mainRepository);
		IManagementGUI addMenuGUI = new ManagementGUI(addMenuController);

		addStudentController.setCompetenceGUI(competenceGUI);
		addStudentController.setSelectCompetenceGUI(selectCompetenceGUI);
		addStudentController.setAddStudentGUI(addStudentGUI);
		addMenuController.setAddMenuGUI(addMenuGUI);

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainGUI.initialize();
					mainGUI.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
