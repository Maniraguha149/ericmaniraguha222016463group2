package MAN;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Milkcollection {
	private int collection_id ;
	private String farmer_id ;
	private  String collection_dateDate ;
	private  String quantity ;
	
	public Milkcollection() {
		//constructor
	}


	public Milkcollection (int collection_id  , String farmer_id, String collection_dateDate, String quantity){
		super();
		this.collection_id =collection_id;
		this.farmer_id =farmer_id ;
		this.collection_dateDate=collection_dateDate;
		this.quantity=quantity;
		
		}

    public int getCollection_id() {
		return collection_id;
	}


	public void setCollection_id(int collection_id) {
		this.collection_id = collection_id;
	}


	public String getFarmer_id() {
		return farmer_id;
	}


	public void setFarmer_id( String farmer_id) {
		this.farmer_id = farmer_id;
	}


	public String getCollection_dateDate() {
		return collection_dateDate;
	}


	public void setCollection_dateDate( String collection_dateDate) {
		this.collection_dateDate = collection_dateDate;
	}


	public String getQuantity() {
		return quantity;
	}


	public void setQuantity( String quantity) {
		this.quantity = quantity;
	} 
	

public void makeconnection() {
}
		public void insertData() {
	// JDBC URL, username, and password of MySQL server
    String host = "jdbc:mysql://localhost/maniraguha_eric_milkdiarycollectiondb";
    String user = "root";
    String password = "";

    // SQL query to insert data
    String sql = "INSERT INTO milkcollection (farmer_id, collection_date, quantity) VALUES (?,?,?)";
	
    try (
        // Establish the connection 
        Connection con = DriverManager.getConnection(host, user, password);

        // Create a prepared statement
    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
    	    ) {
        // Set the values for the prepared statement
       
        preparedStatement.setString(1, this.farmer_id);
        preparedStatement.setString(2, this.collection_dateDate);
        preparedStatement.setString(3, this.quantity);
        
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

		        String sql = "SELECT * FROM milkcollection";

		        try {
		            Connection con = DriverManager.getConnection(host, user, password);
		            PreparedStatement preparedStatement = con.prepareStatement(sql);
		            return preparedStatement.executeQuery();
		        } catch (SQLException e) {
		            e.printStackTrace();
		            return null;}
		        }

public void update(int  inputcollection_id) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/maniraguha_eric_milkdiarycollectiondb";
    String user = "root";
    String password = "";
   
    // SQL query to update data
    String sql = "UPDATE milkcollection SET farmer_id=?,  collection_date=?, quantity=?  WHERE  farmer_id=?";

    try (
        // Establish the co
        Connection co = DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement emp = co.prepareStatement(sql);
    ) {
        // Set the new values for the update
         emp.setString(1, this.getFarmer_id());
        // emp.setString(3, this.getDob()); // Assuming there is a column named 'id' for the WHERE clause
         emp.setString(2, this.getCollection_dateDate());
         emp.setString(3, this.getQuantity());
        
         emp.setInt(4, inputcollection_id);
         
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
public void delete(int   inputcollection_id) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/maniraguha_eric_milkdiarycollectiondb";
    String user = "root";
    String password = "";

    // SQL query to delete data
    String sql = "DELETE FROM milkcollection WHERE collection_id=?";

    try (
        // Establish the 
        Connection co = DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement pl = co.prepareStatement(sql);
    ) {
        // Set the value for the WHERE clause
        pl.setInt(1,   inputcollection_id); // Assuming there is a column named 'id' for the WHERE clause

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



