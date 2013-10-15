/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

/**
 * An interface for a discount.
 * 
 * @author Liz Ife Van Deslunt
 */
public interface DiscountStrategy {
    
    /**
     * Returns the discount rate (e.g., 50% off) as a decimal between 0 and 1.
     * @return The discount rate (e.g., 50% off) as a decimal between 0 and 1.
     */
    public double getDiscountRate();
    /**
     * Sets the discount rate to a decimal between 0 and 1.
     * @param discountRate - The discount rate (e.g., 50% off) as a decimal
     * between 0 and 1.
     */
    public void setDiscountRate(double discountRate);
    
    /**
     * Returns the minimum quantity required to receive the discount.
     * @return The minimum quantity required to receive the discount.
     */
    public double getMinQuantity();
    /**
     * Sets the minimum quantity required to receive the discount.
     * @param quantity - The minimum quantity required to receive the discount.
     */
    public void setMinQuantity(double quantity);
}