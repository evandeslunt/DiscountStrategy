/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

/**
 * The quantity discount applies when a customer purchases more than a minimum
 * amount of the product.
 * 
 * @author Liz Ife Van Deslunt
 */
public class QtyDiscount implements DiscountStrategy {
    // error messages
    public final static String RATE_ERR = "Please enter a discount rate between 0 and 1.";
    public final static String QTY_ERR = "Please enter a quantity greater than zero.";
    
    // constants
    public final static double NO_DISCOUNT = 0.00;
    
    // global variables
    private double discountRate;
    private double minQuantity;
    
    public QtyDiscount(double discountRate, int minNumItems){
        setDiscountRate(discountRate);
        setMinQuantity(minNumItems);
    }
    
    
    // setters
    
    /**
     * Sets the discount rate to a percentage (value between 0 and 1).
     * @param discount The discount percentage, a number between 0 and 1.
     */
    @Override
    public final void setDiscountRate(double discount) throws IllegalArgumentException{
        if(discount < 0 || discount > 1){
            throw new IllegalArgumentException(RATE_ERR);
        }
        this.discountRate = discount;
    }
    
    /**
     * Sets the minimum quantity required to receive the quantity discount.
     * @param quantity - The quantity that must be purchased to receive the 
     * discounted rate.
     */
    @Override
    public final void setMinQuantity(double quantity) throws IllegalArgumentException{
        if(quantity < 2){
            throw new IllegalArgumentException(QTY_ERR);
        }
        this.minQuantity = quantity;
    }
    
    // getters
    
    /**
     * Returns the discount rate that would apply if the minimum quantity has
     * been purchased to qualify for the discount.
     * @return The discount rate.
     */
    @Override
    public final double getDiscountRate(){
        return discountRate;
    }
    
    @Override
    public final double getMinQuantity(){
        return minQuantity;
    }
    
    /**
     * Returns the discount rate that applies, given the quantity purchased. 
     * @param quantity The quantity purchased.
     * @return The discount rate that applies to the purchase. If the quantity
     * purchased is less than the minimum required to receive the discount, returns
     * a value of 0.00 (no discount). If it is greater than or equal to the 
     * minimum, returns the discount rate.
     * @throws IllegalArgumentException If the quantity purchased is less than 0.
     */
    @Override
    public final double applyDiscount(int quantity) throws IllegalArgumentException{
        if(quantity < 0){
            throw new IllegalArgumentException(QTY_ERR);
        } else if (quantity < minQuantity){
            return NO_DISCOUNT;
        } else {
            return discountRate;
        }
    }
}
