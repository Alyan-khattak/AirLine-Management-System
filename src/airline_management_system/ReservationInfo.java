package airline_management_system;

import javax.swing.*;                     // For Swing GUI components
import java.awt.*;                        // For layout and color
import java.awt.event.*;                  // For event handling (e.g., button clicks)
import java.sql.*;                        // For database operations
import net.proteanit.sql.DbUtils;         // To convert ResultSet into TableModel (used for JTable)

// --->>> GUI CLASS TO DISPLAY AND SEARCH RESERVATION INFO <<<---
public class ReservationInfo extends JFrame {

    // Declare GUI components globally so they can be accessed inside methods
    JTable tableAll, tableSingle;      // One table for all reservations, another for search results
    JTextField searchField;            // Text field to input CNIC
    JButton searchButton;              // Button to trigger search

    // ---->>> CONSTRUCTOR TO SET UP GUI <<<----
    public ReservationInfo() {

        setTitle("Reservation Info");                         // Title for window
        setSize(900, 650);                                    // Set window size (width x height)
        setLocation(400, 100);                                // Set window location on screen
        getContentPane().setBackground(Color.WHITE);          // Set background color to white
        setLayout(null);                                      // Absolute positioning (x,y manually)

        // ---->>> SEARCH LABEL <<<----
        JLabel searchLabel = new JLabel("Search by CNIC:");   // Label to indicate CNIC field
        searchLabel.setFont(new Font("Segoe UI", Font.BOLD, 14)); // Set font style and size
        searchLabel.setBounds(20, 10, 150, 30);               // Position (x, y, width, height)
        add(searchLabel);                                     // Add label to frame

        // ---->>> SEARCH TEXT FIELD <<<----
        searchField = new JTextField();                       // Create empty text field for CNIC
        searchField.setFont(new Font("Segoe UI", Font.PLAIN, 14)); // Enhanced font for clarity
        searchField.setBounds(150, 10, 200, 30);              // Set position and size
        add(searchField);                                     // Add text field to frame

        // ---->>> SEARCH BUTTON <<<----
        searchButton = new JButton("Search");                 // Create button labeled "Search"
        searchButton.setFont(new Font("Segoe UI", Font.BOLD, 13)); // Bold font for button
        searchButton.setBounds(360, 10, 100, 30);             // Set position and size
        searchButton.setBackground(new Color(60, 120, 180));  // Set background color (blue shade)
        searchButton.setForeground(Color.WHITE);              // Set text color to white
        searchButton.setFocusPainted(false);                  // Remove border highlight on click
        add(searchButton);                                    // Add button to frame

        // ---->>> MAIN TABLE TO DISPLAY ALL RESERVATIONS <<<----
        tableAll = new JTable();                              // Create JTable to hold all data
        tableAll.setFont(new Font("Segoe UI", Font.PLAIN, 13)); // Set font for better readability
        tableAll.setRowHeight(22);                            // Increase row height
        tableAll.setGridColor(Color.GRAY);                    // Grid line color
        tableAll.setShowVerticalLines(true);                  // Show vertical grid lines

        JScrollPane jspAll = new JScrollPane(tableAll);       // Add scroll to table
        jspAll.setBounds(20, 60, 840, 220);                   // Position and size
        jspAll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); // Scroll policy
        jspAll.setBorder(BorderFactory.createTitledBorder("All Reservations")); // Panel title
        add(jspAll);                                          // Add scrollable table to frame

        // ---->>> SECOND TABLE TO DISPLAY SEARCH RESULT <<<----
        tableSingle = new JTable();                           // Table to show searched CNIC result
        tableSingle.setFont(new Font("Segoe UI", Font.PLAIN, 13)); // Same styling as above
        tableSingle.setRowHeight(22);
        tableSingle.setGridColor(Color.GRAY);
        tableSingle.setShowVerticalLines(true);

        JScrollPane jspSingle = new JScrollPane(tableSingle); // Add scroll to table
        jspSingle.setBounds(20, 300, 840, 220);               // Position and size below first table
        jspSingle.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        jspSingle.setBorder(BorderFactory.createTitledBorder("Search Results")); // Panel title
        add(jspSingle);                                       // Add to frame

        // ---->>> LOAD ALL DATA INITIALLY <<<----
        loadAllReservations();                                // Call method to load full reservation list

        // ---->>> ACTION LISTENER FOR SEARCH BUTTON <<<----
        searchButton.addActionListener(new ActionListener() { // here we ActionListener through anonymass class method whic we studied in class
            public void actionPerformed(ActionEvent ae) {     // and Override the method
                String cnic = searchField.getText().trim();   // Get CNIC input and remove spaces
                if (!cnic.isEmpty()) {
                    searchReservationByCNIC(cnic);            // Call method to search specific CNIC .. that is defined below
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter CNIC to search."); // Error box
                }
            }
        });

        setVisible(true);                                     // Show the GUI window
       setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       // Close app on exit
    }

    // ---->>> METHOD TO LOAD ALL RESERVATIONS FROM DATABASE <<<----
    private void loadAllReservations() {
        try {
            Connection_SQL c = new Connection_SQL();          // Connect to database using custom class
            ResultSet rs = c.s.executeQuery("SELECT * FROM reservation"); // SQL query to fetch all data
            tableAll.setModel(DbUtils.resultSetToTableModel(rs)); // Convert ResultSet into table
        } catch (Exception e) {
            e.printStackTrace();                              // Print error if connection fails
        }
    }

    // ---->>> METHOD TO SEARCH RESERVATION BY CNIC <<<----
    private void searchReservationByCNIC(String cnic) {
        try {
            Connection_SQL c = new Connection_SQL();          // Connect to database again
            String query = "SELECT * FROM reservation WHERE cnic = '" + cnic + "'"; // SQL with filter
            ResultSet rs = c.s.executeQuery(query);           // Execute the query
            tableSingle.setModel(DbUtils.resultSetToTableModel(rs)); // Fill bottom table with result
        } catch (Exception e) {
            e.printStackTrace();                              // Print error if occurs
        }
    }

    
}    
//    // ---->>> MAIN METHOD TO RUN THE CLASS <<<----
//    public static void main(String[] args) {
//        new ReservationInfo();                              
//    }
//}
