/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoesauction.Controller;

import com.sun.rowset.CachedRowSetImpl;
import java.util.Map;
import java.sql.*;
import shoesauction.Connection.DBConnection;
/**
 *
 * @author Dhimas N A 
 */
public class BaseController {
    DBConnection koneksi = new DBConnection();
    
    public ResultSet getWithParamater (Map <Integer, Object> map, String sql){
        try{
            Connection con = koneksi.open();
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            for(Map.Entry <Integer,Object> entry : map.entrySet()){
                ps.setString(entry.getKey(), entry.getValue().toString());
            }
            
            ResultSet rs = ps.executeQuery();
            
            CachedRowSetImpl crs = new CachedRowSetImpl();
            crs.populate(rs);
            
            con.close();
            return crs;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public ResultSet get(String sql){
        try {
            Connection con = koneksi.open();
            
            Statement state = con.createStatement();
            ResultSet rs = state.executeQuery(sql);
            
            CachedRowSetImpl crs = new CachedRowSetImpl();
            crs.populate(rs);
            
            con.close();
            return crs;
        } 
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public boolean preparedStatement(Map<Integer, Object> map, String sql){
        try{
            Connection con = koneksi.open();
            PreparedStatement ps = con.prepareStatement(sql);
            
            for(Map.Entry<Integer, Object> entry : map.entrySet()){
                ps.setString(entry.getKey(), entry.getValue().toString());
            }
            
            int rows = ps.executeUpdate();
            con.close();
            return rows != 0;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
