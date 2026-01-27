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




public class CancelTicket extends JFrame implements ActionListener {
    
    // Globally declarin  Lbales tht would get tht from database
    JLabel labelname, labellblCancellationNmr, labelFCode, labelDateOfTravel,labelSource ,labelDestination;
    //Globally declaring TextFields
    JTextField txtPNR;
    //Globally declaring JButtons
    JButton Cancelflight,fetchDetails;

    
    JRadioButton rbmale,rbfemale;
    
    public CancelTicket(){
        
        setSize(850,520);//setSize(width, height) to set the size of the frame
        setLocation(350,200); //setLocation(distance from left , distance from top) to set the location of the frame
        
        // to Change frame color
        getContentPane().setBackground(Color.WHITE);//in setBackground() we can use color class to set the color that belongs to java.awt package
        // SetBackground(Color) sets the background color if want to set in RGB format then use setBackground(new Color(r,g,b)) where r,g,b are integers from 0 to 255
        
        setLayout(null);
        
        // ------>>>>>> LABELING THE FRANE <<<<<<<------
        
        JLabel heading = new JLabel("CANCELLATION ('.') ");
        heading.setBounds(180,20,300,35);// setBounds(x, y, width, height)
         heading.setFont(new Font("Segoe UI", Font.BOLD, 30));//setFont(Font Objct.(family,type,size))
        heading.setForeground(new Color(0, 51, 102));// text color
        add(heading);// add() method adds the label on the frame
        
        
        // PNR nmbr -->>>  search through PNR nmbr
        JLabel lblPNR = new JLabel("PNR number");
        lblPNR.setBounds(60,80,150,25);
        lblPNR.setFont(new Font("Segoe UI", Font.PLAIN,16));
        add(lblPNR);
           
        /*JTextField*/ txtPNR = new JTextField();
        txtPNR.setBounds(220,80,150,25);
        txtPNR.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        add(txtPNR);
        
           //fetch button
        /*JButton*/ fetchDetails = new JButton(("Show Details"));
        fetchDetails.setFocusPainted(false);
        fetchDetails.setBackground(new Color(0, 51, 102));
        fetchDetails.setForeground(Color.WHITE);
        fetchDetails.setFont(new Font("Segoe UI", Font.BOLD, 14));
        fetchDetails.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        fetchDetails.setBounds(380,80,150,25);
        add(fetchDetails);
        fetchDetails.addActionListener(this);
        
        
        
                  //name lebel
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60,130, 150, 25);
        lblname.setFont(new Font("Segoe UI",Font.PLAIN,16));
        add(lblname);
        
        labelname = new JLabel();
        labelname.setBounds(220,130,150,25);
        labelname.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        add(labelname);
        
        
        
        // Cancellation label  (generate a unique cancellation nmbr for future refrence)
        
       JLabel lblCancellation = new JLabel("Cancellation Number");
       lblCancellation.setBounds(60,180, 150, 25);
       lblCancellation.setFont(new Font("Segoe UI",Font.PLAIN,16));
       add(lblCancellation);
       
       // generate Random Nmbr using Randon class
        Random random = new Random(); // from util library 
       
       labellblCancellationNmr = new JLabel("" + random.nextInt(100000)); //JLabel takes only string so concate it with an empty string 
       labellblCancellationNmr.setBounds(220,180,150,25);
       labellblCancellationNmr.setFont(new Font("Segoe UI", Font.PLAIN, 14));
       add(labellblCancellationNmr);
       
      
       
       
           
        // Flight Code
        JLabel lblFlightCode = new JLabel("Flight Code");
        lblFlightCode.setBounds(60,230,150,25);
        lblFlightCode.setFont(new Font("Segoe UI",Font.PLAIN,16));
        add(lblFlightCode);
           
        labelFCode = new JLabel();
        labelFCode.setBounds(220,230,150,25);
        labelFCode.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        add(labelFCode);
        
        //Date of Travel
        JLabel lbldate = new JLabel("Date of Travel");
        lbldate.setBounds(60,280,150,25);
        lbldate.setFont(new Font("Segoe UI",Font.PLAIN,16));
        add(lbldate);
           
        
        labelDateOfTravel = new JLabel();
        labelDateOfTravel.setBounds(220,280,150,25);
        labelDateOfTravel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        add(labelDateOfTravel);
        
        
     
        
        //Source 
        
        JLabel lblsource = new JLabel("Source");
        lblsource.setBounds(60,330,150,25);
        lblsource.setFont(new Font("Sagoe UI",Font.PLAIN,16));
        add(lblsource);
        
        labelSource = new JLabel();
        labelSource.setBounds(220,330,150,25);
        labelSource.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        add(labelSource);
        
        
        
        
        
        // destination
        JLabel lbldestination = new JLabel("Destination");
        lbldestination.setBounds(60,380,150,25);
        lbldestination.setFont(new Font("Sagoe UI",Font.PLAIN,16));
        add(lbldestination);
        
        labelDestination = new JLabel();
        labelDestination.setBounds(220,380,150,25);
        labelDestination.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        add(labelDestination);
        
        
       
         
         // Cancel Fligjt BUTTON 
         
        /*JButton*/ Cancelflight = new JButton("Cancel");
        Cancelflight.setFocusPainted(false);
        Cancelflight.setBackground(new Color(0, 51, 102));
        Cancelflight.setForeground(Color.WHITE);
        Cancelflight.setFont(new Font("Segoe UI", Font.BOLD, 14));
        Cancelflight.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Cancelflight.setBounds(380,380,120,30);
        add(Cancelflight);
        Cancelflight.addActionListener(this);
        
       
        // Image Icon
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airline_management_system/icons/cancel.jpg"));
        // we want to scale the image icon i1 // do it using Imae class and its functions
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
         // image class objct cant be put in JLabel so chane it ImageIcon
        ImageIcon image = new ImageIcon(i2); // passed image objct to ImageIcOn
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(470,120,250,250);
        add(lblimage);
       
         
       
       
       setVisible(true);
       setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

       
       
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
      if(ae.getSource() == fetchDetails){  // if fetchDetails button is pressed then we will get user data
            //get value from text fields using gettext()
            String PNR = txtPNR.getText();

            try {
                Connection_SQL c = new Connection_SQL();// create an object of Connection_SQL class to establish connection to the database
                  // insert Query
                String query =  "select * from reservation where PNR = '"+PNR+"' ";

                ResultSet rs = c.s.executeQuery(query); // executing Qury nd get result
                
                if(rs.next()) {
                    labelname.setText(rs.getString("Name"));  //setText sets text which rs.getString() gets from database
                    labelFCode.setText(rs.getString("Flight_code"));
                    labelDateOfTravel.setText(rs.getString("Date"));
                    labelSource.setText(rs.getString("Source"));
                    labelDestination.setText(rs.getString("Destination"));
                    
                } else {
                    JOptionPane.showMessageDialog(null," Please Enter Correct PNR Numer");//show msg
                }

            } catch (Exception e){
                e.printStackTrace(); // print error stack in case of error 
            }
            
            // if ends here
        
      } else if(ae.getSource() == Cancelflight){  // if cancel button is pressed then ticket will be cancelled 
            //get values from JLabels using getText()
            String name = labelname.getText(); 
            String pnr = txtPNR.getText();
            String cancelno = labellblCancellationNmr.getText();
            String fcode = labelFCode.getText();
            String date = labelDateOfTravel.getText();
            String src = labelSource.getText(); 
            String dst = labelDestination.getText();

            try {
                Connection_SQL c = new Connection_SQL();// create an object of Connection_SQL class to establish connection to the database
                  // insert Query
                String query =  "insert into cancel values  ('"+pnr+"' , '"+name+"' , '"+cancelno+"' , '"+fcode+"' , '"+src+"' , '"+dst+"' , '"+date+"')  ";

                c.s.executeUpdate(query); // Upadating the DB
                
                // if ticket cancel then we'll have to remove that info from reservation table
                c.s.executeUpdate("delete from reservation where PNR = '"+pnr+"' ");
                
                JOptionPane.showMessageDialog(null," Ticket Cancelled");//show msg
                setVisible(false);
                
                
                

            } catch (Exception e){
                e.printStackTrace(); // print error stack in case of error 
            }
      
                 
      
      
      }
    
    
    

    }
    
    
}    
    
//    public static void main(String[] args){
//        
//        new CancelTicket();
//        
//    
//    
//    }
//}
