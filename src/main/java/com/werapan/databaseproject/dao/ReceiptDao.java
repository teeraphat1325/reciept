/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.werapan.databaseproject.dao;

import com.werapan.databaseproject.helper.DatabaseHelper;
import com.werapan.databaseproject.model.Receipt;
import com.werapan.databaseproject.model.ReceiptDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author werapan
 */
public class ReceiptDao implements Dao<Receipt> {

    @Override
    public Receipt get(int id) {
        Receipt receipt = null;
        String sql = "SELECT * FROM receipt WHERE receipt_id=?";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                receipt = Receipt.fromRS(rs);
                ReceiptDetailDao rdd = new ReceiptDetailDao();
                ArrayList<ReceiptDetail> receiptDetails = (ArrayList<ReceiptDetail>) rdd.getAll("receipt_id=" + receipt.getId(), " receipt_detail_id ");
                receipt.setReceiptDetails(receiptDetails);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return receipt;
    }

    public List<Receipt> getAll() {
        ArrayList<Receipt> list = new ArrayList();
        String sql = "SELECT * FROM receipt";
        Connection conn = DatabaseHelper.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Receipt receipt = Receipt.fromRS(rs);
                list.add(receipt);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }
    
    @Override
    public List<Receipt> getAll(String where, String order) {
        ArrayList<Receipt> list = new ArrayList();
        String sql = "SELECT * FROM receipt where " + where + " ORDER BY" + order;
        Connection conn = DatabaseHelper.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Receipt receipt = Receipt.fromRS(rs);
                list.add(receipt);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }
    

    public List<Receipt> getAll(String order) {
        ArrayList<Receipt> list = new ArrayList();
        String sql = "SELECT * FROM receipt  ORDER BY" + order;
        Connection conn = DatabaseHelper.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Receipt receipt = Receipt.fromRS(rs);
                list.add(receipt);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public Receipt save(Receipt obj) {

        String sql = "INSERT INTO receipt (total, cash, total_qty, user_id, customer_id)"
                + "VALUES(?, ?, ?, ?, ?)";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setFloat(1, obj.getTotal());
            stmt.setFloat(2, obj.getCash());
            stmt.setInt(3, obj.getTotalQty());
            stmt.setInt(4, obj.getUserId());
            stmt.setInt(5, obj.getCustomerId());
            
//            System.out.println(stmt);
            stmt.executeUpdate();
            int id = DatabaseHelper.getInsertedId(stmt);
            obj.setId(id);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return obj;
    }

    @Override
    public Receipt update(Receipt obj) {
        String sql = "UPDATE receipt"
                + " SET total = ?, cash = ?, total_qty = ?, user_id = ?, customer_id = ?"
                + " WHERE receipt_id = ?";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setFloat(1, obj.getTotal());
            stmt.setFloat(2, obj.getCash());
            stmt.setInt(3, obj.getTotalQty());
            stmt.setInt(4, obj.getUserId());
            stmt.setInt(5, obj.getCustomerId());
            stmt.setInt(6, obj.getId());
//            System.out.println(stmt);
            int ret = stmt.executeUpdate();
            System.out.println(ret);
            return obj;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public int delete(Receipt obj) {
        String sql = "DELETE FROM receipt WHERE receipt_id=?";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, obj.getId());
            int ret = stmt.executeUpdate();
            return ret;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return -1;        
    }

}
