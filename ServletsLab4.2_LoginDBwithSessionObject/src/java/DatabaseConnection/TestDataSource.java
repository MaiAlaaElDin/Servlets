/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

/**
 *
 * @author May
 */
public class TestDataSource {

    DataSource myDataSource = null;
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    PreparedStatement preparedStatement = null;

    public  TestDataSource() {
        
            try {
                myDataSource = MyDataSourceFactory.getMySQLDataSource();
                connection = myDataSource.getConnection();
     
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

    }
    
    public Connection getConnection()
    {
        return connection;
    }

}
