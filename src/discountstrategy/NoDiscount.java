/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

/**
 * This class represents a 0% discount (i.e., no discount applied).
 * 
 * @author Liz Ife Van Deslunt
 */
public class NoDiscount implements DiscountStrategy{
    private final String DISCOUNT_ERR = "Cannot set a discount rate on an "
            + "item with no discount.";
    private final String QUANTITY_ERR = "Cannot set a quantity on an item with"
            + "no discount.";
    private final double discountRate = 0; //no discount
    private final double minQuantity = 0; 
    
    /**
     * Default constructor initializes the NoDiscount object.
     */
    public NoDiscount(){
        
    }
    
    /**
     * Returns 0, the discount rate for an item with no discount.
     * @return 0, the discount rate.
     */
    @Override
    public final double getDiscountRate(){
        return discountRate;
    }
    
    /**
     * Returns 0, the minimum quantity for an item with no discount.
     * @return 0, the minimum quantity.
     */
    @Override
    public final double getMinQuantity(){
        return minQuantity;
    }
    
    /**
     * Throws an <code>IllegalArgumentException</code> if one attempts to change
     * the discount rate on a NoDiscount object. To add a discount, create use 
     * the <code>DiscountFactory</code>.
     * @throws IllegalArgumentException when called.
     */
    @Override
    public final void setDiscountRate(double discount) throws IllegalArgumentException{
        throw new IllegalArgumentException(DISCOUNT_ERR);
    }
    
    /**
     * Throws an <code>IllegalArgumentException</code> if one attempts to change
     * the minimum quantity on a NoDiscount object. To add a discount, create use 
     * the <code>DiscountFactory</code>.
     * @throws IllegalArgumentException when called.
     */
    @Override
    public final void setMinQuantity(double quantity) throws IllegalArgumentException{
        throw new IllegalArgumentException(QUANTITY_ERR);
    }
    
    
}
