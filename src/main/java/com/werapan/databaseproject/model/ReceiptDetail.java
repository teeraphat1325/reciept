/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.werapan.databaseproject.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author werapan
 */
public class ReceiptDetail {

    private int id;
    private int productId;
    private String productName;
    private float productPrice;
    private int qty;
    private float totalPrice;
    private int receiptId;

    public ReceiptDetail(int id, int productId, String productName, float productPrice, int qty, float totalPrice, int receiptId) {
        this.id = id;
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.qty = qty;
        this.totalPrice = totalPrice;
        this.receiptId = receiptId;
    }
    
    public ReceiptDetail(int productId, String productName, float productPrice, int qty, float totalPrice, int receiptId) {
        this.id = -1;
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.qty = qty;
        this.totalPrice = totalPrice;
        this.receiptId = receiptId;
    }
    
    public ReceiptDetail() {
        this.id = -1;
        this.productId = 0;
        this.productName = "";
        this.productPrice = 0;
        this.qty = 0;
        this.totalPrice = 0;
        this.receiptId = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(int receiptId) {
        this.receiptId = receiptId;
    }

    @Override
    public String toString() {
        return "ReceiptDetail{" + "id=" + id + ", productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice + ", qty=" + qty + ", totalPrice=" + totalPrice + ", receiptId=" + receiptId + '}';
    }
    
    public static ReceiptDetail fromRS(ResultSet rs) {
        ReceiptDetail receiptDetail = new ReceiptDetail();
        try {
            receiptDetail.setId(rs.getInt("receipt_detail_id"));
            receiptDetail.setProductId(rs.getInt("product_id"));
            receiptDetail.setProductName(rs.getString("product_name"));
            receiptDetail.setProductPrice(rs.getFloat("product_price"));
            receiptDetail.setQty(rs.getInt("qty"));
            receiptDetail.setTotalPrice(rs.getFloat("total_price"));
            receiptDetail.setReceiptId(rs.getInt("receipt_id"));
        } catch (SQLException ex) {
            Logger.getLogger(ReceiptDetail.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return receiptDetail;
    }

}
