package edu.sjsu.peerconnections.deannabase.views;

import edu.sjsu.peerconnections.deannabase.Main;
import edu.sjsu.peerconnections.deannabase.controllers.Authentication;
import edu.sjsu.peerconnections.deannabase.message.Message;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;

/**
 * IntroView is a View displayed in the initial window/Stage where
 * User inputs their log in information, such as username and password.
 * They may also request another password through the "Forget Password?" link.
 * 
 * @author David Luong, Yvonne Hoang, Carl Shefcik, Hung Tang
 * @version 1.0
 */
public class IntroView extends View {

	//instance variables
	private final int WIDTH = 800;
	private final int HEIGHT = 480;
	/*
	 * Labels can contain text or images. In this case, logoLabel will contain an
	 * image of the Peer Connections logo, and forgotPasswordLabel will contain
	 * text reading "Forgot Password?"
	 */
	private Labeled logoLabel, forgotPasswordLabel;
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
	
	/**
	 * This constructor initializes logoLabel, forgotPasswordLabel, usernameTextField,
	 * passwordTextField, and loginButton, organizing them in a GridPane object.
	 * 
	 * Logo will be displayed at the top, followed by username and password fields, 
	 * followed by a log in button, and then a clickable forgot password label.
	 */
	public IntroView() {
		GridPane pane = new GridPane();
		pane.setId("gridpane-1");
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
		/*
		 * Image objects require file paths. To wrap in a Label object,
		 * the Image needs to be wrapped in an ImageView object as the Graphic
		 * of the Label.
		 */

		ImageView logo = new ImageView(new Image(Main.logoPath));
		logoLabel = new Label("", logo);
		VBox logoBoxWrapper = new VBox();
		logoBoxWrapper.getChildren().add(logoLabel);
		//VBox.setVgrow(logoLabel, Priority.ALWAYS);
		logo.fitWidthProperty().bind((pane.widthProperty().getValue()*0.6)); 
		//Hyperlink is a Label that makes the text clickable.
		forgotPasswordLabel = new Hyperlink("Forgot password?");
		//forgotPasswordLabel is currently not clickable
		usernameTextField = new TextField();
		//Setting preferred size to a high value allows it to fill the entire cell
		usernameTextField.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
		//setPromptText() displays the string parameter inside the text field
		//until User clicks inside the field.
		usernameTextField.setPromptText("Username");
		//PasswordField is a TextField that censors user input.
		passwordTextField = new PasswordField();
		passwordTextField.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
		passwordTextField.setPromptText("Password");
		//set action of login button
		//accesses MenuView if authorized, shows error message if not
		ViewAccessors.getLoginButton().setOnAction(e -> {
			if(authorizeUser(usernameTextField.getText(), passwordTextField.getText())) {
				View.newView(new MenuView());
				closeView();
			}
			else {
				Message.getInstance("Username or password not found!", "error").show();
			}
		});
		this.setOnKeyPressed(new EventHandler<KeyEvent>()
				{
					@Override
					public void handle(KeyEvent event) 
					{
						if(event.getCode() == KeyCode.ENTER)
							ViewAccessors.getLoginButton().fire();
					}
			
				});
		//To add a node to the GridPane, use one of pane's add() methods:
		//In this case, we use add(Node child, column, row, columnspan, rowspan)
		//The two spans define how many columns or rows the child fills.
		pane.add(usernameTextField, 1, 5, 3, 1);
		pane.add(passwordTextField, 1, 6, 3, 1);
		pane.add(ViewAccessors.getLoginButton(), 1, 8, 3, 1);
		pane.add(logoBoxWrapper, 1, 1, 3, 3);
		//To center forgotPasswordLabel requires an additional wrapper to set alignment
		//use HBox to wrap forgotPasswordLabel
		HBox forgotPasswordLabelWrapper = new HBox();
		forgotPasswordLabelWrapper.getChildren().add(forgotPasswordLabel);
		//set alignment of forgotPasswordLabelWrapper to centered, then add to pane
		forgotPasswordLabelWrapper.setAlignment(Pos.CENTER);
		pane.add(forgotPasswordLabelWrapper, 2, 9, 1, 1);
		//getChildren() gets a list of the objects this pane contains (visually)
		//Because the GridPane object pane contains all our desired nodes, we add
		//only pane to the children.
		this.getChildren().add(pane);
		//changes the focus of the intro screen so that no textfields are automatically
		//selected (user must click on Username box)
		
		pane.prefHeightProperty().bind(this.heightProperty());
		pane.prefWidthProperty().bind(this.widthProperty());
		
		Platform.runLater( () -> {
			((IntroView)getStage().getScene().getRoot()).initFocus();
		});
	}

	/**
	 * Changes the focus so that no textfields are automatically selected on first display.
	 * 
	 * This method will be called by Main, as requestFocus() will not change focus unless
	 * Stage is already visible.
	 */
	public void initFocus() {
		initFocus(logoLabel);
	}
	
	/**
	 * Authorizes the user with a username and password
	 * @param username
	 * @param password
	 * @return true if user is found
	 */
	public boolean authorizeUser(String username, String password) {
		return Authentication.authenticate(username, password);
	}

}
