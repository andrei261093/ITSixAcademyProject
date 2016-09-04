package itsix.academy.perfect_school.view;

import java.util.List;

import itsix.academy.perfect_school.model.IStage;
import itsix.academy.perfect_school.model.ISubject;

public interface IEditStagesGUI {

	void updateComboBox(List<IStage> stagesList);

	IStage getSelectedStage();

	void updateList(List<ISubject> subjectList);

	void setVisible(boolean b);

}
