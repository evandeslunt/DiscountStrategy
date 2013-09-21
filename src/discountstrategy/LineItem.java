/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

/**
 * Each LineItem on a receipt contains one type of product, and the quantity
 * purchased.
 * @author Liz Ife Van Deslunt
 */
public class LineItem {
    
    private Product product;
    private int quantity;
    
    
    public LineItem(Product p, int quantity){
        setProduct(p);
        setQuantity(quantity);
    }
    
    //getters
    public final int getProductNumber(){
        return product.getItemNumber();
    }
    
    public final String getProdDescription(){
        return product.getDescription();
    }
    
    public final double getUnitPrice(){
        return product.getPrice();
    }
    
    /**
     * Returns the undiscounted price of the item(s).
     * @return 
     */
    public final double getUndiscountedPrice(){
        return quantity * product.getPrice();
    }
    
    /**
     * Returns the percentage discounted (e.g., 20% off).
     * @return 
     */
    public final double getDiscountRate(){
        return product.getDiscountRate();
    }
    
    /**
     * Returns the final price of the item(s) with the discount applied.
     * @return 
     */
    public final double getFinalPrice(){
        return getUndiscountedPrice() * (1 - getDiscountRate());
    }
    
    public final int getQuantity(){
        return quantity;
    }
    
    
    //setters
    public final void setProduct(Product p){
        if(p == null){
            throw new IllegalArgumentException();
        }
        product = p;
    }
    
    public final void setQuantity(int quantity){
        if(quantity <= 0){
            throw new IllegalArgumentException();
        }
        this.quantity = quantity;
    }
    
    
}
