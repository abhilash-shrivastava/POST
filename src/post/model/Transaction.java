/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package post.model;

import java.text.SimpleDateFormat;
import post.model.ProductSpec;
import java.util.ArrayList;
import java.util.Date;
import post.view.Customer;
import post.view.TransactionHeader;

/**
 *
 * @author Abhi
 */
public class Transaction {
  TransactionHeader header;
  private String name;
  private String[] upc;
  Customer customer;
  private String date;
  private String paymentType;
  private float amountTender;
  ProductSpec[] products;
  ArrayList<String> itemsupc = new ArrayList<String>();
  ArrayList<Integer> itemQuantity = new ArrayList<Integer>();
  
  public Transaction(){
    this.date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
  }    
  public String getDate() {
   return date;
  }
  public void setDate(String date) {
   this.date = date;
  }
  public ProductSpec[] getItems() {
   return products;
  }
  public void setItems(ProductSpec[] items) {
   this.products = items;
  }
  public String getUPC(int index) {
   return itemsupc.get(index);
  }
  public void setUPC(String upc) {
   itemsupc.add(upc);
  }
  public int getUpcQuantity(int index) {
   return itemQuantity.get(index);
  }
  public void setUpcQuantity(int qty) {
   itemQuantity.add(qty);
  }
  public Customer getCustomer() {
   return customer;
  }
  public void setCustomer(Customer customer) {
   this.customer = customer;
  }
  public String getName() {
   return name;
  }
  public void setName(String name) {
   this.name = name;
  }
  public String getPaymentType() {
   return paymentType;
  }
  public void setPaymentType(String paymentType) {
   this.paymentType = paymentType;
  }
  public float getAmountTender() {
   return amountTender;
  }
  public void setAmountTender(float amountTender) {
   this.amountTender = amountTender;
  }
  public ArrayList<String> getAllUPC(){
   return itemsupc;
  }
}
