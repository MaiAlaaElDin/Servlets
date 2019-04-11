/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseConnection;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

/**
 *
 * @author May
 */
public class MyDataSourceFactory {
    
    public static DataSource getMySQLDataSource()
    {
        Properties properties = new Properties();
        FileInputStream fileInput = null;
        MysqlDataSource mySqlDataSource = null;
        
        try{
            mySqlDataSource = new MysqlDataSource();
            fileInput = new FileInputStream("C:\\Users\\May\\Documents\\NetBeansProjects\\Servlets Course Labs\\ServletsLab4.2_LoginDBwithSessionObject\\db.properties");
            properties.load(fileInput);
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        mySqlDataSource.setURL(properties.getProperty("MYSQL_DB_URL"));
        mySqlDataSource.setUser(properties.getProperty("USERNAME"));
        mySqlDataSource.setPassword(properties.getProperty("PASSWORD"));
        
        return mySqlDataSource;
    }
    
    
    
    
}
