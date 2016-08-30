package repositories.implementations;

import java.util.ArrayList;
import java.util.List;

import model.IStudent;
import repositories.IStudentRepository;

public class StudentRepository implements IStudentRepository {
	List<IStudent> studentsList = new ArrayList<>();

	@Override
	public void addStudent(IStudent newStudent) {
		studentsList.add(newStudent);
	}

	@Override
	public boolean hasThisStudent(String ssn) {
		
		for (IStudent current : studentsList) {
			if (current.hasThisSSN(ssn)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public IStudent getStudentBySSN(String ssn) {
		for (IStudent current : studentsList) {
			if (current.hasThisSSN(ssn)) {
				return current;
			}
		}
		return null;
	}

	@Override
	public void updateStudent(String ssn, IStudent student) {
		for (IStudent current : studentsList) {
			if (current.hasThisSSN(ssn)) {
				System.out.println("gasit");
				current = student;
			}
		}
	}

}
