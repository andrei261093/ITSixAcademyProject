package itsix.academy.perfect_school.view.implementations;


import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.LineBorder;

import itsix.academy.perfect_school.controllers.IEditStudentController;
import itsix.academy.perfect_school.model.IStage;
import itsix.academy.perfect_school.view.IEditStudentGUI;
import itsix.academy.perfect_school.view.customElements.IntegerJTextField;

import javax.swing.ImageIcon;

public class EditStudentGUI extends JFrame implements IEditStudentGUI {
	private JTextField jSSN;
	private JTextField jFirstName;
	private JTextField jLastName;
	private JTextField jTelephone;
	private JTextField jEmail;
	private JTextField jAddres;

	JButton btnSchedule = new JButton("Schedule");
	JButton btnDiscard = new JButton("Discard");
	JButton btnUpdate = new JButton("Update");
	JButton btnEnableEditing = new JButton("Enable Editing");
	JButton btnSearch = new JButton("Search");

	JComboBox stagesComboBox = new JComboBox();

	IEditStudentController editStudentController;

	public EditStudentGUI(IEditStudentController editStudentController) {
		this.editStudentController = editStudentController;
		initialize();
	}

	private void initialize() {

		setBounds(100, 100, 855, 455);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage((getClass().getClassLoader().getResource("edit.png"))));
		setTitle("Edit Student");

		JLabel lblStudentsSsn = new JLabel("Student's SSN");
		lblStudentsSsn.setBounds(37, 24, 126, 25);
		getContentPane().add(lblStudentsSsn);
		lblStudentsSsn.setIcon(new ImageIcon(getClass().getClassLoader().getResource("student.png")));

		jSSN = new IntegerJTextField(13);
		jSSN.setBounds(156, 27, 169, 20);
		getContentPane().add(jSSN);
		jSSN.setColumns(10);
		btnSearch.setIcon(new ImageIcon(getClass().getClassLoader().getResource("searchIcon.png")));

		
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editStudentController.search();
			}
		});
		btnSearch.setBounds(335, 26, 89, 23);
		getContentPane().add(btnSearch);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(37, 89, 763, 299);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblName = new JLabel("First Name");
		lblName.setBounds(41, 47, 101, 14);
		panel.add(lblName);

		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(41, 86, 101, 14);
		panel.add(lblLastName);

		JLabel lblTelephone = new JLabel("Telephone");
		lblTelephone.setBounds(41, 129, 101, 14);
		panel.add(lblTelephone);
		lblTelephone.setIcon(new ImageIcon(getClass().getClassLoader().getResource("iphone.png")));

		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(41, 171, 101, 14);
		panel.add(lblEmail);
		lblEmail.setIcon(new ImageIcon(getClass().getClassLoader().getResource("email.png")));

		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(41, 210, 101, 14);
		panel.add(lblAddress);
		lblAddress.setIcon(new ImageIcon(getClass().getClassLoader().getResource("address.png")));

		jFirstName = new JTextField();
		jFirstName.setBounds(123, 47, 175, 20);
		panel.add(jFirstName);
		jFirstName.setColumns(10);

		jLastName = new JTextField();
		jLastName.setBounds(123, 86, 175, 20);
		panel.add(jLastName);
		jLastName.setColumns(10);

		jTelephone = new JTextField();
		jTelephone.setBounds(123, 129, 175, 20);
		panel.add(jTelephone);
		jTelephone.setColumns(10);

		jEmail = new JTextField();
		jEmail.setBounds(123, 171, 175, 20);
		panel.add(jEmail);
		jEmail.setColumns(10);

		jAddres = new JTextField();
		jAddres.setBounds(125, 210, 173, 20);
		panel.add(jAddres);
		jAddres.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(330, 47, 387, 117);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblStage = new JLabel("Stage");
		lblStage.setBounds(69, 14, 46, 14);
		panel_1.add(lblStage);

		stagesComboBox.setBounds(125, 11, 184, 20);
		panel_1.add(stagesComboBox);

		btnSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				editStudentController.showSchedule();
			}
		});
		btnSchedule.setBounds(69, 56, 240, 23);
		panel_1.add(btnSchedule);
		btnSchedule.setEnabled(false);
		btnSchedule.setIcon(new ImageIcon(getClass().getClassLoader().getResource("schedule.png")));

		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editStudentController.update();
			}
		});
		btnUpdate.setBounds(628, 265, 89, 23);
		panel.add(btnUpdate);
		btnUpdate.setEnabled(false);
		btnUpdate.setIcon(new ImageIcon(getClass().getClassLoader().getResource("ok.png")));

		btnDiscard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editStudentController.discard();
			}
		});
		btnDiscard.setBounds(529, 265, 89, 23);
		panel.add(btnDiscard);
		btnDiscard.setEnabled(false);
		btnDiscard.setIcon(new ImageIcon(getClass().getClassLoader().getResource("cancel.png")));

		
		btnEnableEditing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				editStudentController.enableInputs();
			}
		});
		btnEnableEditing.setBounds(123, 251, 175, 23);
		panel.add(btnEnableEditing);
		btnEnableEditing.setIcon(new ImageIcon(getClass().getClassLoader().getResource("edit.png")));
		
		inputsSetEnabled(false);
		buttonsSetEnabled(false);
		
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
		return jFirstName.getText();
	}

	@Override
	public String getLastName() {
		return jLastName.getText();
	}

	@Override
	public String getTelephone() {
		return jTelephone.getText();
	}

	@Override
	public String getEmail() {
		return jEmail.getText();
	}

	@Override
	public String getAddress() {
		return jAddres.getText();
	}

	@Override
	public String getSSN() {
		return jSSN.getText();
	}

	@Override
	public void setFirstName(String name) {
		jFirstName.setText(name);
	}

	@Override
	public void setLastName(String name) {
		jLastName.setText(name);
	}

	@Override
	public void setTelephone(String telephone) {
		jTelephone.setText(telephone);
	}

	@Override
	public void setEmail(String email) {
		jEmail.setText(email);
	}

	@Override
	public void setAddress(String address) {
		jAddres.setText(address);
	}

	@Override
	public void updateComboBox(List<IStage> stageList) {
		stagesComboBox.setModel(new DefaultComboBoxModel(stageList.toArray()));
		stagesComboBox.setSelectedIndex(0);
	}

	@Override
	public void clearCombobox() {
		stagesComboBox.removeAllItems();
	}

	@Override
	public IStage getSelectedStage() {
		return (IStage) stagesComboBox.getSelectedItem();
	}

	@Override
	public void buttonsSetEnabled(boolean b) {
		btnSchedule.setEnabled(b);
		btnUpdate.setEnabled(b);
		btnDiscard.setEnabled(b);
		btnEnableEditing.setEnabled(b);
		btnSearch.setEnabled(!b);
		jSSN.setEnabled(!b);
		
	}

	@Override
	public void inputsSetEnabled(boolean b) {
		jAddres.setEnabled(b);
		jEmail.setEnabled(b);
		jFirstName.setEnabled(b);
		jLastName.setEnabled(b);
		jTelephone.setEnabled(b);
	}
}
