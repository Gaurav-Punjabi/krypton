/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author gauravpunjabi
 */
public class MySqlConnect {
        public static Connection connectDB(){
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/krypton","Gaurav", "password");
            return conn;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Connection Unsuccesfull" + e.getMessage(),"Connection",JOptionPane.ERROR_MESSAGE);
            return null;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Some error message"+e.getMessage(),"Connection",JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
