package itsix.academy.perfect_school.randerers;

import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ColoringCellRenderer extends DefaultTableCellRenderer {
	private final Set<Point> highlightedCells = new HashSet<Point>();

	public void setHighlighted(int r, int c, boolean highlighted) {
		if (highlighted) {
			highlightedCells.add(new Point(r, c));
		} else {
			highlightedCells.remove(new Point(r, c));
		}
	}

	public void setHighlighted(int r, int c) {
		highlightedCells.add(new Point(r, c));

	}

	public boolean isHighlighted(int r, int c) {
		return highlightedCells.contains(new Point(r, c));
	}

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {

		Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

		if (((ColoringCellRenderer) c).isHighlighted(row, column)) {
			c.setForeground(Color.BLACK);
			c.setBackground(Color.green);
		} else {
			c.setForeground(Color.BLACK);
			c.setBackground(Color.WHITE);
		}
		return c;

	}

	public Set<Point> getHighlightedCells() {
		return highlightedCells;
	}

}