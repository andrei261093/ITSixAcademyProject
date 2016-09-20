package itsix.academy.perfect_school.view.implementations;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.AbstractAction;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;

import itsix.academy.perfect_school.controllers.IEditPackageController;
import itsix.academy.perfect_school.model.ICompetence;
import itsix.academy.perfect_school.model.IPackage;
import itsix.academy.perfect_school.model.ISubject;
import itsix.academy.perfect_school.view.IEditPagkageGUI;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class EditPackageGUI extends JFrame implements IEditPagkageGUI {
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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 52, 175, 242);
		getContentPane().add(scrollPane);

		scrollPane.setViewportView(list);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.showAddSubjectsGUI();
			}
		});

		btnAdd.setBounds(222, 49, 89, 23);
		getContentPane().add(btnAdd);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.deleteSubject();
			}
		});

		btnDelete.setBounds(222, 83, 89, 23);
		getContentPane().add(btnDelete);
		btnMoveUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.moveUP();
			}
		});

		btnMoveUp.setBounds(222, 151, 89, 23);
		getContentPane().add(btnMoveUp);
		btnMoveDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.moveDown();
			}
		});

		btnMoveDown.setBounds(222, 185, 89, 23);
		getContentPane().add(btnMoveDown);

		JLabel lblNewLabel = new JLabel("Note: The subjects must be in order!");
		lblNewLabel.setBounds(25, 305, 286, 23);
		getContentPane().add(lblNewLabel);

		JLabel lblSubjects = new JLabel("Subjects:");
		lblSubjects.setBounds(25, 27, 46, 14);
		getContentPane().add(lblSubjects);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.save();
			}
		});
		btnSave.setBounds(222, 271, 89, 23);

		getContentPane().add(btnSave);
		setLocationRelativeTo(null);
		

		getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
				"Cancel");
		
		getRootPane().getActionMap().put("Cancel", new AbstractAction() {
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
	}

	@Override
	public void updateSubjectsList(List<ISubject> subjects) {
		DefaultListModel<ISubject> model = new DefaultListModel<>();
		for (ISubject current : subjects) {
			model.addElement(current);
		}
		list.setModel(model);
	}

	@Override
	public int getSelectedSubjectIndex() {
		return list.getSelectedIndex();
	}

	@Override
	public void setListSelection(int index) {
		list.setSelectedIndex(index);
		
	}

	@Override
	public ISubject getSelectedSubject() {
		return (ISubject) list.getSelectedValue();
	}
}
