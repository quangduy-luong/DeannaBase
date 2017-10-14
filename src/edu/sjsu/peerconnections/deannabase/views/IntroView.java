package edu.sjsu.peerconnections.deannabase.views;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;

/**
 * IntroView (View of MVC) is a Pane displayed in the initial window/Stage
 * where User inputs their log in information, such as username and password.
 * They may also request another password through the "Forget Password?" link.
 * 
 * @author David Luong
 * @version 1.0
 */
public class IntroView extends Pane {

	//instance variables
	private final int WIDTH = 800;
	private final int HEIGHT = 480;
	/*
	 * Labels can contain text or images. In this case, logoLabel will contain an
	 * image of the Peer Connections logo, and forgotPasswordLabel will contain
	 * text reading "Forgot Password?"
	 */
	private Label logoLabel, forgotPasswordLabel;
	/*
	 * TextFields are where User will input information. usernameTextField is for
	 * username, and passwordTextField is for their password. passwordTextField is
	 * declared as a TextField, but will be initialized as a PasswordField, which
	 * will visually censor User's input.
	 */
	private TextField usernameTextField, passwordTextField;
	/*
	 * Button to submit information and log User in. On successful log in, screen
	 * will close and send User to a new window specific to either Student Employee 
	 * or Staff. On unsuccessful log in, an error message will be displayed for
	 * wrong username/password.
	 */
	private Button loginButton;

	/**
	 * This constructor initializes logoLabel, forgotPasswordLabel, usernameTextField,
	 * passwordTextField, and loginButton, organizing them in a GridPane object.
	 * 
	 * Logo will be displayed at the top, followed by username and password fields, 
	 * followed by a log in button, and then a clickable forgot password label.
	 */
	public IntroView() {
		GridPane pane = new GridPane();
		//Set to true for debugging; setGridLinesVisible is default false.
		//Remove line for finished product.
		pane.setGridLinesVisible(true);
		
		int rows = 12;
		int columns = 5;
		/*
		 * Design of grid, from top to bottom:
		 * 1 row of spacing
		 * 3 rows for logo
		 * 1 row of spacing
		 * 2 rows for username & password
		 * 1 row for spacing
		 * 1 row for log in button
		 * 1 row for forgot password label
		 * 2 rows of spacing
		 * 
		 * 1 column of spacing on each side
		 */
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
		
		//initialize instance variables
		logoLabel = new Label("Logo");
		forgotPasswordLabel = new Label("Forgot password?");
		usernameTextField = new TextField();
		//setPromptText() displays the string parameter inside the text field
		//until User clicks inside the field.
		usernameTextField.setPromptText("Username");
		//PasswordField is a TextField that censors user input.
		passwordTextField = new PasswordField();
		passwordTextField.setPromptText("Password");
		loginButton = new Button("Log In");
		//Setting preferred width to a high value allows it to span the entire
		//width of the column, matching username and password text field lengths.
		loginButton.setPrefWidth(Double.MAX_VALUE);
		
		//To add a node to the GridPane, use one of pane's add() methods:
		//In this case, we use add(Node child, column, row, columnspan, rowspan)
		//The two spans define how many columns or rows the child fills.
		pane.add(usernameTextField, 1, 5, 3, 1);
		pane.add(passwordTextField, 1, 6, 3, 1);
		
		pane.add(loginButton, 1, 8, 3, 1);
		//forgotPasswordLabel is currently not centered or clickable
		//center with CSS later?
		pane.add(forgotPasswordLabel, 2, 9, 3, 1);
		//getChildren() gets a list of the objects this pane contains (visually)
		//Because the GridPane object pane contains all our desired nodes, we add
		//only pane to the children.
		this.getChildren().add(pane);

	}

}
