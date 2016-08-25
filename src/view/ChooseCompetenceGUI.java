package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;

import controllers.IChooseCompetenceController;
import model.IStage;
import model.ISubject;
import model.IPackage;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class ChooseCompetenceGUI extends JFrame implements IChooseCompetenceGUI {

	IChooseCompetenceController controller;

	// Visual Elements Declare
	private JTextField textField;

	private JButton btnAddOptionals = new JButton("Add Optionals");
	private JButton btnAddCompetences = new JButton("Add Competences");
	private JButton btnAddSelected = new JButton("Save Selected");
	private JButton btnCreateSchedule = new JButton("Create Schedule");
	private JButton btnSaveStudent = new JButton("Save Student");
	private JButton btnReset = new JButton("Reset!");

	private JComboBox comboBox = new JComboBox();

	private JCheckBoxTree tree = new JCheckBoxTree();

	private JList list = new JList();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JScrollPane scrollPane_1 = new JScrollPane();

	// Constructor
	public ChooseCompetenceGUI(IChooseCompetenceController controller) {
		this.controller = controller;
		initialize();
	}

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
		btnAddCompetences.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.showSelectCompetenceGUI();
			}
		});

		btnAddCompetences.setBounds(278, 22, 125, 23);
		getContentPane().add(btnAddCompetences);
		scrollPane.setBounds(21, 72, 236, 295);

		TreeModel tm = new DefaultTreeModel(null);
		tree.setModel(tm);

		getContentPane().add(scrollPane);
		scrollPane.setViewportView(tree);

		btnAddSelected.setBounds(278, 104, 125, 23);
		getContentPane().add(btnAddSelected);

		comboBox.setBounds(460, 73, 125, 20);
		getContentPane().add(comboBox);
		scrollPane_1.setBounds(599, 72, 236, 295);

		getContentPane().add(scrollPane_1);
		scrollPane_1.setViewportView(list);

		JSeparator separator = new JSeparator();
		separator.setBounds(21, 51, 814, 20);
		getContentPane().add(separator);

		JSeparator separator_1 = new JSeparator(SwingConstants.VERTICAL);
		separator_1.setBounds(429, 72, 10, 251);
		getContentPane().add(separator_1);

		btnCreateSchedule.setBounds(460, 104, 125, 23);
		getContentPane().add(btnCreateSchedule);

		btnSaveStudent.setBounds(460, 22, 125, 23);
		getContentPane().add(btnSaveStudent);

		btnReset.setBounds(650, 22, 125, 23);
		getContentPane().add(btnReset);

		btnAddOptionals.setBounds(278, 72, 125, 23);
		getContentPane().add(btnAddOptionals);

		// Buttons Action Listeners
		btnAddSelected.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.makeStages();
				controller.dispalyStages();
			}
		});
		btnCreateSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.showScheduleGUI();
			}
		});
		btnAddOptionals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		
		//Combobox Action Listeners
		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.populateList();
			}
		});
	}

	@Override
	public void populateTree(TreeModel model) {
		tree.setModel(model);
		((DefaultTreeModel) tree.getModel()).nodeStructureChanged((TreeNode) (model.getRoot()));
	}

	// Returns
	@Override
	public List<IPackage> getSelectedTreePackages() {
		List<IPackage> returnList = new ArrayList<>();
		returnList.addAll(tree.getSelectedItems());
		return returnList;
	}
	
	@Override
	public IStage getSelectedListSubject(){
		return (IStage) comboBox.getSelectedItem();
	}

	@Override
	public void populateComboBox(List<IStage> stageList) {
		comboBox.setModel(new DefaultComboBoxModel(stageList.toArray()));
		comboBox.setSelectedIndex(0);
	}
	
	@Override
	public void populateList(List<ISubject> subjectList){
		DefaultListModel<ISubject> model = new DefaultListModel<>();
		for (ISubject subject : subjectList) {
			model.addElement(subject);
		}
		list.setModel(model);
	}
	
}
