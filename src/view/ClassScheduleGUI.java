package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import controllers.IAddStudentController;
import model.ICourse;
import model.ISubject;
import model.ITeacher;
import randerers.*;
import transformers.HourToIndexTransformer;

import javax.swing.ListSelectionModel;

public class ClassScheduleGUI extends JFrame {
	private IAddStudentController controller;

	private JTable table = new JTable();;
	private JList<ISubject> subjectsList = new JList<ISubject>();
	private JComboBox teachersComboBox = new JComboBox();
	private JLabel lblRoom = new JLabel("test");
	private HourToIndexTransformer indexTransformer = new HourToIndexTransformer();
	private JButton addBtn = new JButton("Add");
	private JButton btnSave = new JButton("Save");
	private JButton btnRemove = new JButton("Remove");
	private ColoringCellRenderer cellRenderer = new ColoringCellRenderer();

	private DefaultTableModel tableModel = new DefaultTableModel(
			new Object[][] { { null, null, null, null, null }, { null, null, null, null, null },
					{ null, null, null, null, null }, { null, null, null, null, null },
					{ null, null, null, null, null }, { null, null, null, null, null }, },
			new String[] { "Luni", "Marti", "Miercuri", "Joi", "Vineri" });

	// constructor
	public ClassScheduleGUI(IAddStudentController controller) {
		this.controller = controller;
		initialize();
	}

	public void initialize() {

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 905, 415);

		getContentPane().setLayout(null);

		JLabel lblSubject = new JLabel("Subjects:");
		lblSubject.setBounds(10, 37, 70, 14);
		getContentPane().add(lblSubject);

		JLabel lblTeacher = new JLabel("Teacher:");
		lblTeacher.setBounds(10, 290, 57, 14);
		getContentPane().add(lblTeacher);

		JLabel lblRoomLbl = new JLabel("Room:");
		lblRoomLbl.setBounds(351, 328, 57, 14);
		getContentPane().add(lblRoomLbl);

		lblRoom.setBounds(413, 328, 100, 14);
		getContentPane().add(lblRoom);

		subjectsList.setBounds(71, 36, 182, 240);
		getContentPane().add(subjectsList);
		subjectsList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				if (evt.getClickCount() == 1) {
					resetTableHighlight();
					controller.displayTeachers();
					if (teachersComboBox.getItemAt(0) != null) {
						teachersComboBox.setSelectedIndex(0);
					}

				}
			}
		});

		teachersComboBox.setBounds(71, 287, 182, 20);
		getContentPane().add(teachersComboBox);
		teachersComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.highlightTable();
			}
		});

		addBtn.setBounds(679, 324, 89, 23);
		getContentPane().add(addBtn);
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.addCourseToTable();
			}
		});

		table.setRowSelectionAllowed(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(tableModel);
		table.setDefaultRenderer(Object.class, cellRenderer);

		table.setBounds(343, 37, 524, 270);
		table.setRowHeight(0, 45);
		table.setRowHeight(1, 45);
		table.setRowHeight(2, 45);
		table.setRowHeight(3, 45);
		table.setRowHeight(4, 45);
		table.setRowHeight(5, 45);
		getContentPane().add(table);

		JLabel label = new JLabel("08:00-10:00");
		label.setBounds(263, 53, 70, 14);
		getContentPane().add(label);

		JLabel label_1 = new JLabel("10:00-12:00");
		label_1.setBounds(263, 93, 70, 14);
		getContentPane().add(label_1);

		JLabel label_2 = new JLabel("12:00-14:00");
		label_2.setBounds(263, 135, 70, 14);
		getContentPane().add(label_2);

		JLabel label_3 = new JLabel("14:00-16:00");
		label_3.setBounds(263, 182, 70, 14);
		getContentPane().add(label_3);

		JLabel label_4 = new JLabel("16:00-18:00");
		label_4.setBounds(263, 229, 70, 14);
		getContentPane().add(label_4);

		JLabel label_5 = new JLabel("18:00-20:00");
		label_5.setBounds(263, 273, 70, 14);
		getContentPane().add(label_5);

		JLabel lblLuni = new JLabel("Luni");
		lblLuni.setBounds(375, 12, 46, 14);
		getContentPane().add(lblLuni);

		JLabel lblMarti = new JLabel("Marti");
		lblMarti.setBounds(484, 12, 46, 14);
		getContentPane().add(lblMarti);

		JLabel lblMiercuri = new JLabel("Miercuri");
		lblMiercuri.setBounds(587, 12, 57, 14);
		getContentPane().add(lblMiercuri);

		JLabel lblJoi = new JLabel("Joi");
		lblJoi.setBounds(699, 12, 46, 14);
		getContentPane().add(lblJoi);

		JLabel lblVineri = new JLabel("Vineri");
		lblVineri.setBounds(797, 12, 46, 14);
		getContentPane().add(lblVineri);

		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.removeSelectedTableCourseFromStudentsCourses();
				controller.removeCourseFromTable();

			}
		});
		btnRemove.setBounds(580, 324, 89, 23);
		getContentPane().add(btnRemove);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.saveStage();
			}
		});

		btnSave.setBounds(778, 324, 89, 23);
		getContentPane().add(btnSave);
	}
	
	public void clearTeachersComboBox(){
		teachersComboBox.removeAllItems();
	}

	public void updateListModel(Set<ISubject> listElements) {
		DefaultListModel<ISubject> listModel = new DefaultListModel<ISubject>();

		for (ISubject subject : listElements) {
			listModel.addElement(subject);
		}

		subjectsList.setModel(listModel);
	}

	public ISubject getSelectedSubject() {
		return (ISubject) subjectsList.getSelectedValue();
	}

	public void updateTeachersCB(List<ITeacher> teachersList) {
		teachersComboBox.setModel(new DefaultComboBoxModel(teachersList.toArray()));

	}

	public ITeacher getSelectedComboBoxTeacher() {
		return (ITeacher) teachersComboBox.getSelectedItem();
	}

	public void addCourseToTable(ICourse course) {
		tableModel.setValueAt(course, indexTransformer.hourToIndex(course), indexTransformer.dayToIndex(course));
	}

	public void setRoomLbl(String room) {
		lblRoom.setText(room);

	}

	public ICourse getSelectedTableItem() {
		// System.out.println(table.getSelectedRow() + " " +
		// table.getSelectedColumn());
		return (ICourse) table.getValueAt(table.getSelectedRow(), table.getSelectedColumn());
	}

	public Point getSelectedTableCellIndex() {
		Point point = new Point(table.getSelectedRow(), table.getSelectedColumn());
		return point;
	}

	public void highlightTable(List<ICourse> courses) {
		resetTableHighlight();

		for (ICourse course : courses) {
			cellRenderer.setHighlighted(indexTransformer.hourToIndex(course), indexTransformer.dayToIndex(course));
		}

		table.repaint();
	}

	public boolean isHighlighted(int x, int y) {
		return cellRenderer.isHighlighted(x, y);
	}

	public void resetTableHighlight() {
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				if (!cellRenderer.isHighlighted(i, j)) {
					cellRenderer.setHighlighted(i, j, true);
				}
			}
		}

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				cellRenderer.setHighlighted(i, j, false);
			}
		}
		table.repaint();
	}

	public void emptyTableCell(int row, int column) {
		table.setValueAt(null, row, column);
	}

	public List<ICourse> getAllElementsFromTable() {
		List<ICourse> lista = new ArrayList<>();
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 5; j++) {
				if (table.getValueAt(i, j) != null) {
					lista.add((ICourse) table.getValueAt(i, j));
				}
			}
		}
		return lista;
	}

	public void populateTable(List<ICourse> courses) {
		if (!courses.isEmpty()) {
			for (ICourse course : courses) {
				tableModel.setValueAt(course, indexTransformer.hourToIndex(course),
						indexTransformer.dayToIndex(course));
				System.out.println(course);
			}
		}
	}

	public void clearTableOfItems() {
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 5; j++) {
				table.setValueAt(null, i, j);
			}
		}
	}

}
