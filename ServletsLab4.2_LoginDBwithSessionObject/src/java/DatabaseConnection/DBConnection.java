/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseConnection;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author May
 */
public class DBConnection {
    
    //Create properties file
    public DBConnection()
    {
        Properties properties = new Properties();
        OutputStream output = null;
    
        try {
            output = new FileOutputStream("C:\\Users\\May\\Documents\\NetBeansProjects\\Servlets Course Labs\\ServletsLab3.1_LoginwithDB\\db.properties");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    
        properties.setProperty("MYSQL_DB_URL", "jdbc:mysql://localhost:3306/logindb?allowPublicKeyRetrieval=true&useSSL=false");
        properties.setProperty("USERNAME", "root");
        properties.setProperty("PASSWORD","root");
        
        try {
            properties.store(output, null);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        finally{
            if(output != null)
            {
                try {
                    output.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
        
        
    }
    
    
}
