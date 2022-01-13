/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoesauction.Query;
/**
 *
 * @author Dhimas N A
 */
public class MainQuery {
    public String register = "INSERT INTO database_pengguna (email, username, password) values (?,?,?)";
    public String login = "SELECT * FROM database_pengguna WHERE username = ? AND password = ?";
    
    public String createBid = "INSERT INTO database_bid (id_bid, id_product, total_bid, username) values (?,?,?,?)";
    public String updateBid = "UPDATE database_bid SET id_product = ?, total_bid = ?, username = ? WHERE id_bid =?";
    public String deleteBid = "DELETE FROM database_bid WHERE id_bid = ?";
    
    public String createProduct = "INSERT INTO database_product (id_product, nama_product, stock, start_bid, start_date, end_date) VALUES (?,?,?,?,?,?)";
    public String updateProduct = "UPDATE database_product SET nama_product = ?, stock = ?, start_bid = ?, start_date = ?, end_date = ? WHERE id_product =? ";
    public String deleteProduct = "DELETE FROM database_product WHERE id_product = ?";
    
    public String createTransaction = "INSERT INTO database_transaksi (id_transaksi, id_bid, id_product, username, jumlah, end_bid) VALUES (?,?,?,?,?,?)";
    public String updateTransaction = "UPDATE database_transaksi SET id_bid = ?, id_product = ?, username = ?, jumlah = ?, end_bid =? WHERE id_transaksi =?";
    public String deleteTransaction ="DELETE FROM database_transaksi WHERE id_transaksi = ?";
    
    public String getBid = "SELECT * FROM database_bid";
    public String getProduct = "SELECT * FROM database_product";
    public String getTransaction = "SELECT * FROM database_transaksi";
    
    public String showById = "SELECT * FORM database_bid WHERE id = ?";
    public String showByName = "SELECT * FROM database_bid WHERE name LIKE ?";    
    
    public String createIDproduct = "SELECT * FROM database_product ORDER by id_product DESC";
    public String createIDbid = "SELECT * FROM database_bid ORDER by id_bid DESC";
    public String createIDtransaction = "SELECT * FROM database_transaksi ORDER by id_transaksi DESC";
    
    public String cb_product = "select id_product from database_product order by id_product asc";
    public String getUsername = "select username from database_pengguna order by username asc";
}
