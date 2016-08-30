package itsix.academy.perfect_school.controllers.implementations;

import javax.swing.JOptionPane;

import itsix.academy.perfect_school.controllers.IEditStudentController;
import itsix.academy.perfect_school.controllers.IScheduleController;
import itsix.academy.perfect_school.model.IStudent;
import itsix.academy.perfect_school.repositories.ICoursesRepository;
import itsix.academy.perfect_school.repositories.IStudentRepository;
import itsix.academy.perfect_school.view.IEditStudentGUI;
import itsix.academy.perfect_school.view.implementations.EditStudentGUI;

public class EditStudentController implements IEditStudentController {
	IScheduleController scheduleController;

	IStudentRepository studentRepository;

	IEditStudentGUI editStudentGUI = new EditStudentGUI(this);

	IStudent student;

	public EditStudentController(IStudentRepository studentRepository, ICoursesRepository coursesRepository) {
		super();
		this.studentRepository = studentRepository;
		this.scheduleController = new ScheduleController(coursesRepository);
	}

	@Override
	public void showEditStudentGUI() {
		editStudentGUI.setVisible(true);
	}

	@Override
	public void showSchedule() {
		scheduleController.editSchedule(editStudentGUI.getSelectedStage());
	}

	@Override
	public void discard() {
		editStudentGUI.setFirstName("");
		editStudentGUI.setLastName("");
		editStudentGUI.setTelephone("");
		editStudentGUI.setEmail("");
		editStudentGUI.setAddress("");
		editStudentGUI.clearCombobox();
		editStudentGUI.buttonsSetEnabled(false);
		editStudentGUI.inputsSetEnabled(false);
	}

	@Override
	public void search() {
		if (studentRepository.hasThisStudent(editStudentGUI.getSSN())) {
			student = studentRepository.getStudentBySSN(editStudentGUI.getSSN());
			editStudentGUI.setFirstName(student.getFirstName());
			editStudentGUI.setLastName(student.getLastName());
			editStudentGUI.setTelephone(student.getTelephone());
			editStudentGUI.setEmail(student.getEmail());
			editStudentGUI.setAddress(student.getAddress());
			editStudentGUI.updateComboBox(student.getStages());
			editStudentGUI.buttonsSetEnabled(true);
		}else{
			JOptionPane.showMessageDialog(null, "Student not found!");
		}
	}

	@Override
	public void update() {
		student.setFirstName(editStudentGUI.getFirstName());
		student.setLastName(editStudentGUI.getLastName());
		student.setAddress(editStudentGUI.getAddress());
		student.setEmail(editStudentGUI.getEmail());
		student.setTelephone(editStudentGUI.getTelephone());
		studentRepository.updateStudent(editStudentGUI.getSSN(), student);
		discard();
	}

	@Override
	public void enableInputs() {
		editStudentGUI.inputsSetEnabled(true);
	}

}
