package edu.sjsu.peerconnections.deannabase.views;

import edu.sjsu.peerconnections.deannabase.Main;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * View is an abstract Pane that represents all views in the program.
 * 
 * @author David Luong, Yvonne Hoang, Carl Shefcik, Hung Tang
 * @version 1.0
 */
public abstract class View extends Pane {
	
	//stage that holds the View
	private Stage stage;
	
	/**
	 * Sets the Stage.
	 * @param stage
	 */
	public void setStage(Stage stage) {
		this.stage = stage;
	}
	
	/**
	 * Gets the Stage.
	 * @return stage
	 */
	public Stage getStage() {
		return stage;
	}
	
	/**
	 * Sets and adds a stylesheet to the scene.
	 * Does NOT remove old stylesheets.
	 * @param path file path to the stylesheet
	 */
	public void setStylesheet(String path) {
		stage.getScene().getStylesheets().add(path);
	}
	
	/**
	 * Sets the title for the stage.
	 * @param title
	 */
	public void setTitle(String title) {
		stage.setTitle(title);
	}
	
	/**
	 * Sets the icon for the stage.
	 * @param path file path to the icon
	 */
	public void setIcon(String path) {
		stage.getIcons().add(new Image(Main.iconPath));
	}
	
	/**
	 * Requests focus for a specified Node.
	 * If not set, Textfields are autofocused.
	 * @param n Node to be focused
	 */
	public void initFocus(Node n) {
		n.requestFocus();
	}

	/**
	 * Closes the view
	 */
	public void closeView() {
		stage.close();
	}
	
	/**
	 * Creates a specified View
	 * Adds default stylesheet, title, and icon to the Stage.
	 * @param view
	 * @return created view
	 */
	public static View newView(View view) {
		Stage s = new Stage();
		s.setScene(new Scene(view));
		view.setStage(s);
		view.setStylesheet(Main.stylesheetPath);
		view.setTitle(Main.title);
		view.setIcon(Main.iconPath);
		s.setMinHeight(480);
		s.setMinWidth(800);
		s.show();
		return view;
	}
}
