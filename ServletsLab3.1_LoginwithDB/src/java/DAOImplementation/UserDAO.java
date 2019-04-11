/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOImplementation;

import DatabaseConnection.TestDataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author May
 */
public class UserDAO {

    Statement statement;
    String queryString;
    ResultSet resultSet;
    boolean check;

    public UserDAO() {
        try {
            statement = new TestDataSource().getConnection().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean validateUserLogin(String username, String password) {
        try {
            queryString = "select * from user";
            resultSet = statement.executeQuery(queryString);
            
            while(resultSet.next())
            {
                System.out.println(resultSet.getString("username"));
                System.out.println(resultSet.getString("password"));
                
                //////////////////////
                if(username.equals(resultSet.getString("username")) && password.equals(resultSet.getString("password")))
                {
                    check = true;
                }
                else{
                    check = false;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }

}
