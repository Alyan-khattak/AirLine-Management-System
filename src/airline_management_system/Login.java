  package airline_management_system;

import javax.swing.*; // * means import all classes from javax.swing package, // its comes from extended Swing library that's why we use "x" i.e javax.swing
import java.awt.*; // * means import all classes from java.awt package, // this package contains classes for GUI components like Color, Font, etc.
import java.awt.event.*;  // this package contains classes for event handling like ActionListener, MouseListener, etc.
import java.sql.*; // this package contains classes for working with SQL databases like Connection, Statement, ResultSet, etc.

public class Login extends JFrame implements ActionListener {  // ActionListener is an interface that is used to handle action events like button clicks, etc.
                                                               // ActionListenser has an abstract method actionPerformed(ActionEvent e) that needs to be Overridden (implemented) in the class

    // Globally declare Buttons used in constructor so that they can be accessed in the actionPerformed method
    JButton reset, submit, exit;
    // Globally declare input Text Fields used in constructor so that they can be accessed in the actionPerformed method
    JTextField txtUsername;
    JPasswordField txtPassword;

    // Default constructor of the class
    public Login() {
        //To view from
        setTitle("🔥 Airline Login Portal 🔥"); // Title of the frame
        setVisible(true); // To make the frame visible
        setSize(500, 350); //setSize(width, height) to set the size of the frame
        setLocation(500, 250); //setLocation(distance from left , distance from top) to set the location of the frame
        setResizable(false); //user can,t resize the frane 
        // to Change frame color
        getContentPane().setBackground(new Color(30, 30, 30)); // getContentPane() returns the content pane of the frame, 
                                      //in setBackground() we can use color class to set the color that belongs to java.awt package
        // SetBackground(Color) sets the background color if want to set in RGB format then use setBackground(new Color(r,g,b)) where r,g,b are integers from 0 to 255
        // new Color(30,30,30) grey color 

        setLayout(null); // setLayout(null) means no layout manager is used, we will set the position and size manually

        // ----->>>> Fancy Heading Label <<<<-----
        JLabel heading = new JLabel("Aye Aye Captain"); // label for title
        heading.setBounds(80, 20, 400, 40); // position and size
        heading.setFont(new Font("Segoe UI", Font.BOLD, 24)); // font family, style and size
        heading.setForeground(new Color(0, 204, 204)); // cyan text color for glow effect
        add(heading); // add label to frame

        // ----->>>> Label Creation <<<<------

        // To Label FRAME
        JLabel lblUsername = new JLabel("Username"); // JLabel is used to create a label in the frame   
        // now to Set the Lable position and size on screen
        lblUsername.setBounds(70, 80, 100, 25); // setBounds(x, y, width, height) sets the position and size of the label
        lblUsername.setFont(new Font("Arial", Font.PLAIN, 16)); // set font
        lblUsername.setForeground(Color.WHITE); // white text
        add(lblUsername); // add() method adds the label (i.e the above lbl is username ) to the frame   

        // Now we want password Label so
        JLabel lblPassword = new JLabel("Password"); // JLabel is used to create a label in the frame
        lblPassword.setBounds(70, 130, 100, 25); // setBounds(x, y, width, height) sets the position and size of the label
        lblPassword.setFont(new Font("Arial", Font.PLAIN, 16)); // set font
        lblPassword.setForeground(Color.WHITE); // white text
        add(lblPassword); // add() method adds the label (i.e the above lbl is password) to the frame

        // ----->>>> Text Field Creation <<<<------

        // Now we want to add text fields for username and password // dabba banana h Input k liye

        /*JTextField*/ txtUsername = new JTextField(); // JTextField is used to create a text field in the frame
        // now to Set the Text Field position and size on screen
        txtUsername.setBounds(170, 80, 220, 25); // setBounds(x, y, width, height) sets the position and size of the text field
        txtUsername.setBackground(new Color(50, 50, 50)); // dark input box
        txtUsername.setForeground(Color.CYAN); // input text color
        txtUsername.setFont(new Font("Consolas", Font.PLAIN, 14)); // input font
        txtUsername.setCaretColor(Color.CYAN);           // make caret visible
        txtUsername.getCaret().setBlinkRate(500);
        add(txtUsername); // add() method adds the text field (i.e the above txt is username) to the frame
        // Now we want password text field 
        // can use text field for password but it will show the password in plain text
        // so we will use JPasswordField which is used to create a password field in the frame

        /*JPasswordField*/ txtPassword = new JPasswordField();
        txtPassword.setBounds(170, 130, 220, 25); // setBounds(x, y, width, height) sets the position and size of the text field
        txtPassword.setBackground(new Color(50, 50, 50));
        txtPassword.setForeground(Color.CYAN);
        txtPassword.setFont(new Font("Consolas", Font.PLAIN, 14));
        txtPassword.setCaretColor(Color.CYAN);           // make caret visible
        txtPassword.getCaret().setBlinkRate(500);
        add(txtPassword); // add() method adds the text field (i.e the above txt is password) to the frame

        // ----->>>> Button Creation <<<<------
        // use JButton class to create a button in the frame
        /*JButton*/ reset = new JButton("Reset"); // JButton is used to create a button in the frame
        reset.setBounds(20, 200, 90, 35); 
        reset.setBackground(new Color(204, 229, 255)); // Light blue shade
        reset.setForeground(Color.BLACK); // Black text color
        reset.setFont(new Font("Tahoma", Font.BOLD, 14)); // Bold font
        reset.setFocusPainted(false); // remove ugly border glow
        reset.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        add(reset); 
        reset.addActionListener(this); // listener is added to the button so that it can perform an action when clicked

        // submit Login button
        /*JButton*/ submit = new JButton("Login");
        submit.setBounds(130, 200, 100, 35);
        submit.setBackground(new Color(0, 153, 76)); // green
        submit.setForeground(Color.WHITE); // white text
        submit.setFont(new Font("Tahoma", Font.BOLD, 14)); // bold font
        submit.setFocusPainted(false); // remove ugly border glow
        submit.setBorder(BorderFactory.createLineBorder(Color.CYAN)); // cyan border
        add(submit);
        submit.addActionListener(this); // listener is added to the button so that it can perform an action when clicked

        // exit button
        /*JButton*/ exit = new JButton("Exit");
        exit.setBounds(250, 200, 100, 35);
        exit.setBackground(new Color(255, 51, 51)); // red
        exit.setForeground(Color.WHITE);
        exit.setFont(new Font("Tahoma", Font.BOLD, 14));
        exit.setFocusPainted(false);
        exit.setBorder(BorderFactory.createLineBorder(Color.RED));
        add(exit); 
        exit.addActionListener(this); // listener is added to the button so that it can perform an action when clicked
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Buttons was appearing only on hover to solve that issue
        revalidate();  // Ensures the layout is recalculated
        repaint();     // Forces the frame to repaint the UI
    }

    // Overriding the actionPerformed method of ActionListener interface b/c this method is abstract method and needs to be implemented in the class
    @Override
    //This function defines what actually happens when the button is clicked (what action is performed)
    public void actionPerformed(ActionEvent ae) {
        // ae is the ActionEvent object that contains information about the event that occurred
        // we can use getSource() method to get the source of the event (i.e the button that was clicked) 
        // Action konsy button sy trigger hwa h 
        if (ae.getSource() == submit) { // if submit button is clicked then we want to check the username and password
            // it will search it in dadatabse. we eshtablish connection to database in Connection_SQL.java file

            String username = txtUsername.getText(); // getText() method returns the text entered in the text field // values nikalti h 
            String password = txtPassword.getText(); // getText() method returns the text entered in the password field

            // exception handling is done in Connection_SQL.java file
            try {
                // to connect to the database we will use Connection_SQL class
                Connection_SQL c = new Connection_SQL(); // create an object of Connection_SQL class to establish connection to the database
                //select Query
                String query = "select * from Login where username = '" + username + "' and password = '" + password + "' ";
                // query is a string that contains the SQL query to be executed // we cancatenate the username and password that we got from the text fields usin getText() method

                ResultSet rs = c.s.executeQuery(query); // executeQuery() method is used to execute the SQL query and as select query returns a result set, we use ResultSet to store the result of the query
                // rs is a ResultSet object that contains the result of the query

                if (rs.next()) {
                    new Home(); // Home page Opens
                    setVisible(false); // to hide the frame
                } else {
                    //JOptionPane is a class that is used to create dialog boxes in Java Swing
                    // showMessageDialog() method is used to show a message dialog with the specified message
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                }

            } catch (Exception e) {
                e.printStackTrace(); // printStackTrace() method prints the stack trace of the exception
            }

        } else if (ae.getSource() == exit) { // if exit button is clicked then we want to close the frame

            setVisible(false); // to hide the frame

        } else if (ae.getSource() == reset) { // if reset button is clicked then we want to clear the text fields

            txtUsername.setText(""); // setText("") sets the text of the text field to empty string
            txtPassword.setText(""); // setText("") sets the text of the password field to empty string
        }

        
    }

    public static void main(String[] args) {
        new Login();
    }
}
