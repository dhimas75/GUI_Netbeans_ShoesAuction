/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoesauction.Model;

import java.util.Date;

/**
 *
 * @author Dhimas N A
 */
public class MainModel {
    public String email;
    public String username;
    public String password;
    
    public String id_bid;
    public String total_bid;
    
    public String id_transaction;
    public String total;
    
    public String id_product;
    public String name_product;
    public String stock_product;
    public String start_bid;
    public Date start_date;
    public Date end_date;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId_bid() {
        return id_bid;
    }

    public void setId_bid(String id_bid) {
        this.id_bid = id_bid;
    }

    public String getTotal_bid() {
        return total_bid;
    }

    public void setTotal_bid(String total_bid) {
        this.total_bid = total_bid;
    }

    public String getId_product() {
        return id_product;
    }

    public void setId_product(String id_product) {
        this.id_product = id_product;
    }

    public String getName_product() {
        return name_product;
    }

    public void setName_product(String name_product) {
        this.name_product = name_product;
    }

    public String getStock_product() {
        return stock_product;
    }

    public void setStock_product(String stock_product) {
        this.stock_product = stock_product;
    }

    public String getStart_bid() {
        return start_bid;
    }

    public void setStart_bid(String start_bid) {
        this.start_bid = start_bid;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public String getId_transaction() {
        return id_transaction;
    }

    public void setId_transaction(String id_transaction) {
        this.id_transaction = id_transaction;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
    
    
}
