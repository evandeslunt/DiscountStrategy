
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
    
    /**
     * Returns the effective discount rate (e.g., if the discount requires a
     * purchase of at least 5 items, but the customer has only purchased 4 items,
     * returns a discount rate of 0. If they purchased 5 items, returns the 
     * discounted rate.
     * @param quantity
     * @return
     * @throws IllegalArgumentException 
     */
    public double applyDiscount(int quantity) throws IllegalArgumentException;
    
    public String toString();
    
}
