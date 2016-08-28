package controllers;

import view.IAddMenuGUI;

public interface IAddMenuController {

	void updateAll();

	void setAddMenuGUI(IAddMenuGUI addMenuGUI);

	void showAddMenuGUI();

	void saveTeacher();

}
