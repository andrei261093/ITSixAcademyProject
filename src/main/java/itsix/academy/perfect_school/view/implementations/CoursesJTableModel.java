package itsix.academy.perfect_school.view.implementations;

import java.util.List;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import itsix.academy.perfect_school.model.ICourse;

public class CoursesJTableModel {
	private DefaultTableModel model;

	public DefaultTableModel createModel(List<ICourse> courses) {
		 model = new DefaultTableModel();

		String[] columnNames = { "Subject", "Teacher", "Day", "Hour", "Room" };
		model.setColumnIdentifiers(columnNames);
	
	
		
		for (ICourse course : courses) {
			Object[] o = new Object[6];
			o[0] = course;
			o[1] = course.getTeacher();
			o[2] = course.getDay();
			o[3] = course.getHour();
			o[4] = course.getRoom();
			
			model.addRow(o);
		}

		return model;
	}
	

}
