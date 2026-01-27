/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airline_management_system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils; // pkg in jar file 
import java.awt.event.*;


public class JourneyDetails extends JFrame implements ActionListener  {
    
    //globally declaring Jtable
    JTable table;
    //globally declaring JTextField
    JTextField txtpnr;
    JButton show;
    
    public JourneyDetails(){
        
        
        
        setSize(820,500);
        setLocation(400,150);
        // to Change frame color
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        // we will get Journey details Using pnr nmbr
        
        JLabel lblpnr = new JLabel("PNR DETAILS");
        lblpnr.setFont(new Font("Tahoma", Font.PLAIN,16));
        lblpnr.setBounds(50,50,100,25);
        add(lblpnr);
        
        txtpnr = new JTextField();
        txtpnr.setBounds(160,50,100,25);
        add(txtpnr);
        
        // show detials on button click
        
        show = new JButton("Show Details");
        show.setBackground(Color.BLACK);
        show.setForeground(Color.WHITE);
        show.setBounds(290,50,120,25);
        show.addActionListener(this);
        add(show);
        
        
        // --->>> SHOWING DATA IN TABULAR FORM <<<----
        
        
        table =  new JTable();
        table.setFont(new Font("Segoe UI", Font.PLAIN, 13)); // Same styling as above
   
        /// --->>> ADDING SCROLL BAR <<<<---- //
        JScrollPane jsp = new JScrollPane(table); // pass table
        jsp.setBounds(0,100,810,150);
        add(jsp);
        
  
        setVisible(true);
        
         setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


    
    
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae){
        
        try {
            Connection_SQL c = new Connection_SQL();
            
            ResultSet rs = c.s.executeQuery("select * from reservation where PNR = '"+txtpnr.getText()+"' ");
            // to check if pnr exits or not
            if(!rs.isBeforeFirst()){
                JOptionPane.showMessageDialog(null, "NO Information Found");
                return;
            }
            table.setModel(DbUtils.resultSetToTableModel(rs)); // DbUtils is a class that has fucntion resultsettotablemodel
            // then we put the data in table objct using setModel method
            
            
        } catch (Exception e){
            e.printStackTrace();
        }
        
       
    
    } 
    
    
//}
    
    
    
    
    
    public static void main(String[] args){
        
        new JourneyDetails();
    
    
    
    }
    
}
