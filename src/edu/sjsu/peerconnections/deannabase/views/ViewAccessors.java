package edu.sjsu.peerconnections.deannabase.views;

import edu.sjsu.peerconnections.deannabase.Main;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 * ViewAccessors is a class that has all the buttons used to view all of the main views
 * 
 * @author David Luong, Yvonne Hoang, Carl Shefcik, Hung Tang
 * @version 1.0
 */
/**
 * @author David Luong, Yvonne Hoang, Carl Shefcik, Hung Tang
 * @version 1.0
 * 
 */
public class ViewAccessors {
	//all the buttons
	private static Button loginButton, importButton, generateReportsButton, accessDataButton, 
				manageAccountsButton, menuButton;
	private static VBox logoBox;
	
	/**
	 * Instantiates all the buttons to be used on the main menu and navigation menus.
	 */
	public static void initialize() {
		loginButton = new Button("Log In");
		loginButton.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
		loginButton.setId("btn-1");
		
		menuButton = new Button("Menu");
		menuButton.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
		menuButton.setId("btn-1");
		
		importButton = new Button("Import Data");
		importButton.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
		importButton.setId("btn-1");
		
		generateReportsButton = new Button("Generate Reports");
		generateReportsButton.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
		generateReportsButton.setId("btn-1");
		
		accessDataButton = new Button("Manage Data");
		accessDataButton.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
		accessDataButton.setId("btn-1");
		
		manageAccountsButton = new Button("Manage Accounts");
		manageAccountsButton.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
		manageAccountsButton.setId("btn-1");
		
		logoBox = new VBox();
		Label logoLabel = new Label("", new ImageView(new Image(Main.logoPath)));
		logoBox.setId("logo-1");
		logoBox.setAlignment(Pos.CENTER);
		logoBox.getChildren().add(logoLabel);
	}
	
	/**
	 * Gets the import button.
	 * @return importButton
	 */
	public static Button getImportButton() {
		return importButton;
	}
	
	/**
	 * Gets the Generate Reports button.
	 * @return generateReportsButton
	 */
	public static Button getGRButton() {
		return generateReportsButton;
	}
	
	/**
	 * Gets the Access Data button.
	 * @return accessDataButton
	 */
	public static Button getADButton() {
		return accessDataButton;
	}
	
	/**
	 * Gets the Manage Accounts button.
	 * @return manageAccountsButton
	 */
	public static Button getMAButton() {
		return manageAccountsButton;
	}
	
	/**
	 * Gets the Login button.
	 * @return loginButton
	 */
	public static Button getLoginButton() {
		return loginButton;
	}
	
	/**
	 * Gets the menu button
	 * @return menuButton
	 */
	public static Button getMenuButton() {
		return menuButton;
	}
	
	public static VBox getLogo() {
		return logoBox;
	}
	
}
