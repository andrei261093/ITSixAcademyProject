package itsix.academy.perfect_school.repositories;

import java.util.List;

import itsix.academy.perfect_school.model.IRoom;

public interface IRoomsRepository {

	List<IRoom> getRoomsList();

	boolean hasThisRoom(IRoom room);

	void addRoom(IRoom room);

}
