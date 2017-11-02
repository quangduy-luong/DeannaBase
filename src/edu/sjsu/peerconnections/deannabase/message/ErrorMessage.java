package edu.sjsu.peerconnections.deannabase.message;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * Instance of Message class, represents an error message
 * 
 * @author David Luong, Yvonne Hoang, Carl Shefcik, Hung Tang
 * @version 1.0
 */

public class ErrorMessage extends Message {
	
	/**
	 * Creates a new error alert with the message
	 * @param message
	 */
	ErrorMessage(String message) {
		this.text = message;
		this.alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error");
		alert.setHeaderText(null);
		alert.setContentText(message);
	}
	
	@Override
	public String getType() {
		return "Error";
	}

}
