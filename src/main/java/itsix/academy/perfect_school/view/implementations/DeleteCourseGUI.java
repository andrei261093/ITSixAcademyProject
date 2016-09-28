package itsix.academy.perfect_school.view.implementations;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;

import itsix.academy.perfect_school.controllers.IDeleteCourseController;
import itsix.academy.perfect_school.model.ICourse;
import itsix.academy.perfect_school.view.IDeleteCoursesGUI;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;

public class DeleteCourseGUI extends JFrame implements IDeleteCoursesGUI {
	private JTable table;
	private JButton btnDelete;
	private CoursesJTableModel model;

	private IDeleteCourseController controller;

	public DeleteCourseGUI(IDeleteCourseController controller) {
		model = new CoursesJTableModel();
		this.controller = controller;
		initialize();
	}

	private void initialize() {
		setTitle("Delete Competences Menu");
		setBounds(100, 100, 490, 401);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 454, 304);
		getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setAutoCreateRowSorter(true);

		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(isTableSelected()){
					controller.delete();
				}
			}
		});
		btnDelete.setBounds(375, 326, 89, 23);
		getContentPane().add(btnDelete);

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
	public void updateTable(List<ICourse> courses) {
		table.setModel(model.createModel(courses));
	}

	@Override
	public ICourse getSelectedCourse() {
		return (ICourse) table.getModel().getValueAt(table.getSelectedRow(), 0);
	}
	
	public boolean isTableSelected(){
		if(table.getSelectedRow() == -1){
			return false;
		}
		return true;
	}
}
