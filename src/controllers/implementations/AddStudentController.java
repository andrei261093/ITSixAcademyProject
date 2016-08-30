package controllers.implementations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JOptionPane;

import org.omg.CORBA.DynamicImplementation;

import buiders.JTreeModelBuider;
import buiders.TreeModelBuider;
import controllers.IAddStudentController;
import controllers.IScheduleController;
import model.ICompetence;
import model.ICourse;
import model.IStage;
import model.IStudent;
import model.ISubject;
import model.ITeacher;
import model.implementations.Stage;
import model.implementations.Student;
import model.IPackage;
import repositories.ICompetenceRepository;
import repositories.ICoursesRepository;
import repositories.IStudentRepository;
import repositories.ITeachersRepository;
import transformers.HourToIndexTransformer;
import view.IAddStudentGUI;
import view.IAddCompetenceGUI;
import view.ISelectCompetencesGUI;
import view.implementations.AddCompetenceGUI;
import view.implementations.ScheduleGUI;

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
