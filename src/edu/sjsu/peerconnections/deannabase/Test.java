package edu.sjsu.peerconnections.deannabase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.sjsu.peerconnections.deannabase.controllers.Authentication;
import edu.sjsu.peerconnections.deannabase.controllers.DBController;
import edu.sjsu.peerconnections.models.UserModel;

public class Test {
	
	public static void main(String[] args) {
		// Testing methods to be called here
		DBController.init();
		testLogin();
		testIteration();
	}
	
	public static void testLogin() {
		System.out.println("Testing correct user: " + Authentication.authenticate("insert_test", "hashedanyway"));
		System.out.println("Testing incorrect user: " + Authentication.authenticate("insert_test", "idkwhat"));
	}
	
	public static void testIteration() {
		ResultSet rs = DBController.executeQuery("SELECT * FROM Users", null);
		ArrayList<UserModel> users = new ArrayList<UserModel>();
		try {
			while (rs.next()) {
				UserModel user = new UserModel();
				user.load(rs);
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (UserModel user : users) {
			System.out.println(user);
		}
	}

}
