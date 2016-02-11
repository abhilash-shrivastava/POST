/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package post.controller;

/**
 *
 * @author Abhi
 */
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.HashMap;
import post.model.ProductSpec;


public class ProductReader {
    
  HashMap <String, ProductSpec> productMap = new HashMap<String, ProductSpec>();

  public HashMap<String, ProductSpec> getAllProducts(){
    
    File itemFile  = new File("products.txt");
    try{

      Scanner scanner = new Scanner(itemFile);

      while(scanner.hasNext()){

        String fileRecord = scanner.nextLine();
        String[] fileRecordSplit = fileRecord.split(" ");
        ProductSpec item = new ProductSpec();
        item.setUPC(fileRecordSplit[0]);
        item.setDescription(fileRecordSplit[1]);
        item.setPrice(Float.parseFloat(fileRecordSplit[2]));
        productMap.put(item.getUPC(), item);
      }
    }catch(FileNotFoundException e){

      e.printStackTrace();
    }
    return productMap;    
  }
}
