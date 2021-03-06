package edu.sjsu.peerconnections.deannabase.views;

import edu.sjsu.peerconnections.deannabase.Main;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
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
	
	//variable gridpane
	protected GridPane grid;
	
	/**
	 * Generates a new view with specified rows and columns
	 * @param rows
	 * @param columns
	 */
	public View(int rows, int columns) {
		grid = new GridPane();
		grid.setId("gridpane-1");
		//Set to true for debugging; setGridLinesVisible is default false.
		//Remove line for finished product.
//		grid.setGridLinesVisible(true);
		//for loops create the number of columns and rows previously specified.
		for (int i = 0; i < columns; i++) {
			//ColumnConstraints - literally, a column object/node for GridPane to use
			ColumnConstraints colConst = new ColumnConstraints();
			//all columns are same size (divided equally across the pane)
			colConst.setPercentWidth(100.0 / columns);
			//getColumnConstraints() gets the GridPane object's list of ColumnConstraints, 
			//to which we add a new column node/child to.
			grid.getColumnConstraints().add(colConst);
		}
		for (int i = 0; i < rows; i++) {
			//RowConstraints - literally, a row object/node for GridPane to use
			RowConstraints rowConst = new RowConstraints();
			//all rows are same size (divided equally across the pane)
			rowConst.setPercentHeight(100.0 / rows);
			grid.getRowConstraints().add(rowConst);         
		}
		this.getChildren().add(grid);
		
		grid.prefHeightProperty().bind(this.heightProperty());
		grid.prefWidthProperty().bind(this.widthProperty());
	}
	
	/**
	 * Adds a child node to the grid at specified position and span
	 * @param node
	 * @param col
	 * @param row
	 * @param colSpan
	 * @param rowSpan
	 */
	public void add(Node node, int col, int row, int colSpan, int rowSpan) {
		grid.add(node, col, row, colSpan, rowSpan);
	}
	
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
