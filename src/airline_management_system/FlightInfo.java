package airline_management_system;

import javax.swing.*;                     // For Swing GUI components like JFrame, JTable, JScrollPane
import java.awt.*;                        // For layout and color
import java.sql.*;                        // For database operations
import net.proteanit.sql.DbUtils;         // To convert ResultSet to TableModel for JTable

// --->>> GUI CLASS TO DISPLAY FLIGHT INFORMATION <<<---
public class FlightInfo extends JFrame {

    JTable table; // Declare globally so it can be accessed from different methods if needed

    // ---->>> CONSTRUCTOR TO SETUP THE FLIGHT INFO WINDOW <<<----
    public FlightInfo() {

        setTitle("Flight Information");                     // Set the title of the window
        setSize(850, 600);                                  // Set width and height of the window
        setLocation(400, 150);                              // Set the location of the window on screen
        getContentPane().setBackground(Color.WHITE);        // Set background color of the window
        setLayout(null);                                    // Use absolute layout for custom positioning

        // ---->>> CREATE A TABLE TO DISPLAY FLIGHT DATA <<<----
        table = new JTable();                               // Create a JTable object to hold flight data
        table.setFont(new Font("Segoe UI", Font.PLAIN, 14)); // Modern font for readability
        table.setRowHeight(25);                              // Increase row height
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14)); // Header font
        //Customizes the font of the table header (column titles).

        try {
            Connection_SQL c = new Connection_SQL();        // Connect to the database using custom connection class
            ResultSet rs = c.s.executeQuery("SELECT * FROM flight"); // SQL query to get all flights
            table.setModel(DbUtils.resultSetToTableModel(rs));       // Convert ResultSet to TableModel and set to table
        } catch (Exception e) {
            e.printStackTrace();                            // Print any error that occurs while fetching data
        }

        // ---->>> ADD TABLE TO A SCROLL PANE <<<----
        JScrollPane jsp = new JScrollPane(table);           // Create a scroll pane and pass the table in it
        jsp.setBounds(40, 100, 750, 420);                   // Set position and size of scroll pane
        jsp.setBorder(BorderFactory.createLineBorder(new Color(150, 150, 150))); // soft border
         jsp.setBorder(BorderFactory.createTitledBorder("Flight Info")); // Panel title
        add(jsp);                                           // Add scroll pane (with table inside) to the frame

        // ---->>> ADD CUSTOM HEADING <<<----
        JLabel heading = new JLabel("✈️ Flight Information");
        heading.setFont(new Font("Segoe UI", Font.BOLD, 28));
        heading.setForeground(new Color(0, 102, 204));
        heading.setBounds(280, 30, 400, 40);
        add(heading);

        setVisible(true);                                   // Make the frame visible
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }
}
//    // ---->>> MAIN METHOD TO RUN THE FLIGHT INFO WINDOW <<<----
//    public static void main(String[] args) {
//        new FlightInfo(); // Create an object which runs the constructor and shows the GUI
//    }
//}
