package itsix.academy.perfect_school.view.implementations;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import itsix.academy.perfect_school.controllers.IManagementController;
import itsix.academy.perfect_school.model.ICompetence;
import itsix.academy.perfect_school.model.IPackage;
import itsix.academy.perfect_school.model.IRoom;
import itsix.academy.perfect_school.model.ISubject;
import itsix.academy.perfect_school.model.ITeacher;
import itsix.academy.perfect_school.view.IManagementGUI;
import javax.swing.border.LineBorder;

public class ManagementGUI extends JFrame implements IManagementGUI {

	private static final long serialVersionUID = 1L;
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

	JButton btnSaveTeacher = new JButton("Add");
	JButton btnSaveRoom = new JButton("Add");
	JButton btnSaveCourse = new JButton("Save");
	JButton btnSaveSubject = new JButton("Save");

	JComboBox subjectsComboBox = new JComboBox();
	JComboBox teachersComboBox = new JComboBox();
	JComboBox dayComboBox = new JComboBox();
	JComboBox hourComboBox = new JComboBox();
	JComboBox roomComboBox = new JComboBox();

	JList<ICompetence> competenceList = new JList();
	JList<IPackage> packsList = new JList();

	IManagementController controller;
	private JList<IRoom> roomsJList;
	private JList<ITeacher> teachersJList;
	private JList<ISubject> subjectsJList;

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
		tabbedPane.addTab("Subjects", null, panel, null);
		panel.setLayout(null);

		JLabel lblAddNewSubject = new JLabel("Subjects");
		lblAddNewSubject.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblAddNewSubject.setBounds(10, 11, 186, 50);
		panel.add(lblAddNewSubject);

		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.BLACK);
		panel_1.setBackground(SystemColor.menu);
		tabbedPane.addTab("Teachers", null, panel_1, null);
		panel_1.setLayout(null);

		JLabel lblNewTeacher = new JLabel("Teachers");
		lblNewTeacher.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewTeacher.setBounds(10, 11, 211, 50);
		panel_1.add(lblNewTeacher);

		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Rooms", null, panel_4, null);
		panel_4.setLayout(null);

		JLabel lblNewRoom = new JLabel("Rooms");
		lblNewRoom.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewRoom.setBounds(10, 11, 174, 56);
		panel_4.add(lblNewRoom);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Courses", null, panel_2, null);
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
		tabbedPane.addTab("Competences", null, panel_3, null);
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
		btnNewCompetence.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.createCompetence();
			}
		});
		btnNewCompetence.setBounds(138, 364, 117, 23);
		panel_3.add(btnNewCompetence);

		JButton btnAdd = new JButton("New Package");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.addPackage();
			}
		});
		btnAdd.setBounds(282, 364, 117, 23);
		panel_3.add(btnAdd);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.deletePackage();
			}
		});
		btnDelete.setBounds(447, 363, 75, 23);
		panel_3.add(btnDelete);

		JButton btnDelete_1 = new JButton("Delete");
		btnDelete_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.deleteCompetence();
			}
		});
		btnDelete_1.setBounds(25, 364, 89, 23);
		panel_3.add(btnDelete_1);

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
		lblNewTeacher.setIcon(new ImageIcon(getClass().getClassLoader().getResource("teacher.png")));
		btnSaveCourse.setIcon(new ImageIcon(getClass().getClassLoader().getResource("ok.png")));

		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_9.setBounds(10, 83, 244, 302);
		panel.add(panel_9);
		panel_9.setLayout(null);
		btnSaveSubject.setBounds(74, 113, 89, 23);
		panel_9.add(btnSaveSubject);

		btnSaveSubject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.saveSubject();
			}
		});
		btnSaveSubject.setIcon(new ImageIcon(getClass().getClassLoader().getResource("ok.png")));
		inputSubjectName.setBounds(85, 11, 112, 20);
		panel_9.add(inputSubjectName);
		inputSubjectName.setColumns(10);

		JLabel lblName = new JLabel("Name");
		lblName.setBounds(34, 14, 46, 14);
		panel_9.add(lblName);

		JLabel lblCode = new JLabel("Code");
		lblCode.setBounds(34, 59, 46, 14);
		panel_9.add(lblCode);
		inputSubjectCode.setBounds(85, 56, 112, 20);
		panel_9.add(inputSubjectCode);
		inputSubjectCode.setColumns(10);

		JPanel panel_10 = new JPanel();
		panel_10.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_10.setBounds(295, 83, 244, 302);
		panel.add(panel_10);
		panel_10.setLayout(null);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(26, 11, 196, 246);
		panel_10.add(scrollPane_4);

		subjectsJList = new JList();
		scrollPane_4.setViewportView(subjectsJList);

		JButton btnDeleteSubject = new JButton("Delete");
		btnDeleteSubject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.deleteSubject();
			}
		});
		btnDeleteSubject.setBounds(78, 268, 89, 23);
		panel_10.add(btnDeleteSubject);

		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_7.setBounds(10, 83, 244, 302);
		panel_1.add(panel_7);
		panel_7.setLayout(null);
		inputTeacherFirstName.setBounds(93, 11, 141, 20);
		panel_7.add(inputTeacherFirstName);
		inputTeacherFirstName.setColumns(10);
		inputTeacherLastName.setBounds(93, 50, 141, 20);
		panel_7.add(inputTeacherLastName);
		inputTeacherLastName.setColumns(10);
		inputTeacherTelephone.setBounds(93, 92, 141, 20);
		panel_7.add(inputTeacherTelephone);
		inputTeacherTelephone.setColumns(10);
		inputTeacherEmail.setBounds(93, 132, 141, 20);
		panel_7.add(inputTeacherEmail);
		inputTeacherEmail.setColumns(10);
		inputTeacherAddress.setBounds(93, 169, 141, 20);
		panel_7.add(inputTeacherAddress);
		inputTeacherAddress.setColumns(10);

		JLabel lblAddress = new JLabel(" Address");
		lblAddress.setBounds(18, 169, 82, 14);
		panel_7.add(lblAddress);
		lblAddress.setIcon(new ImageIcon(getClass().getClassLoader().getResource("address.png")));

		JLabel lblEmail = new JLabel(" Email");
		lblEmail.setBounds(18, 132, 82, 14);
		panel_7.add(lblEmail);
		lblEmail.setIcon(new ImageIcon(getClass().getClassLoader().getResource("email.png")));

		JLabel lblTelephone = new JLabel("Telephone");
		lblTelephone.setBounds(18, 92, 82, 14);
		panel_7.add(lblTelephone);
		lblTelephone.setIcon(new ImageIcon(getClass().getClassLoader().getResource("iphone.png")));

		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(18, 50, 82, 14);
		panel_7.add(lblLastName);

		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(18, 11, 82, 14);
		panel_7.add(lblFirstName);
		btnSaveTeacher.setBounds(72, 237, 89, 23);
		panel_7.add(btnSaveTeacher);

		btnSaveTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.saveTeacher();
			}
		});
		btnSaveTeacher.setIcon(new ImageIcon(getClass().getClassLoader().getResource("ok.png")));

		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_8.setBounds(295, 83, 244, 302);
		panel_1.add(panel_8);
		panel_8.setLayout(null);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(26, 11, 196, 246);
		panel_8.add(scrollPane_3);

		teachersJList = new JList();
		scrollPane_3.setViewportView(teachersJList);

		JButton btnDeleteRoom = new JButton("Delete");
		btnDeleteRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				controller.deleteTeacher();
			}
		});
		
		teachersJList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					controller.showTeacherInfo();
				}
			}
		});
		
		btnDeleteRoom.setBounds(78, 268, 89, 23);
		panel_8.add(btnDeleteRoom);
		lblNewRoom.setIcon(new ImageIcon(getClass().getClassLoader().getResource("room.png")));

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_5.setBounds(10, 83, 244, 302);
		panel_4.add(panel_5);
		panel_5.setLayout(null);

		JLabel lblName_2 = new JLabel("Name");
		lblName_2.setBounds(10, 14, 46, 14);
		panel_5.add(lblName_2);
		inputRoom.setBounds(45, 11, 177, 20);
		panel_5.add(inputRoom);
		inputRoom.setColumns(10);
		btnSaveRoom.setBounds(76, 42, 89, 23);
		panel_5.add(btnSaveRoom);
		btnSaveRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.saveRoom();
			}
		});
		btnSaveRoom.setIcon(new ImageIcon(getClass().getClassLoader().getResource("ok.png")));

		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_6.setBounds(295, 83, 244, 302);
		panel_4.add(panel_6);
		panel_6.setLayout(null);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(26, 11, 196, 246);
		panel_6.add(scrollPane_2);

		roomsJList = new JList();
		scrollPane_2.setViewportView(roomsJList);

		JButton btnDelete_2 = new JButton("Delete");
		btnDelete_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.deleteRoom();
			}
		});
		btnDelete_2.setBounds(78, 268, 89, 23);
		panel_6.add(btnDelete_2);
		lblNewCourse.setIcon(new ImageIcon(getClass().getClassLoader().getResource("course.png")));

		JButton btnDeleteCourses = new JButton("Delete Courses");
		btnDeleteCourses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.deleteCourses();
			}
		});
		btnDeleteCourses.setBounds(415, 392, 124, 23);
		panel_2.add(btnDeleteCourses);
		
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

	@Override
	public boolean isACompetenceSelected() {
		return !competenceList.isSelectionEmpty();
	}

	@Override
	public boolean isAPackageSelected() {
		return !packsList.isSelectionEmpty();
	}

	@Override
	public void updateRoomsList(List<IRoom> rooms) {
		DefaultListModel<IRoom> model = new DefaultListModel<>();
		for (IRoom room : rooms) {
			model.addElement(room);
		}
		roomsJList.setModel(model);
	}

	@Override
	public IRoom getSelectedJListRoom() {
		return roomsJList.getSelectedValue();
	}

	@Override
	public boolean isARoomSelected() {
		return !roomsJList.isSelectionEmpty();
	}

	@Override
	public void updateTeachersList(List<ITeacher> teachers) {
		DefaultListModel<ITeacher> model = new DefaultListModel<>();
		for (ITeacher teacher : teachers) {
			model.addElement(teacher);
		}
		teachersJList.setModel(model);
	}

	@Override
	public ITeacher getSelectedJListTeacher() {
		return teachersJList.getSelectedValue();
	}

	@Override
	public boolean isATeacherSelected() {
		return !teachersJList.isSelectionEmpty();
	}
	
	@Override
	public void updateSubjectsList(List<ISubject> subjects) {
		DefaultListModel<ISubject> model = new DefaultListModel<>();
		for (ISubject subject : subjects) {
			model.addElement(subject);
		}
		subjectsJList.setModel(model);
	}

	@Override
	public ISubject getSelectedJListSubject() {
		return subjectsJList.getSelectedValue();
	}

	@Override
	public boolean isASubjectSelected() {
		return !subjectsJList.isSelectionEmpty();
	}
}
