package controllers;

import java.util.List;

import buiders.JTreeModelBuider;
import buiders.TreeModelBuider;
import model.ICompetence;
import repositories.ICompetenceRepository;
import repositories.ICoursesRepository;
import view.IChooseCompetenceGUI;
import view.ISelectCompetencesGUI;

public class ChooseCompetenceController implements IChooseCompetenceController {
	
	// GUI
	IChooseCompetenceGUI competenceGUI;
	ISelectCompetencesGUI selectCompetenceGUI;
	
	// Repository
	ICompetenceRepository competenceRepository;
	ICoursesRepository courseRepository;
	
	//Builders
	JTreeModelBuider jtreeModelBuilder = new TreeModelBuider();
	
	//Needed variables
	List<ICompetence> selectedList;

	//Constructor
	public ChooseCompetenceController(ICompetenceRepository competenceRepository, ICoursesRepository courseRepository) {
		super();
		this.competenceRepository = competenceRepository;
		this.courseRepository = courseRepository;
	}

	//Setters
	public void setCompetenceGUI(IChooseCompetenceGUI competenceGUI) {
		this.competenceGUI = competenceGUI;
	}

	public void setSelectCompetenceGUI(ISelectCompetencesGUI selectCompetenceGUI) {
		this.selectCompetenceGUI = selectCompetenceGUI;
	}

	@Override
	public void showSelectCompetenceGUI() {
		selectCompetenceGUI.populateList(competenceRepository.getCompetences());
		selectCompetenceGUI.setVisible(true);		
	}

	@Override
	public void setCompetencesList(List<ICompetence> selectedList) {
		this.selectedList = selectedList;		
	}
	
	@Override
	public void populateTree(){
		competenceGUI.populateTree(jtreeModelBuilder.buidModel(selectedList));
	}



}
