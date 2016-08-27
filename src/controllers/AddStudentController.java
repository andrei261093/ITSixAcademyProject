package controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import buiders.JTreeModelBuider;
import buiders.TreeModelBuider;
import model.ICompetence;
import model.ICourse;
import model.IStage;
import model.ISubject;
import model.ITeacher;
import model.IPackage;
import model.Stage;
import repositories.ICompetenceRepository;
import repositories.ICoursesRepository;
import repositories.IStudentRepository;
import repositories.ITeachersRepository;
import transformers.HourToIndexTransformer;
import view.ClassScheduleGUI;
import view.IAddStudentGUI;
import view.IAddCompetenceGUI;
import view.ISelectCompetencesGUI;

public class AddStudentController implements IAddStudentController {

	// GUI
	IAddCompetenceGUI addCompetenceGUI;
	ISelectCompetencesGUI selectCompetenceGUI;
	ClassScheduleGUI scheduleGUI;
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

	public void setScheduleGUI(ClassScheduleGUI scheduleGUI) {
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
		initializeStages();
		if (!addCompetenceGUI.getSelectedTreePackages().isEmpty()) {
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
	public void displayTeachers() {
		List<ITeacher> teachersList = getTeachersOfThisSubject(scheduleGUI.getSelectedSubject());
		scheduleGUI.updateTeachersCB(teachersList);
	}

	private List<ITeacher> getTeachersOfThisSubject(ISubject selectedComboBoxStage) {
		Set<ITeacher> returnList = new HashSet<ITeacher>();
		for (ICourse course : courseRepository.getRelationsList()) {
			if (course.hasThisSubject(selectedComboBoxStage)) {
				returnList.add(course.getTeacher());
			}
		}
		List<ITeacher> list = new ArrayList<>();
		list.addAll(returnList);
		return list;
	}

	@Override
	public void highlightTable() {
		scheduleGUI.highlightTable(
				getRelationTeacherCourse(scheduleGUI.getSelectedSubject(), scheduleGUI.getSelectedComboBoxTeacher()));

	}

	public List<ICourse> getRelationTeacherCourse(ISubject subject, ITeacher teacher) {
		List<ICourse> returnList = new ArrayList<>();
		for (ICourse relation : courseRepository.getRelationsList()) {
			if (relation.hasThisSubjectAndTeacher(subject, teacher)) {
				returnList.add(relation);
			}
		}
		return returnList;
	}

	@Override
	public void addCourseToTable() {
		List<ICourse> list = getRelationTeacherCourse(scheduleGUI.getSelectedSubject(),
				scheduleGUI.getSelectedComboBoxTeacher());

		for (ICourse course : list) {
			if (transformer.getCoursePoint(course).equals(scheduleGUI.getSelectedTableCellIndex()) && scheduleGUI
					.isHighlighted(scheduleGUI.getSelectedTableCellIndex().x, scheduleGUI.getSelectedTableCellIndex().y)
					&& !studentHasThisSubject(course.getSubject())) {
				scheduleGUI.addCourseToTable(course);
				studentCourseList.add(course);
				scheduleGUI.resetTableHighlight();
			}
		}

	}

	public boolean studentHasThisSubject(ISubject subject) {
		for (ICourse course : studentCourseList) {
			if (course.hasThisSubject(subject)) {
				return true;
			}
		}
		return false;
	}

	public void removeSelectedTableCourseFromStudentsCourses() {
		removeCourseFromStudentsCourses(scheduleGUI.getSelectedTableItem());
	}

	public void removeCourseFromStudentsCourses(ICourse curs) {
		ICourse item = null;
		for (ICourse course : studentCourseList) {
			if (course.hasThisSubject(curs.getSubject())) {
				item = course;
			}
		}
		studentCourseList.remove(item);
	}

	public void removeCourseFromTable() {
		scheduleGUI.emptyTableCell(scheduleGUI.getSelectedTableCellIndex().x,
				scheduleGUI.getSelectedTableCellIndex().y);
	}

	@Override
	public void showScheduleGUI() {
		Set<ISubject> stageSubjects = new HashSet<>();
		stageSubjects.addAll(addCompetenceGUI.getSelectedComboBoxStage().getSubjectList());
		scheduleGUI.updateListModel(stageSubjects);
		scheduleGUI.clearTableOfItems();
		scheduleGUI.populateTable(addCompetenceGUI.getSelectedComboBoxStage().getCourses());
		scheduleGUI.setVisible(true);
	}

	@Override
	public void saveStage() {
		addCompetenceGUI.getSelectedComboBoxStage().setCourses(scheduleGUI.getAllElementsFromTable());
		scheduleGUI.clearTeachersComboBox();
		scheduleGUI.setVisible(false);
	}

	@Override
	public void showAddCompetenceGUI() {
		addStudentGUI.setVisible(false);
		addCompetenceGUI.setVisible(true);
	}

	@Override
	public void showAddStudentGUI() {
		addStudentGUI.setVisible(true);
	}

}
