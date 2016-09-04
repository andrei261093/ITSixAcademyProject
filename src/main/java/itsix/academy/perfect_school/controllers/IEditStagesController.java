package itsix.academy.perfect_school.controllers;

import java.util.List;

import itsix.academy.perfect_school.model.IStage;

public interface IEditStagesController {

	void editStages(List<IStage> stagesList);

	void showMoveWindow();

	void updateList();

	void moveSubjects();

}
