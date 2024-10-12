/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test_service;

import com.werapan.databaseproject.dao.ProductDao;
import com.werapan.databaseproject.dao.ReceiptDao;
import com.werapan.databaseproject.model.Product;
import com.werapan.databaseproject.model.Receipt;
import com.werapan.databaseproject.model.ReceiptDetail;
import com.werapan.databaseproject.service.ReceiptService;
import java.util.List;

/**
 *
 * @author Aspire
 */
public class TestReceiptService {

    public static void main(String[] args) {
//        ReceiptService receiptService = new ReceiptService();
//        for (Receipt receipt : receiptService.getReceipts()) {
//            System.out.println(receipt);
//        }
//
//        System.out.println(receiptService.getById(1));
//        Receipt r1 = new Receipt(1000, 10, 1);
//
//        ProductDao pd = new ProductDao();
//        List<Product> products = pd.getAll();
//        Product product0 = products.get(0);
//        Product product1 = products.get(1);
//        
//        ReceiptDetail newReceiptDetail1 = new ReceiptDetail(product0.getId(), product0.getName(),product0.getPrice(), 
//                1, product0.getPrice() * 1, -1);
//        r1.addReceiptDetail(newReceiptDetail1);
//        ReceiptDetail newReceiptDetail2 = new ReceiptDetail(product0.getId(), product1.getName(),product1.getPrice(), 
//                2, product0.getPrice() * 2, -1); 
//        r1.addReceiptDetail(newReceiptDetail2);
//        System.out.println(r1);
//        
//        receiptService.addNew(r1);
//
//        for (Receipt receipt : receiptService.getReceipts()) {
//            System.out.println(receipt);
//        }
        ReceiptDao rd = new ReceiptDao();
        System.out.println(rd.get(1));
      
    }
}
