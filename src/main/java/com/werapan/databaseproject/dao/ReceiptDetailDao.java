/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.werapan.databaseproject.dao;

import com.werapan.databaseproject.helper.DatabaseHelper;
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
public class ReceiptDetailDao implements Dao<ReceiptDetail> {

    @Override
    public ReceiptDetail get(int id) {
        ReceiptDetail receiptDetail = null;
        String sql = "SELECT * FROM receipt_detail WHERE receipt_detail_id=?";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                receiptDetail = ReceiptDetail.fromRS(rs);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return receiptDetail;
    }

    public List<ReceiptDetail> getAll() {
        ArrayList<ReceiptDetail> list = new ArrayList();
        String sql = "SELECT * FROM receipt_detail";
        Connection conn = DatabaseHelper.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                ReceiptDetail receiptDetail = ReceiptDetail.fromRS(rs);
                list.add(receiptDetail);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public List<ReceiptDetail> getAll(String where, String order) {
        ArrayList<ReceiptDetail> list = new ArrayList();
        String sql = "SELECT * FROM receipt_detail where " + where + " ORDER BY" + order;
        Connection conn = DatabaseHelper.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                ReceiptDetail receiptDetail = ReceiptDetail.fromRS(rs);
                list.add(receiptDetail);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    public List<ReceiptDetail> getAll(String order) {
        ArrayList<ReceiptDetail> list = new ArrayList();
        String sql = "SELECT * FROM receipt_detail ORDER BY" + order;
        Connection conn = DatabaseHelper.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                ReceiptDetail receiptDetail = ReceiptDetail.fromRS(rs);
                list.add(receiptDetail);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public ReceiptDetail save(ReceiptDetail obj) {

        String sql = "INSERT INTO receipt_detail (product_id, product_name, product_price, qty, total_price, receipt_id)"
                + "VALUES(?, ?, ?, ?, ?, ?)";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, obj.getProductId());
            stmt.setString(2, obj.getProductName());
            stmt.setFloat(3, obj.getProductPrice());
            stmt.setInt(4, obj.getQty());
            stmt.setFloat(5, obj.getTotalPrice());
            stmt.setInt(6, obj.getReceiptId());

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
    public ReceiptDetail update(ReceiptDetail obj) {
        String sql = "UPDATE receipt_detail"
                + " SET product_id = ?, product_name = ?, product_price = ?, qty = ?, total_price = ?, receipt_id = ?"
                + " WHERE receipt_detail_id = ?";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, obj.getProductId());
            stmt.setString(2, obj.getProductName());
            stmt.setFloat(3, obj.getProductPrice());
            stmt.setInt(4, obj.getQty());
            stmt.setFloat(5, obj.getTotalPrice());
            stmt.setInt(6, obj.getReceiptId());
            stmt.setInt(7, obj.getId());
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
    public int delete(ReceiptDetail obj) {
        String sql = "DELETE FROM receipt_detail WHERE receipt_detail_id=?";
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
