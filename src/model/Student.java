package model;

import java.util.ArrayList;
import java.util.List;

public class Student implements IStudent {
	List<IStage> stageList = new ArrayList<>();
	String name;
	String ssn;

	public Student(String name, String SSN) {
		super();
		this.name = name;
		this.ssn = SSN;
	}

	public Student(String name, String SSN, List<IStage> stageList) {
		super();
		this.name = name;
		this.ssn = SSN;
		this.stageList = stageList;
	}

	@Override
	public void setStages(List<IStage> stageList) {
		this.stageList = stageList;
	}

	@Override
	public List<IStage> getStages() {
		return stageList;
	}

}
