/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airline_management_system;
import javax.swing.*;        // * means import all classes from javax.swing package
                             // this package contains all GUI components like JButton, JLabel, JFrame, etc.
import java.awt.*;           // * means import all classes from java.awt package
                             // used for setting colors, fonts, layouts, etc.
import java.awt.event.*;     // this package is used to handle events like button clicks

public class Home extends JFrame implements ActionListener {  // Home class extends JFrame for GUI window
                                                              // implements ActionListener to handle button clicks

    // Declaring all buttons globally so we can access them in the actionPerformed() method
    JButton addCustomerBtn, flightDetailsBtn, bookFlightBtn, journeyDetailsBtn, cancelTicketBtn, rescheduleBookingBtn, boardingPassBtn, reservationDetailsBtn;

    // Default constructor of the class
    public Home() {
        
        // Setting background image on frame
        // ImageIcon is used to load image from resource
        // ClassLoader.getSystemResource is used to get image path from project directory
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airline_management_system/icons/front.png"));
        JLabel image = new JLabel(i1); // JLabel is used because we can’t directly place an ImageIcon on JFrame
        image.setBounds(0, 0, 1600, 800); // setting image size on frame
        add(image); // adding image to JFrame
        image.setOpaque(true); // <--- make image JLabel opaque so background applies
        image.setBackground(Color.BLACK); // <--- set background black for areas not covered by image

        // Adding heading label over the image
        JLabel heading = new JLabel("Sky Ways"); // setting heading text
        heading.setBounds(700, 30, 480, 50); // x, y, width, height
        heading.setForeground(Color.BLACK); // setting font color
        heading.setOpaque(true); // allows us to set background
        heading.setBackground(new Color(255, 255, 255, 170)); // semi-transparent white background
        heading.setBorder(BorderFactory.createLineBorder(new Color(0, 153, 204), 3));  //BorderFactory is a helper class in Swing used to create different kinds of borders.
        heading.setFont(new Font("Segoe UI", Font.BOLD, 40)); // set font (font-family, style, size)
        image.add(heading); // add heading label over the image

        // Creating a panel to hold buttons vertically
        JPanel buttonPanel = new JPanel(); // JPanel is a container for other components
        buttonPanel.setLayout(new GridLayout(9, 1, 15, 15)); // GridLayout(rows, columns, hGap, vGap)
        buttonPanel.setBounds(50, 120, 300, 520); // panel size on image
        buttonPanel.setBackground(new Color(0, 0, 0, 100)); // semi-transparent black background
        image.add(buttonPanel); // adding panel to the image

        // Creating all buttons with custom styling using helper method
        addCustomerBtn = createCoolButton("Add Customer Details"); //we call createcoolButton method and passed button's text
        flightDetailsBtn = createCoolButton("Flight Details");     // then the method creates and styles the button and return it here
        bookFlightBtn = createCoolButton("Book Flights");
        journeyDetailsBtn = createCoolButton("Journey Details");
        cancelTicketBtn = createCoolButton("Cancel Ticket");
        rescheduleBookingBtn = createCoolButton("Reschedule Booking");
        boardingPassBtn = createCoolButton("Boarding Pass");
        reservationDetailsBtn = createCoolButton("Reservation Details");
        JButton exitBtn = createCoolButton("Exit"); // Exit button to close app

        // Adding all buttons to the panel one below the other
        buttonPanel.add(addCustomerBtn);
        buttonPanel.add(flightDetailsBtn);
        buttonPanel.add(bookFlightBtn);
        buttonPanel.add(journeyDetailsBtn);
        buttonPanel.add(cancelTicketBtn);
        buttonPanel.add(rescheduleBookingBtn);
        buttonPanel.add(boardingPassBtn);
        buttonPanel.add(reservationDetailsBtn);
        buttonPanel.add(exitBtn);

        // Registering action listeners to each button
        addCustomerBtn.addActionListener(this); // this refers to current class
        flightDetailsBtn.addActionListener(this);
        bookFlightBtn.addActionListener(this);
        journeyDetailsBtn.addActionListener(this);
        cancelTicketBtn.addActionListener(this);
        rescheduleBookingBtn.addActionListener(this);
        boardingPassBtn.addActionListener(this);
        reservationDetailsBtn.addActionListener(this);
        exitBtn.addActionListener(e -> System.exit(0)); // lambda expression to close app when Exit button is clicked
                         //  e represent Action Event objct (parameter) -> { body }

        // Frame settings
        setLayout(null); // using no layout manager
        setExtendedState(JFrame.MAXIMIZED_BOTH); // open frame in full screen mode
        setVisible(true); // make frame visible
        
    }

    // Helper method to create a cool styled JButton
    // this method Style buttons once ... as we pass our buttons into this method
    // this method returns a Jbutton
    private JButton createCoolButton(String text) {
        JButton button = new JButton(text); // create button with label text
        button.setFocusPainted(false); // removes default focus border
        button.setFont(new Font("Segoe UI", Font.BOLD, 18)); // set modern readable font
        button.setBackground(new Color(60, 120, 180)); // set cool blue background (using RGB vales)
        button.setForeground(Color.WHITE); // white text for contrast
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // padding inside button (top,left,bottom,right)
        button.setCursor(new Cursor(Cursor.HAND_CURSOR)); // hand cursor on hover

        // Hover effect using MouseAdapter
        button.addMouseListener(new java.awt.event.MouseAdapter() { //This is a helper class that lets us override only the methods we want — without writing all the boring extra stuff.
                                     //A shortcut class to only override needed methods           //Normally, to use a full MouseListener, you’d have to write 5 methods 
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(30, 144, 255)); // lighter color on hover
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(60, 120, 180)); // original color on exit
            }
        });

        return button; // return the styled button
    }

    // Overriding the actionPerformed method of ActionListener interface
    // This method runs whenever any button is clicked
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object src = ae.getSource(); // get the source of button click

        // Checking which button was clicked and opening respective new window
        if (src == addCustomerBtn) {
            new AddCustomer(); // opens AddCustomer class window
        } else if (src == flightDetailsBtn) {
            new FlightInfo(); // opens FlightInfo class window
        } else if (src == bookFlightBtn) {
            new BookFlight(); // opens BookFlight class window
        } else if (src == journeyDetailsBtn) {
            new JourneyDetails(); // opens JourneyDetails class window
        } else if (src == cancelTicketBtn) {
            new CancelTicket(); // opens CancelTicket class window
        } else if (src == rescheduleBookingBtn) {
            new UpdateBooking(); // opens UpdateBooking class window
        } else if (src == boardingPassBtn) {
            new BoardingPass(); // opens BoardingPass class window
        } else if (src == reservationDetailsBtn ) {
            new ReservationInfo();
        }
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit app when frame is closed
    } // remove this braket if wanna run here 

    // main method to run the program
    public static void main(String[] args) {
        new Home(); // creating object of Home class to show GUI
    }
}
