/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoesauction.Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import shoesauction.Helper.Helper;
import shoesauction.Model.MainModel;
import shoesauction.Query.MainQuery;

/**
 *
 * @author Dhimas N A
 */
public class MainController extends BaseController {
    Helper helper = new Helper();
    MainQuery query = new MainQuery();
    
    public boolean register(MainModel model) throws ParseException{
        Map <Integer, Object> map = new HashMap<>();
        map.put(1, model.getEmail());
        map.put(2, model.getUsername());
        map.put(3, model.getPassword());
        
        String sql = this.query.register;
        
        return this.preparedStatement(map, sql);
    }
    
    public ResultSet login(MainModel model) throws ParseException, SQLException{
        Map<Integer, Object> map = new HashMap<>();
        map.put(1, model.getUsername());
        map.put(2, model.getPassword());
        
        String sql = this.query.login;
        
        return this.getWithParamater(map, sql);
    }
    
    public String usersID (String username, String password, String usersID) throws SQLException{ //pencarian bedasarkan ID
     String sql = this.query.login;
     
     Map<Integer, Object>map = new HashMap<>();
     map.put(1, username);
    map.put(2, password);
	 
	 ResultSet rs = this.getWithParamater(map, sql);
	 
	 if (rs.next()) {
			usersID = rs.getString("username");
		}

		return usersID;
	}
    
    
    
    public boolean createTransaction (MainModel model) throws ParseException{
        Map <Integer, Object> map = new HashMap<>();
        map.put(1, model.getId_transaction());
        map.put(2, model.getId_bid());
        map.put(3, model.getId_product());
        map.put(4, model.getUsername());
        map.put(5, model.getTotal());
        map.put(6, model.getTotal_bid());
        String sql = this.query.createTransaction;
        
        return this.preparedStatement(map, sql);
    }
    
    public boolean updateTransaction(String id, MainModel model) throws ParseException {
        Map <Integer, Object> map = new HashMap<>();
        map.put(1, model.getId_transaction());
        map.put(2, model.getId_bid());
        map.put(3, model.getId_product());
        map.put(4, model.getUsername());
        map.put(5, model.getTotal());
        map.put(6, model.getTotal_bid());
        map.put(7, id);
        
        String sql = this.query.updateTransaction;
        
        return this.preparedStatement(map, sql);
    }
    
    public boolean deleteTransaction(String id) throws ParseException{
        Map<Integer, Object> map = new HashMap<>();
        map.put(1, id);
        
        String sql = this.query.deleteTransaction;
        
        return this.preparedStatement(map, sql);
    }
    
    
    public boolean createProduct(MainModel model) throws ParseException{
        String date = helper.parseDateToString(model.getStart_date());
        String date2 = helper.parseDateToString(model.getEnd_date());
        
        Map <Integer, Object> map = new HashMap<>();
        map.put(1, model.getId_product());
        map.put(2, model.getName_product());
        map.put(3, model.getStock_product());
        map.put(4, model.getStart_bid());
        map.put(5, date);
        map.put(6, date2);
        String sql = this.query.createProduct;
        
        return this.preparedStatement(map, sql);
    }
    
    public boolean updateProduct(String id, MainModel model) throws ParseException {
        String date = helper.parseDateToString(model.getStart_date());
        String date2 = helper.parseDateToString(model.getEnd_date());
        
        Map <Integer, Object> map = new HashMap<>();
        map.put(1, model.getName_product());
        map.put(2, model.getStock_product());
        map.put(3, model.getStart_bid());
        map.put(4, date);
        map.put(5, date2);
        map.put(6, id);
        
        String sql = this.query.updateProduct;
        
        return this.preparedStatement(map, sql);
    }
    
    public boolean deleteProduct(String id) throws ParseException{
        Map<Integer, Object> map = new HashMap<>();
        map.put(1, id);
        
        String sql = this.query.deleteProduct;
        
        return this.preparedStatement(map, sql);
    }
    
    
    public boolean createBid(MainModel model) throws ParseException{
        Map <Integer, Object> map = new HashMap<>();
        map.put(1, model.getId_bid());
        map.put(2, model.getId_product());
        map.put(3, model.getTotal_bid());
        map.put(4, model.getUsername());
        String sql = this.query.createBid;
        
        return this.preparedStatement(map, sql);
    }
    
    public boolean updateBid(MainModel model) throws ParseException {
        Map <Integer, Object> map = new HashMap<>();
        map.put(1, model.getId_bid());
        map.put(2, model.getId_product());
        map.put(3, model.getTotal_bid());
        map.put(4, model.getUsername());
        String sql = this.query.updateBid;
        
        return this.preparedStatement(map, sql);
    }
    
    public boolean deleteBid(MainModel model) throws ParseException {
        Map <Integer, Object> map = new HashMap<>();
        map.put(1, model.getId_bid());
        
        String sql = this.query.deleteBid;
        
        return this.preparedStatement(map, sql);
    }
    
    public ResultSet getBid(){
        String sql = this.query.getBid;
        return this.get(sql);
    }
    
    public ResultSet getProduct(){
        String sql = this.query.getProduct;
        return this.get(sql);
    }
    
    public ResultSet getTransaction(){
        String sql = this.query.getTransaction;
        return this.get(sql);
    }
    
    public ResultSet showById(String id){
        String sql = this.query.showById;
        
        Map<Integer, Object> map = new HashMap<>();
        map.put(1, id);
        
        return this.getWithParamater(map, sql);
    }
    
    public ResultSet showByName(String name){
        String sql = this.query.showByName;
        
        Map<Integer, Object> map = new HashMap<>();
        map.put(1, helper.parseLikeQuery(name));
        
        return this.getWithParamater(map, sql);
    }
}
