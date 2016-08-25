package view;

import java.util.List;

import javax.swing.tree.TreeModel;

import model.IStage;
import model.ISubject;
import model.IPackage;

public interface IChooseCompetenceGUI {

	void setVisible(boolean b);

	void initialize();

	void populateTree(TreeModel model);

	public List<IPackage> getSelectedTreePackages();

	void populateComboBox(List<IStage> stageList);

	IStage getSelectedListSubject();

	void populateList(List<ISubject> subjectList);

}