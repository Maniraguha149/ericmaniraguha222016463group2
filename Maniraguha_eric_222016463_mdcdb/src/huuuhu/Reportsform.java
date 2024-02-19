package huuuhu;

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
import huuhu.Reports;

public class Reportsform implements ActionListener {
	JFrame frame;
	JLabel  report_id_lb=new JLabel(" report_id");
	JLabel  report_dateDate_lb=new JLabel(" report_dateDate ");
	JLabel total_milk_collected_lb=new JLabel("total_milk_collected");
	
	
    JTextField  report_id_txf=new JTextField();
	JTextField  report_dateDate_txf=new JTextField();
    JTextField total_milk_collected_txf=new JTextField();
    
    
    JButton insert_btn = new JButton("INSERT");
    JButton view_btn = new JButton("VIEW");
    JButton update_btn = new JButton("UPDATE");
    JButton delete_btn = new JButton("DELETE");
    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);

    
    Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
    int w = (int) screensize.getWidth();
    int h = (int) screensize.getWidth();
    public  Reportsform() {
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
        frame.setTitle("Reportsform");
        frame.setBounds(0, 0, w / 2, h / 2);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.PINK);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
    }
    private void setLocationAndSize() {
    	report_id_lb.setBounds(10, 10, 200, 30);
    	report_dateDate_lb.setBounds(10, 50, 200, 30);
    	total_milk_collected_lb.setBounds(10, 90, 200, 30);
    	
    	
    	report_id_txf.setBounds(200, 10, 300, 30);
    	report_dateDate_txf.setBounds(200, 50, 300, 30);
    	total_milk_collected_txf.setBounds(200, 90, 300, 30);
    	
    	
    	
    	 
    	 
    	 insert_btn.setBounds(10, 250, 85, 30);
    	 view_btn.setBounds(100,  250, 85, 30);
         update_btn.setBounds(190,  250, 85, 30);
         delete_btn.setBounds(280,  250, 85, 30);
         table.setBounds(10, 330, 480, 200);
     	}
    private void setFontForAll() {
   	Font fontLabel = new Font("Georgia", Font.BOLD, 18);
   	report_id_lb.setFont(fontLabel);
   	report_dateDate_lb.setFont(fontLabel);
   	total_milk_collected_lb.setFont(fontLabel);
   	
   	
   	   	 
   	
   	Font fontText = new Font("Georgia", Font.BOLD, 18);
   	report_id_txf.setFont(fontText);
   	report_dateDate_txf.setFont(fontText);
   	total_milk_collected_txf.setFont(fontText);
   
   	
   	Font fontButtonItalic = new Font("Courier New", Font.ITALIC, 12);
    insert_btn.setFont(fontButtonItalic);
    view_btn.setFont(fontButtonItalic);
    update_btn.setFont(fontButtonItalic);
    delete_btn.setFont(fontButtonItalic);
}
 private void addComponentToFrame() {
 	frame.add(report_id_lb);
     frame.add(report_dateDate_lb);
     frame.add(total_milk_collected_lb);
     
     	
     frame.add(report_id_txf);
     frame.add(report_dateDate_txf);
     frame.add(total_milk_collected_txf);
     
     
     //Buttons CRUD
     frame.add(insert_btn);
     frame.add(view_btn);
     frame.add(update_btn);
     frame.add(delete_btn);
     frame.add(table);
 }
 @Override
	public void actionPerformed(ActionEvent e) {
	 Reports rps=new  Reports ();
	if(e.getSource()==insert_btn) {
	rps.setReport_dateDate(report_dateDate_txf.getText());
		//emp.setDob(dob_txf.getText());
		rps.setTotal_milk_collected(total_milk_collected_txf.getText());
		rps.insertData();
	    }

	else if (e.getSource() == view_btn) {
        model.setColumnCount(0);
        model.setRowCount(0);
        model.addColumn("report_id");
        model.addColumn("report_dateDate");
        model.addColumn("total_milk_collected");
        

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
		int id=Integer.parseInt(report_id_txf.getText());
		
		rps.setReport_dateDate(report_dateDate_txf.getText());
		//emp.setdob(dob_txf.getText());
		rps.setTotal_milk_collected( total_milk_collected_txf.getText());
		rps.update(id);
		}
        else {
		int id=Integer.parseInt(report_id_txf.getText());
		rps.delete(id);}
        }

	public static void main(String[] args) {
		Reportsform rps=new Reportsform ();
             System.out.println(rps);
}
	}
 


