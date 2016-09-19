package itsix.academy.perfect_school.view.implementations;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import itsix.academy.perfect_school.controllers.IEditPackageController;
import itsix.academy.perfect_school.model.ICompetence;
import itsix.academy.perfect_school.model.IPackage;
import itsix.academy.perfect_school.model.ISubject;
import itsix.academy.perfect_school.view.IEditPagkageGUI;

public class EditPackageGUI extends JFrame implements IEditPagkageGUI{
	private IEditPackageController controller;
	
	private JList list = new JList();
	
	private JButton btnAdd = new JButton("Add");
	private JButton btnDelete = new JButton("Delete");
	private JButton btnMoveUp = new JButton("Move UP");
	private JButton btnMoveDown = new JButton("Move Down");
	private JButton btnSave = new JButton("Save");
	
	public EditPackageGUI(IEditPackageController controller) {
		this.controller = controller;
		initialize();
	}

	private void initialize() {
		
	setBounds(100, 100, 350, 372);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 52, 175, 242);
		getContentPane().add(scrollPane);
		
		
		scrollPane.setViewportView(list);
		
		
		btnAdd.setBounds(222, 49, 89, 23);
		getContentPane().add(btnAdd);
		
		
		btnDelete.setBounds(222, 83, 89, 23);
		getContentPane().add(btnDelete);
		
		
		btnMoveUp.setBounds(222, 151, 89, 23);
		getContentPane().add(btnMoveUp);
		
		
		btnMoveDown.setBounds(222, 185, 89, 23);
		getContentPane().add(btnMoveDown);
		
		JLabel lblNewLabel = new JLabel("Note: The subjects must be in order!");
		lblNewLabel.setBounds(25, 305, 286, 23);
		getContentPane().add(lblNewLabel);
		
		JLabel lblSubjects = new JLabel("Subjects:");
		lblSubjects.setBounds(25, 27, 46, 14);
		getContentPane().add(lblSubjects);
		btnSave.setBounds(222, 271, 89, 23);
		
		getContentPane().add(btnSave);
		setLocationRelativeTo(null);
	}
	
	@Override
	public void updateSubjectsList(List<ISubject> subjects){
		DefaultListModel<ISubject> model = new DefaultListModel<>();
		for (ISubject current : subjects) {
			model.addElement(current);
		}
		list.setModel(model);
	}
}
