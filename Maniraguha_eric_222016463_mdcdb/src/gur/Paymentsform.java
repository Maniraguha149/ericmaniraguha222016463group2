package gur;

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

import HHHHHH.Payments;
import MILK.FARMERS;

public class Paymentsform implements ActionListener {
	JFrame frame;
	JLabel payment_id_lb=new JLabel("payment_id");
	JLabel farmer_id_lb=new JLabel("farmer_id ");
	JLabel collection_id_lb=new JLabel("collection_id");
	JLabel payment_amount_lb=new JLabel("payment_amount");
	JLabel payment_date_lb=new JLabel("payment_date");
	
    JTextField payment_id_txf=new JTextField();
	JTextField farmer_id_txf=new JTextField();
    JTextField collection_id_txf=new JTextField();
    JTextField payment_amount_txf= new JTextField();
    JTextField payment_date_txf=new JTextField();
    
    JButton insert_btn = new JButton("INSERT");
    JButton view_btn = new JButton("VIEW");
    JButton update_btn = new JButton("UPDATE");
    JButton delete_btn = new JButton("DELETE");
    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
    
    Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
    int w = (int) screensize.getWidth();
    int h = (int) screensize.getWidth();
    public   Paymentsform() {
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
        frame.setTitle(" Paymentsform");
        frame.setBounds(0, 0, w / 2, h / 2);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.PINK);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
    }
    private void setLocationAndSize() {
    	 payment_id_lb.setBounds(10, 10, 200, 30);
    	 farmer_id_lb.setBounds(10, 50, 200, 30);
    	 collection_id_lb.setBounds(10, 90, 200, 30);
    	 payment_amount_lb.setBounds(10, 130, 200, 30);
    	 payment_date_lb.setBounds(10, 170, 200, 30);
    	
    	 payment_id_txf.setBounds(200, 10, 300, 30);
    	 farmer_id_txf.setBounds(200, 50, 300, 30);
    	 collection_id_txf.setBounds(200, 90, 300, 30);
    	 payment_amount_txf.setBounds(200, 130, 300, 30);
    	 payment_date_txf.setBounds(200, 170, 300, 30);
     	
    	
    	
    	 
    	 
    	 insert_btn.setBounds(10, 250, 85, 30);
    	 view_btn.setBounds(100,  250, 85, 30);
         update_btn.setBounds(190,  250, 85, 30);
         delete_btn.setBounds(280,  250, 85, 30);
         table.setBounds(10, 330, 480, 200);
     	}
    private void setFontForAll() {
   	Font fontLabel = new Font("Georgia", Font.BOLD, 18);
   	payment_id_lb.setFont(fontLabel);
   	farmer_id_lb.setFont(fontLabel);
   	collection_id_lb.setFont(fontLabel);
   	payment_amount_lb.setFont(fontLabel);
    payment_date_lb.setFont(fontLabel);
   	
   	   	 
   	
   	Font fontText = new Font("Georgia", Font.BOLD, 18);
   	payment_id_txf.setFont(fontText);
   	farmer_id_txf.setFont(fontText);
   	collection_id_txf.setFont(fontText);
   	payment_amount_txf.setFont(fontText);
   	payment_date_txf.setFont(fontText);
   	
   	
   	Font fontButtonItalic = new Font("Courier New", Font.ITALIC, 12);
    insert_btn.setFont(fontButtonItalic);
    view_btn.setFont(fontButtonItalic);
    update_btn.setFont(fontButtonItalic);
    delete_btn.setFont(fontButtonItalic);
}
 private void addComponentToFrame() {
 	frame.add(payment_id_lb);
     frame.add(farmer_id_lb);
     frame.add(collection_id_lb);
     frame.add(payment_amount_lb);
     frame.add(	payment_date_lb);
     	
     frame.add(payment_id_txf);
     frame.add(farmer_id_txf);
     frame.add(collection_id_txf);
     frame.add(payment_amount_txf);
     frame.add(payment_date_txf);
     
     //Buttons CRUD
     frame.add(insert_btn);
     frame.add(view_btn);
     frame.add(update_btn);
     frame.add(delete_btn);
     frame.add(table);
 }

 @Override
	public void actionPerformed(ActionEvent e) {
	 Payments pms=new Payments();
	if(e.getSource()==insert_btn) {
	
		pms.setPayment_amount(payment_amount_txf.getText());
		//emp.setDob(dob_txf.getText());
		pms.setPayment_date(payment_date_txf.getText());
		pms.setFarmer_id(farmer_id_txf.getText());
		pms.setCollection_id(collection_id_txf.getText());
		pms.insertData();
	    }

	else if (e.getSource() == view_btn) {
        model.setColumnCount(0);
        model.setRowCount(0);
        model.addColumn("payment_id");
        model.addColumn("payment_amount");
        model.addColumn("payment_date");
        model.addColumn("farmer_id");
        model.addColumn("collection_id");

        ResultSet resultSet =Payments .viewData();
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
		int id=Integer.parseInt(payment_id_txf.getText());
		pms.setPayment_amount(payment_amount_txf.getText());
		//emp.setdob(dob_txf.getText());
		pms.setPayment_date(payment_date_txf.getText());
		pms.setFarmer_id(farmer_id_txf.getText());
		pms.setCollection_id( collection_id_txf.getText());
		pms.update(id);
		
		}
	
        else {
		int id=Integer.parseInt(payment_id_txf.getText());
		pms.delete(id);}}
 

	public static void main(String[] args) {
		Paymentsform psf=new Paymentsform ();
             System.out.println(psf);
}
	
	}
	
 

