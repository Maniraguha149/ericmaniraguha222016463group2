package dodai;

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


public class Farmersform implements ActionListener{
	JFrame frame;
	JLabel farmer_id_lb=new JLabel("farmer_id");
	JLabel farmer_name_lb=new JLabel("farmer_name ");
	JLabel contact_number_lb=new JLabel("contact_name");
	JLabel address_lb=new JLabel("address");
	
    JTextField farmer_id_txf=new JTextField();
	JTextField farmer_name_txf=new JTextField();
    JTextField contact_number_txf=new JTextField();
    JTextField address_txf= new JTextField();
    
    JButton insert_btn = new JButton("INSERT");
    JButton view_btn = new JButton("VIEW");
    JButton update_btn = new JButton("UPDATE");
    JButton delete_btn = new JButton("DELETE");
    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);

    
    Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
    int w = (int) screensize.getWidth();
    int h = (int) screensize.getWidth();
    public  Farmersform() {
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
        frame.setTitle("Farmers Form");
        frame.setBounds(0, 0, w / 2, h / 2);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.PINK);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
    }
    private void setLocationAndSize() {
    	farmer_id_lb.setBounds(10, 10, 200, 30);
    	farmer_name_lb.setBounds(10, 50, 200, 30);
    	contact_number_lb.setBounds(10, 90, 200, 30);
    	address_lb.setBounds(10, 130, 200, 30);
    	
    	farmer_id_txf.setBounds(200, 10, 300, 30);
    	farmer_name_txf.setBounds(200, 50, 300, 30);
    	contact_number_txf.setBounds(200, 90, 300, 30);
    	address_txf.setBounds(200, 130, 300, 30);
    	
    	
    	 
    	 
    	 insert_btn.setBounds(10, 250, 85, 30);
         view_btn.setBounds(100,  250, 85, 30);
         update_btn.setBounds(190,  250, 85, 30);
         delete_btn.setBounds(280,  250, 85, 30);
         table.setBounds(10, 330, 480, 200);


     	}
    private void setFontForAll() {
   	Font fontLabel = new Font("Georgia", Font.BOLD, 18);
   	farmer_id_lb.setFont(fontLabel);
   	farmer_name_lb.setFont(fontLabel);
   	contact_number_lb.setFont(fontLabel);
   	address_lb.setFont(fontLabel);
   	
   	   	 
   	
   	Font fontText = new Font("Georgia", Font.BOLD, 18);
   	farmer_id_txf.setFont(fontText);
   	farmer_name_txf.setFont(fontText);
   	contact_number_txf.setFont(fontText);
   	address_txf.setFont(fontText);
   	
   	Font fontButtonItalic = new Font("Courier New", Font.ITALIC, 12);
    insert_btn.setFont(fontButtonItalic);
    view_btn.setFont(fontButtonItalic);
    update_btn.setFont(fontButtonItalic);
    delete_btn.setFont(fontButtonItalic);
}
 private void addComponentToFrame() {
 	frame.add(farmer_id_lb);
     frame.add(farmer_name_lb);
     frame.add(contact_number_lb);
     frame.add(address_lb);
     	
     frame.add(farmer_id_txf);
     frame.add(farmer_name_txf);
     frame.add(contact_number_txf);
     frame.add(address_txf);
     
     //Buttons CRUD
     frame.add(insert_btn);
     frame.add(view_btn);
     frame.add(update_btn);
     frame.add(delete_btn);
     frame.add(table);
 }
 @Override
	public void actionPerformed(ActionEvent e) {
	 FARMERS fms=new FARMERS();
	if(e.getSource()==insert_btn) {
	
		fms.setFarmer_name(farmer_name_txf.getText());
		//emp.setDob(dob_txf.getText());
		fms.setcontact_number(contact_number_txf.getText());
		fms.setAddress(address_txf.getText());
		fms.insertData();
	    }

	else if (e.getSource() == view_btn) {
        model.setColumnCount(0);
        model.setRowCount(0);
        model.addColumn("farmer_id");
        model.addColumn("farmer_name");
        model.addColumn("contact_number");
        model.addColumn("address");

        ResultSet resultSet = FARMERS.viewData();
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
		int id=Integer.parseInt(farmer_id_txf.getText());
		
		fms.setFarmer_name(farmer_name_txf.getText());
		//emp.setdob(dob_txf.getText());
		fms.setcontact_number(contact_number_txf.getText());
		fms.setAddress(address_txf.getText());
		fms.update(id);
		}
        else {
		int id=Integer.parseInt(farmer_id_txf.getText());
		fms.delete(id);
        }}
 
	public static void main(String[] args) {
		Farmersform fsf=new Farmersform ();
             System.out.println(fsf);
}
	}
 