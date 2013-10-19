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
    public final static String RATE_ERR = "Please enter a value between 0 and 1.";
    public final static String QTY_ERR = "Please enter a number greater than 1.";
    public final static String MISSING_QTY_ERR = "Please enter the quantity purchased.";
    
    // constants
    public final static double NO_DISCOUNT = 0.00;
    public final static double NOT_INITIALIZED = -1;
    
    // global variables
    private double discountRate;
    private double minQuantity;
    private double actualQuantity;
    
    public QtyDiscount(double discountRate, int minNumItems){
        setDiscountRate(discountRate);
        setMinQuantity(minNumItems);
        actualQuantity = NOT_INITIALIZED;
    }
    
    public QtyDiscount(double discountRate, int minNumItems, int actualNumItems){
        setDiscountRate(discountRate);
        setMinQuantity(minNumItems);
        setActualQuantity(actualNumItems);
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
    
    /**
     * Sets the actual quantity purchased.
     * @param quantity - The quantity of items purchased.
     */
    public final void setActualQuantity(int quantity) throws IllegalArgumentException{
         if(quantity <= 0){
            throw new IllegalArgumentException(QTY_ERR);
        }
        this.actualQuantity = quantity;
    }
    
    // getters
    
    /**
     * Returns the discount rate, if the actual number of items purchased is 
     * greater than the minimum quantity required. Otherwise, returns 0 as the 
     * discount rate.
     * If no value has been supplied for the discount, it throws an exception
     * asking for the quantity purchased (ideally, throws it to user interface,
     * which would let you enter the quantity purchased and continue).
     * @return 
     */
    @Override
    public final double getDiscountRate(){
        if(actualQuantity == NOT_INITIALIZED){
            throw new IllegalArgumentException(MISSING_QTY_ERR);
        } else if(actualQuantity < minQuantity){
            return NO_DISCOUNT;
        } else{
            return discountRate;
        }
    }
    
    @Override
    public final double getMinQuantity(){
        return minQuantity;
    }
}
