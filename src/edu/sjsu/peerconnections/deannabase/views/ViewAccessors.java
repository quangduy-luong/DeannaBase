package edu.sjsu.peerconnections.deannabase.views;

import javafx.scene.control.Button;

/**
 * ViewAccessors is a class that has all the buttons used to view all of the main views
 * 
 * @author David Luong, Yvonne Hoang, Carl Shefcik, Hung Tang
 * @version 1.0
 */
public class ViewAccessors {
	//all the buttons
	private Button importButton, generateReportsButton, accessDataButton, manageAccountsButton;
	
	//instantiates all the buttons to be used on the main menu and navigation menus
	public ViewAccessors() {
		importButton = new Button("Import Data");
		importButton.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
		importButton.setId("btn-1");
		
		generateReportsButton = new Button("Generate Reports");
		generateReportsButton.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
		generateReportsButton.setId("btn-1");
		
		accessDataButton = new Button("View All Data");
		accessDataButton.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
		accessDataButton.setId("btn-1");
		
		manageAccountsButton = new Button("Manage Accounts");
		manageAccountsButton.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
		manageAccountsButton.setId("btn-1");
	}
	
	//simple get methods that all return buttons
	
	public Button getImportButton() {
		return importButton;
	}
	
	public Button getGRButton() {
		return generateReportsButton;
	}
	
	public Button getADButton() {
		return accessDataButton;
	}
	
	public Button getMAButton() {
		return manageAccountsButton;
	}
	
}
