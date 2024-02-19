package MAN;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import MILK.FARMERS;
import dodai.Farmersform;

public class Milkcollectionform implements ActionListener {
    JFrame frame;
    JLabel collection_id_lb = new JLabel("collection_id");
    JLabel farmer_id_lb = new JLabel("farmer_id ");
    JLabel collection_date_lb = new JLabel("collection_date");
    JLabel quantity_lb = new JLabel("quantity");

    JTextField collection_id_txf = new JTextField();
    JTextField farmer_id_txf = new JTextField();
    JTextField collection_date_txf = new JTextField();
    JTextField quantity_txf = new JTextField();

    JButton insert_btn = new JButton("INSERT");
    JButton view_btn = new JButton("VIEW");
    JButton update_btn = new JButton("UPDATE");
    JButton delete_btn = new JButton("DELETE");
    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);

    Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
    int w = (int) screensize.getWidth();
    int h = (int) screensize.getWidth();

    public Milkcollectionform() {
        setFontForAll();
        createForm();
        setLocationAndSize();
        addComponentToFrame();
        actionEvent();
    }

    private void actionEvent() {
        insert_btn.addActionListener(this);
        view_btn.addActionListener(this);
        update_btn.addActionListener(this);
        delete_btn.addActionListener(this);
    }

    private void createForm() {
        frame = new JFrame();
        frame.setTitle("Milk Collection Form");
        frame.setBounds(0, 0, w / 2, h / 2);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.PINK);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
    }

    private void setLocationAndSize() {
    	
    	collection_id_lb.setBounds(10, 10, 200, 30);
    	 farmer_id_lb.setBounds(10, 50, 200, 30);
    	 collection_date_lb.setBounds(10, 90, 200, 30);
    	 quantity_lb.setBounds(10, 130, 200, 30);
    	
    	collection_id_txf.setBounds(200, 10, 300, 30);
    	 farmer_id_txf.setBounds(200, 50, 300, 30);
    	 collection_date_txf.setBounds(200, 90, 300, 30);
    	 quantity_txf.setBounds(200, 130, 300, 30);
    	
    	
    	 
    	 
    	 insert_btn.setBounds(10, 250, 85, 30);
         view_btn.setBounds(100,  250, 85, 30);
         update_btn.setBounds(190,  250, 85, 30);
         delete_btn.setBounds(280,  250, 85, 30);
         table.setBounds(10, 330, 480, 200);
     	
        // ... (unchanged)

    }

    private void setFontForAll() {
    	Font fontLabel = new Font("Georgia", Font.BOLD, 18);
    	collection_id_lb.setFont(fontLabel);
    	farmer_id_lb.setFont(fontLabel);
    	 collection_date_lb.setFont(fontLabel);
    	 quantity_lb.setFont(fontLabel);
       	
       	   	 
       	
       	Font fontText = new Font("Georgia", Font.BOLD, 18);
       	collection_id_txf.setFont(fontText);
       	farmer_id_txf.setFont(fontText);
        collection_date_txf.setFont(fontText);
        quantity_txf.setFont(fontText);
       	
       	Font fontButtonItalic = new Font("Courier New", Font.ITALIC, 12);
        insert_btn.setFont(fontButtonItalic);
        view_btn.setFont(fontButtonItalic);
        update_btn.setFont(fontButtonItalic);
        delete_btn.setFont(fontButtonItalic);}

    private void addComponentToFrame() {
    	frame.add(collection_id_lb);
        frame.add(farmer_id_lb);
        frame.add(collection_date_lb);
        frame.add(quantity_lb);
        	
        frame.add(collection_id_txf);
        frame.add(farmer_id_txf);
        frame.add(collection_date_txf);
        frame.add(quantity_txf);
        
        //Buttons CRUD
        frame.add(insert_btn);
        frame.add(view_btn);
        frame.add(update_btn);
        frame.add(delete_btn);
        frame.add(table);
      
    }
   @Override
	public void actionPerformed(ActionEvent e) {
		Milkcollection mc= new	Milkcollection();		
		if(e.getSource()==insert_btn) {
			mc.setFarmer_id(farmer_id_txf.getText());
			//emp.setDob(dob_txf.getText());
			mc.setCollection_dateDate(collection_date_txf.getText());
			mc.setQuantity(quantity_txf.getText());
			mc.insertData();
		    }

		else if (e.getSource() == view_btn) {
	        model.setColumnCount(0);
	        model.setRowCount(0);
	        model.addColumn("collection_id");
	        model.addColumn("farmer_id");
	        model.addColumn("collection_date");
	        model.addColumn("quantity");

	        ResultSet resultSet = Milkcollection.viewData();
	        if (resultSet != null) {
	            try {
	                while (resultSet.next()) {
	                    model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
	                            resultSet.getString(3), resultSet.getString(4) });
	                }
	            } catch (SQLException ex) {
	                ex.printStackTrace();
	            }
	        }
		}
	        else if (e.getSource()==update_btn) {
			int id=Integer.parseInt(collection_id_txf.getText());
			
			mc.setFarmer_id(farmer_id_txf.getText());
			//emp.setdob(dob_txf.getText());
			mc.setCollection_dateDate(collection_date_txf.getText());
			mc.setQuantity(quantity_txf.getText());
			mc.update(id);
			}
	        else {
			int id=Integer.parseInt(collection_id_txf.getText());
			mc.delete(id);}}
   

		public static void main(String[] args) {
			Milkcollectionform mcf= new	Milkcollectionform();
	             System.out.println(mcf);
	}
		}
	 	
	