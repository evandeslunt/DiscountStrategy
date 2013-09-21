/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

/**
 * This discount is available to "preferred customers." For simplicity, it is a 
 * flat rate discount of 10%. It is easy to see that we could expand the capabilities;
 * for example, we could have different tiers of discounts (10%, 20%, etc.).
 * 
 * @author Liz Ife Van Deslunt
 */
public class PreferredCustomerDiscount implements Discount{
    public final String RATE_ERR = "Please enter a value between 0 and 1.";
    public final double DEFAULT_DISCOUNT = .1;
    
    private double discountRate;
    
    public PreferredCustomerDiscount(){
        discountRate = DEFAULT_DISCOUNT;
    }
    

    @Override
    public double getDiscountRate() {
        return discountRate;
    }

    @Override
    public void setDiscountRate(double discount) {
       if(discount < 0 || discount > 1){
            throw new IllegalArgumentException(RATE_ERR);
        }
        this.discountRate = discount;
    }
    
}
