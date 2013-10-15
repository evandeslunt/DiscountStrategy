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
public class FlatRateDiscount implements DiscountStrategy{
    // error messages
    private final String RATE_ERR = "Please enter a value between 0 and 1.";
    private final String QUANTITY_ERR = "Please enter a value greater than or "
            + "equal to 0.";
    
    // global variables
    private double discountRate;
    private double minQuantity;
    
    /**
     * Constructor that takes a discount rate only and provides a default value
     * (1.0) for the minimum quantity.
     * @param discountRate - The discount rate (e.g. 50% off) as a decimal 
     * between 0 and 1.
     */
    public FlatRateDiscount(double discountRate){
        setDiscountRate(discountRate);
    }
    
    /**
     * Constructor that takes a discount rate and minimum quantity.
     * @param discountRate - The discount rate (e.g. 50% off) as a decimal
     * between 0 and 1.
     * @param minQuantity - The minimum quantity required to receive the discount. 
     */
    public FlatRateDiscount(double discountRate, double minQuantity){
        setDiscountRate(discountRate);
        setMinQuantity(minQuantity);
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
    
    /**
     * Sets the minimum quantity required to receive the discount.
     * @param minQuantity - The minimum quantity required to receive the discount.
     */
    @Override
    public final void setMinQuantity(double minQuantity){
        if(minQuantity < 0){
            throw new IllegalArgumentException(QUANTITY_ERR);
        }
        this.minQuantity = minQuantity;
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
    
    /**
     * Returns the minimum quantity required to receive the discount.
     * @return The minimum quantity required to receive the discount.
     */
    @Override
    public final double getMinQuantity(){
        return minQuantity;
    }
    
}
