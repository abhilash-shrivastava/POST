/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package post.model;

/**
 *
 * @author Abhi
 */
public class ProductSpec {
    
  private String upc;
  private String description;
  private float price;

  public String getUPC(){
    return upc;
  }
  public void setUPC(String upcId){
    this.upc = upcId;
  }
  public String getDescription(){
    return description;
  }
  public void setDescription(String desc){
    this.description = desc;
  }
  public float getPrice(){
    return price;
  }
  public void setPrice(float amount){
    this.price = amount;
  }
}
