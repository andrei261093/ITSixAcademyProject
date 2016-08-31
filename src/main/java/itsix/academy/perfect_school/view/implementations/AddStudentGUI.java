package itsix.academy.perfect_school.view.implementations;


import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import itsix.academy.perfect_school.controllers.IAddStudentController;
import itsix.academy.perfect_school.view.IAddStudentGUI;

public class AddStudentGUI extends JFrame implements IAddStudentGUI {

	private JTextField inputFirstName = new JTextField();
	private JTextField inputLastName = new JTextField();
	private JTextField inputTelephone = new JTextField();
	private JTextField inputAddress = new JTextField();
	private JTextField inputSSN = new JTextField();
	private JTextField inputEmail = new JTextField();

	JButton btnNext = new JButton("Next");
	JButton btnDiscard = new JButton("Discard");

	IAddStudentController controller;

	public AddStudentGUI(IAddStudentController controller) {
		this.controller = controller;
		initialize();
	}

	@Override
	public void initialize() {

		setBounds(100, 100, 473, 469);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage((getClass().getClassLoader().getResource("addStudent.png"))));
		setTitle("New Student");

		JLabel lblStudentName = new JLabel("First Name");
		lblStudentName.setBounds(95, 66, 116, 14);
		getContentPane().add(lblStudentName);
		//lblStudentName.setIcon(new ImageIcon(getClass().getClassLoader().getResource("person.png")));

		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(95, 112, 116, 14);
		getContentPane().add(lblLastName);
		//lblLastName.setIcon(new ImageIcon(getClass().getClassLoader().getResource("person.png")));
		
		JLabel lblTelephone = new JLabel("Telephone");
		lblTelephone.setBounds(95, 265, 116, 14);
		getContentPane().add(lblTelephone);
		lblTelephone.setIcon(new ImageIcon(getClass().getClassLoader().getResource("iphone.png")));
		
		JLabel lblAddres = new JLabel("Address");
		lblAddres.setBounds(95, 218, 116, 14);
		getContentPane().add(lblAddres);
		lblAddres.setIcon(new ImageIcon(getClass().getClassLoader().getResource("address.png")));

		JLabel lblSsn = new JLabel("SSN");
		lblSsn.setBounds(95, 165, 116, 14);
		getContentPane().add(lblSsn);
		lblSsn.setIcon(new ImageIcon(getClass().getClassLoader().getResource("ssn.png")));

		inputFirstName.setBounds(200, 66, 159, 20);
		getContentPane().add(inputFirstName);
		inputFirstName.setColumns(10);

		inputLastName.setBounds(200, 112, 159, 20);
		getContentPane().add(inputLastName);
		inputLastName.setColumns(10);

		inputTelephone.setBounds(200, 265, 159, 20);
		getContentPane().add(inputTelephone);
		inputTelephone.setColumns(10);

		inputAddress.setBounds(200, 218, 159, 20);
		getContentPane().add(inputAddress);
		inputAddress.setColumns(10);

		inputSSN.setBounds(200, 165, 159, 20);
		getContentPane().add(inputSSN);
		inputSSN.setColumns(10);

		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.showAddCompetenceGUI();
			}
		});
		btnNext.setBounds(322, 375, 89, 23);
		getContentPane().add(btnNext);

		btnDiscard.setBounds(59, 375, 89, 23);
		getContentPane().add(btnDiscard);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(95, 312, 116, 14);
		getContentPane().add(lblEmail);
		lblEmail.setIcon(new ImageIcon(getClass().getClassLoader().getResource("email.png")));

		inputEmail.setBounds(200, 312, 159, 20);
		getContentPane().add(inputEmail);
		inputEmail.setColumns(10);
		setLocationRelativeTo(null);
		
		btnDiscard.setIcon(new ImageIcon(getClass().getClassLoader().getResource("cancel.png")));
		btnNext.setIcon(new ImageIcon(getClass().getClassLoader().getResource("ok.png")));
		
		getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
			    "Cancel");
			  getRootPane().getActionMap().put("Cancel", new AbstractAction() {
			   private static final long serialVersionUID = 1L;

			   public void actionPerformed(ActionEvent e) {
			    dispose();
			   clearInputs();
			   }
			  });
		

	}

	@Override
	public String getFirstName() {
		return inputFirstName.getText();
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
	public String getEmail() {
		return inputEmail.getText();
	}

	@Override
	public String getSSN() {
		return inputSSN.getText();
	}

	@Override
	public String getAddres() {
		return inputAddress.getText();
	}

	@Override
	public void clearInputs() {
		inputFirstName.setText("");
		inputLastName.setText("");
		inputAddress.setText("");
		inputSSN.setText("");
		inputTelephone.setText("");
		inputEmail.setText("");
	}
}
