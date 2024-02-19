package menu;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import MAN.Milkcollectionform;
import dodai.Farmersform;
import gur.Paymentsform;
import huuuhu.Reportsform;
import okey.Inventoryform;

public class menu extends JFrame implements ActionListener {
    private JMenuBar menuBar;
    private JMenu homeMenu;
    private JMenuItem FarmersItem;
    private JMenuItem MilkcollectionItem;
    private JMenuItem InventoryItem;
    private JMenuItem PaymentsItem;
    private JMenuItem ReportsItem;
    private JMenuItem settingsItem;
    private JMenuItem logoutItem;
    private String loggedInUser;

    public menu(String username) {
        this.loggedInUser = username;
        setTitle("Dashboard");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create menu bar
        menuBar = new JMenuBar();

        // Create home menu
        homeMenu = new JMenu("Home");

        // Create menu items
        FarmersItem = new JMenuItem(" Farmers");
        FarmersItem.addActionListener(this);
        MilkcollectionItem = new JMenuItem("Milkcollection");
        MilkcollectionItem.addActionListener(this);
        InventoryItem = new JMenuItem("Inventory");
        InventoryItem.addActionListener(this);
        PaymentsItem = new JMenuItem("Payments");
        PaymentsItem.addActionListener(this);
        ReportsItem = new JMenuItem("Reports");
        ReportsItem.addActionListener(this);
        settingsItem = new JMenuItem("Settings");
        settingsItem.addActionListener(this);
        logoutItem = new JMenuItem("Logout");
        logoutItem.addActionListener(this);

        // Add menu items to home menu
        homeMenu.add(FarmersItem);
        homeMenu.add(MilkcollectionItem);
        homeMenu.add(InventoryItem);
        homeMenu.add(PaymentsItem);
        homeMenu.add(ReportsItem);
        homeMenu.add(settingsItem);
        homeMenu.addSeparator();
        homeMenu.add(logoutItem);

        // Add home menu to menu bar
        menuBar.add(homeMenu);

        // Set menu bar to frame
        setJMenuBar(menuBar);

        // Initialize dashboard panel
        JPanel dashboardPanel = new JPanel();
        dashboardPanel.setLayout(new BorderLayout());

        // Add components to dashboard panel
        JLabel titleLabel = new JLabel("Welcome " + loggedInUser + " to Dashboard");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        dashboardPanel.add(titleLabel, BorderLayout.CENTER);

        // Add dashboard panel to frame
        add(dashboardPanel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == FarmersItem) {
            JOptionPane.showMessageDialog(this, "Opening Farmers Form...");
            new Farmersform();
        } else if (e.getSource() == MilkcollectionItem) {
            JOptionPane.showMessageDialog(this, "Opening Milkcollection Form...");
            new Milkcollectionform();
        } else if (e.getSource() == InventoryItem) { 
            JOptionPane.showMessageDialog(this, "Opening Inventory Form...");
            new Inventoryform();
        } else if (e.getSource() == PaymentsItem) {
            JOptionPane.showMessageDialog(this, "Opening Payments Form...");
            new Paymentsform();
        } else if (e.getSource() == ReportsItem) {
            JOptionPane.showMessageDialog(this, "Opening Reports Form...");
            new Reportsform();
        } else if (e.getSource() == settingsItem) {
            String newUsername = JOptionPane.showInputDialog(this, "Enter new username:");
            String newPassword = JOptionPane.showInputDialog(this, "Enter new password:");
            JOptionPane.showMessageDialog(this, "User registered successfully: " + newUsername);
        } else if (e.getSource() == logoutItem) {
            int choice = JOptionPane.showConfirmDialog(this, "Do you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                dispose();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new menu("milkdiarycollection"));
    }
}






