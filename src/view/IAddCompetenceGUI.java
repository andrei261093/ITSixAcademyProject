package view;

import java.util.List;

import javax.swing.tree.TreeModel;

import model.IStage;
import model.ISubject;
import model.IPackage;

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
