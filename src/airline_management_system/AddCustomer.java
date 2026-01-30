package airline_management_system;

import javax.swing.*; // for Swing components
import java.awt.*; // for Color, Font, Layout, Cursor etc.
import java.awt.event.*; // for ActionEvent and ActionListener

public class AddCustomer extends JFrame implements ActionListener {

    // ----------- GLOBAL COMPONENT DECLARATION ------------
    JTextField txtname, txtnationality, txtCNIC, txtaddress, txtphone; // Input fields
    JRadioButton rbmale, rbfemale; // Gender radio buttons

    // ----------- CONSTRUCTOR FOR GUI ------------
    public AddCustomer() {

        // ------- FRAME SETUP --------
        setSize(900, 600); // Set the width and height of the frame
        setLocation(300, 150); // Position of frame on the screen
        setTitle("Add Customer"); // Frame title

        // ------- FRAME BACKGROUND COLOR --------
        getContentPane().setBackground(new Color(245, 245, 255)); // Light blue background
        setLayout(null); // Using no layout manager (absolute positioning)

        // ----------- HEADING -----------
        JLabel heading = new JLabel("✈ Add Customer Details");
        heading.setBounds(270, 20, 500, 40); // Position and size of heading
        heading.setFont(new Font("Segoe U FontI", Font.BOLD, 36)); // Font style
        heading.setForeground(new Color(25, 25, 112)); // Dark blue text color
        heading.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLUE)); // Bottom border
        add(heading); // Add heading to frame

        // ----------- NAME LABEL & TEXT FIELD -----------
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60, 80, 150, 25);
        lblname.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        add(lblname);

        txtname = new JTextField();
        txtname.setBounds(220, 80, 180, 25);
        add(txtname);

        // ----------- NATIONALITY LABEL & TEXT FIELD -----------
        JLabel lblnationality = new JLabel("Nationality");
        lblnationality.setBounds(60, 130, 150, 25);
        lblnationality.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        add(lblnationality);

        txtnationality = new JTextField();
        txtnationality.setBounds(220, 130, 180, 25);
        add(txtnationality);

        // ----------- CNIC LABEL & TEXT FIELD -----------
        JLabel lblCNIC = new JLabel("CNIC");
        lblCNIC.setBounds(60, 180, 150, 25);
        lblCNIC.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        add(lblCNIC);

        txtCNIC = new JTextField();
        txtCNIC.setBounds(220, 180, 180, 25);
        add(txtCNIC);

        // ----------- ADDRESS LABEL & TEXT FIELD -----------
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(60, 230, 150, 25);
        lbladdress.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        add(lbladdress);

        txtaddress = new JTextField();
        txtaddress.setBounds(220, 230, 180, 25);
        add(txtaddress);

        // ----------- GENDER LABEL & RADIO BUTTONS -----------
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(60, 280, 150, 25);
        lblgender.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        add(lblgender);
                             //radio button
        rbmale = new JRadioButton("Male");
        rbmale.setBounds(220, 280, 70, 25);
        rbmale.setBackground(new Color(245, 245, 255)); // Match background
        add(rbmale);

        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(300, 280, 80, 25);
        rbfemale.setBackground(new Color(245, 245, 255));
        add(rbfemale);

        // ----------- BUTTON GROUP FOR GENDER (SELECT ONLY ONE) -----------
        ButtonGroup genderButton = new ButtonGroup(); // A ButtonGroup is a logical container that groups radio buttons together that add objct of radio button so that only one button is selected at a tym
          // Add both radio buttons to the group
        // This ensures that when one is selected, the other gets automatically unselected
        genderButton.add(rbmale);
        genderButton.add(rbfemale);

        // ----------- PHONE LABEL & TEXT FIELD -----------
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(60, 330, 150, 25);
        lblphone.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        add(lblphone);

        txtphone = new JTextField();
        txtphone.setBounds(220, 330, 180, 25);
        add(txtphone);

        // ----------- SAVE BUTTON -----------
        JButton save = new JButton("💾 SAVE");
        save.setBackground(new Color(0, 102, 204)); // Blue color
        save.setForeground(Color.WHITE); // White text
        save.setBounds(220, 390, 180, 35);
        save.setFont(new Font("Segoe UI Font", Font.BOLD, 16)); // Bold font
        save.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Hand cursor on hover
        save.setFocusPainted(false); // Removes focus border
        save.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2)); // Blue border
        add(save);
        save.addActionListener(this);

        // ----------- BUTTON HOVER EFFECT -----------
        //This is a helper class that lets us override only the methods we want — without writing all the boring extra stuff.
         //A shortcut class to only override needed methods           //Normally, to use a full MouseListener, you’d have to write 5 methods 
        save.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                save.setBackground(new Color(0, 153, 255)); // Lighter blue on hover
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                save.setBackground(new Color(0, 102, 204)); // Original blue
            }
        });

        // ----------- IMAGE ICON -----------
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("airline_management_system/icons/emp.png")); // Load image
        JLabel lblimage = new JLabel(image); // JLabel with image
        lblimage.setBounds(450, 80, 350, 400); // Set image position and size
        add(lblimage);

        // ----------- FINAL FRAME SETTINGS -----------
        setVisible(true); // Make frame visible
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
 // Close app on exit
    }

    // ----------- ACTION PERFORMED METHOD (Save Button Logic) -----------
    @Override
    public void actionPerformed(ActionEvent ae) {
        // Getting input from text fields
        String name = txtname.getText();
        String nationality = txtnationality.getText();
        String address = txtaddress.getText();
        String phone = txtphone.getText();
        String CNIC = txtCNIC.getText();

        // Getting selected gender
        String gender = null;
        if (rbmale.isSelected()) {
            gender = "Male";
        } else {
            gender = "Female";
        }

        try {
            // Creating connection object to interact with database
            Connection_SQL c = new Connection_SQL();

            // Writing SQL query to insert data into passenger table
            String query = "insert into passenger values ( '" + CNIC + "' , '" + name + "' , '" + nationality + "' , '" + phone + "' , '" + address + "' ,  '" + gender + "' ) ";

            // Executing query using Statement object 's' inside Connection_SQL class
            c.s.executeUpdate(query);

            // Show success message
            JOptionPane.showMessageDialog(null, "🎉 Customer Details Added Successfully");

            // Close the form after saving
            setVisible(false);

        } catch (Exception e) {
            // Print error stack if any exception occurs
            e.printStackTrace();
        }
    }
}

//    // ----------- MAIN METHOD TO RUN THE GUI -----------
//    public static void main(String[] args) {
//        new AddCustomer(); // Object created to call constructor and show form
//    }
//}
