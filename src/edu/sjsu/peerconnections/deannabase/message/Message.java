package edu.sjsu.peerconnections.deannabase.message;

import javafx.scene.control.Alert;

/**
 * Factory class for spawning notification messages 
 * 
 * @author David Luong, Yvonne Hoang, Carl Shefcik, Hung Tang
 * @version 1.0
 */

public abstract class Message {
	
	//text of data and actual alert that contains the message
	protected String text;
	protected Alert alert;
	
	//returns the type of the message
	public abstract String getType();
	
	//returns text of message
	public String getText() {
		return text;
	}
	
	/**
	 * Factory method to spawn new messages
	 * @param message
	 * @param type
	 * @return the notification message
	 */
	public static Message getInstance(String message, String type) {
		if (type.equalsIgnoreCase("warning")) {
			return new WarningMessage(message);
		}
		else if (type.equalsIgnoreCase("error")) {
			return new ErrorMessage(message);
		}
		else if (type.equalsIgnoreCase("information")) {
			return new InformationMessage(message);
		}
		else return null;
	}
	
	/**
	 * Displays the alert on the screen
	 */
	public void show() {
		alert.showAndWait();
	}

}
