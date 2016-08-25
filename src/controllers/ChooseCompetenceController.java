package controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import buiders.JTreeModelBuider;
import buiders.TreeModelBuider;
import itsix.PerfectSchool.Model.ITeacherCourse;
import model.ICompetence;
import model.ICourse;
import model.IStage;
import model.ISubject;
import model.ITeacher;
import model.IPackage;
import model.Stage;
import repositories.ICompetenceRepository;
import repositories.ICoursesRepository;
import view.ClassScheduleGUI;
import view.IChooseCompetenceGUI;
import view.ISelectCompetencesGUI;

public class ChooseCompetenceController implements IChooseCompetenceController {

	// GUI
	IChooseCompetenceGUI competenceGUI;
	ISelectCompetencesGUI selectCompetenceGUI;
	ClassScheduleGUI scheduleGUI;
	

	// Repository
	ICompetenceRepository competenceRepository;
	ICoursesRepository courseRepository;

	// Builders
	JTreeModelBuider jtreeModelBuilder = new TreeModelBuider();

	// Needed variables
	List<ICompetence> selectedList;
	List<IStage> stageList;

	// Constructor
	public ChooseCompetenceController(ICompetenceRepository competenceRepository, ICoursesRepository courseRepository) {
		super();
		this.competenceRepository = competenceRepository;
		this.courseRepository = courseRepository;
		initializeStages();

	}

	// Setters
	public void setCompetenceGUI(IChooseCompetenceGUI competenceGUI) {
		this.competenceGUI = competenceGUI;
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
		competenceGUI.populateTree(jtreeModelBuilder.buidModel(selectedList));
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
		for (IPackage _package : competenceGUI.getSelectedTreePackages()) {
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

	@Override
	public void dispalyStages() {
		competenceGUI.populateComboBox(stageList);
	}

	@Override
	public void populateList() {
		competenceGUI.populateList(competenceGUI.getSelectedListSubject().getSubjectList());
	}

	@Override
	public void displayTeachers() {
		List<ITeacher> teachersList = getTeachersOfThisSubject(scheduleGUI.getSelectedSubject());
		scheduleGUI.updateTeachersCB(teachersList);
	}

	private List<ITeacher> getTeachersOfThisSubject(ISubject selectedComboBoxStage) {
		Set<ITeacher> returnList = new HashSet();
		for (ICourse course : CourseRepository.getRelationsList()) {
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
		scheduleGUI.highlightTable(getRelationTeacherCourse(scheduleGUI.getSelectedSubject(), scheduleGUI.getSelectedTeacher()));
		
	}
	
	public List<ICourse> getRelationTeacherCourse(ISubject subject, ITeacher teacher) {
		List<ICourse> returnList = new ArrayList<>();
		for (ICourse relation : teacherCourseRepository.getRelationsList()) {
			if (relation.hasThisSubjectAndTeacher(subject, teacher)) {
				returnList.add(relation);
			}
		}
		return returnList;
	}


}