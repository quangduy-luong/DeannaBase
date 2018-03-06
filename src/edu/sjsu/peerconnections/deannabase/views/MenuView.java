package edu.sjsu.peerconnections.deannabase.views;

import javafx.scene.layout.VBox;

/**
 * MenuView is a view of the main menu that is shown right after the user logs in
 * 
 * @author David Luong, Yvonne Hoang, Carl Shefcik, Hung Tang
 * @version 1.0
 */
public class MenuView extends View {
	private final int BUTTON_SPACING = 15;
	
	/**
	 * This constructor displays logo and menu buttons in a vertical list.
	 */
	public MenuView() {
		super(12, 5);
		//set action of the Import Data button to close the stage and open ImportDataView
		ViewAccessors.getImportButton().setOnAction(e -> {
			View.newView(new ImportDataView());
			closeView();
		});
		//set action of the Generate Reports button to close the stage and open GenerateReportsView
		ViewAccessors.getGRButton().setOnAction(e -> {
			View.newView(new GenerateReportsView());
			closeView();
		});
		//set action of the Access Data button to close the stage and open AccessDataView
		ViewAccessors.getADButton().setOnAction(e -> {
			View.newView(new FormView());
			closeView();
		});
		//set action of the Manage Account button to close the stage and open ManageAccountdsView
		ViewAccessors.getMAButton().setOnAction(e -> {
			View.newView(new ManageAccountsView());
			closeView();
		});
		//set action of the logout button to close the stage and open IntroView
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
		buttonWrapperBox.getChildren().add(ViewAccessors.getImportButton());
		buttonWrapperBox.getChildren().add(ViewAccessors.getGRButton());
		buttonWrapperBox.getChildren().add(ViewAccessors.getADButton());
		buttonWrapperBox.getChildren().add(ViewAccessors.getMAButton());
		buttonWrapperBox.getChildren().add(ViewAccessors.getLogOutButton());
		this.add(buttonWrapperBox, 2, 6, 1, 4);
	}
	
	
}
