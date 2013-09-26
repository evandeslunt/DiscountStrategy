/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

/**
 * A flat-rate discount applies the same discount rate to any product purchase,
 * regardless of quantity.
 * 
 * @author Liz Ife Van Deslunt
 */
public class FlatRateDiscount implements Discount{
    // error messages
    public final String RATE_ERR = "Please enter a value between 0 and 1.";
    
    // global variables
    private double discountRate;
    
    
    public FlatRateDiscount(double discountRate){
        setDiscountRate(discountRate);
    }
    
    // setters
    
     /**
     * Sets the discount rate to a percentage.
     * @param discount The discount percentage, a number between 0 and 1.
     */
    @Override
    public final void setDiscountRate(double discount){
          if(discount < 0 || discount > 1){
            throw new IllegalArgumentException(RATE_ERR);
        }
        this.discountRate = discount;
    }
    
    // getters
    
    /**
     * Returns the discount rate as a percentage (a number between 0 and 1).
     * @return 
     */
    @Override
    public final double getDiscountRate(){
        return discountRate;
    }
}
