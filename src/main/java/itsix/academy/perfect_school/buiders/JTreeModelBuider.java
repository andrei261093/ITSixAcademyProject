package itsix.academy.perfect_school.buiders;


import java.util.List;

import javax.swing.tree.TreeModel;

import itsix.academy.perfect_school.model.ICompetence;

public interface JTreeModelBuider {

	TreeModel buidModel(List<ICompetence> selectedList);

}


