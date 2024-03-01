package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import model.Studentinfo;


public class Userdao {

	 private String dbUrl="jdbc:mysql://localhost:3306/webtech2";
     private String username="root";
      private String passwd="";
	
	   public String registerStudent(Studentinfo sd){
	        try{
	            Connection con = DriverManager.getConnection(dbUrl, username, passwd);
	            PreparedStatement pst = con.prepareStatement("insert into studentinfo (email,picture,document) values(?,?,?)");
	            pst.setString(1, sd.getEmail());
	            pst.setBytes(2, sd.getPicture());
	            pst.setBytes(3, sd.getDocument());
	            int rowAffected = pst.executeUpdate();
	            con.close();
	            if(rowAffected>0){
	                return "Data Saved";
	            }else{
	                return "data Not saved";
	            }
	        }catch(Exception ex){
	            ex.printStackTrace();
	            return "Server Error";
	        }
	    }
	
}
