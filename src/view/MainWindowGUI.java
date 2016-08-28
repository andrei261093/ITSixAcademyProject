package view;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import controllers.IAddMenuController;
import controllers.IAddStudentController;

import javax.swing.ImageIcon;

public class MainWindowGUI extends JFrame implements IMainWindowGUI {
	JButton btnNewStudent = new JButton("New Student");
	JButton btnEditStudent = new JButton("Edit Student");
	JButton btnAddMenu = new JButton("Add Menu");

	IAddStudentController addStudentController;
	IAddMenuController addMenuController;

	public MainWindowGUI(IAddStudentController addStudentController, IAddMenuController addMenuController) {
		this.addStudentController = addStudentController;
		this.addMenuController = addMenuController;
		
		initialize();
		
	}

	@Override
	public void initialize() {
		setResizable(false);
		setBounds(100, 100, 608, 334);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		getContentPane().setLayout(null);
		btnNewStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addStudentController.showAddStudentGUI();
				setVisible(false);
			}
		});

		btnNewStudent.setBounds(71, 225, 136, 23);
		getContentPane().add(btnNewStudent);

		btnEditStudent.setBounds(227, 225, 136, 23);
		getContentPane().add(btnEditStudent);

		btnAddMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addMenuController.showAddMenuGUI();
			}
		});
		btnAddMenu.setBounds(390, 225, 136, 23);
		getContentPane().add(btnAddMenu);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\andre\\Downloads\\Student-3-icon.png"));
		label.setBounds(227, 52, 146, 135);
		getContentPane().add(label);

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
