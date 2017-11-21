package edu.sjsu.peerconnections.deannabase.views;

import edu.sjsu.peerconnections.deannabase.controllers.Authentication;
import edu.sjsu.peerconnections.deannabase.message.Message;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Labeled;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;

/**
 * IntroView is a View displayed in the initial window/Stage where
 * User inputs their log in information, such as username and password.
 * They may also request another password through the "Forget Password?" link.
 * 
 * @author David Luong, Yvonne Hoang, Carl Shefcik, Hung Tang
 * @version 1.0
 */
public class IntroView extends View {

	/*
	 * Labels can contain text or images. In this case, logoLabel will contain an
	 * image of the Peer Connections logo, and forgotPasswordLabel will contain
	 * text reading "Forgot Password?"
	 */
	private Labeled forgotPasswordLabel;
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
		super(12, 5);
		//initialize instance variables
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
		//To add a node to the GridPane, use View's add() method:
		//In this case, we use add(Node child, column, row, columnspan, rowspan)
		//The two spans define how many columns or rows the child fills.
		this.add(usernameTextField, 1, 5, 3, 1);
		this.add(passwordTextField, 1, 6, 3, 1);
		this.add(ViewAccessors.getLoginButton(), 1, 8, 3, 1);
		this.add(ViewAccessors.getLogo(), 1, 1, 3, 3);
		//To center forgotPasswordLabel requires an additional wrapper to set alignment
		//use HBox to wrap forgotPasswordLabel
		HBox forgotPasswordLabelWrapper = new HBox();
		forgotPasswordLabelWrapper.getChildren().add(forgotPasswordLabel);
		//set alignment of forgotPasswordLabelWrapper to centered, then add to pane
		forgotPasswordLabelWrapper.setAlignment(Pos.CENTER);
		this.add(forgotPasswordLabelWrapper, 2, 9, 1, 1);
		//getChildren() gets a list of the objects this pane contains (visually)
		//Because the GridPane object pane contains all our desired nodes, we add
		//only pane to the children.
		//changes the focus of the intro screen so that no textfields are automatically
		//selected (user must click on Username box)
		
		grid.prefHeightProperty().bind(this.heightProperty());
		grid.prefWidthProperty().bind(this.widthProperty());
		
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
		initFocus(ViewAccessors.getLogo());
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
