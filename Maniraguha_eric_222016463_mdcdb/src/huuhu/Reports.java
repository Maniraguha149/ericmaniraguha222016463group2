package huuhu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Reports {
	private int report_id ;
	private String report_dateDate ;
	private String total_milk_collected;
	public Reports() {
		//  constructor Reports
	};
	
	
	public Reports(int report_id,String report_dateDate ,  String total_milk_collected) {
		super();
		this.report_id =report_id;
		this.report_dateDate =report_dateDate ;
		this.total_milk_collected=total_milk_collected;
	
		
		}


	


	public int getReport_id() {
		return report_id;
	}


	public void setReport_id(int report_id) {
		this.report_id = report_id;
	}


	public String getReport_dateDate() {
		return report_dateDate;
	}


	public void setReport_dateDate(String report_dateDate) {
		this.report_dateDate = report_dateDate;
	}


	public String getTotal_milk_collected() {
		return total_milk_collected;
	}


	public void setTotal_milk_collected(String total_milk_collected) {
		this.total_milk_collected = total_milk_collected;
	}
	public void makeconnection() {
	}

	public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/maniraguha_eric_milkdiarycollectiondb";
	    String user = "root";
	    String password = "";

	    // SQL query to insert data
	    String sql = "INSERT INTO reports ( report_date, total_milk_collacted) VALUES (?,?)";
		
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	   
	        preparedStatement.setString(2, this. report_dateDate);
	        preparedStatement.setString(3, this.total_milk_collected);
	     
	        
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

	        String sql = "SELECT * FROM	reports";

	        try {
	            Connection con = DriverManager.getConnection(host, user, password);
	            PreparedStatement preparedStatement = con.prepareStatement(sql);
	            return preparedStatement.executeQuery();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;}
	        }


	public void update(int  inputreport_id) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/maniraguha_eric_milkdiarycollectiondb";
	    String user = "root";
	    String password = "";

	    // SQL query to update data
	    String sql = "UPDATE reports SET  report_date=?,  total_milk_collacted=?,  WHERE report_Id=?";

	    try (
	        // Establish the co
	        Connection co = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement emp = co.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	         emp.setString(1, this.getReport_dateDate());
	        // emp.setString(3, this.getDob()); // Assuming there is a column named 'id' for the WHERE clause
	         emp.setString(2, this.getTotal_milk_collected());
	        
	         emp.setInt(3, inputreport_id);
	         
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
	public void delete(int  inputreport_id) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/maniraguha_eric_milkdiarycollectiondb";
	    String user = "root";
	    String password = "";

	    // SQL query to delete data
	    String sql = "DELETE FROM reports WHERE report_Id=?";

	    try (
	        // Establish the 
	        Connection co = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement pl = co.prepareStatement(sql);
	    ) {
	        // Set the value for the WHERE clause
	        pl.setInt(1,  inputreport_id); // Assuming there is a column named 'id' for the WHERE clause

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

	
	

