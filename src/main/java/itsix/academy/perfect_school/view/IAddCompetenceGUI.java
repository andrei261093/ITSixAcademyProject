package itsix.academy.perfect_school.view;



import java.util.List;

import javax.swing.tree.TreeModel;

import itsix.academy.perfect_school.model.IPackage;
import itsix.academy.perfect_school.model.IStage;
import itsix.academy.perfect_school.model.ISubject;

public interface IAddCompetenceGUI {

	void setVisible(boolean b);

	void initialize();

	void populateTree(TreeModel model);

	public List<IPackage> getSelectedTreePackages();

	void populateStagesComboBox(List<IStage> stageList);

	IStage getSelectedComboBoxStage();

	void populateSubjectsPerStageList(List<ISubject> subjectList);

	void buttonsSetEnabled(boolean b);

}
