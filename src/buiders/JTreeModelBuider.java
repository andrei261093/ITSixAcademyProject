package buiders;

import java.util.List;

import javax.swing.tree.TreeModel;

import model.ICompetence;

public interface JTreeModelBuider {

	TreeModel buidModel(List<ICompetence> selectedList);

}


