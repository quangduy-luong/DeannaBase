package edu.sjsu.peerconnections.deannabase;

import edu.sjsu.peerconnections.deannabase.views.IntroView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main is a class with the sole purpose of launching the application. All
 * Stages, Scenes, Panes, etc. should be reachable through the initial window
 * that Main launches.
 * 
 * @author David Luong
 * @version 1.0
 *
 */
public class Main extends Application {

	/**
	 * Launches the application.
	 * @param args
	 */
	public static void main(String[] args) {
		launch();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		/*
		 * setScene() must be called to add a Scene to the Stage and display it.
		 * 
		 * Scenes contain Panes, which store the objects that are to be displayed;
		 * in this case, IntroView class is a Pane through which User sees and
		 * inputs their log in information.
		 */
		primaryStage.setScene(new Scene(new IntroView()));
		//show() must be called to display the Stage to User.
		primaryStage.show();
	}
}
