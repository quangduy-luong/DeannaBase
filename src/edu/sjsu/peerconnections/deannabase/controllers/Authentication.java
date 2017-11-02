package edu.sjsu.peerconnections.deannabase.controllers;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/**
 * Authentication controller. Responsible for authenticating users, hashing passwords
 * 	and communicating with the database to login and register users
 * 
 * @author David Luong, Yvonne Hoang, Carl Shefcik, Hung Tang
 * @version 1.0
 */

public class Authentication {
	
	/**
	 * Authenticates a user
	 * 	First hashes the password using SHA-256 algorithm
	 * 	Then it attempts to find a match in the database
	 * @param username
	 * @param password
	 * @return true if authentication is successful
	 */
	public static boolean authenticate(String username, String password) {
		MessageDigest hasher;
		try {
			hasher = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		String hashedPassword = byteArrayToString(hasher.digest(password.getBytes()));
		return login(username, hashedPassword);
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
	 * Attempts to locate a user in the database. Placeholder for now
	 * @param username
	 * @param hashedPassword
	 * @return
	 */
	private static boolean login(String username, String hashedPassword) {
		Map<String, String> users = new HashMap<String, String>();
		users.put("user", "5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8");
		return users.containsKey(username) && users.get(username).equals(hashedPassword);
	}

}
