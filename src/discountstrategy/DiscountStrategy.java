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
    
    public double getDiscountRate();
    public void setDiscountRate(double discountRate);
}