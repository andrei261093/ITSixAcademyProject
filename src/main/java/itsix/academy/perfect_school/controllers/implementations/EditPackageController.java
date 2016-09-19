package itsix.academy.perfect_school.controllers.implementations;

import itsix.academy.perfect_school.controllers.IEditPackageController;
import itsix.academy.perfect_school.model.IPackage;
import itsix.academy.perfect_school.view.IEditPagkageGUI;
import itsix.academy.perfect_school.view.implementations.EditPackageGUI;

public class EditPackageController implements IEditPackageController{
	
	IEditPagkageGUI editGUI;
	IPackage _package;
	IPackage auxPackage;

	public EditPackageController() {
		super();
		editGUI = new EditPackageGUI(this);
	}
	
	@Override
	public void editPackage(IPackage _package){
		this._package = _package;
		this.auxPackage = _package;
		editGUI.updateSubjectsList(auxPackage.getSubjects());
		editGUI.setVisible(true);		
	}
	
	
	
}
