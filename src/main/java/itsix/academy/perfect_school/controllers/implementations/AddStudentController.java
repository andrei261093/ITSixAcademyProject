package itsix.academy.perfect_school.controllers.implementations;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import itsix.academy.perfect_school.buiders.JTreeModelBuider;
import itsix.academy.perfect_school.buiders.TreeModelBuider;
import itsix.academy.perfect_school.controllers.IAddStudentController;
import itsix.academy.perfect_school.controllers.IScheduleController;
import itsix.academy.perfect_school.model.ICompetence;
import itsix.academy.perfect_school.model.ICourse;
import itsix.academy.perfect_school.model.IPackage;
import itsix.academy.perfect_school.model.IStage;
import itsix.academy.perfect_school.model.IStudent;
import itsix.academy.perfect_school.model.implementations.Stage;
import itsix.academy.perfect_school.model.implementations.Student;
import itsix.academy.perfect_school.repositories.ICompetenceRepository;
import itsix.academy.perfect_school.repositories.ICoursesRepository;
import itsix.academy.perfect_school.repositories.IStudentRepository;
import itsix.academy.perfect_school.transformers.HourToIndexTransformer;
import itsix.academy.perfect_school.view.IAddCompetenceGUI;
import itsix.academy.perfect_school.view.IAddStudentGUI;
import itsix.academy.perfect_school.view.ISelectCompetencesGUI;
import itsix.academy.perfect_school.view.implementations.AddCompetenceGUI;
import itsix.academy.perfect_school.view.implementations.ScheduleGUI;

public class AddStudentController implements IAddStudentController {
	// Controllers
	IScheduleController scheduleController;

	// GUI
	IAddCompetenceGUI addCompetenceGUI;
	ISelectCompetencesGUI selectCompetenceGUI;
	ScheduleGUI scheduleGUI;
	IAddStudentGUI addStudentGUI;

	// Transformer
	private HourToIndexTransformer transformer = new HourToIndexTransformer();

	// Repository
	ICompetenceRepository competenceRepository;
	ICoursesRepository courseRepository;
	// SITeachersRepository teacherRepository;
	IStudentRepository studentsRepository;

	// Builders
	JTreeModelBuider jtreeModelBuilder = new TreeModelBuider();

	// Needed variables
	List<ICompetence> selectedList;
	List<IStage> stageList = new ArrayList<>();
	private List<ICourse> studentCourseList = new ArrayList<>();

	// Constructor
	public AddStudentController(ICompetenceRepository competenceRepository, ICoursesRepository courseRepository,
			IStudentRepository studentsRepository) {
		super();
		this.competenceRepository = competenceRepository;
		this.courseRepository = courseRepository;
		this.studentsRepository = studentsRepository;
		scheduleController = new ScheduleController(courseRepository);
	}

	// Setters
	public void setCompetenceGUI(IAddCompetenceGUI competenceGUI) {
		this.addCompetenceGUI = competenceGUI;
	}

	@Override
	public void setAddStudentGUI(IAddStudentGUI addStudentGUI) {
		this.addStudentGUI = addStudentGUI;
	}

	public void setSelectCompetenceGUI(ISelectCompetencesGUI selectCompetenceGUI) {
		this.selectCompetenceGUI = selectCompetenceGUI;
	}

	public void setScheduleGUI(ScheduleGUI scheduleGUI) {
		this.scheduleGUI = scheduleGUI;
	}

	// Functions
	@Override
	public void showSelectCompetenceGUI() {
		selectCompetenceGUI.populateList(competenceRepository.getCompetences());
		selectCompetenceGUI.setVisible(true);
	}

	@Override
	public void setCompetencesList(List<ICompetence> selectedList) {
		this.selectedList = selectedList;
	}

	@Override
	public void populateTree() {
		addCompetenceGUI.populateTree(jtreeModelBuilder.buidModel(selectedList));
	}

	public void initializeStages() {
		stageList = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			IStage stage = new Stage("Stage " + (i + 1));
			stageList.add(stage);
		}
	}

	@Override
	public void makeStages() {
		if (!addCompetenceGUI.getSelectedTreePackages().isEmpty()) {
			System.out.println("s a intrat aici");
			initializeStages();
			for (IPackage _package : addCompetenceGUI.getSelectedTreePackages()) {
				for (int i = 0; i < _package.getSubjects().size(); i++) {
					stageList.get(i).addSubject(_package.getSubjects().get(i));
				}
			}
			List<IStage> auxList = new ArrayList<>();
			for (IStage stage : stageList) {
				if (!stage.hasNoSubjects()) {
					auxList.add(stage);
				}
			}
			stageList = auxList;
			addCompetenceGUI.buttonsSetEnabled(true);
			dispalyStages();
		}else{
			JOptionPane.showMessageDialog(null, "No package was selected!");
		}
		
	}

	@Override
	public void dispalyStages() {
		addCompetenceGUI.populateStagesComboBox(stageList);
	}

	@Override
	public void populateList() {
		addCompetenceGUI.populateSubjectsPerStageList(addCompetenceGUI.getSelectedComboBoxStage().getSubjectList());
	}

	@Override
	public void showScheduleGUI() {
		scheduleController.editSchedule(addCompetenceGUI.getSelectedComboBoxStage());
	}

	@Override
	public void showAddCompetenceGUI() {
		addStudentGUI.setVisible(false);
		initializeStages();
		addCompetenceGUI = new AddCompetenceGUI(this);
		addCompetenceGUI.setVisible(true);
	}

	@Override
	public void showAddStudentGUI() {
		addStudentGUI.setVisible(true);
	}

	@Override
	public void addStudent() {
		IStudent student = new Student(addStudentGUI.getFirstName(), addStudentGUI.getLastName(), addStudentGUI.getTelephone(), addStudentGUI.getAddres(), addStudentGUI.getEmail(), addStudentGUI.getSSN());
		student.setStages(stageList);
		studentsRepository.addStudent(student);
		addStudentGUI.clearInputs();
		addCompetenceGUI.setVisible(false);
		
	}

}
