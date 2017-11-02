package edu.sjsu.peerconnections.deannabase.message;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * Instance of Message class, represents an warning message
 * 
 * @author David Luong, Yvonne Hoang, Carl Shefcik, Hung Tang
 * @version 1.0
 */

public class WarningMessage extends Message {
	
	/**
	 * Creates a new warning alert with the message
	 * @param message
	 */
	WarningMessage(String message) {
		this.text = message;
		this.alert = new Alert(AlertType.WARNING);
		alert.setTitle("Warning");
		alert.setHeaderText(null);
		alert.setContentText(message);
	}
	
	@Override
	public String getType() {
		return "Warning";
	}

}
