// same license and package imports...
package airline_management_system;
import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser; // clndr jar file to show chalander
import java.util.*; // to use math functions like Random

public class BoardingPass extends JFrame implements ActionListener {
    
    // Globally declarin  Lbales tht would get tht from database
    JLabel labelname, labelnationality,  labelFCode,labelFname , labelDateOfTravel,labelSource ,labelDestination, labelclass,labelprice;
    //Globally declaring TextFields
    JTextField txtPNR;
    //Globally declaring JButtons
    JButton bEnter;
    
    public BoardingPass(){
        
        setSize(1000,550);//setSize(width, height) to set the size of the frame
        setLocation(300,150); //setLocation(distance from left , distance from top) to set the location of the frame
        
        // to Change frame color
        getContentPane().setBackground(Color.WHITE);//in setBackground() we can use color class to set the color that belongs to java.awt package
        setLayout(null);

        // Background image
        ImageIcon bgIcon = new ImageIcon(ClassLoader.getSystemResource("airline_management_system/icons/front.png"));
        Image bgImg = bgIcon.getImage().getScaledInstance(1000, 550, Image.SCALE_SMOOTH);
        JLabel background = new JLabel(new ImageIcon(bgImg));
        background.setBounds(0, 0, 1000, 550);
        add(background);

        // Panel for content
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(0, 0, 0, 180)); // 90% transparent black
        panel.setBounds(30, 30, 920, 470);
        panel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
        background.add(panel);
        
        // ------>>>>>> LABELING THE FRANE <<<<<<<------
        JLabel heading = new JLabel("9/11 Maqsad Air Lines");
        heading.setBounds(320,10,450,35);// setBounds(x, y, width, height)
        heading.setFont(new Font("Tahoma",Font.BOLD,32));//setFont(Font Objct.(family,type,size))
        heading.setForeground(Color.RED);// text color
        panel.add(heading);// add() method adds the label on the frame
        
        JLabel subheading = new JLabel("Fly Straight into Buildings");
        subheading.setBounds(300,50,400,30);// setBounds(x, y, width, height)
        subheading.setFont(new Font("Tahoma",Font.BOLD,20));
        subheading.setForeground(Color.RED);
        panel.add(subheading);
        
        // PNR nmbr 
        JLabel lblPNR = new JLabel("PNR number");
        lblPNR.setBounds(60,100,150,25);
        lblPNR.setFont(new Font("Tahoma", Font.PLAIN,16));
        lblPNR.setForeground(Color.WHITE);
        panel.add(lblPNR);
           
        txtPNR = new JTextField();
        txtPNR.setBounds(220,100,150,25);
        panel.add(txtPNR);

        bEnter = new JButton("Enter");
        bEnter.setBackground(new Color(0, 0, 0));
        bEnter.setForeground(Color.WHITE);
        bEnter.setBounds(380,100,120,25);
        bEnter.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        bEnter.setFocusPainted(false);
        panel.add(bEnter);
        bEnter.addActionListener(this);
        
        //name lebel
        JLabel lblname = new JLabel("NAME");
        lblname.setBounds(60,140, 150, 25);
        lblname.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblname.setForeground(Color.WHITE);
        panel.add(lblname);
        
        labelname = new JLabel();
        labelname.setBounds(220,140,150,25);
        labelname.setOpaque(true);
        labelname.setBackground(Color.BLACK);
        labelname.setForeground(Color.WHITE);
        panel.add(labelname);
        
        // Nationality label
        JLabel lblnationality = new JLabel("NATIONALITY");
        lblnationality.setBounds(60,180, 150, 25);
        lblnationality.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblnationality.setForeground(Color.WHITE);
        panel.add(lblnationality);
       
        labelnationality = new JLabel();
        labelnationality.setBounds(220,180,150,25);
        labelnationality.setOpaque(true);
        labelnationality.setBackground(Color.BLACK);
        labelnationality.setForeground(Color.WHITE);
        panel.add(labelnationality);
       
        // Source 
        JLabel lblsource = new JLabel("SOURCE");
        lblsource.setBounds(60,230,150,25);
        lblsource.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblsource.setForeground(Color.WHITE);
        panel.add(lblsource);
        
        labelSource = new JLabel();
        labelSource.setBounds(220,230,150,25);
        labelSource.setOpaque(true);
        labelSource.setBackground(Color.BLACK);
        labelSource.setForeground(Color.WHITE);
        panel.add(labelSource);
        
        // destination
        JLabel lbldestination = new JLabel("DESTINATION");
        lbldestination.setBounds(400,230,150,25);
        lbldestination.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbldestination.setForeground(Color.WHITE);
        panel.add(lbldestination);
        
        labelDestination = new JLabel();
        labelDestination.setBounds(560,230,150,25);
        labelDestination.setOpaque(true);
        labelDestination.setBackground(Color.BLACK);
        labelDestination.setForeground(Color.WHITE);
        panel.add(labelDestination);
        
        // Flight name 
        JLabel lblfname = new JLabel("Flight Name ");
        lblfname.setBounds(60,280,150,25);
        lblfname.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblfname.setForeground(Color.WHITE);
        panel.add(lblfname);
           
        labelFname = new JLabel();
        labelFname.setBounds(220,280,150,25);
        labelFname.setOpaque(true);
        labelFname.setBackground(Color.BLACK);
        labelFname.setForeground(Color.WHITE);
        panel.add(labelFname);
        
        // Flight Code
        JLabel lblFlightCode = new JLabel("Flight Code");
        lblFlightCode.setBounds(400,280,150,25);
        lblFlightCode.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblFlightCode.setForeground(Color.WHITE);
        panel.add(lblFlightCode);
           
        labelFCode = new JLabel();
        labelFCode.setBounds(560,280,150,25);
        labelFCode.setOpaque(true);
        labelFCode.setBackground(Color.BLACK);
        labelFCode.setForeground(Color.WHITE);
        panel.add(labelFCode);
          
        //Date of Travel
        JLabel lbldate = new JLabel("Date of Travel");
        lbldate.setBounds(60,320,150,25);
        lbldate.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbldate.setForeground(Color.WHITE);
        panel.add(lbldate);
        
        labelDateOfTravel = new JLabel();
        labelDateOfTravel.setBounds(220,320,150,25);
        labelDateOfTravel.setOpaque(true);
        labelDateOfTravel.setBackground(Color.BLACK);
        labelDateOfTravel.setForeground(Color.WHITE);
        panel.add(labelDateOfTravel);
        
        //// Class
        JLabel lblClass = new JLabel("CLASS");
        lblClass.setBounds(400, 140, 150, 25);
        lblClass.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblClass.setForeground(Color.WHITE);
        panel.add(lblClass);

        labelclass = new JLabel();
        labelclass.setBounds(560, 140, 150, 25);
        labelclass.setOpaque(true);
        labelclass.setBackground(Color.BLACK);
        labelclass.setForeground(Color.WHITE);
        panel.add(labelclass);
        
        // Price
        JLabel lblPrice = new JLabel("PRICE");
        lblPrice.setBounds(400, 180, 150, 25);
        lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblPrice.setForeground(Color.WHITE);
        panel.add(lblPrice);

        labelprice = new JLabel();
        labelprice.setBounds(560, 180, 150, 25);
        labelprice.setOpaque(true);
        labelprice.setBackground(Color.BLACK);
        labelprice.setForeground(Color.WHITE);
        panel.add(labelprice);        
        
        // Image Icon
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airline_management_system/icons/cancel.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 130, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(i2);
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(720,15,200,150);
        panel.add(lblimage);
       
        setVisible(true); 
         setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == bEnter ){  // if fetchuser button is pressed then we will get user data
            //get value from text fields using gettext()
            String PNR = txtPNR.getText();

            try {
                Connection_SQL c = new Connection_SQL();// create an object of Connection_SQL class to establish connection to the database
                String query =  "select * from reservation where PNR = '"+PNR+"' ";
                ResultSet rs = c.s.executeQuery(query); // executing Qury nd get result
                
                if(rs.next()) {
                    labelname.setText(rs.getString("Name"));  //setText sets text which rs.getString() gets from database
                    labelFCode.setText(rs.getString("Flight_code"));
                    labelFname.setText(rs.getString("Flight_name"));
                    labelnationality.setText(rs.getString("Nationality"));
                    labelDateOfTravel.setText(rs.getString("Date"));
                    labelSource.setText(rs.getString("Source"));
                    labelDestination.setText(rs.getString("Destination"));
                    labelclass.setText(rs.getString("class"));
                    labelprice.setText(rs.getString("Price"));
                    
                } else {
                    JOptionPane.showMessageDialog(null," User Does Not Exist");//show msg
                }

            } catch (Exception e){
                e.printStackTrace(); // print error stack in case of error 
            }
        }
       
    }
    
    
    
}
//    public static void main(String[] args){
//        new BoardingPass();
//    }
//}
