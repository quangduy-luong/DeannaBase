package edu.sjsu.peerconnections.deannabase.views;

import javafx.scene.layout.VBox;

/**
 * Import data view is a page to manage accounts after the main menu
 * 
 * @author David Luong, Yvonne Hoang, Carl Shefcik, Hung Tang
 * @version 1.0
 */
public class ImportDataView extends View{
private final int BUTTON_SPACING = 15;
	
	public ImportDataView() {
		super(12, 5);
		//set action of the Menu button to close the stage and open manage acct
		ViewAccessors.getMenuButton().setOnAction(e -> {
			View.newView(new MenuView());
			closeView();
		});
		//set action of the logout button to close the stage and open intro view
		ViewAccessors.getLogOutButton().setOnAction(e -> {
			View.newView(new IntroView());
			closeView();
		});
		
		//To add a node to the GridPane, use one of pane's add() methods:
		//In this case, we use add(Node child, column, row, columnspan, rowspan)
		//The two spans define how many columns or rows the child fills.
		this.add(ViewAccessors.getLogo(), 1, 1, 3, 3);
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
		buttonWrapperBox.getChildren().add(ViewAccessors.getLogOutButton());
		this.add(buttonWrapperBox, 2, 5, 1, 4);
	}

}
