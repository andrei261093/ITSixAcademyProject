package itsix.academy.perfect_school.repositories.implementations;

import java.util.ArrayList;
import java.util.List;

import itsix.academy.perfect_school.model.ICourse;
import itsix.academy.perfect_school.model.IRoom;
import itsix.academy.perfect_school.repositories.IRoomsRepository;

public class RoomsRepository implements IRoomsRepository {
	List<IRoom> roomsList = new ArrayList<>();

	public RoomsRepository(List<IRoom> roomsList) {
		super();
		this.roomsList = roomsList;
	}
	
	public RoomsRepository() {
		
	}
	
	@Override
	public List<IRoom> getRoomsList() {
		return roomsList;
	}
	@Override
	public boolean hasThisRoom(IRoom room){
		boolean ok = false;
		for (IRoom currentRoom : roomsList) {
			if (currentRoom.equals(room)) {
				ok = true;
			}
		}
		return ok;
	}
	@Override
	public void addRoom(IRoom room){
		roomsList.add(room);
	}
}
