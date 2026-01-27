/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airline_management_system;

import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser; // clndr jar file to show chalander
import java.util.*; // to use math functions like Random




public class BookFlight extends JFrame implements ActionListener {
    
    // Globally declarin  Lbales tht would get tht from database
    JLabel labelname, labelnationality, labeladdress, labelgender, labelfname, labelfcode, labelprice;
    //Globally declaring TextFields
    JTextField txtCNIC;
    //Globally declaring JButtons
    JButton bookflight,fetchflight,fetchuser;
    //Globally declaring Choice
    Choice source,destination, flightClass;
    //Globally declaring JDateChooser class from jar files
    JDateChooser dcdate;
    
    
    public BookFlight(){
        
        setSize(1200,900);//setSize(width, height) to set the size of the frame
        setLocation(200,50); //setLocation(distance from left , distance from top) to set the location of the frame
        
        // to Change frame color
         getContentPane().setBackground(new Color(245, 245, 255));//in setBackground() we can use color class to set the color that belongs to java.awt package
        // SetBackground(Color) sets the background color if want to set in RGB format then use setBackground(new Color(r,g,b)) where r,g,b are integers from 0 to 255
        
        setLayout(null);
        
        // ------>>>>>> LABELING THE FRANE <<<<<<<------
        
        // ---------------------- HEADING -------------------------------
        
        JLabel heading = new JLabel("BooK Flight");
        heading.setBounds(420,20,500,35);// setBounds(x, y, width, height)
         heading.setFont(new Font("Segoe UI", Font.BOLD, 32));
        heading.setForeground(new Color(0, 102, 204)); // sky blue
        add(heading);// add() method adds the label on the frame
        
        
        // ------------------- CNIC Input + Fetch User -------------------
        
        // CNIC
        JLabel lblCNIC = new JLabel("CNIC");
        lblCNIC.setBounds(60, 80, 150, 25);
        lblCNIC.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        add(lblCNIC);
           
        /*JTextField*/ txtCNIC = new JTextField();
        txtCNIC.setBounds(220, 80, 150, 25);
        txtCNIC.setBorder(BorderFactory.createLineBorder(Color.GRAY)); // Border added
        add(txtCNIC);
        
           //fetch button
        /*JButton*/ fetchuser = new JButton(("Fetch User"));
        fetchuser.setBounds(380, 80, 120, 25);
        fetchuser.setBackground(new Color(0, 102, 204));
        fetchuser.setForeground(Color.WHITE);
        fetchuser.setFocusPainted(false);
        fetchuser.setCursor(new Cursor(Cursor.HAND_CURSOR)); // hand icon on hover
        add(fetchuser);
        fetchuser.addActionListener(this);
        
        // ------------- Hover Effect for Fetch User Button --------------
        fetchuser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                fetchuser.setBackground(new Color(0, 80, 180));
            }

            public void mouseExited(MouseEvent evt) {
                fetchuser.setBackground(new Color(0, 102, 204));
            }
        });
        
        
        // ---------------------- Passenger Info Labels ------------------
        
                  //name lebel
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60,130, 150, 25);
        lblname.setFont(new Font("Sagoe UI",Font.PLAIN,16));
        add(lblname);
        
        labelname = new JLabel();
        labelname.setBounds(220,130,150,25);
        add(labelname);
        
        
        
        // Nationality label
        
       JLabel lblnationality = new JLabel("Nationality");
       lblnationality.setBounds(60,180, 150, 25);
       lblnationality.setFont(new Font("Sagoe UI",Font.PLAIN,16));
       add(lblnationality);
       
       labelnationality = new JLabel();
       labelnationality.setBounds(220,180,150,25);
       add(labelnationality);
       
      
       
       
           
        // address
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(60,230,150,25);
        lbladdress.setFont(new Font("Sagoe UI",Font.PLAIN,16));
        add(lbladdress);
           
        labeladdress = new JLabel();
        labeladdress.setBounds(220,230,150,25);
        add(labeladdress);
        
        //gender
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(60,280,150,25);
        lblgender.setFont(new Font("Sagoe UI",Font.PLAIN,16));
        add(lblgender);
           
        
        labelgender = new JLabel();
        labelgender.setBounds(220,280,150,25);
        add(labelgender);
        
        
     
        
        //Source 
        
        JLabel lblsource = new JLabel("Source");
        lblsource.setBounds(60,330,150,25);
        lblsource.setFont(new Font("Sagoe UI",Font.PLAIN,16));
        add(lblsource);
        
        // Drop down that pick values from DB
               // DROP DOWN
        /*Choice*/ source = new Choice();
        source.setBounds(220,330,150,25);
        add(source);
        
        // destination
        JLabel lbldestination = new JLabel("Destination");
        lbldestination.setBounds(60,380,150,25);
        lbldestination.setFont(new Font("Sagoe UI",Font.PLAIN,16));
        add(lbldestination);
        
        // Drop down that pick values from DB
               // DROP DOWN
        /*Choice*/ destination = new Choice(); //awt library
        destination.setBounds(220,380,150,25);
        add(destination);
        
           // call db
           
        try {
            Connection_SQL c = new Connection_SQL();
            String query = "select * from flight";
            ResultSet rs = c.s.executeQuery(query);
            
            while(rs.next()) { // next() jumps rows one by one
                // .add() method adds values to drop down
                source.add(rs.getString("source")); // rs.getStrin resturn values from source table 
                destination.add(rs.getString("destination"));
                
            }
            
            
        } catch ( Exception e){   
            e.printStackTrace();
        }
         
         // -------------------- Fetch Flights Button ----------------------
         
        /*JButton*/ fetchflight = new JButton("Fetch flights");
        fetchflight.setBounds(380, 380, 120, 30);
        fetchflight.setBackground(new Color(0, 102, 204));
        fetchflight.setForeground(Color.WHITE);
        fetchflight.setFocusPainted(false);
        fetchflight.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(fetchflight);
        fetchflight.addActionListener(this);
        
         // Hover effect
        fetchflight.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                fetchflight.setBackground(new Color(0, 80, 180));
            }

            public void mouseExited(MouseEvent evt) {
                fetchflight.setBackground(new Color(0, 102, 204));
            }
        });
        
        
        // TO Book flight we need two more labels
        
        // Flight name 
        JLabel lblfname = new JLabel("Flight Name ");
        lblfname.setBounds(60,490,150,25);
        lblfname.setFont(new Font("Segoe UI",Font.PLAIN,16));
        add(lblfname);
           
        labelfname = new JLabel();
        labelfname.setBounds(220,490,150,25);
        add(labelfname);
        
        // Flight Code
        JLabel lblfcode = new JLabel("Flight Code");
        lblfcode.setBounds(60,540,150,25);
        lblfcode.setFont(new Font("Segoe UI",Font.PLAIN,16));
        add(lblfcode);
           
        labelfcode = new JLabel();
        labelfcode.setBounds(220,540,150,25);
        add(labelfcode);
        
        //// Flight Class label
         JLabel lblclass = new JLabel("Class");
         lblclass.setBounds(60, 430, 150, 25);
         lblclass.setFont(new Font("Segoe UI", Font.PLAIN, 16));
         add(lblclass);
         
         // CHOICE TO SELECT BUSINESS OR ECONOMY
         flightClass = new Choice();    
         flightClass.setBounds(220, 430, 150, 25);
         flightClass.add("Economy");
         flightClass.add("Business");
         add(flightClass);         
         
        
        // Date o ffliht 
        JLabel lbldate = new JLabel("Date of Travel");
        lbldate.setBounds(60,590,150,25);
        lbldate.setFont(new Font("Segoe UI",Font.PLAIN,16));
        add(lbldate);
           
        /*JDateChooser*/ dcdate = new JDateChooser(); //JDateChooer class will show date
        dcdate.setBounds(220,590,150,25);
        add(dcdate);
      
        
        // ---------------------- Decorative Image -------------------------
        
        // Image Icon
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airline_management_system/icons/details.jpg"));
        // we want to scale the image icon i1 // do it using Imae class and its functions
        Image i2 = i1.getImage().getScaledInstance(450, 320, Image.SCALE_DEFAULT);
         // image class objct cant be put in JLabel so chane it ImageIcon
        ImageIcon image = new ImageIcon(i2); // passed image objct to ImageIcOn
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(550,80,500,410);
        add(lblimage);
        
        // ---------------------- Book Flight Button ------------------------

        
        // we Need BOOk fliht Button
        /*JButton*/ bookflight = new JButton("Book Flight");
        bookflight.setBounds(290, 700, 150, 30);
        bookflight.setBackground(new Color(34, 139, 34)); // Green
        bookflight.setForeground(Color.WHITE);
        bookflight.setFocusPainted(false);
        bookflight.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bookflight.addActionListener(this);
        add(bookflight);
        
         // Hover effect
        bookflight.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                bookflight.setBackground(new Color(0, 128, 0));
            }

            public void mouseExited(MouseEvent evt) {
                bookflight.setBackground(new Color(34, 139, 34));
            }
        });
        
        // Price Label
        JLabel lblprice = new JLabel("Price");
        lblprice.setBounds(60, 640, 150, 25);
        lblprice.setFont(new Font("Sagoe UI", Font.PLAIN, 16));
        add(lblprice);

        labelprice = new JLabel();
        labelprice.setBounds(220, 640, 150, 25);
        add(labelprice);
       
       
       
       
       
       
       setVisible(true);
     setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

       
       
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
      if(ae.getSource() == fetchuser){  // if fetchuser button is pressed then we will get user data
            //get value from text fields using gettext()
            String CNIC = txtCNIC.getText();

            try {
                Connection_SQL c = new Connection_SQL();// create an object of Connection_SQL class to establish connection to the database
                  // insert Query
                String query =  "select * from passenger where CNIC = '"+CNIC+"' ";

                ResultSet rs = c.s.executeQuery(query); // executing Qury nd get result
                
                if(rs.next()) {
                    labelname.setText(rs.getString("Name"));  //setText sets text which rs.getString() gets from database
                    labelnationality.setText(rs.getString("Nationality"));
                    labeladdress.setText(rs.getString("Address"));
                    labelgender.setText(rs.getString("Gender"));
                    
                } else {
                    JOptionPane.showMessageDialog(null," User Does Not Exist");//show msg
                }

            } catch (Exception e){
                e.printStackTrace(); // print error stack in case of error 
            }
            
            // if ends here
        
      } else if(ae.getSource() == fetchflight){  // if fetchfliht button is pressed then we will get user data
            //get value from drop downs using getselected()
            String src = source.getSelectedItem(); //item you select from source dropdown is strord in src
            String dst = destination.getSelectedItem();
            
            
            // It checks if source and destination are the same or not
            if (src.equals(dst)) {
                JOptionPane.showMessageDialog(null, "Source and destination cannot be the same.");
                return;
              }
         // 👇 Class-based pricing
            Random random = new Random();


        String cls = (String) flightClass.getSelectedItem();  // Cast to String
        int price;

        if ("Economy".equals(cls)) {
            price = 10_000 + random.nextInt(5_000);  // 10,000 - 14,999
        } else if ("Business".equals(cls)) {
            price = 30_000 + random.nextInt(10_000); // 30,000 - 39,999
         }  else {
            price = 15_000 + random.nextInt(5_000);  // fallback
         }

         labelprice.setText("Rs. " + price);  // Show in GUI

            try {
                Connection_SQL c = new Connection_SQL();// create an object of Connection_SQL class to establish connection to the database
                  // insert Query
                String query =  "select * from flight where Source = '"+src+"' and Destination = '"+dst+"' ";

                ResultSet rs = c.s.executeQuery(query); // executing Qury nd get result
                
                if(rs.next()) {
                    labelfname.setText(rs.getString("Flight_name"));  //setText sets text which rs.getString() gets from database
                    labelfcode.setText(rs.getString("Flight_code"));
                    
                } else {
                    JOptionPane.showMessageDialog(null," No Flights");//show msg
                }
                
                

            } catch (Exception e){
                e.printStackTrace(); // print error stack in case of error 
            }
      
           /// ele if ends here
      
      } else {
          // generate Random Nmbr using Randon class
        Random random = new Random(); // from util library   
          
          //get value from text fields using gettext()
        String name = labelname.getText();
        String nationality = labelnationality.getText();
        String address = labeladdress.getText();
        String CNIC = txtCNIC.getText();
        String flightname = labelfname.getText();
        String flightcode = labelfcode.getText();
        String src = source.getSelectedItem(); // drop downs
        String dst = destination.getSelectedItem();
        String fclass = flightClass.getSelectedItem();
        String price = labelprice.getText();
        // get date from dcdate that we choose on ui
        String ddate = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
        // GetText() method works on JTextField so Type dcdate into JTextField
        //Choose a DateEditor() method and use its UIComponent
        
        // this is to comform booking
        int confirm = JOptionPane.showConfirmDialog(
                null,
                 "Do you want to confirm this booking?", //Message shown to the user
                 "Booking Confirmation",                 //Title of the dialog window
                 JOptionPane.YES_NO_OPTION
         );
        
        
        if (confirm != JOptionPane.YES_OPTION) {
            return; // Stop booking if user clicks "No"
        }
        try {
            Connection_SQL c = new Connection_SQL();// create an object of Connection_SQL class to establish connection to the database
            
                  // insert Query
            String query =  "insert into reservation values ('PNR-"+random.nextInt(1000000)+"' , 'TIC-"+random.nextInt(10000)+"', '"+CNIC+"' , '"+name+"' , '"+nationality+"' , '"+flightname+"' , '"+flightcode+"' , '"+src+"' , '"+dst+"' , '"+ddate+"' , '"+fclass+"' , '"+price+"' ) ";

            c.s.executeUpdate(query); // executing Qury 
                
            
            JOptionPane.showMessageDialog(null," Ticket Book Successful");//show msg
            
  
        }   catch (Exception e){
                e.printStackTrace(); // print error stack in case of error 
            }      
      
      
      }
    
     

    
    }
    
    
//}    
    public static void main(String[] args){
        
        new BookFlight();
        
    
    
    }
}