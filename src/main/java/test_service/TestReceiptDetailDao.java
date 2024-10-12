/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test_service;

import com.werapan.databaseproject.dao.ProductDao;
import com.werapan.databaseproject.dao.ReceiptDao;
import com.werapan.databaseproject.dao.ReceiptDetailDao;
import com.werapan.databaseproject.model.Product;
import com.werapan.databaseproject.model.Receipt;
import com.werapan.databaseproject.model.ReceiptDetail;
import com.werapan.databaseproject.service.ProductService;
import java.util.List;

/**
 *
 * @author Aspire
 */
public class TestReceiptDetailDao {
    public static void main(String[] args) {
        ReceiptDetailDao rdd = new ReceiptDetailDao();
        for(ReceiptDetail rd : rdd.getAll()) {
            System.out.println(rd);
        }
        ReceiptDao rd = new ReceiptDao();
        ProductDao pd = new ProductDao();
        List<Product> products = pd.getAll();
        Product product0 = products.get(0);
        Receipt receipt = rd.get(1);
        ReceiptDetail newReceiptDetail = new ReceiptDetail(product0.getId(), product0.getName(), 
                product0.getPrice(), 1, product0.getPrice() * 1, receipt.getId());
        
        rdd.save(newReceiptDetail);
    }
}
