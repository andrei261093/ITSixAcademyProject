package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controllers.IAddMenuController;
import model.ISubject;
import model.ITeacher;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTextPane;

public class AddMenuGUI extends JFrame implements IAddMenuGUI {

	private JTextField inputSubjectName = new JTextField();
	private JTextField inputSubjectCode = new JTextField();
	private JTextField inputTeacherFirstName = new JTextField();
	private JTextField inputTeacherLastName = new JTextField();
	private JTextField inputTeacherTelephone = new JTextField();
	private JTextField inputTeacherEmail = new JTextField();
	private JTextField inputTeacherAddress = new JTextField();
	private JTextField inputCompetenceName = new JTextField();
	private JTextField inputRoom = new JTextField();

	JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

	JButton btnSaveTeacher = new JButton("Save");
	JButton btnSaveRoom = new JButton("Save");
	JButton btnSaveCourse = new JButton("Save");
	JButton btnNewPack = new JButton("New Pack");
	JButton btnSaveCompetence = new JButton("Save");
	JButton btnSaveSubject = new JButton("Save");

	JComboBox subjectsComboBox = new JComboBox();
	JComboBox teachersComboBox = new JComboBox();
	JComboBox dayComboBox = new JComboBox();
	JComboBox hourComboBox = new JComboBox();
	JComboBox roomComboBox = new JComboBox();
	JList list = new JList();

	IAddMenuController controller;

	public AddMenuGUI(IAddMenuController controller) {
		this.controller = controller;
		initialize();
	}

	public void initialize() {

		setBounds(100, 100, 590, 515);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);

		tabbedPane.setBounds(10, 11, 554, 454);
		getContentPane().add(tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Add Subject", null, panel, null);
		panel.setLayout(null);

		JLabel lblAddNewSubject = new JLabel("New Subject");
		lblAddNewSubject.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblAddNewSubject.setBounds(10, 11, 186, 50);
		panel.add(lblAddNewSubject);

		JLabel lblName = new JLabel("Name");
		lblName.setBounds(205, 134, 46, 14);
		panel.add(lblName);

		JLabel lblCode = new JLabel("Code");
		lblCode.setBounds(205, 179, 46, 14);
		panel.add(lblCode);

		inputSubjectName.setBounds(256, 131, 86, 20);
		panel.add(inputSubjectName);
		inputSubjectName.setColumns(10);

		inputSubjectCode.setBounds(256, 176, 86, 20);
		panel.add(inputSubjectCode);
		inputSubjectCode.setColumns(10);

		btnSaveSubject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSaveSubject.setBounds(230, 287, 89, 23);
		panel.add(btnSaveSubject);

		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.BLACK);
		panel_1.setBackground(SystemColor.menu);
		tabbedPane.addTab("Add Teacher", null, panel_1, null);
		panel_1.setLayout(null);

		JLabel lblNewTeacher = new JLabel("New Teacher");
		lblNewTeacher.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewTeacher.setBounds(10, 11, 211, 50);
		panel_1.add(lblNewTeacher);

		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(194, 89, 69, 14);
		panel_1.add(lblFirstName);

		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(194, 128, 69, 14);
		panel_1.add(lblLastName);

		JLabel lblTelephone = new JLabel("Telephone");
		lblTelephone.setBounds(194, 170, 69, 14);
		panel_1.add(lblTelephone);

		JLabel lblEmail = new JLabel(" Email");
		lblEmail.setBounds(194, 210, 46, 14);
		panel_1.add(lblEmail);

		JLabel lblAddress = new JLabel(" Address");
		lblAddress.setBounds(194, 247, 69, 14);
		panel_1.add(lblAddress);

		inputTeacherFirstName.setBounds(273, 86, 86, 20);
		panel_1.add(inputTeacherFirstName);
		inputTeacherFirstName.setColumns(10);

		inputTeacherLastName.setBounds(273, 125, 86, 20);
		panel_1.add(inputTeacherLastName);
		inputTeacherLastName.setColumns(10);

		inputTeacherTelephone.setBounds(273, 167, 86, 20);
		panel_1.add(inputTeacherTelephone);
		inputTeacherTelephone.setColumns(10);

		inputTeacherEmail.setBounds(273, 207, 86, 20);
		panel_1.add(inputTeacherEmail);
		inputTeacherEmail.setColumns(10);

		inputTeacherAddress.setBounds(273, 244, 86, 20);
		panel_1.add(inputTeacherAddress);
		inputTeacherAddress.setColumns(10);

		btnSaveTeacher.setBounds(234, 303, 89, 23);
		panel_1.add(btnSaveTeacher);

		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Add Room", null, panel_4, null);
		panel_4.setLayout(null);

		JLabel lblNewRoom = new JLabel("New Room");
		lblNewRoom.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewRoom.setBounds(10, 11, 174, 56);
		panel_4.add(lblNewRoom);

		JLabel lblName_2 = new JLabel("Name");
		lblName_2.setBounds(164, 162, 46, 14);
		panel_4.add(lblName_2);

		inputRoom.setBounds(220, 159, 120, 20);
		panel_4.add(inputRoom);
		inputRoom.setColumns(10);

		btnSaveRoom.setBounds(215, 288, 89, 23);
		panel_4.add(btnSaveRoom);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Add Course", null, panel_2, null);
		panel_2.setLayout(null);

		JLabel lblSubject = new JLabel("Subject");
		lblSubject.setBounds(180, 116, 46, 14);
		panel_2.add(lblSubject);

		subjectsComboBox.setBounds(248, 113, 102, 20);
		panel_2.add(subjectsComboBox);

		JLabel lblTeacher = new JLabel("Teacher");
		lblTeacher.setBounds(180, 67, 58, 14);
		panel_2.add(lblTeacher);

		teachersComboBox.setBounds(248, 64, 102, 20);
		panel_2.add(teachersComboBox);

		JLabel lblDay = new JLabel("Day");
		lblDay.setBounds(180, 164, 46, 14);
		panel_2.add(lblDay);
		dayComboBox.setModel(new DefaultComboBoxModel(new String[] { "Luni", "Marti", "Miercuri", "Joi", "Vineri" }));

		dayComboBox.setBounds(248, 161, 102, 20);
		panel_2.add(dayComboBox);

		JLabel lblHour = new JLabel("Hour");
		lblHour.setBounds(180, 215, 46, 14);
		panel_2.add(lblHour);
		hourComboBox.setModel(
				new DefaultComboBoxModel(new String[] { "08:00", "10:00", "12:00", "14:00", "16:00", "18:00" }));

		hourComboBox.setBounds(248, 212, 102, 20);
		panel_2.add(hourComboBox);

		JLabel lblRoom = new JLabel("Room");
		lblRoom.setBounds(180, 266, 46, 14);
		panel_2.add(lblRoom);
		roomComboBox.setModel(new DefaultComboBoxModel(new String[] { "Aula Belea", "C2", "C4" }));

		roomComboBox.setBounds(248, 263, 102, 20);
		panel_2.add(roomComboBox);
		btnSaveCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.saveTeacher();
			}
		});

		btnSaveCourse.setBounds(225, 325, 89, 23);
		panel_2.add(btnSaveCourse);

		JLabel lblNewCourse = new JLabel("New Course");
		lblNewCourse.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewCourse.setBounds(10, 11, 152, 47);
		panel_2.add(lblNewCourse);

		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Add Competence", null, panel_3, null);
		panel_3.setLayout(null);

		JLabel lblName_1 = new JLabel("Name");
		lblName_1.setBounds(55, 68, 46, 14);
		panel_3.add(lblName_1);

		inputCompetenceName = new JTextField();
		inputCompetenceName.setBounds(111, 65, 200, 20);
		panel_3.add(inputCompetenceName);
		inputCompetenceName.setColumns(10);

		list.setBounds(55, 96, 256, 257);
		panel_3.add(list);

		JLabel lblNewCompetence = new JLabel("New Competence");
		lblNewCompetence.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewCompetence.setBounds(10, 11, 180, 46);
		panel_3.add(lblNewCompetence);

		btnNewPack.setBounds(206, 364, 105, 23);
		panel_3.add(btnNewPack);

		JLabel lblDetails = new JLabel("Details");
		lblDetails.setBounds(349, 68, 46, 14);
		panel_3.add(lblDetails);

		btnSaveCompetence.setBounds(419, 364, 89, 23);
		panel_3.add(btnSaveCompetence);

		JTextPane txtpnSdfg = new JTextPane();
		txtpnSdfg.setEditable(false);
		txtpnSdfg.setText("niste text\r\n");
		txtpnSdfg.setBounds(331, 96, 177, 257);
		panel_3.add(txtpnSdfg);

		tabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				controller.updateAll();
			}
		});
	}

	@Override
	public void updateTeachersComboBox(List<ITeacher> teachers) {
		teachersComboBox.setModel(new DefaultComboBoxModel<>(teachers.toArray()));
	}

	@Override
	public void updateSubjectsCombobox(List<ISubject> subjectList) {
		subjectsComboBox.setModel(new DefaultComboBoxModel<>(subjectList.toArray()));

	}

	@Override
	public ISubject getSelectedSubject() {
		return (ISubject) subjectsComboBox.getSelectedItem();
	}

	@Override
	public ITeacher getSelectedTeacher() {
		return (ITeacher) teachersComboBox.getSelectedItem();
	}

	@Override
	public String getSelectedDay() {
		return (String) dayComboBox.getSelectedItem();
	}

	@Override
	public String getSelectedHour() {
		return (String) hourComboBox.getSelectedItem();
	}

	@Override
	public String getSelectedRoom() {
		return (String) roomComboBox.getSelectedItem();
	}

}
