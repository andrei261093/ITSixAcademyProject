package itsix.academy.perfect_school.view.implementations;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import itsix.academy.perfect_school.controllers.IEditStagesController;
import itsix.academy.perfect_school.model.IStage;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class MoveSubjectToWindow extends JFrame {

	JComboBox comboBox = new JComboBox();
	JButton btnDone = new JButton("Done");
	
	IEditStagesController controller;
	
	public MoveSubjectToWindow(IEditStagesController controller) {
		initialize();
		this.controller = controller;
	}

	private void initialize() {
		setBounds(100, 100, 257, 112);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblMoveTo = new JLabel("Move to");
		lblMoveTo.setBounds(10, 11, 61, 14);
		getContentPane().add(lblMoveTo);
		
		
		comboBox.setBounds(61, 8, 164, 20);
		getContentPane().add(comboBox);
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.moveSubjects();
			}
		});
		
		
		btnDone.setBounds(136, 39, 89, 23);
		getContentPane().add(btnDone);
		
		setLocationRelativeTo(null);
	}
	

	public void updateComboBox(List<IStage> stagesList) {
		comboBox.setModel(new DefaultComboBoxModel(stagesList.toArray()));
	}


	public IStage getSelectedStage() {
		return (IStage) comboBox.getSelectedItem();
	}


}
