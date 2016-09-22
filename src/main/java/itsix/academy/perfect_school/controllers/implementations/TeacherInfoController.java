package itsix.academy.perfect_school.controllers.implementations;

import itsix.academy.perfect_school.controllers.ITeacherInfoController;
import itsix.academy.perfect_school.model.ITeacher;
import itsix.academy.perfect_school.view.ITeacherInfoGUI;
import itsix.academy.perfect_school.view.implementations.TeacherInfoGUI;

public class TeacherInfoController implements ITeacherInfoController {
	ITeacherInfoGUI infoGui;
	ITeacher teacher;

	@Override
	public void showInfo(ITeacher teacher) {
		infoGui = new TeacherInfoGUI(this);
		this.teacher = teacher;
		setInputsTexts(teacher);
		infoGui.setVisible(true);
	}

	public void setInputsTexts(ITeacher teacher) {
		infoGui.setEditable(false);
		infoGui.setVisible(false);
		infoGui.setAddress(teacher.getAddress());
		infoGui.setEmail(teacher.getEmail());
		infoGui.setFirstName(teacher.getFirstName());
		infoGui.setLastName(teacher.getLastName());
		infoGui.setTelephone(teacher.getTelephone());
	}

	@Override
	public void updateTeacher() {
		teacher.setAddress(infoGui.getAddress());
		teacher.setEmail(infoGui.getEmail());
		teacher.setFirstName(infoGui.getFirstName());
		teacher.setLastName(infoGui.getLastName());
		teacher.setTelephone(infoGui.getTelephone());
		infoGui.setVisible(false);
	}

	@Override
	public void setEditable() {
		infoGui.setEditable(true);
	}

}
