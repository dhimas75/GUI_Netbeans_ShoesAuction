/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoesauction.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author Dhimas N A
 */
public class DBConnection {
    
    public Connection con;
    public Statement stm;
        
    public Connection open(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            String url = "jdbc:mysql://127.0.0.1/shoes";
            
            con = DriverManager.getConnection(url, "root", "");
            return con;
        }
        catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
}
