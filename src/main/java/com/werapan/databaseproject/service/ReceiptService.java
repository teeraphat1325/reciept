/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.werapan.databaseproject.service;

import com.werapan.databaseproject.dao.ReceiptDao;
import com.werapan.databaseproject.dao.ReceiptDetailDao;
import com.werapan.databaseproject.model.Receipt;
import com.werapan.databaseproject.model.ReceiptDetail;
import java.util.List;

/**
 *
 * @author werapan
 */
public class ReceiptService {
    
    public Receipt getById(int id) {
        ReceiptDao receiptDao = new ReceiptDao();
        return receiptDao.get(id);
    }
    
    
    public List<Receipt> getReceipts(){
        ReceiptDao receiptDao = new ReceiptDao();
        return receiptDao.getAll(" receipt_id asc");
    }

    public Receipt addNew(Receipt editedReceipt) {
        ReceiptDao receiptDao = new ReceiptDao();
        ReceiptDetailDao receiptDetailDao = new ReceiptDetailDao();
        Receipt receipt = receiptDao.save(editedReceipt);
        for(ReceiptDetail rd: editedReceipt.getReceiptDetails()) {
            rd.setReceiptId(receipt.getId());
            receiptDetailDao.save(rd);
        }
        return receipt;
    }

    public Receipt update(Receipt editedReceipt) {
        ReceiptDao receiptDao = new ReceiptDao();
        return receiptDao.update(editedReceipt);
    }

    public int delete(Receipt editedReceipt) {
        ReceiptDao receiptDao = new ReceiptDao();
        return receiptDao.delete(editedReceipt);
    }
}
