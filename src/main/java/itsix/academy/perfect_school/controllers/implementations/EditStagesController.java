package itsix.academy.perfect_school.controllers.implementations;

import java.util.List;

import itsix.academy.perfect_school.controllers.IEditStagesController;
import itsix.academy.perfect_school.model.IStage;
import itsix.academy.perfect_school.view.IEditStagesGUI;
import itsix.academy.perfect_school.view.implementations.EditStagesGUI;
import itsix.academy.perfect_school.view.implementations.MoveSubjectToWindow;

public class EditStagesController implements IEditStagesController {

	IEditStagesGUI editStageGUI;
	MoveSubjectToWindow moveWindow;

	List<IStage> stagesList;

	public EditStagesController() {
		super();
		editStageGUI = new EditStagesGUI(this);
		moveWindow = new MoveSubjectToWindow(this);
	}

	public void setEditStageGUI(IEditStagesGUI editStageGUI) {
		this.editStageGUI = editStageGUI;
	}

	@Override
	public void editStages(List<IStage> stageList) {
		stagesList = stageList;
		moveWindow.updateComboBox(stagesList);
		editStageGUI.updateComboBox(stagesList);
		editStageGUI.updateList(editStageGUI.getSelectedStage().getSubjectList());
		editStageGUI.setVisible(true);
	}

	@Override
	public void showMoveWindow() {
		moveWindow.setVisible(true);
	}

	@Override
	public void updateList() {
		editStageGUI.updateList(editStageGUI.getSelectedStage().getSubjectList());
	}

	@Override
	public void moveSubjects() {
		moveWindow.getSelectedStage().addSubjects(editStageGUI.getSeletedSubjects());
		editStageGUI.getSelectedStage().deleteSubjects(editStageGUI.getSeletedSubjects());
		editStageGUI.updateList(editStageGUI.getSelectedStage().getSubjectList());
		moveWindow.setVisible(false);
	}

	@Override
	public void hideWindow() {
		editStageGUI.setVisible(false);
		
	}

}
