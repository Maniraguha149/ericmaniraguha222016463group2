package MILK;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class FARMERS {

	private int farmer_id ;
	private String farmer_name ;
	private String  contact_number ;
	private String address  ;
	
	
	public FARMERS(){
		super();
		this.farmer_id =farmer_id;
		this.farmer_name =farmer_name ;
		this. contact_number= contact_number;
		this.address=address;
		
		}
    public int getFarmer_id() {
		return farmer_id;
	}


	public void setFarmer_id(int farmer_id) {
		this.farmer_id = farmer_id;
	}


	public String getFarmer_name() {
		return farmer_name;
	}


	public void setFarmer_name(String farmer_name) {
		this.farmer_name = farmer_name;
	}


	public String getcontact_number() {
		return  contact_number;
	}


	public void setcontact_number(String  contact_number) {
		this. contact_number =  contact_number;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}
	public void makeconnection() {
	}
			public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/maniraguha_eric_milkdiarycollectiondb";
	    String user = "root";
	    String password = "";

	    // SQL query to insert data
	    String sql = "INSERT INTO farmers (farmer_name, contact_number, address) VALUES (?,?,?)";
		
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       
	        preparedStatement.setString(1, this.farmer_name);
	        preparedStatement.setString(2, this. contact_number);
	        preparedStatement.setString(3, this.address);
	     
	        
	                // Execute the query
	        int rowsAffected = preparedStatement.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	        	System.out.println("Data inserted sucessfully");
	            JOptionPane.showMessageDialog(null, "Data inserted successfully!","After insert",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to insert data.");
	            JOptionPane.showMessageDialog(null, "Failed to inserted data.!","After insert",JOptionPane.ERROR_MESSAGE);

	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }	
	}

		    public static ResultSet viewData() {
		        String host = "jdbc:mysql://localhost/maniraguha_eric_milkdiarycollectiondb";
		        String user = "root";
		        String password = "";

		        String sql = "SELECT * FROM farmers";

		        try {
		            Connection con = DriverManager.getConnection(host, user, password);
		            PreparedStatement preparedStatement = con.prepareStatement(sql);
		            return preparedStatement.executeQuery();
		        } catch (SQLException e) {
		            e.printStackTrace();
		            return null;
		        }
		    }


	public void update(int  inputfarmer_id) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/maniraguha_eric_milkdiarycollectiondb";
	    String user = "root";
	    String password = "";

	    // SQL query to update data
	    String sql = "UPDATE farmers SET  farmer_name=?,  contact_number=?, address=?  WHERE farmer_Id=?";

	    try (
	        // Establish the co
	        Connection co = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement emp = co.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	         emp.setString(1, this.getFarmer_name());
	        // emp.setString(3, this.getDob()); // Assuming there is a column named 'id' for the WHERE clause
	         emp.setString(2, this.getcontact_number());
	         emp.setString(3, this.getAddress());
	        
	         emp.setInt(4, inputfarmer_id);
	         
	       	        // Execute the update
	        int rowsAffected = emp.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	            System.out.println("Data updated successfully!");
	            JOptionPane.showMessageDialog(null, "Data updated successfully!","After update",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to update data. No matching record found.");
	            JOptionPane.showMessageDialog(null, "Failed to update data!","After update",JOptionPane.INFORMATION_MESSAGE);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }   
	}
	public void delete(int  inputfarmer_id) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/maniraguha_eric_milkdiarycollectiondb";
	    String user = "root";
	    String password = "";

	    // SQL query to delete data
	    String sql = "DELETE FROM farmers WHERE farmer_Id=?";

	    try (
	        // Establish the 
	        Connection co = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement pl = co.prepareStatement(sql);
	    ) {
	        // Set the value for the WHERE clause
	        pl.setInt(1,  inputfarmer_id); // Assuming there is a column named 'id' for the WHERE clause

	        // Execute the delete
	        int rowsAffected = pl.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	            System.out.println("Data deleted successfully!");
	            JOptionPane.showMessageDialog(null, "Data deleted successfully!","After delete",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to delete data. No matching record found.");
	            JOptionPane.showMessageDialog(null, "Failed to delete data!","After delete",JOptionPane.INFORMATION_MESSAGE);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	}

	
	
