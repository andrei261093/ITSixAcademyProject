package app;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import controllers.AddStudentController;
import controllers.IAddStudentController;
import model.Competence;
import model.Course;
import model.ICompetence;
import model.ICourse;
import model.IPackage;
import model.ISubject;
import model.ITeacher;
import model.Package;
import model.Subject;
import model.Teacher;
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
import view.AddCompetenceGUI;
import view.AddStudentGUI;
import view.ClassScheduleGUI;
import view.IAddCompetenceGUI;
import view.IAddStudentGUI;
import view.IMainWindowGUI;
import view.ISelectCompetencesGUI;
import view.MainWindowGUI;
import view.SelectCompetencesGUI;

public class App {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

		ICompetenceRepository competenceRepository = new CompetenceRepository();
		ICoursesRepository courseRepository = new CoursesRepository();
		ISubjectRepository subjectRepository = new SubjectRepository();
		ITeachersRepository teachersRepository = new TeachersRepository();
		IStudentRepository studentsRepository = new StudentRepository();

		ISubject oop = new Subject("oop");
		ISubject vpe = new Subject("vpe");
		ISubject dnad = new Subject("dnad");
		ISubject pc = new Subject("pc");
		ISubject cp = new Subject("cp");
		ISubject ai = new Subject("ai");
		ISubject pt = new Subject("pt");
		ISubject ood = new Subject("ood");
		ISubject nm = new Subject("nm");
		ISubject ds = new Subject("ds");
		ISubject os = new Subject("os");
		
		subjectRepository.addSubject(oop);
		subjectRepository.addSubject(vpe);
		subjectRepository.addSubject(dnad);
		subjectRepository.addSubject(pc);
		subjectRepository.addSubject(cp);
		subjectRepository.addSubject(ai);
		subjectRepository.addSubject(pt);
		subjectRepository.addSubject(nm);
		subjectRepository.addSubject(ds);
		subjectRepository.addSubject(os);
		subjectRepository.addSubject(ood);
		
		
		
		
		ITeacher brezovan = new Teacher("Brezovan");
		ITeacher spahiu = new Teacher("Spahiu");
		ITeacher mariusMarian = new Teacher("Marius Marian");
		ITeacher stanescu = new Teacher("Stanescu");
		ITeacher udristoiu = new Teacher("Udristoiu");
		ITeacher lemeni = new Teacher("Lemeni");
		
		teachersRepository.addTeacher(brezovan);
		teachersRepository.addTeacher(spahiu);
		teachersRepository.addTeacher(mariusMarian);
		teachersRepository.addTeacher(udristoiu);
		teachersRepository.addTeacher(lemeni);
		teachersRepository.addTeacher(stanescu);
		
		
		ICourse course1 = new Course(oop, brezovan, "Luni", "14:00", "ACB");
		ICourse course2 = new Course(os, udristoiu, "Marti", "16:00", "ACB");
		ICourse course3 = new Course(vpe, spahiu, "Vineri", "12:00", "ACB");
		ICourse course4 = new Course(vpe, spahiu, "Marti", "10:00", "ACB");
		ICourse course5 = new Course(vpe, stanescu, "Joi", "08:00", "ACB");
		ICourse course6 = new Course(dnad, lemeni, "Mirecuri", "10:00", "ACB");
		ICourse course7 = new Course(dnad, mariusMarian, "Vineri", "18:00", "ACB");
		
		
		courseRepository.addCourse(course7);
		courseRepository.addCourse(course6);
		courseRepository.addCourse(course5);
		courseRepository.addCourse(course4);
		courseRepository.addCourse(course3);
		courseRepository.addCourse(course2);
		courseRepository.addCourse(course1);
		
		List<ISubject> lista1 = new ArrayList<>();
		lista1.add(cp);
		lista1.add(pt);
		lista1.add(oop);
		lista1.add(vpe);
		
		List<ISubject> lista2 = new ArrayList<>();
		lista2.add(cp);
		lista2.add(pt);
		lista2.add(oop);
		lista2.add(dnad);
		
		
		
		IPackage package1 = new Package(lista1, "pachet 1");
		IPackage package2 = new Package(lista2, "pachet 2");
		
		ICompetence java = new Competence("Java");
		java.addPackage(package1);
		ICompetence oopCompetence = new Competence("OOP");
		oopCompetence.addPackage(package2);
		
		competenceRepository.addCompetence(java);
		competenceRepository.addCompetence(oopCompetence);
		
		
		
		IAddStudentController controller = new AddStudentController(competenceRepository, courseRepository, studentsRepository);

		IAddCompetenceGUI competenceGUI = new AddCompetenceGUI(controller);
		ISelectCompetencesGUI selectCompetenceGUI = new SelectCompetencesGUI(controller);
		ClassScheduleGUI scheduleGUI = new ClassScheduleGUI(controller);
		IAddStudentGUI addStudentGUI = new AddStudentGUI(controller);
		IMainWindowGUI mainGUI  = new MainWindowGUI(controller);

		controller.setCompetenceGUI(competenceGUI);
		controller.setSelectCompetenceGUI(selectCompetenceGUI);
		controller.setScheduleGUI(scheduleGUI);
		controller.setAddStudentGUI(addStudentGUI);

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
