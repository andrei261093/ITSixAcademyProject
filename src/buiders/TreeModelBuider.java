package buiders;

import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;

import model.ICompetence;
import model.ISubject;
import model.IPackage;

public class TreeModelBuider implements JTreeModelBuider {

	@Override
	public TreeModel buidModel(List<ICompetence> selectedList) {
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Competente");
		for (ICompetence competence : selectedList) {
			DefaultMutableTreeNode competenceNode = new DefaultMutableTreeNode(competence);
			root.add(competenceNode);
			for (IPackage _package : competence.getPackages()) {
				DefaultMutableTreeNode _packageNode = new DefaultMutableTreeNode(_package);
				competenceNode.add(_packageNode);
				for (ISubject subject : _package.getSubjects()) {
					DefaultMutableTreeNode subjectNode = new DefaultMutableTreeNode(subject);
					_packageNode.add(subjectNode);
				}
			}
		}
		TreeModel tm = new DefaultTreeModel(root);
		return tm;
	}

}
