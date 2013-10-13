
package discountstrategy;

/**
 * A Factory that creates a DiscountStrategy object.
 * 
 * @author Liz Ife Van Deslunt
 */
public class DiscountFactory {
    
    public enum DISCOUNT_TYPE {FLAT_RATE, QUANTITY, NONE};
     
    /**
     * Returns a DiscountStrategy object.
     * @param type - The type of DiscountStrategy.
     * @param discountRate - The discount rate applied.
     * @param quantity - The minimum quantity required to receive the discount
     * (for quantity discounts)
     * @return A DiscountStrategy object.
     */
    public DiscountStrategy getDiscount(DISCOUNT_TYPE type, double discountRate, 
            int quantity){
        switch(type){
            case FLAT_RATE:
                return new FlatRateDiscount(discountRate);
            case QUANTITY:
                return new QtyDiscount(discountRate, quantity);
            case NONE:
                return new NoDiscount();
            default:
                return null;
        }
    }
    
}
