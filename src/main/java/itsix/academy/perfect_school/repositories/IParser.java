package itsix.academy.perfect_school.repositories;



import java.io.Serializable;

public interface IParser extends Serializable {

	void serialize(IMainRepository billsRepository);

	IMainRepository deserializeRepository();
	
}
