/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Ali Magdy
 */
public class DataBaseConnection {
    
     public static Connection connectDb(){
        
        try{
            
            Class.forName("oracle.jdbc.driver.OracleDriver");
            
            Connection connect = DriverManager.getConnection("jdbc:Oracle:thin:@localhost:1521:xe", "university", "root");
            return connect;
        }catch(Exception e){e.printStackTrace();}
        return null;
    }
    
}


