/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package post.controller;

import post.model.Transaction;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author Abhi
 */
public class TransactionReader {
  
  HashMap <String, Transaction> transactionMap = new HashMap<String, Transaction>();

  public HashMap<String, Transaction> getAllTransaction(){
  File transactionFile  = new File("transactions.txt");
  int item = 0;
  String fileRecord;

  try{
    Scanner scanner = new Scanner(transactionFile).useDelimiter(Pattern.compile("^\\s*\\n", Pattern.MULTILINE));
    while(scanner.hasNext()){
      Transaction transaction = new Transaction(); 
      fileRecord = scanner.next();
      String[] fileRecordSplit = fileRecord.split("\\n");
      int size = fileRecordSplit.length;
      transaction.setName(fileRecordSplit[0]);
      for(int i = 1; i < (size-1); i++)
      {

        String[] itemArray = fileRecordSplit[i].split(" ");
        transaction.setUPC(itemArray[0]);
        if (itemArray.length == 1){
          transaction.setUpcQuantity(1);
        }
        else
        {
          transaction.setUpcQuantity(Integer.parseInt(itemArray[1]));
        }
      }
      String[] paymentArray = fileRecordSplit[size-1].split(" ");
      transaction.setPaymentType(paymentArray[0]);
      transaction.setAmountTender(Float.parseFloat(paymentArray[1]));
      transactionMap.put(transaction.getName(), transaction);
    }
  }catch(FileNotFoundException e){
    e.printStackTrace();
  }
    return transactionMap;    
  }
}