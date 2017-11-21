package edu.sjsu.peerconnections.deannabase.views;

import javafx.scene.layout.VBox;

/**
 * Manage accouns view is a page to manage accounts after the main menu
 * 
 * @author David Luong, Yvonne Hoang, Carl Shefcik, Hung Tang
 * @version 1.0
 */
public class ManageAccountsView extends View{
	private final int BUTTON_SPACING = 15;
	
	public ManageAccountsView() {
		super(12, 5);
		//set action of the Manage acct button to close the stage and open manage acct
		ViewAccessors.getMAButton().setOnAction(e -> {
			View.newView(new MenuView());
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
		buttonWrapperBox.getChildren().add(ViewAccessors.getImportButton());
		buttonWrapperBox.getChildren().add(ViewAccessors.getGRButton());
		buttonWrapperBox.getChildren().add(ViewAccessors.getADButton());
		buttonWrapperBox.getChildren().add(ViewAccessors.getMAButton());
		this.add(buttonWrapperBox, 2, 5, 1, 4);
	}
	
}
