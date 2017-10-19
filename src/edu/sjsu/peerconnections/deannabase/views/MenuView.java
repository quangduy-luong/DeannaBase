package edu.sjsu.peerconnections.deannabase.views;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

/**
 * MenuView is a view of the main menu that is shown right after the user logs in
 * 
 * @author David Luong, Yvonne Hoang, Carl Shefcik, Hung Tang
 * @version 1.0
 */
public class MenuView extends View {
	//buttons to be presented at the middle of the menu page
	private Labeled logoLabel;
	private final int WIDTH = 800;
	private final int HEIGHT = 480;
	
	public MenuView() {
		GridPane pane = new GridPane();
		ViewAccessors buttons  = new ViewAccessors();
		int rows = 12;
		int columns = 5;
		
		//for loops create the number of columns and rows previously specified.
		for (int i = 0; i < columns; i++) {
			//ColumnConstraints - literally, a column object/node for GridPane to use
			ColumnConstraints colConst = new ColumnConstraints();
			//all columns are same size (divided equally across the pane)
			colConst.setPercentWidth(100.0 / columns);
			//getColumnConstraints() gets the GridPane object's list of ColumnConstraints, 
			//to which we add a new column node/child to.
			pane.getColumnConstraints().add(colConst);
		}
		for (int i = 0; i < rows; i++) {
			//RowConstraints - literally, a row object/node for GridPane to use
			RowConstraints rowConst = new RowConstraints();
			//all rows are same size (divided equally across the pane)
			rowConst.setPercentHeight(100.0 / rows);
			pane.getRowConstraints().add(rowConst);         
		}
		/*
		 * Scenes wrap around the panes they contain, so panes must define their
		 * preferred size, defined previously as instance variables.
		 */
		pane.setPrefSize(WIDTH, HEIGHT);
		/*
		 * Image objects require file paths. To wrap in a Label object,
		 * the Image needs to be wrapped in an ImageView object as the Graphic
		 * of the Label.
		 */
		Image logo = new Image("./resources/logo.png");
		logoLabel = new Label("", new ImageView(logo));
		
		//To add a node to the GridPane, use one of pane's add() methods:
		//In this case, we use add(Node child, column, row, columnspan, rowspan)
		//The two spans define how many columns or rows the child fills.
		pane.add(logoLabel, 1, 1, 3, 3);
		pane.add(buttons.getImportButton(), 2, 4, 1, 1);
		pane.add(buttons.getGRButton(), 2, 6, 1, 1);
		pane.add(buttons.getADButton(), 2, 8, 1, 1);
		pane.add(buttons.getMAButton(), 2, 10, 1, 1);
		
		//getChildren() gets a list of the objects this pane contains (visually)
		//Because the GridPane object pane contains all our desired nodes, we add
		//only pane to the children.
		this.getChildren().add(pane);
		
	}

}
