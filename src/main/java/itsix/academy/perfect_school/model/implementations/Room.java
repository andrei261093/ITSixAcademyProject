package itsix.academy.perfect_school.model.implementations;

import itsix.academy.perfect_school.model.IRoom;

public class Room implements IRoom {
	String roomName;

	public Room(String roomName) {
		super();
		this.roomName = roomName;
	}
	@Override
	public String getRoomName() {
		return roomName;
	}
	@Override
	public String toString() {
		return roomName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((roomName == null) ? 0 : roomName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Room other = (Room) obj;
		if (roomName == null) {
			if (other.roomName != null)
				return false;
		} else if (!roomName.equals(other.roomName))
			return false;
		return true;
	}
	
	
	
	
}
