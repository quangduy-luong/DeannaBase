package edu.sjsu.peerconnections.deannabase;

import edu.sjsu.peerconnections.deannabase.views.IntroView;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.image.Image;
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
	
	protected String stylesheet = "./resources/stylesheet.css";

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
		IntroView introView = new IntroView();
		Scene scene = new Scene(introView);
		introView.setScene(scene);
		/*
		 * To add CSS to style the scenes:
		 * getStylesheets() gets the list of stylesheets, and add() adds a particular
		 * (named) stylesheet to the list
		 */
		scene.getStylesheets().add(stylesheet);
		//show() must be called to display the Stage to User.
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.setTitle("Peer Connections Database");
		primaryStage.getIcons().add(new Image("./resources/icon.png"));
		primaryStage.show();
		//changes the focus of the intro screen so that no textfields are automatically
		//selected (user must click on Username box)
		Platform.runLater( () -> {
			((IntroView)primaryStage.getScene().getRoot()).initFocus();
		});
	}
}
