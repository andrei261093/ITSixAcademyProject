package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controllers.IAddStudentController;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddStudentGUI extends JFrame implements IAddStudentGUI {

	private JTextField inputFirstName = new JTextField();
	private JTextField inputLastName = new JTextField();
	private JTextField inputTelephone = new JTextField();
	private JTextField inputAddress = new JTextField();
	private JTextField inputSSN = new JTextField();

	IAddStudentController controller;

	public AddStudentGUI(IAddStudentController controller) {
		this.controller = controller;
		initialize();
	}

	@Override
	public void initialize() {

		setBounds(100, 100, 473, 469);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel lblStudentName = new JLabel("First Name");
		lblStudentName.setBounds(130, 69, 72, 14);
		getContentPane().add(lblStudentName);

		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(130, 115, 65, 14);
		getContentPane().add(lblLastName);

		JLabel lblTelephone = new JLabel("Telephone");
		lblTelephone.setBounds(130, 169, 65, 14);
		getContentPane().add(lblTelephone);

		JLabel lblAddres = new JLabel("Addres");
		lblAddres.setBounds(130, 221, 65, 14);
		getContentPane().add(lblAddres);

		JLabel lblSsn = new JLabel("SSN");
		lblSsn.setBounds(130, 266, 46, 14);
		getContentPane().add(lblSsn);

		inputFirstName.setBounds(221, 66, 86, 20);
		getContentPane().add(inputFirstName);
		inputFirstName.setColumns(10);

		inputLastName.setBounds(221, 112, 86, 20);
		getContentPane().add(inputLastName);
		inputLastName.setColumns(10);

		inputTelephone.setBounds(221, 166, 86, 20);
		getContentPane().add(inputTelephone);
		inputTelephone.setColumns(10);

		inputAddress.setBounds(221, 218, 86, 20);
		getContentPane().add(inputAddress);
		inputAddress.setColumns(10);

		inputSSN.setBounds(221, 263, 86, 20);
		getContentPane().add(inputSSN);
		inputSSN.setColumns(10);

		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.showAddCompetenceGUI();
			}
		});
		btnNext.setBounds(322, 375, 89, 23);
		getContentPane().add(btnNext);

		JButton btnDiscard = new JButton("Discard");
		btnDiscard.setBounds(59, 375, 89, 23);
		getContentPane().add(btnDiscard);
	}

}
