package itsix.academy.perfect_school.controllers.implementations;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import itsix.academy.perfect_school.controllers.IScheduleController;
import itsix.academy.perfect_school.model.ICourse;
import itsix.academy.perfect_school.model.IStage;
import itsix.academy.perfect_school.model.ISubject;
import itsix.academy.perfect_school.model.ITeacher;
import itsix.academy.perfect_school.repositories.ICoursesRepository;
import itsix.academy.perfect_school.transformers.HourToIndexTransformer;
import itsix.academy.perfect_school.view.IScheduleGUI;
import itsix.academy.perfect_school.view.implementations.ScheduleGUI;

public class ScheduleController implements IScheduleController {
	IScheduleGUI scheduleGUI;

	ICoursesRepository courseRepository;

	IStage stage;

	HourToIndexTransformer transformer = new HourToIndexTransformer();

	public ScheduleController(ICoursesRepository courseRepository) {
		super();
		this.courseRepository = courseRepository;
		scheduleGUI = new ScheduleGUI(this);
	}

	
	@Override
	public void editSchedule(IStage stage){
		this.stage = stage;
		scheduleGUI.updateListModel(stage.getSubjectList());
		scheduleGUI.resetTableHighlight();
		scheduleGUI.clearTableOfItems();
		scheduleGUI.populateTable(stage.getCourses());
		scheduleGUI.setVisible(true);
	}
	@Override
	public void removeCourseFromTable() {
		scheduleGUI.emptyTableCell(scheduleGUI.getSelectedTableCellIndex().x,
				scheduleGUI.getSelectedTableCellIndex().y);
	}
	@Override
	public void removeCourseFromStudentsCourses(ICourse curs) {
		ICourse item = null;
		for (ICourse course : stage.getCourses()) {
			if (course.hasThisSubject(curs.getSubject())) {
				item = course;
			}
		}
		stage.getCourses().remove(item);
	}
	@Override
	public void removeSelectedTableCourseFromStudentsCourses() {
		removeCourseFromStudentsCourses(scheduleGUI.getSelectedTableItem());
	}

	public boolean studentHasThisSubject(ISubject subject) {
		for (ICourse course : stage.getCourses()) {
			if (course.hasThisSubject(subject)) {
				return true;
			}
		}
		return false;
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
				stage.getCourses().add(course);
				scheduleGUI.resetTableHighlight();
			}
		}

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
	public void highlightTable() {
		scheduleGUI.highlightTable(
				getRelationTeacherCourse(scheduleGUI.getSelectedSubject(), scheduleGUI.getSelectedComboBoxTeacher()));

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
	public void displayTeachers() {
		List<ITeacher> teachersList = getTeachersOfThisSubject(scheduleGUI.getSelectedSubject());
		scheduleGUI.updateTeachersCB(teachersList);
	}
	@Override
	public void saveStage() {
		scheduleGUI.clearTeachersComboBox();
		scheduleGUI.setVisible(false);
	}

}
