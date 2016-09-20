package itsix.academy.perfect_school.view.implementations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import itsix.academy.perfect_school.controllers.IEditPackageController;
import itsix.academy.perfect_school.model.ISubject;
import itsix.academy.perfect_school.view.IAddSubjectToPackage;

public class AddSubjectToPackageGUI extends JFrame implements IAddSubjectToPackage {
	private IEditPackageController controller;
	
	private JTextField textField;
	private JList list;

	public AddSubjectToPackageGUI(IEditPackageController controller) {
		this.controller = controller;
		initialize();
	}

	private void initialize() {

		setBounds(100, 100, 281, 424);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);

		textField = new JTextField();
		textField.setBounds(79, 11, 176, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		textField.getDocument().addDocumentListener(new DocumentListener() {
			  public void changedUpdate(DocumentEvent e) {
			    search();
			  }
			  public void removeUpdate(DocumentEvent e) {
			    search();
			  }
			  public void insertUpdate(DocumentEvent e) {
			    search();
			  }

			});

		JLabel lblSerach = new JLabel("Serach");
		lblSerach.setBounds(10, 14, 59, 14);
		getContentPane().add(lblSerach);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 42, 245, 282);
		getContentPane().add(scrollPane);

		list = new JList();
		scrollPane.setViewportView(list);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.addSubjects();
			}
		});
		btnAdd.setBounds(91, 348, 89, 23);
		getContentPane().add(btnAdd);
		
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
	public String getText() {
		return textField.getText();
	}
	
	void search(){
		controller.searchSubjects();
	}
	
	@Override
	public List<ISubject> getSelectedSubjects(){
		return list.getSelectedValuesList();
	}
}
