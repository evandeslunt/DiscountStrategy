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
public class QtyDiscount implements Discount {
    // error messages
    public final static String RATE_ERR = "Please enter a value between 0 and 1.";
    public final static String NUM_ITEMS_ERR = "Please enter a number greater than 1.";
    public final static String MISSING_QTY_ERR = "Please enter the quantity purchased.";
    
    // constants
    public final static double NO_DISCOUNT = 0.00;
    public final static int NOT_INITIALIZED = -1;
    
    // global variables
    private double discountRate;
    private int minNumItems;
    private int actualNumItems;
    
    public QtyDiscount(double discountRate, int minNumItems){
        setDiscountRate(discountRate);
        setMinNumItems(minNumItems);
        actualNumItems = NOT_INITIALIZED;
    }
    
    public QtyDiscount(double discountRate, int minNumItems, int actualNumItems){
        setDiscountRate(discountRate);
        setMinNumItems(minNumItems);
        setActualNumItems(actualNumItems);
    }
    
    // setters
    
    /**
     * Sets the discount rate to a percentage (value between 0 and 1).
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
     * Sets the minimum number of items required to receive the quantity discount.
     * @param num The number of items that must be purchased to receive the 
     * discounted rate.
     */
    public final void setMinNumItems(int num){
        if(num < 2){
            throw new IllegalArgumentException(NUM_ITEMS_ERR);
        }
        this.minNumItems = num;
    }
    
    /**
     * Sets the actual number of items purchased.
     * @param num 
     */
    public final void setActualNumItems(int num){
         if(num <= 0){
            throw new IllegalArgumentException();
        }
        this.actualNumItems = num;
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
        if(minNumItems == NOT_INITIALIZED){
            throw new IllegalArgumentException(MISSING_QTY_ERR);
        } else if(actualNumItems < minNumItems){
            return NO_DISCOUNT;
        } else{
            return discountRate;
        }
    }
    
    public final int getMinNumItems(){
        return minNumItems;
    }
}
