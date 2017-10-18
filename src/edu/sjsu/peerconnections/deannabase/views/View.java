package edu.sjsu.peerconnections.deannabase.views;

import edu.sjsu.peerconnections.deannabase.Main;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Abstract class representing all views in the program
 * 
 * @author David Luong, Yvonne Hoang, Carl Shefcik, Hung Tang
 * @version 1.0
 */
public abstract class View extends Pane {
	
	//stage that holds the View
	private Stage stage;
	
	/**
	 * Stage setter
	 * @param stage
	 */
	public void setStage(Stage stage) {
		this.stage = stage;
	}
	
	/**
	 * Stage getter
	 * @return stage
	 */
	public Stage getStage() {
		return stage;
	}
	
	/**
	 * Stylesheet setter - adds a stylesheet to the scene
	 * Does NOT remove old stylesheets
	 * @param path
	 */
	public void setStylesheet(String path) {
		stage.getScene().getStylesheets().add(path);
	}
	
	/**
	 * Title setter for the stage
	 * @param title
	 */
	public void setTitle(String title) {
		stage.setTitle(title);
	}
	
	/**
	 * Icon setter for the stage
	 * @param path
	 */
	public void setIcon(String path) {
		stage.getIcons().add(new Image(Main.iconPath));
	}
	
	/**
	 * Requests focus for a specified Node
	 * @param n
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
	 * Adds default stylesheet, title, icon to the stage
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
		s.show();
		return view;
	}
}
