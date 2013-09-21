/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

/**
 * This class represents a 0% discount (i.e., full price)
 * 
 * @author Liz Ife Van Deslunt
 */
public class NoDiscount implements Discount{
    private final String DISCOUNT_ERR = "Cannot set a discount rate on an "
            + "item with no discount.";
    private final double discountRate = 0; //no discount
    
    public NoDiscount(){
        
    }
    
    @Override
    public final double getDiscountRate(){
        return discountRate;
    }
    
    @Override
    public final void setDiscountRate(double discount){
        throw new IllegalArgumentException(DISCOUNT_ERR);
    }
}
