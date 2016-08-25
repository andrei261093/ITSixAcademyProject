package app;

import java.awt.EventQueue;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import controllers.ChooseCompetenceController;
import controllers.IChooseCompetenceController;
import repositories.CompetenceRepository;
import repositories.CoursesRepository;
import repositories.ICompetenceRepository;
import repositories.ICoursesRepository;
import view.ChooseCompetenceGUI;
import view.IChooseCompetenceGUI;
import view.ISelectCompetencesGUI;
import view.SelectCompetencesGUI;

public class App {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		
		ICompetenceRepository competenceRepository=new CompetenceRepository();
		ICoursesRepository courseRepository = new CoursesRepository();
		
		IChooseCompetenceController controller = new ChooseCompetenceController(competenceRepository, courseRepository);
		
		IChooseCompetenceGUI competenceGUI = new ChooseCompetenceGUI(controller);
		ISelectCompetencesGUI selectCompetenceGUI = new SelectCompetencesGUI(controller);
		
		controller.setCompetenceGUI(competenceGUI);
		controller.setSelectCompetenceGUI(selectCompetenceGUI);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					competenceGUI.initialize();
					competenceGUI.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
