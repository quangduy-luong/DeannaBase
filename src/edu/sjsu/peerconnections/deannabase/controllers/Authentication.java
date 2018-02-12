package edu.sjsu.peerconnections.deannabase.controllers;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import edu.sjsu.peerconnections.models.UserModel;

/**
 * Authentication controller. Responsible for authenticating users, hashing passwords
 * 	and communicating with the database to login and register users
 * 
 * @author David Luong, Yvonne Hoang, Carl Shefcik, Hung Tang
 * @version 1.0
 */

public class Authentication {
	
	private static UserModel currentUser;
	
	/**
	 * Authenticates a user
	 * 	First hashes the password using SHA-512 algorithm
	 * 	Then it attempts to find a match in the database
	 * @param username
	 * @param password
	 * @return true if authentication is successful
	 */
	public static boolean authenticate(String username, String password) {
		// something that does the hash for you
		MessageDigest hasher;
		try {
			hasher = MessageDigest.getInstance("SHA-512");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return false;
		}
		// sets up database connection to compare user password
		UserModel user = new UserModel();
		ArrayList<Object> params = new ArrayList<Object>();
		params.add(username);
		// attempts to find a user in the database with the provided username
		ResultSet rs = DBController.executeQuery("SELECT * FROM Users WHERE Username = ?", params);
		try {
			if (rs.next()) {
				user.load(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		hasher.update(password.getBytes());
		hasher.update(user.getSalt().getBytes());
		String hashedPassword = byteArrayToString(hasher.digest());
		// user is authenticated only if the hashed password match
		if (user.getPassword().equals(hashedPassword)) {
			loginUser(user);
			return true;
		}
		return false;
	}

	/**
	 * Helper method to convert byte array to hex-string representation
	 * @param byteArray
	 * @return hex-string representation
	 */
	private static String byteArrayToString(byte[] byteArray) {
		StringBuffer hexString = new StringBuffer();
		for (int i=0;i<byteArray.length;i++) {
			String hex=Integer.toHexString(0xff & byteArray[i]);
			if(hex.length()==1) hexString.append('0');
			hexString.append(hex);
		}
		return hexString.toString();
	}
	
	/**
	 * Generates a secure 64-bit random string 
	 * @return randomized string
	 */
	private static String randomSalt() {
		Random random = new SecureRandom();
		byte[] salt = new byte[64];
		random.nextBytes(salt);
		return byteArrayToString(salt);
	}
	
	/**
	 * Logs the user in
	 * @param user - user to be logined
	 */
	private static void loginUser(UserModel user) {
		currentUser = user;
	}
	
	/**
	 * Logs the current user out
	 */
	public static void logoutUser() {
		currentUser = null;
	}
	
	/**
	 * Current user getter
	 * @return
	 */
	public static UserModel getCurrentUser() {
		return currentUser;
	}
	
	/**
	 * Creates a new User with the specified username and password
	 * @param username
	 * @param password
	 * @return the new user model
	 */
	public static UserModel createUser(String username, String password) {
		// snipped below deals with security measures
		MessageDigest hasher;
		try {
			hasher = MessageDigest.getInstance("SHA-512");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
		String salt = randomSalt();
		hasher.update(password.getBytes());
		hasher.update(salt.getBytes());
		String hashedPassword = byteArrayToString(hasher.digest());
		
		// creates a new user model
		UserModel model = new UserModel(username, hashedPassword, salt);
		
		// inserts the model into the database
		model.create();
		return model;
	}

}
