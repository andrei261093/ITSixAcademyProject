package view;

import javax.swing.tree.TreeModel;

public interface IChooseCompetenceGUI {

	void setVisible(boolean b);

	void initialize();

	void populateTree(TreeModel model);

}
