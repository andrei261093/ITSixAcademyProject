package controllers.implementations;

import controllers.IEditStudentController;
import model.IStudent;
import repositories.IStudentRepository;
import view.IEditStudentGUI;
import view.implementations.EditStudentGUI;

public class EditStudentController implements IEditStudentController {
	IStudentRepository studentRepository;

	IEditStudentGUI editStudentGUI = new EditStudentGUI(this);

	IStudent student;

	public EditStudentController(IStudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}
	

	@Override
	public void showEditStudentGUI() {
		
		editStudentGUI.setVisible(true);
	}

	@Override
	public void showSchedule() {
		// TODO Auto-generated method stub

	}

	@Override
	public void discard() {
		// TODO Auto-generated method stub

	}

	@Override
	public void search() {
		student = studentRepository.getStudentBySSN(editStudentGUI.getSSN());
		editStudentGUI.setFirstName(student.getFirstName());
		editStudentGUI.setLastName(student.getLastName());
		editStudentGUI.setTelephone(student.getTelephone());
		editStudentGUI.setEmail(student.getEmail());
		editStudentGUI.setAddress(student.getAddress());
	}

	@Override
	public void update() {
		student.setFirstName(editStudentGUI.getFirstName());
		student.setLastName(editStudentGUI.getLastName());
		student.setAddress(editStudentGUI.getAddress());
		student.setEmail(editStudentGUI.getEmail());
		student.setTelephone(editStudentGUI.getTelephone());
		studentRepository.updateStudent(editStudentGUI.getSSN(), student);
	}

}
