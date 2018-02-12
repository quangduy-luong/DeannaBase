package edu.sjsu.peerconnections.models;

import java.sql.ResultSet;

/**
 * Basic model interface. Supports 3 database operations: Load from ResultSet, update, and create
 * 
 * @author David Luong, Yvonne Hoang, Carl Shefcik, Hung Tang
 * @version 1.0
 *
 */
public interface Model {
	
	public boolean load(ResultSet rs);
	public boolean update();
	public boolean create();

}
