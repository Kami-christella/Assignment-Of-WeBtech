package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dbConf.ConnectDb;
import model.Studentinfo;


public class ControllerClass {

	public String saveUser( String username, String password) throws SQLException {
		
		
		Connection con = DriverManager.getConnection(ConnectDb.url, ConnectDb.user, ConnectDb.password);
		PreparedStatement statement = con.prepareStatement("insert into user value(?,?)");
		statement.setString(1, username);
		statement.setString(2, password);
		
		
		statement.executeUpdate();
		statement.close();
		con.close();
		return "user saved successful";
	}
	
public String saveInfo( String email, byte[] picture, byte[] document) throws SQLException {
		
		
		Connection con = DriverManager.getConnection(ConnectDb.url, ConnectDb.user, ConnectDb.password);
		PreparedStatement statement = con.prepareStatement("insert into studentinfo value(?,?,?)");
		statement.setString(1, email);
		statement.setBytes(2, picture);
		statement.setBytes(3, document);
		
		
		statement.executeUpdate();
		statement.close();
		con.close();
		return "Student Information saved successful";
	}

	
	
	
}
