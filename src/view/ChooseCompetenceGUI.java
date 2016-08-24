package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import controllers.IChooseCompetenceController;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;

public class ChooseCompetenceGUI extends JFrame implements IChooseCompetenceGUI{
	
	IChooseCompetenceController controller;
	
	//Visual Elements Declare
	private JTextField textField;
	
	private JButton btnNewButton_1 = new JButton("Add Optionals");
	private JButton btnChooseCompetence = new JButton("Add Skills");
	private JButton btnAddSelected = new JButton("Save Selected");
	private JButton btnNewButton = new JButton("Create Schedule");
	private JButton btnSaveStudent = new JButton("Save Student");
	private JButton btnReset = new JButton("Reset!");

	private JComboBox comboBox = new JComboBox();
	
	private JCheckBoxTree tree = new JCheckBoxTree();
	
	private JList list = new JList();
	
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					ChooseCompetenceGUI window = new ChooseCompetenceGUI();
//					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ChooseCompetenceGUI(IChooseCompetenceController controller) {
		this.controller = controller;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		setTitle("Choose Courses");
		setBounds(100, 100, 890, 427);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblStudentSsn = new JLabel("Student SSN:");
		lblStudentSsn.setBounds(32, 26, 90, 14);
		getContentPane().add(lblStudentSsn);
		
		textField = new JTextField();
		textField.setBounds(111, 23, 136, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		btnChooseCompetence.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.showSelectCompetenceGUI();
			}
		});
		
		
		btnChooseCompetence.setBounds(278, 22, 125, 23);
		getContentPane().add(btnChooseCompetence);
		
		
		tree.setBounds(21, 72, 236, 295);
		getContentPane().add(tree);
		
		
		btnAddSelected.setBounds(278, 104, 125, 23);
		getContentPane().add(btnAddSelected);
		
		
		comboBox.setBounds(460, 73, 125, 20);
		getContentPane().add(comboBox);
		
		
		list.setBounds(599, 72, 236, 295);
		getContentPane().add(list);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(21, 51, 814, 20);
		getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator(SwingConstants.VERTICAL);
		separator_1.setBounds(429, 72, 10, 251);
		getContentPane().add(separator_1);
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(460, 104, 125, 23);
		getContentPane().add(btnNewButton);
		
		
		btnSaveStudent.setBounds(460, 22, 125, 23);
		getContentPane().add(btnSaveStudent);
		
		
		btnReset.setBounds(650, 22, 125, 23);
		getContentPane().add(btnReset);
		
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(278, 72, 125, 23);
		getContentPane().add(btnNewButton_1);
	}
}
