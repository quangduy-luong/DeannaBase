package edu.sjsu.peerconnections.deannabase.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import edu.sjsu.peerconnections.deannabase.message.Message;

public class DBController {
	
	public static String databaseURL = "jdbc:ucanaccess://res/Database.accdb;jackcessOpener=edu.sjsu.peerconnections.deannabase.helpers.CryptCodecOpener";
	private static String user = "deannabase";
	private static String pass = "p43Da.C0bX";
	
	/**
	 * Initializes the database driver
	 */
	public static void init() {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		}
		catch(ClassNotFoundException cnfex) {

			System.out.println("Problem in loading or "
					+ "registering MS Access JDBC driver");
			cnfex.printStackTrace();
			Message.getInstance("Could not load MS Access JDBC Driver.", "error").show();
			System.exit(0);
		}
	}
	
	/**
	 * Executes a given SQL query with a list of parameters. Returns the ResultSet to be processed
	 * @param query - query string
	 * @param params - List of parameters to be filled
	 * @return ResultSet object to be further processed by each loader separately
	 */
	public static ResultSet executeQuery(String query, List<Object> params) {
		Connection connection = null;
		PreparedStatement pstm = null;
		ResultSet result = null;
		try {
			connection = DriverManager.getConnection(databaseURL, user, pass); 
			pstm = connection.prepareStatement(query);
			if (params != null) {
				for(int i = 1; i <= params.size(); i++) {
					pstm.setObject(i, params.get(i - 1));
				}
			}
			result = pstm.executeQuery();
		}
		catch(SQLException sqlex){
			sqlex.printStackTrace();
		}
		finally {
			try {
				pstm.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	/**
	 * Executes a given SQL update command with a list of parameters.
	 * @param query - update string
	 * @param params - List of parameters to be filled
	 * @return # of rows affected
	 */
	public static int executeUpdate(String update, List<Object> params) {
		Connection connection = null;
		PreparedStatement pstm = null;
		int result = 0;
		try {
			connection = DriverManager.getConnection(databaseURL, user, pass); 
			pstm = connection.prepareStatement(update);
			if (params != null) {
				for(int i = 1; i <= params.size(); i++) {
					pstm.setObject(i, params.get(i - 1));
				}
			}
			result = pstm.executeUpdate();
		}
		catch(SQLException sqlex){
			sqlex.printStackTrace();
		}
		finally {
			try {
				pstm.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

}
