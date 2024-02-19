package okey;

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
import week.Inventory;

public class Inventoryform implements ActionListener {
	JFrame frame;
	JLabel  inventory_id_lb=new JLabel(" inventory_id");
	JLabel collection_id_lb=new JLabel("collection_id ");
	JLabel expiration_dateDate_lb=new JLabel("expiration_dateDate");
	JLabel quantity_lb=new JLabel("quantity");
	
    JTextField inventory_id_txf=new JTextField();
	JTextField collection_id_txf=new JTextField();
    JTextField expiration_dateDate_txf=new JTextField();
    JTextField quantity_txf= new JTextField();
    
    JButton insert_btn = new JButton("INSERT");
    JButton view_btn = new JButton("VIEW");
    JButton update_btn = new JButton("UPDATE");
    JButton delete_btn = new JButton("DELETE");
    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);

    
    Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
    int w = (int) screensize.getWidth();
    int h = (int) screensize.getWidth();
    public  Inventoryform() {
    	setFontForAll();
        createForm();
        setLocationAndSize();
        addComponentToFrame();
        actionEvent();
    }
    
    
    private void actionEvent() {
        insert_btn.addActionListener((ActionListener) this);
        view_btn.addActionListener((ActionListener) this);
        update_btn.addActionListener((ActionListener) this);
        delete_btn.addActionListener((ActionListener) this);
        }
    private void createForm() {
        frame = new JFrame();
        frame.setTitle("Inventoryform");
        frame.setBounds(0, 0, w / 2, h / 2);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.PINK);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
    }
    private void setLocationAndSize() {
    	inventory_id_lb.setBounds(10, 10, 200, 30);
    	collection_id_lb.setBounds(10, 50, 200, 30);
    	expiration_dateDate_lb.setBounds(10, 90, 200, 30);
    	quantity_lb.setBounds(10, 130, 200, 30);
    	
    	inventory_id_txf.setBounds(200, 10, 300, 30);
    	collection_id_txf.setBounds(200, 50, 300, 30);
    	expiration_dateDate_txf.setBounds(200, 90, 300, 30);
    	quantity_txf.setBounds(200, 130, 300, 30);
    	
    	
    	 
    	 
    	 insert_btn.setBounds(10, 250, 85, 30);
    	 view_btn.setBounds(100,  250, 85, 30);
         update_btn.setBounds(190,  250, 85, 30);
         delete_btn.setBounds(280,  250, 85, 30);
         table.setBounds(10, 330, 480, 200);
     	}
    private void setFontForAll() {
   	Font fontLabel = new Font("Georgia", Font.BOLD, 18);
   	inventory_id_lb.setFont(fontLabel);
   	collection_id_lb.setFont(fontLabel);
   	expiration_dateDate_lb.setFont(fontLabel);
   	quantity_lb.setFont(fontLabel);
   	
   	   	 
   	
   	Font fontText = new Font("Georgia", Font.BOLD, 18);
   	inventory_id_txf.setFont(fontText);
   	collection_id_txf.setFont(fontText);
   	expiration_dateDate_txf.setFont(fontText);
   	quantity_txf.setFont(fontText);
   	
   	Font fontButtonItalic = new Font("Courier New", Font.ITALIC, 12);
    insert_btn.setFont(fontButtonItalic);
    view_btn.setFont(fontButtonItalic);
    update_btn.setFont(fontButtonItalic);
    delete_btn.setFont(fontButtonItalic);
}
 private void addComponentToFrame() {
 	frame.add(inventory_id_lb);
     frame.add(collection_id_lb);
     frame.add(expiration_dateDate_lb);
     frame.add(quantity_lb);
     	
     frame.add(inventory_id_txf);
     frame.add(collection_id_txf);
     frame.add(expiration_dateDate_txf);
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
	 Inventory  iv=new Inventory ();
	if(e.getSource()==insert_btn) {
	
		iv.setCollection_id(collection_id_txf.getText());
		//emp.setDob(dob_txf.getText());
		iv.setExpiration_dateDate(expiration_dateDate_txf.getText());
		iv.setQuantity(quantity_txf.getText());
		iv.insertData();
	    }

	else if (e.getSource() == view_btn) {
        model.setColumnCount(0);
        model.setRowCount(0);
        model.addColumn("inventory_id");
        model.addColumn("collection_id");
        model.addColumn("expiration_dateDate");
        model.addColumn("quantity");

        ResultSet resultSet = Inventory.viewData();
        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
                            resultSet.getString(3), resultSet.getString(4) });
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }}
	}
     else if (e.getSource()==update_btn) {
		int id=Integer.parseInt(inventory_id_txf.getText());
		
		iv.setCollection_id(collection_id_txf.getText());
		//emp.setdob(dob_txf.getText());
		iv.setExpiration_dateDate(expiration_dateDate_txf.getText());
		iv.setQuantity(quantity_txf.getText());
		iv.update(id);
		}
     else {
		int id=Integer.parseInt(inventory_id_txf.getText());
		iv.delete(id);}}

	


	public static void main(String[] args) {
		 Inventoryform ivf=new Inventoryform ();
          System.out.println(ivf);
}
	}

