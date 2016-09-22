package itsix.academy.perfect_school.view.implementations;

import java.awt.EventQueue;

import javax.swing.JFrame;

import itsix.academy.perfect_school.controllers.ITeacherInfoController;
import itsix.academy.perfect_school.view.ITeacherInfoGUI;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class TeacherInfoGUI extends JFrame implements ITeacherInfoGUI {
	private JTextField inputName;
	private JTextField inputLastName;
	private JTextField inputTelephone;
	private JTextField inputEmail;
	private JTextField inputAddress;

	private ITeacherInfoController controller;

	public TeacherInfoGUI(ITeacherInfoController controller) {
		this.controller = controller;
		initialize();
	}

	private void initialize() {

		setBounds(100, 100, 196, 211);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(10, 11, 67, 14);
		getContentPane().add(lblFirstName);

		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(10, 36, 67, 14);
		getContentPane().add(lblLastName);

		JLabel lblTelephone = new JLabel("Telephone");
		lblTelephone.setBounds(10, 61, 67, 14);
		getContentPane().add(lblTelephone);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 86, 46, 14);
		getContentPane().add(lblEmail);

		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(10, 114, 46, 14);
		getContentPane().add(lblAddress);

		inputName = new JTextField();
		inputName.setBounds(75, 8, 86, 20);
		getContentPane().add(inputName);
		inputName.setColumns(10);

		inputLastName = new JTextField();
		inputLastName.setBounds(75, 36, 86, 20);
		getContentPane().add(inputLastName);
		inputLastName.setColumns(10);

		inputTelephone = new JTextField();
		inputTelephone.setBounds(75, 61, 86, 20);
		getContentPane().add(inputTelephone);
		inputTelephone.setColumns(10);

		inputEmail = new JTextField();
		inputEmail.setBounds(75, 86, 86, 20);
		getContentPane().add(inputEmail);
		inputEmail.setColumns(10);

		inputAddress = new JTextField();
		inputAddress.setBounds(75, 111, 86, 20);
		getContentPane().add(inputAddress);
		inputAddress.setColumns(10);

		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.updateTeacher();
			}
		});
		btnNewButton.setBounds(97, 142, 67, 23);
		getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Edit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.setEditable();
			}
		});
		btnNewButton_1.setBounds(10, 142, 67, 23);
		getContentPane().add(btnNewButton_1);
		
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
	public String getFirstName() {
		return inputName.getText();
	}

	@Override
	public String getLastName() {
		return inputLastName.getText();
	}

	@Override
	public String getTelephone() {
		return inputTelephone.getText();
	}

	@Override
	public String getAddress() {
		return inputAddress.getText();
	}

	@Override
	public String getEmail() {
		return inputEmail.getText();
	}

	@Override
	public void setFirstName(String s) {
		inputName.setText(s);
	}

	@Override
	public void setLastName(String s) {
		inputLastName.setText(s);
	}

	@Override
	public void setTelephone(String s) {
		inputTelephone.setText(s);
	}

	@Override
	public void setAddress(String s) {
		inputAddress.setText(s);
	}

	@Override
	public void setEmail(String s) {
		inputEmail.setText(s);
	}

	@Override
	public void setEditable(boolean b) {
		inputAddress.setEditable(b);
		inputEmail.setEditable(b);
		inputLastName.setEditable(b);
		inputName.setEditable(b);
		inputTelephone.setEditable(b);
	}

}
