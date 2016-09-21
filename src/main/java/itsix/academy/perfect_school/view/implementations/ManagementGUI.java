package itsix.academy.perfect_school.view.implementations;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import itsix.academy.perfect_school.controllers.IManagementController;
import itsix.academy.perfect_school.model.ICompetence;
import itsix.academy.perfect_school.model.IPackage;
import itsix.academy.perfect_school.model.IRoom;
import itsix.academy.perfect_school.model.ISubject;
import itsix.academy.perfect_school.model.ITeacher;
import itsix.academy.perfect_school.view.IManagementGUI;

public class ManagementGUI extends JFrame implements IManagementGUI {

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
	JButton btnSaveSubject = new JButton("Save");

	JComboBox subjectsComboBox = new JComboBox();
	JComboBox teachersComboBox = new JComboBox();
	JComboBox dayComboBox = new JComboBox();
	JComboBox hourComboBox = new JComboBox();
	JComboBox roomComboBox = new JComboBox();

	JList competenceList = new JList();
	JList packsList = new JList();

	IManagementController controller;

	public ManagementGUI(IManagementController controller) {
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
		lblName.setBounds(139, 135, 46, 14);
		panel.add(lblName);

		JLabel lblCode = new JLabel("Code");
		lblCode.setBounds(139, 180, 46, 14);
		panel.add(lblCode);

		inputSubjectName.setBounds(190, 132, 204, 20);
		panel.add(inputSubjectName);
		inputSubjectName.setColumns(10);

		inputSubjectCode.setBounds(190, 177, 204, 20);
		panel.add(inputSubjectCode);
		inputSubjectCode.setColumns(10);

		btnSaveSubject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.saveSubject();
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
		lblFirstName.setBounds(139, 86, 82, 14);
		panel_1.add(lblFirstName);

		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(139, 125, 82, 14);
		panel_1.add(lblLastName);

		JLabel lblTelephone = new JLabel("Telephone");
		lblTelephone.setBounds(139, 167, 82, 14);
		panel_1.add(lblTelephone);

		JLabel lblEmail = new JLabel(" Email");
		lblEmail.setBounds(139, 207, 82, 14);
		panel_1.add(lblEmail);

		JLabel lblAddress = new JLabel(" Address");
		lblAddress.setBounds(139, 244, 82, 14);
		panel_1.add(lblAddress);

		inputTeacherFirstName.setBounds(231, 86, 173, 20);
		panel_1.add(inputTeacherFirstName);
		inputTeacherFirstName.setColumns(10);

		inputTeacherLastName.setBounds(231, 125, 173, 20);
		panel_1.add(inputTeacherLastName);
		inputTeacherLastName.setColumns(10);

		inputTeacherTelephone.setBounds(231, 167, 173, 20);
		panel_1.add(inputTeacherTelephone);
		inputTeacherTelephone.setColumns(10);

		inputTeacherEmail.setBounds(231, 207, 173, 20);
		panel_1.add(inputTeacherEmail);
		inputTeacherEmail.setColumns(10);

		inputTeacherAddress.setBounds(231, 244, 173, 20);
		panel_1.add(inputTeacherAddress);
		inputTeacherAddress.setColumns(10);

		btnSaveTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.saveTeacher();
			}
		});

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
		lblName_2.setBounds(133, 162, 46, 14);
		panel_4.add(lblName_2);

		inputRoom.setBounds(189, 159, 207, 20);
		panel_4.add(inputRoom);
		inputRoom.setColumns(10);
		btnSaveRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.saveRoom();
			}
		});

		btnSaveRoom.setBounds(215, 288, 89, 23);
		panel_4.add(btnSaveRoom);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Add Course", null, panel_2, null);
		panel_2.setLayout(null);

		JLabel lblSubject = new JLabel("Subject");
		lblSubject.setBounds(146, 116, 46, 14);
		panel_2.add(lblSubject);

		subjectsComboBox.setBounds(214, 113, 191, 20);
		panel_2.add(subjectsComboBox);

		JLabel lblTeacher = new JLabel("Teacher");
		lblTeacher.setBounds(146, 67, 58, 14);
		panel_2.add(lblTeacher);

		teachersComboBox.setBounds(214, 64, 191, 20);
		panel_2.add(teachersComboBox);

		JLabel lblDay = new JLabel("Day");
		lblDay.setBounds(146, 164, 46, 14);
		panel_2.add(lblDay);
		dayComboBox.setModel(new DefaultComboBoxModel(new String[] { "Luni", "Marti", "Miercuri", "Joi", "Vineri" }));

		dayComboBox.setBounds(214, 161, 191, 20);
		panel_2.add(dayComboBox);

		JLabel lblHour = new JLabel("Hour");
		lblHour.setBounds(146, 215, 46, 14);
		panel_2.add(lblHour);
		hourComboBox.setModel(
				new DefaultComboBoxModel(new String[] { "08:00", "10:00", "12:00", "14:00", "16:00", "18:00" }));

		hourComboBox.setBounds(214, 212, 191, 20);
		panel_2.add(hourComboBox);

		JLabel lblRoom = new JLabel("Room");
		lblRoom.setBounds(146, 266, 46, 14);
		panel_2.add(lblRoom);

		roomComboBox.setBounds(214, 263, 191, 20);
		panel_2.add(roomComboBox);

		btnSaveCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.saveCourse();
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

		JLabel lblName_1 = new JLabel("Search");
		lblName_1.setBounds(25, 26, 46, 14);
		panel_3.add(lblName_1);

		inputCompetenceName = new JTextField();
		inputCompetenceName.setBounds(81, 26, 174, 20);
		panel_3.add(inputCompetenceName);
		inputCompetenceName.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 57, 230, 296);
		panel_3.add(scrollPane);
		scrollPane.setViewportView(competenceList);

		JLabel lblPacks = new JLabel("Packs");
		lblPacks.setBounds(282, 26, 46, 14);
		panel_3.add(lblPacks);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(282, 58, 240, 294);
		panel_3.add(scrollPane_1);

		scrollPane_1.setViewportView(packsList);

		JButton btnNewCompetence = new JButton("New Competence");
		btnNewCompetence.setBounds(138, 364, 117, 23);
		panel_3.add(btnNewCompetence);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.addPackage();
			}
		});
		btnAdd.setBounds(282, 364, 75, 23);
		panel_3.add(btnAdd);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDelete.setBounds(447, 363, 75, 23);
		panel_3.add(btnDelete);
		
		

		packsList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					controller.editPackage();
				}
			}
		});

		tabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				controller.updateAll();
			}
		});

		competenceList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 1) {
					controller.updatePackagesList();
				}
			}
		});

		setLocationRelativeTo(null);

		lblAddNewSubject.setIcon(new ImageIcon(getClass().getClassLoader().getResource("subject.png")));
		lblAddress.setIcon(new ImageIcon(getClass().getClassLoader().getResource("address.png")));
		lblNewTeacher.setIcon(new ImageIcon(getClass().getClassLoader().getResource("teacher.png")));
		lblTelephone.setIcon(new ImageIcon(getClass().getClassLoader().getResource("iphone.png")));
		lblEmail.setIcon(new ImageIcon(getClass().getClassLoader().getResource("email.png")));
		btnSaveCourse.setIcon(new ImageIcon(getClass().getClassLoader().getResource("ok.png")));
		btnSaveRoom.setIcon(new ImageIcon(getClass().getClassLoader().getResource("ok.png")));
		btnSaveSubject.setIcon(new ImageIcon(getClass().getClassLoader().getResource("ok.png")));
		btnSaveTeacher.setIcon(new ImageIcon(getClass().getClassLoader().getResource("ok.png")));
		lblNewRoom.setIcon(new ImageIcon(getClass().getClassLoader().getResource("room.png")));
		lblNewCourse.setIcon(new ImageIcon(getClass().getClassLoader().getResource("course.png")));

	}

	@Override
	public void updateRoomsComboBox(List<IRoom> rooms) {
		roomComboBox.setModel(new DefaultComboBoxModel<>(rooms.toArray()));
	}

	@Override
	public void updateTeachersComboBox(List<ITeacher> teachers) {

		Collections.sort(teachers, new Comparator<ITeacher>() {
			@Override
			public int compare(ITeacher t1, ITeacher t2) {
				return t1.toString().compareToIgnoreCase(t2.toString());
			}
		});

		teachersComboBox.setModel(new DefaultComboBoxModel<>(teachers.toArray()));
	}

	@Override
	public void updateCompetenceList(List<ICompetence> competences) {
		DefaultListModel<ICompetence> model = new DefaultListModel<>();
		for (ICompetence competence : competences) {
			model.addElement(competence);
		}
		competenceList.setModel(model);
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
	public String getInputRoomName() {
		return inputRoom.getText();
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
	public IRoom getSelectedRoom() {
		return (IRoom) roomComboBox.getSelectedItem();
	}

	@Override
	public String getTeachersFirstName() {
		return inputTeacherFirstName.getText();
	}

	@Override
	public String getTeachersLastName() {
		return inputTeacherLastName.getText();
	}

	@Override
	public String getTeachersEmail() {
		return inputTeacherEmail.getText();
	}

	@Override
	public String getTeachersAddress() {
		return inputTeacherAddress.getText();
	}

	@Override
	public String getTeachersTelephone() {
		return inputTeacherTelephone.getText();
	}

	@Override
	public void clearInputs() {
		inputTeacherAddress.setText("");
		inputTeacherEmail.setText("");
		inputTeacherFirstName.setText("");
		inputTeacherLastName.setText("");
		inputTeacherTelephone.setText("");
		inputSubjectCode.setText("");
		inputSubjectName.setText("");
		inputRoom.setText("");
	}

	@Override
	public String getSubjectName() {
		return inputSubjectName.getText();
	}

	@Override
	public String getSubjectCode() {
		return inputSubjectCode.getText();
	}

	@Override
	public ICompetence getSelectedListCompetence() {
		return (ICompetence) competenceList.getSelectedValue();
	}

	@Override
	public void updatePackagesList(ICompetence competence) {
		DefaultListModel<IPackage> model = new DefaultListModel<>();
		for (IPackage current : competence.getPackages()) {
			model.addElement(current);
		}
		packsList.setModel(model);
	}

	@Override
	public IPackage getSelectedPackage() {
		return (IPackage) packsList.getSelectedValue();
	}

}
