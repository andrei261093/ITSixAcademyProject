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
