/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

/**
 * This interface defines the basic information common to any product.
 * 
 * @author Liz Ife Van Deslunt
 */
public interface Product {
    
    public String getDescription();
    public void setDescription(String description);
    
    public double getPrice();
    public void setPrice(double price);
    
    public int getProductID();
    public void setProductID(int prodID);
    
    public double getDiscountRate();
    
    public DiscountStrategy getDiscountType();
    public void setDiscountType(DiscountStrategy discount);
    
}
