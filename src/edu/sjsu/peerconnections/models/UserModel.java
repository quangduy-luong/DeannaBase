package edu.sjsu.peerconnections.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.sjsu.peerconnections.deannabase.controllers.DBController;

public class UserModel implements Model {
	
	private String username;
	private String password;
	private String salt;
	private boolean admin;
	
	public UserModel() {
		this("", "", "");
	}
	
	public UserModel(String username, String password, String salt) {
		this.username = username;
		this.password = password;
		this.salt = salt;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	@Override
	public boolean load(ResultSet rs) {
		try {
			username = rs.getString(1);
			password = rs.getString(2);
			salt = rs.getString(3);
			admin = rs.getBoolean(4);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean update() {
		String sql = "UPDATE Users SET PasswordHash = ?, Salt = ?, Admin = ? WHERE Username = ?";
		ArrayList<Object> args = new ArrayList<Object>();
		args.add(password);
		args.add(salt);
		args.add(admin);
		args.add(username);
		return DBController.executeUpdate(sql, args) > 0;
	}

	@Override
	public boolean create() {
		String sql = "INSERT INTO Users (Username, PasswordHash, Salt, Admin) VALUES (?, ?, ?, ?)";
		ArrayList<Object> args = new ArrayList<Object>();
		args.add(username);
		args.add(password);
		args.add(salt);
		args.add(admin);
		return DBController.executeUpdate(sql, args) > 0;
	}
	
	@Override
	public String toString() {
		return "Username: " + username + "\nPassword hash: " + password + "\nSalt: " + salt + "\nAdmin: " + admin + "\n";
		
	}

}
