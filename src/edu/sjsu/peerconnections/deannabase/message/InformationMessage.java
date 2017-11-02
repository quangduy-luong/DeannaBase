package edu.sjsu.peerconnections.deannabase.message;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * Instance of Message class, represents an information message
 * 
 * @author David Luong, Yvonne Hoang, Carl Shefcik, Hung Tang
 * @version 1.0
 */

public class InformationMessage extends Message {
	
	/**
	 * Creates a new information alert with the message
	 * @param message
	 */
	InformationMessage(String message) {
		this.text = message;
		this.alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information");
		alert.setHeaderText(null);
		alert.setContentText(message);
	}
	
	@Override
	public String getType() {
		return "Information";
	}

}
