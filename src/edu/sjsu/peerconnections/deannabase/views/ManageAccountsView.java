package edu.sjsu.peerconnections.deannabase.views;

import edu.sjsu.peerconnections.deannabase.Main;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;

/**
 * Manage accouns view is a page to manage accounts after the main menu
 * 
 * @author David Luong, Yvonne Hoang, Carl Shefcik, Hung Tang
 * @version 1.0
 */
public class ManageAccountsView extends View{
	private Labeled logoLabel;
	private final int WIDTH = 800;
	private final int HEIGHT = 480;
	private final int BUTTON_SPACING = 15;
	
	public ManageAccountsView() {
		GridPane pane = new GridPane();
		pane.setId("gridpane-1");
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
		Image logo = new Image(Main.logoPath);
		logoLabel = new Label("", new ImageView(logo));
		
		//To add a node to the GridPane, use one of pane's add() methods:
		//In this case, we use add(Node child, column, row, columnspan, rowspan)
		//The two spans define how many columns or rows the child fills.
		pane.add(logoLabel, 1, 1, 3, 3);
		
		//set action of the menu button to close the stage and open MenuView
		ViewAccessors.getMenuButton().setOnAction(e -> {
			View.newView(new MenuView());
			closeView();
		});
		
		/*
		 * Use VBox to arrange the buttons with custom spacing inside GridPane:
		 * custom spacing is declared as an instance variable BUTTON_SPACING.
		 * 
		 * Buttons are arranged in the center column (2); if more buttons are added,
		 * create another wrapper GridPane with 2 columns of buttons, spanning 
		 * 3 columns of the outer pane. 
		 */ 
		VBox buttonWrapperBox = new VBox(BUTTON_SPACING);
		buttonWrapperBox.getChildren().add(ViewAccessors.getMenuButton());
		pane.add(buttonWrapperBox, 2, 5, 1, 4);
		
		//getChildren() gets a list of the objects this pane contains (visually)
		//Because the GridPane object pane contains all our desired nodes, we add
		//only pane to the children.
		this.getChildren().add(pane);
		
		
	}
	
}
