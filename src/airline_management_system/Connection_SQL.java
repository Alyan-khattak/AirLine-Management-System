/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airline_management_system;

import java.sql.*; // Importing the SQL package to work with SQL databases


public class Connection_SQL {

    // This class is used to establish a connection to the SQL database
    Connection c;
    Statement s;
    
    
    

    public Connection_SQL(){
        // Constructor to establish a connection to the database
        try {
          
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/AirLine_Managment_System","root","bankai1234567890");
            s = c.createStatement(); 
            
            
            

        } catch (Exception e) {
            // Handle exceptions related to database connection
            e.printStackTrace();
        }
    }
    


}
 