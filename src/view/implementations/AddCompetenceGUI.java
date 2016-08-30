package view.implementations;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.SwingConstants;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;
import controllers.IAddStudentController;
import model.IStage;
import model.IStudent;
import model.ISubject;
import view.IAddCompetenceGUI;
import view.JCheckBoxTree;
import model.IPackage;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;


public class AddCompetenceGUI extends JFrame implements IAddCompetenceGUI {

	IAddStudentController controller;
	private JButton btnAddCompetences = new JButton("Add Competences");
	private JButton btnAddSelected = new JButton("Save Selected");
	private JButton btnCreateSchedule = new JButton("Schedule");
	private JButton btnSaveStudent = new JButton("Save Student");

	private JComboBox comboBox = new JComboBox();

	private JCheckBoxTree tree = new JCheckBoxTree();

	private JList subjectPerStageList = new JList();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JScrollPane scrollPane_1 = new JScrollPane();

	// Constructor
	public AddCompetenceGUI(IAddStudentController controller) {
		this.controller = controller;
		initialize();
	}

	public void initialize() {
		setTitle("Add Courses");
		setBounds(100, 100, 890, 427);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		btnAddCompetences.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.showSelectCompetenceGUI();
			}
		});

		btnAddCompetences.setBounds(278, 70, 125, 23);
		getContentPane().add(btnAddCompetences);
		scrollPane.setBounds(21, 72, 236, 295);

		TreeModel tm = new DefaultTreeModel(null);
		tree.setModel(tm);

		getContentPane().add(scrollPane);
		scrollPane.setColumnHeaderView(tree);

		btnAddSelected.setBounds(278, 104, 125, 23);
		getContentPane().add(btnAddSelected);

		comboBox.setBounds(460, 73, 125, 20);
		getContentPane().add(comboBox);
		scrollPane_1.setBounds(599, 72, 236, 295);

		getContentPane().add(scrollPane_1);
		scrollPane_1.setViewportView(subjectPerStageList);

		JSeparator separator = new JSeparator();
		separator.setBounds(21, 23, 814, 20);
		getContentPane().add(separator);

		JSeparator separator_1 = new JSeparator(SwingConstants.VERTICAL);
		separator_1.setBounds(429, 72, 10, 251);
		getContentPane().add(separator_1);

		btnCreateSchedule.setBounds(460, 104, 125, 23);
		getContentPane().add(btnCreateSchedule);
		btnSaveStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.addStudent();
			}
		});

		btnSaveStudent.setBounds(710, 38, 125, 23);
		getContentPane().add(btnSaveStudent);

		// Buttons Action Listeners
		btnAddSelected.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.makeStages();
			}
		});
		btnCreateSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.showScheduleGUI();
			}
		});
		
		//Combobox Action Listeners
		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.populateList();
			}
		});
		
		buttonsSetEnabled(false);
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
	public IStage getSelectedComboBoxStage(){
		return (IStage) comboBox.getSelectedItem();
	}

	@Override
	public void populateStagesComboBox(List<IStage> stageList) {
		comboBox.setModel(new DefaultComboBoxModel(stageList.toArray()));
		comboBox.setSelectedIndex(0);
	}
	
	@Override
	public void populateSubjectsPerStageList(List<ISubject> subjectList){
		DefaultListModel<ISubject> model = new DefaultListModel<>();
		for (ISubject subject : subjectList) {
			model.addElement(subject);
		}
		subjectPerStageList.setModel(model);
	}
	@Override
	public void buttonsSetEnabled(boolean b){
		btnCreateSchedule.setEnabled(b);
		btnSaveStudent.setEnabled(b);
	}
	
}
