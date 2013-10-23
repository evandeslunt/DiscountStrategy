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
    // error messages
    private final static String QTY_ERR = "Please enter a quantity greater than 0.";
    private final static String PROD_ERR = "Please enter a valid product.";
    
    // global variables
    private Product product;
    private int quantity;
    
    
    public LineItem(Product p, int quantity){
        setProduct(p);
        setQuantity(quantity);
    }
    
    //getters
    public final int getProductNumber(){
        return product.getProductID();
    }
    
    public final String getProdDescription(){
        return product.getDescription();
    }
    
    public final double getUnitPrice(){
        return product.getPrice();
    }
    
    /**
     * Returns the undiscounted price of the item(s). (qty * price)
     * @return 
     */
    public final double getExtendedPrice(){
        return quantity * product.getPrice();
    }
    
    /**
     * Returns the percentage discounted (e.g., 20% off).
     * @return 
     */
    public final double getDiscountRate(){
        return product.applyDiscount(quantity);
    }
    
    /**
     * Returns the final price of the item(s) with the discount applied.
     * @return 
     */
    public final double getFinalPrice(){
        return getExtendedPrice() * (1 - getDiscountRate());
    }
    
    public final int getQuantity(){
        return quantity;
    }
    
    
    //setters
    public final void setProduct(Product p){
        if(p == null){
            throw new NullPointerException(PROD_ERR);
        }
        product = p;
    }
    
    public final void setQuantity(int quantity){
        if(quantity <= 0){
            throw new IllegalArgumentException(QTY_ERR);
        }
        this.quantity = quantity;
    }
    
    
}
