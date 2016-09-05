package itsix.academy.perfect_school.view.implementations;

import java.awt.EventQueue;

import javax.swing.JFrame;

import itsix.academy.perfect_school.controllers.IEditStagesController;
import itsix.academy.perfect_school.model.ICompetence;
import itsix.academy.perfect_school.model.IStage;
import itsix.academy.perfect_school.model.ISubject;
import itsix.academy.perfect_school.view.IEditStagesGUI;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.LineNumberInputStream;
import java.util.List;
import java.awt.event.ActionEvent;

public class EditStagesGUI extends JFrame implements IEditStagesGUI {

	JComboBox comboBox = new JComboBox();

	JList list = new JList();

	JButton btnDone = new JButton("Done");
	JButton btnMove = new JButton("Move");

	IEditStagesController controller;

	public EditStagesGUI(IEditStagesController controller) {
		this.controller = controller;
		initialize();
	}

	private void initialize() {
		setBounds(100, 100, 423, 499);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel lblCurrentStage = new JLabel("Current Stage");
		lblCurrentStage.setBounds(24, 14, 83, 14);
		getContentPane().add(lblCurrentStage);

		comboBox.setBounds(117, 11, 135, 20);
		getContentPane().add(comboBox);
		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.updateList();
			}
		});

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(24, 60, 356, 372);
		getContentPane().add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 21, 193, 303);
		panel.add(scrollPane);

		scrollPane.setViewportView(list);

		btnMove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.showMoveWindow();
			}
		});
		btnMove.setBounds(234, 25, 89, 23);
		panel.add(btnMove);

		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.hideWindow();
			}
		});
		btnDone.setBounds(234, 338, 112, 23);
		panel.add(btnDone);
		
		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		setLocationRelativeTo(null);
	}

	@Override
	public void updateComboBox(List<IStage> stagesList) {
		comboBox.setModel(new DefaultComboBoxModel(stagesList.toArray()));
	}

	@Override
	public IStage getSelectedStage() {
		return (IStage) comboBox.getSelectedItem();
	}

	@Override
	public void updateList(List<ISubject> subjectList) {
		DefaultListModel<ISubject> model = new DefaultListModel();
		for (ISubject competence : subjectList) {
			model.addElement(competence);
		}
		list.setModel(model);
	}

	@Override
	public List<ISubject> getSeletedSubjects(){
		return list.getSelectedValuesList();
	}
}
