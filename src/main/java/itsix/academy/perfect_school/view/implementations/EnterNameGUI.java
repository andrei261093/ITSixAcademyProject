package itsix.academy.perfect_school.view.implementations;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import itsix.academy.perfect_school.controllers.IManagementController;
import itsix.academy.perfect_school.publisherSubscriber.IInnerPublisher;
import itsix.academy.perfect_school.publisherSubscriber.IPublisher;
import itsix.academy.perfect_school.publisherSubscriber.ISubscriber;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class EnterNameGUI extends JFrame {

	private static final long serialVersionUID = 1L;

	private JTextField textField;

	IManagementController controller;

	public EnterNameGUI(IManagementController controller) {
		this.controller = controller;

		initialize();
	}

	private void initialize() {

		setBounds(100, 100, 327, 110);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(44, 14, 46, 14);
		getContentPane().add(lblName);

		textField = new JTextField();
		textField.setBounds(88, 11, 184, 20);
		getContentPane().add(textField);
		textField.setColumns(10);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.addNewCompetence();
			}
		});
		btnOk.setBounds(109, 42, 89, 23);
		getContentPane().add(btnOk);
		
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

	public String getInput() {
		return textField.getText();
	}

	public void resetText() {
		textField.setText("");
	}

}
