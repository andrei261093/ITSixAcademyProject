package itsix.academy.perfect_school.repositories;

import java.io.Serializable;
import java.util.List;

import itsix.academy.perfect_school.model.IRoom;

public interface IRoomsRepository extends Serializable{

	List<IRoom> getRoomsList();

	boolean hasThisRoom(IRoom room);

	void addRoom(IRoom room);

	void delete(IRoom room);

}
