package transformers;

import java.awt.Point;


import model.ICourse;

public class HourToIndexTransformer {
	
	public int hourToIndex(ICourse relation) {
		String hour= relation.getHour();
		
		int index = 0;
	
		switch (hour) {
		case "80:00":
			index =0;
			break;
		case "10:00":
			index = 1;
			break;
		case "12:00":
			index = 2;
			break;
		case "14:00":
			index = 3;
			break;
		case "16:00":
			index = 4;
			break;
		case "18:00":
			index = 5;
			break;
		}

		return index;
	}
	
	public int dayToIndex(ICourse relation) {
		String day= relation.getDay();
		
		int index = 0;
	
		switch (day) {
		case "Luni":
			index =0;
			break;
		case "Marti":
			index = 1;
			break;
		case "Miercuri":
			index = 2;
			break;
		case "Joi":
			index = 3;
			break;
		case "Vineri":
			index = 4;
			break;
		}
		return index;
	}
	
	public Point getCoursePoint(ICourse relation){
		return new Point(hourToIndex(relation),dayToIndex(relation));
	}
}
