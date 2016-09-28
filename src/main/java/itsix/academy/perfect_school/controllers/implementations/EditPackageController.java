package itsix.academy.perfect_school.controllers.implementations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import itsix.academy.perfect_school.controllers.IEditPackageController;
import itsix.academy.perfect_school.model.ICompetence;
import itsix.academy.perfect_school.model.IPackage;
import itsix.academy.perfect_school.model.ISubject;
import itsix.academy.perfect_school.model.implementations.Package;
import itsix.academy.perfect_school.publisherSubscriber.IInnerPublisher;
import itsix.academy.perfect_school.publisherSubscriber.ISubscriber;
import itsix.academy.perfect_school.repositories.ISubjectRepository;
import itsix.academy.perfect_school.view.IAddSubjectToPackage;
import itsix.academy.perfect_school.view.IEditPagkageGUI;
import itsix.academy.perfect_school.view.implementations.AddSubjectToPackageGUI;
import itsix.academy.perfect_school.view.implementations.EditPackageGUI;

public class EditPackageController implements IEditPackageController {

	IEditPagkageGUI editGUI;
	IAddSubjectToPackage addSubjects;
	
	IInnerPublisher publisher;

	ICompetence currentCompetence;
	IPackage _package;

	List<ISubject> originalSubjects;

	List<ISubject> copySubjects;

	ISubjectRepository subjectRepository;

	public EditPackageController(ISubjectRepository subjectRepository, IInnerPublisher publisher) {
		super();
		this.publisher = publisher;
		this.subjectRepository = subjectRepository;
		editGUI = new EditPackageGUI(this);
		addSubjects = new AddSubjectToPackageGUI(this);
	}

	@Override
	public void editPackage(IPackage _package) {
		originalSubjects = _package.getSubjects();
		copySubjects = new ArrayList<>(originalSubjects);

		editGUI.showNameInput(false);
		editGUI.updateSubjectsList(copySubjects);
		editGUI.setVisible(true);
	}

	@Override
	public void addPackage(ICompetence currentCompetence) {
		this.currentCompetence = currentCompetence;
		editGUI.showNameInput(true);
		copySubjects = new ArrayList<>();

		editGUI.updateSubjectsList(copySubjects);
		editGUI.setVisible(true);
	}

	@Override
	public void moveUP() {
		int index = editGUI.getSelectedSubjectIndex();
		if ((index - 1) >= 0) {
			Collections.swap(copySubjects, index, index - 1);
			editGUI.updateSubjectsList(copySubjects);
			editGUI.setListSelection(index - 1);
		}
	}

	@Override
	public void moveDown() {
		int index = editGUI.getSelectedSubjectIndex();
		if ((index + 1) < copySubjects.size()) {
			Collections.swap(copySubjects, index, index + 1);
			editGUI.updateSubjectsList(copySubjects);
			editGUI.setListSelection(index + 1);
		}
	}

	@Override
	public void addSubjects() {

		for (ISubject element : addSubjects.getSelectedSubjects()) {
			if (!copySubjects.contains(element)) {
				copySubjects.add(element);
			}
		}

		editGUI.updateSubjectsList(copySubjects);
		addSubjects.setVisible(false);

	}

	@Override
	public void showAddSubjectsGUI() {
		addSubjects.updateSubjectsList(subjectRepository.getSubjectList());
		addSubjects.setVisible(true);

	}

	@Override
	public void deleteSubject() {
		copySubjects.remove(editGUI.getSelectedSubject());
		editGUI.updateSubjectsList(copySubjects);
	}

	@Override
	public void searchSubjects() {
		if (addSubjects.getText() != "") {
			addSubjects.updateSubjectsList(
					subjectRepository.getSubjectsThatContainsThisStringInName(addSubjects.getText()));
		} else {
			addSubjects.updateSubjectsList(subjectRepository.getSubjectList());
		}
	}

	@Override
	public void save() {
		originalSubjects.clear();
		originalSubjects.addAll(copySubjects);

		editGUI.setVisible(false);
	}

	@Override
	public void addPackageToRepository() {
		IPackage newPackage = new Package(copySubjects, editGUI.getPackageName());
		currentCompetence.addPackage(newPackage);	
		publisher.notifySubscribers();
		editGUI.setVisible(false);
		
	}

	@Override
	public void subscribe(ISubscriber subscriber) {
		publisher.subscribe(subscriber);
		
	}

	@Override
	public void unsubscribe(ISubscriber subscriber) {
		publisher.unsubscribe(subscriber);
		
	}

}
