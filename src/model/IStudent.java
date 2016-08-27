package model;

import java.util.List;

public interface IStudent {

	void setStages(List<IStage> stageList);

	List<IStage> getStages();

}
