/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

/**
 *
 * @author Liz Ife Van Deslunt
 */
public interface Product {
    
    public String getDescription();
    public void setDescription(String description);
    
    public double getPrice();
    public void setPrice(double price);
    
    public int getItemNumber();
    public void setItemNumber(int itemNumber);
    
    public double getDiscountRate();
    
    public Discount getDiscountType();
    public void setDiscountType(Discount discount);
    
}
