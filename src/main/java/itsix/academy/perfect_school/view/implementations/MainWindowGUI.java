package itsix.academy.perfect_school.view.implementations;



import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import itsix.academy.perfect_school.controllers.IAddStudentController;
import itsix.academy.perfect_school.controllers.IEditStudentController;
import itsix.academy.perfect_school.controllers.IManagementController;
import itsix.academy.perfect_school.repositories.IMainRepository;
import itsix.academy.perfect_school.repositories.IParser;
import itsix.academy.perfect_school.repositories.implementations.ParseObjectsFile;
import itsix.academy.perfect_school.view.IMainWindowGUI;

public class MainWindowGUI extends JFrame implements IMainWindowGUI {
	JButton btnNewStudent = new JButton("New Student");
	JButton btnEditStudent = new JButton("Edit Student");
	JButton btnAddMenu = new JButton("Management");

	IAddStudentController addStudentController;
	IManagementController addMenuController;
	IEditStudentController editStudentController;
	
	IMainRepository mainRepository;

	public MainWindowGUI(IAddStudentController addStudentController, IManagementController addMenuController, IEditStudentController editStudentController, IMainRepository mainRepository ) {
		this.addStudentController = addStudentController;
		this.addMenuController = addMenuController;
		this.editStudentController = editStudentController;
		
		this.mainRepository = mainRepository;
		
		initialize();
		
	}

	@Override
	public void initialize() {
		setResizable(false);
		setBounds(100, 100, 608, 334);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
            	IParser parser = new ParseObjectsFile();
        		parser.serialize(mainRepository);
                e.getWindow().dispose();
            }
        });
		
		setIconImage(Toolkit.getDefaultToolkit().getImage((getClass().getClassLoader().getResource("appIcon.png"))));
		setTitle("Perfect School");

		getContentPane().setLayout(null);
		btnNewStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addStudentController.showAddStudentGUI();
			}
		});

		btnNewStudent.setBounds(71, 225, 136, 23);
		getContentPane().add(btnNewStudent);
		btnEditStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editStudentController.showEditStudentGUI();
			}
		});

		btnEditStudent.setBounds(227, 225, 136, 23);
		getContentPane().add(btnEditStudent);

		btnAddMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addMenuController.showAddMenuGUI();
			}
		});
		btnAddMenu.setBounds(390, 225, 136, 23);
		getContentPane().add(btnAddMenu);
		
		btnNewStudent.setIcon(new ImageIcon(getClass().getClassLoader().getResource("addStudent.png")));
		btnEditStudent.setIcon(new ImageIcon(getClass().getClassLoader().getResource("edit.png")));
		btnAddMenu.setIcon(new ImageIcon(getClass().getClassLoader().getResource("manage.png")));

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(getClass().getClassLoader().getResource("homeIcon.png")));
		label.setBounds(227, 52, 136, 135);
		getContentPane().add(label);
		
		setLocationRelativeTo(null);
	}

	private void centerFrame() {

		Dimension windowSize = getSize();
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Point centerPoint = ge.getCenterPoint();

		int dx = centerPoint.x - windowSize.width / 2;
		int dy = centerPoint.y - windowSize.height / 2;

		System.out.println(dx + " " + dy);
		this.setLocation(dx, dy);
	}

}
