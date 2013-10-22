
package discountstrategy;

/**
 * A flat-rate discount applies the same discount rate to any product purchase,
 * regardless of quantity. 
 * 
 * @author Liz Ife Van Deslunt
 */
public class FlatRateDiscount implements DiscountStrategy{
    // error messages
    private static final String RATE_ERR = "Please enter a value between 0 and 1.";
    private static final String QUANTITY_ERR = "Please enter a value greater than or "
            + "equal to 0.";
    
    // constants
    private static final int DEFAULT_MIN_QUANTITY = 1; //min quantity required to receive the discount
    private static final double NO_DISCOUNT = 0.00;
    // global variables
    private double discountRate;
    private double minQuantity;
    
    /**
     * Constructor that takes a discount rate.
     * 
     * @param discountRate - The discount rate (e.g. 50% off) as a decimal 
     * between 0 and 1.
     */
    public FlatRateDiscount(double discountRate){
        setDiscountRate(discountRate);
        setMinQuantity(DEFAULT_MIN_QUANTITY);
    }
    
    // setters
    
     /**
     * Sets the discount rate to a percentage (value between 0 and 1).
     * 
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
     * Sets the minimum quantity required to receive the discount.
     * 
     * @param minQuantity - The minimum quantity required to receive the discount.
     */
    @Override
    public final void setMinQuantity(double minQuantity) throws IllegalArgumentException{
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
     * 
     * @return The minimum quantity required to receive the discount.
     */
    @Override
    public final double getMinQuantity(){
        return minQuantity;
    }
    
    /**
     * Returns the discount rate that applies, given the quantity purchased. 
     * 
     * @param quantity The quantity purchased.
     * @return The discount rate that applies to the purchase. 
     * @throws IllegalArgumentException If the quantity purchased is less than 0.
     */
    @Override
    public final double applyDiscount(int quantity) throws IllegalArgumentException{
        if(quantity < 0){
            throw new IllegalArgumentException(QUANTITY_ERR);
        } else {
            return discountRate;
        }
    }
    
}
