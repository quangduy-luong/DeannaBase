package edu.sjsu.peerconnections.deannabase;

import edu.sjsu.peerconnections.deannabase.views.IntroView;
import edu.sjsu.peerconnections.deannabase.views.View;
import edu.sjsu.peerconnections.deannabase.views.ViewAccessors;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Main is a class with the sole purpose of launching the application. All
 * Stages, Scenes, Panes, etc. should be reachable through the initial window
 * that Main launches.
 * 
 * @author David Luong, Yvonne Hoang, Carl Shefcik, Hung Tang
 * @version 1.0
 *
 */
public class Main extends Application {
	
	//instance variables
	public static String stylesheetPath = "./resources/stylesheet.css";
	public static String title = "Peer Connections Database";
	public static String iconPath = "./resources/icon.png";
	public static String logoPath = "./resources/logo.png";

	/**
	 * Launches the application.
	 * @param args
	 */
	public static void main(String[] args) {
		launch();
	}

	/**
	 * Start the application by setting up the login view.
	 */
	@Override
	public void start(Stage primaryStage) {
		//initializes all buttons
		ViewAccessors.initializeButtons();
		//creates a new View object via factory method (newView())
		View introView = View.newView(new IntroView());
		//disables User's ability to resize window of login screen
		introView.getStage().setResizable(false);
	}
}
