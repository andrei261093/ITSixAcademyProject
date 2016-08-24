package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

import controllers.IChooseCompetenceController;
import model.ICompetence;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class SelectCompetencesGUI extends JFrame implements ISelectCompetencesGUI {

	IChooseCompetenceController controller;

	JList list = new JList();

	JButton btnReset = new JButton("Reset");
	JButton btnSave = new JButton("Save");

	public SelectCompetencesGUI(IChooseCompetenceController controller) {
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

		btnSave.setBounds(198, 301, 89, 23);
		getContentPane().add(btnSave);
		btnReset.setBounds(32, 301, 89, 23);
		getContentPane().add(btnReset);

		// Action Listeners
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				List<ICompetence> selectedList = list.getSelectedValuesList();
				controller.setCompetencesList(selectedList);
			}
		});

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
