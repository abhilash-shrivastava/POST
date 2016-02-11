/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package post;

import post.controller.TransactionReader;
import post.controller.ProductReader;
import post.model.Transaction;
import post.model.ProductSpec;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author Abhi
 */
public class POST {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {

    float total = 0;
    ArrayList<String> itemsUpc = new ArrayList<String>();
    ProductReader productReader = new ProductReader();
    HashMap <String, ProductSpec> productMap = productReader.getAllProducts();
    TransactionReader transactionReader = new TransactionReader();
    HashMap <String, Transaction> transactionMap = transactionReader.getAllTransaction();
    Iterator<String> iteratorTransaction = transactionMap.keySet().iterator();

    while(iteratorTransaction.hasNext()){

    Transaction transaction = transactionMap.get(iteratorTransaction.next());
    System.out.println("----- SAFEWAY ----");
    System.out.println(transaction.getName() + "  " + LocalDateTime.now());
    itemsUpc = transaction.getAllUPC();
    for(int i = 0; i < itemsUpc.size(); i++){

      ProductSpec productSpec = productMap.get(itemsUpc.get(i));
      float subTotal = ((productSpec.getPrice())*(transaction.getUpcQuantity(i)));
      System.out.println(productSpec.getDescription() + "  " + transaction.getUpcQuantity(i) + " @ " + productSpec.getPrice() + "  " + subTotal);
      total = total + subTotal;
    }
    System.out.println("Total: " + total);
    if (transaction.getPaymentType().equals("CHECK")){
      System.out.println("Paid By Check");
    }
    if (transaction.getPaymentType().equals("CREDIT")){
      System.out.println("Credit Card" + "  " + (int)transaction.getAmountTender());
    }
    if (transaction.getPaymentType().equals("CASH")){
      System.out.println("Amount Tendered: " + transaction.getAmountTender());
      System.out.println("Amount Returned: " + (transaction.getAmountTender() - total));      
    }
    total = 0;
    System.out.println("\n");
    }
  }
}
