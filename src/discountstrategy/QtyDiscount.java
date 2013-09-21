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

    public final String RATE_ERR = "Please enter a value between 0 and 1.";
    public final String NUM_ITEMS_ERR = "Please enter a number greater than 1.";
    
    private double discountRate;
    private int minNumItems;
    
    /**
     * Creates a new QtyDiscount.
     * @param discountRate The discount rate, a value between 0 and 1.
     */
    public QtyDiscount(double discountRate, int minNumItems){
        setDiscountRate(discountRate);
        setMinNumItems(minNumItems);
    }
    
    // setters
    
    
    /**
     * Sets the discount rate to a percentage.
     * @param discount The discount percentage, a number between 0 and 1.
     */
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
    
    
    // getters
    
    @Override
    public final double getDiscountRate(){
        return discountRate;
    }
    
    
    public final int getMinNumItems(){
        return minNumItems;
    }
}
