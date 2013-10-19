
package discountstrategy;

/**
 * This interface defines the basic information common to any product.
 * 
 * @author Liz Ife Van Deslunt
 */
public interface Product {
    
    public String getDescription();
    public void setDescription(String description) throws IllegalArgumentException, NullPointerException;
    
    public double getPrice();
    public void setPrice(double price) throws IllegalArgumentException;
    
    public int getProductID();
    public void setProductID(int prodID) throws IllegalArgumentException;
    
    public double getDiscountRate();
    
    public DiscountStrategy getDiscountType();
    public void setDiscountType(DiscountStrategy discount) throws NullPointerException;
    
}
