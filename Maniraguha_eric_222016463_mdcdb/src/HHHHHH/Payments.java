package HHHHHH;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Payments {
	private int payment_id;
	private String payment_amount ;
	private String payment_date ;
	private String farmer_id ;
	private String collection_id ;
	public Payments() {
		// default constructor
	}

	
	

	public Payments(int payment_id, String payment_amount, String  payment_date, String farmer_id,String collection_id) {
			
		super();
		this.payment_id= payment_id;
		this.payment_amount = payment_amount;
		this.payment_date = payment_date;
		this.farmer_id  = farmer_id ;
		this.collection_id = collection_id;
		
	}
	
	public int getPayment_id() {
		return payment_id;
	}




	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}




	public String getPayment_amount() {
		return payment_amount;
	}




	public void setPayment_amount(String payment_amount) {
		this.payment_amount = payment_amount;
	}




	public String getPayment_date() {
		return payment_date;
	}




	public void setPayment_date(String payment_date) {
		this.payment_date = payment_date;
	}




	public String getFarmer_id() {
		return farmer_id;
	}




	public void setFarmer_id(String farmer_id) {
		this.farmer_id = farmer_id;
	}




	public String getCollection_id() {
		return collection_id;
	}




	public void setCollection_id(String collection_id) {
		this.collection_id = collection_id;
	}
	public void makeconnection() {
	}
	
	public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/maniraguha_eric_milkdiarycollectiondb";
	    String user = "root";
	    String password = "";

	    // SQL query to insert data
	    String sql = "INSERT INTO payments (payment_amount, payment_date, farmer_id, collection_id) VALUES (?,?,?,?)";
		
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       
	        preparedStatement.setString(1, this.payment_amount);
	        preparedStatement.setString(2, this. payment_date);
	        preparedStatement.setString(3, this. farmer_id);
	        preparedStatement.setString(4, this.collection_id);
	        
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

	        String sql = "SELECT * FROM payments";

	        try {
	            Connection con = DriverManager.getConnection(host, user, password);
	            PreparedStatement preparedStatement = con.prepareStatement(sql);
	            return preparedStatement.executeQuery();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;}
	        }

	public void update(int inputpayment_id ) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/maniraguha_eric_milkdiarycollectiondb";
	    String user = "root";
	    String password = "";

	    // SQL query to update data
	    String sql = "UPDATE payments SET  payment_amount=?, payment_date=?, farmer_id=? ,collection_id =?, WHERE payment_id=?";

        
	    try (
	        // Establish the co
	        Connection co = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement emp = co.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	         emp.setString(1, this.getPayment_amount());// emp.setString(3, this.getDob()); // Assuming there is a column named 'id' for the WHERE clause
	         emp.setString(2, this.getPayment_date());
	         emp.setString(3, this.getFarmer_id());
	         emp.setString(4, this.getCollection_id());
	         emp.setInt(5,inputpayment_id());
	         
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
	private int inputpayment_id() {
		// TODO Auto-generated method stub
		return 0;
	}


	public void delete(int  inputpayment_id) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/maniraguha_eric_milkdiarycollectiondb";
	    String user = "root";
	    String password = "";

	    // SQL query to delete data
	    String sql = "DELETE FROM payments WHERE payment_Id=?";

	    try (
	        // Establish the 
	        Connection co = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement pl = co.prepareStatement(sql);
	    ) {
	        // Set the value for the WHERE clause
	        pl.setInt(1,  inputpayment_id); // Assuming there is a column named 'id' for the WHERE clause

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

	
	

