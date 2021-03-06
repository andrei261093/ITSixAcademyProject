package itsix.academy.perfect_school.view.implementations;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import itsix.academy.perfect_school.controllers.IAddStudentController;
import itsix.academy.perfect_school.model.ICompetence;
import itsix.academy.perfect_school.view.ISelectCompetencesGUI;

public class SelectCompetencesGUI extends JFrame implements ISelectCompetencesGUI {

	IAddStudentController controller;

	JList list = new JList();
	JButton btnAdd = new JButton("Add");

	public SelectCompetencesGUI(IAddStudentController controller) {
		this.controller = controller;
		initialize();
	}

	public void initialize() {
		setTitle("Select Courses");
		setBounds(100, 100, 336, 380);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		JLabel lblSelectCompetences = new JLabel("Select Competences");
		lblSelectCompetences.setBounds(32, 11, 255, 14);
		getContentPane().add(lblSelectCompetences);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 36, 255, 254);
		getContentPane().add(scrollPane);
		scrollPane.setViewportView(list);

		btnAdd.setBounds(114, 301, 89, 23);
		getContentPane().add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				List<ICompetence> selectedList = list.getSelectedValuesList();
				controller.setCompetencesList(selectedList);
				dispose();
				controller.populateTree();
			}
		});
		setLocationRelativeTo(null);
	}

	@Override
	public void populateList(List<ICompetence> competences) {
		DefaultListModel<ICompetence> model = new DefaultListModel();
		for (ICompetence competence : competences) {
			model.addElement(competence);
		}
		list.setModel(model);
	}

}
