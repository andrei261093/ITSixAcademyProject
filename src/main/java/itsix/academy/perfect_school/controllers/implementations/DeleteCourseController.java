package itsix.academy.perfect_school.controllers.implementations;

import javax.swing.JOptionPane;

import itsix.academy.perfect_school.controllers.IDeleteCourseController;
import itsix.academy.perfect_school.repositories.ICoursesRepository;
import itsix.academy.perfect_school.view.IDeleteCoursesGUI;
import itsix.academy.perfect_school.view.implementations.DeleteCourseGUI;

public class DeleteCourseController implements IDeleteCourseController {
	IDeleteCoursesGUI deleteGUI;
	ICoursesRepository coursesRepository;

	public DeleteCourseController(ICoursesRepository coursesRepository) {
		super();
		this.coursesRepository = coursesRepository;
		deleteGUI = new DeleteCourseGUI(this);
	}

	@Override
	public void showGUI() {
		deleteGUI.updateTable(coursesRepository.getCoursesList());
		deleteGUI.setVisible(true);
	}

	@Override
	public void delete() {
		coursesRepository.delete(deleteGUI.getSelectedCourse());	
		deleteGUI.updateTable(coursesRepository.getCoursesList());
	}

}
