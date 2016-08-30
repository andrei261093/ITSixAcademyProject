package itsix.academy.perfect_school.view;



import java.awt.Point;
import java.util.List;

import itsix.academy.perfect_school.model.ICourse;
import itsix.academy.perfect_school.model.ISubject;
import itsix.academy.perfect_school.model.ITeacher;

public interface IScheduleGUI {

	void clearTeachersComboBox();

	void updateListModel(List<ISubject> listElements);

	ISubject getSelectedSubject();

	void updateTeachersCB(List<ITeacher> teachersList);

	ITeacher getSelectedComboBoxTeacher();

	void addCourseToTable(ICourse course);

	void setRoomLbl(String room);

	ICourse getSelectedTableItem();

	Point getSelectedTableCellIndex();

	void highlightTable(List<ICourse> courses);

	boolean isHighlighted(int x, int y);

	void resetTableHighlight();

	void emptyTableCell(int row, int column);

	List<ICourse> getAllElementsFromTable();

	void populateTable(List<ICourse> courses);

	void clearTableOfItems();

	void setVisible(boolean b);

	
}
