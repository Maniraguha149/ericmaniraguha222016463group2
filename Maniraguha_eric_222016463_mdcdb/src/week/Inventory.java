package week;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Inventory {
	private int inventory_id ;
	private String collection_id ;
	private String expiration_dateDate ;
	private String quantity ;
	
	public Inventory() {
		// TODO Auto-generated constructor stub
	}
	
	public Inventory (int inventory_id  ,String collection_id,String expiration_dateDate,String quantity){
		super();
		this.inventory_id =inventory_id;
		this.collection_id =collection_id ;
		this.expiration_dateDate=expiration_dateDate;
		this.quantity=quantity;
		
		}

	public int getInventory_id() {
		return inventory_id;
	}

	public void setInventory_id(int inventory_id) {
		this.inventory_id = inventory_id;
	}

	public String getCollection_id() {
		return collection_id;
	}

	public void setCollection_id(String collection_id) {
		this.collection_id = collection_id;
	}

	public String getExpiration_dateDate() {
		return expiration_dateDate;
	}

	public void setExpiration_dateDate(String expiration_dateDate) {
		this.expiration_dateDate = expiration_dateDate;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
	
	
	public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/maniraguha_eric_milkdiarycollectiondb";
	    String user = "root";
	    String password = "";

	    // SQL query to insert data
	    String sql = "INSERT INTO 	inventory ( collection_id , expiration_date, quantity) VALUES (?,?,?)";
		
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       
	        preparedStatement.setString(1, this. collection_id);
	        preparedStatement.setString(2, this. expiration_dateDate);
	        preparedStatement.setString(3, this. quantity);
	       
	    	
	        
	                // Execute the query
	        int rowsAffected = preparedStatement.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	        	System.out.println("Data inserted sucessfully");
	            JOptionPane.showMessageDialog(null, "Data registered successfully!","After insert",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to insert data.");
	            JOptionPane.showMessageDialog(null, "Failed to register data.!","After insert",JOptionPane.ERROR_MESSAGE);

	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }	
	}

	  public static ResultSet viewData() {
	        String host = "jdbc:mysql://localhost/maniraguha_eric_milkdiarycollectiondb";
	        String user = "root";
	        String password = "";

	        String sql = "SELECT * FROM 	inventory";

	        try {
	            Connection con = DriverManager.getConnection(host, user, password);
	            PreparedStatement preparedStatement = con.prepareStatement(sql);
	            return preparedStatement.executeQuery();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }}

	public void update(int  inputinventory_id) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/maniraguha_eric_milkdiarycollectiondb";
	    String user = "root";
	    String password = "";

	    // SQL query to update data
	    String sql = "UPDATE 	inventory SET  collection_id=?,  expiration_date=?, quantity=?  WHERE inventory_id =?";
	    try (
	        // Establish the co
	        Connection co = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement emp = co.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	         emp.setString(1, this.getCollection_id());
	        // emp.setString(3, this.getDob()); // Assuming there is a column named 'id' for the WHERE clause
	         emp.setString(2, this.getExpiration_dateDate());
	         emp.setString(3, this.getQuantity());
	        
	         emp.setInt(4, inputinventory_id);
	         
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
	public void delete(int  inputinventory_id) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/maniraguha_eric_milkdiarycollectiondb";
	    String user = "root";
	    String password = "";

	    // SQL query to delete data
	    String sql = "DELETE FROM inventory WHERE inventory_id =?";

	    try (
	        // Establish the 
	        Connection co = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement pl = co.prepareStatement(sql);
	    ) {
	        // Set the value for the WHERE clause
	        pl.setInt(1,  inputinventory_id); // Assuming there is a column named 'id' for the WHERE clause

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

	public void setExpiration_date(String text) {
		// TODO Auto-generated method stub
		
	}
	}


	
	

