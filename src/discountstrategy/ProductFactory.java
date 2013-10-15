/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

/**
 * A Factory that creates product objects.
 * @author Liz Ife Van Deslunt
 */
public class ProductFactory {
    
    private int lastProdID = 100;
    public enum PROD_TYPE {CLOTHING};
    
    /**
     * Initializes a ProductFactory
     */
    public ProductFactory(){
        
    }
    
    /**
     * This method returns a product with all parameters specified.
     * @param type
     * @param descr
     * @param price
     * @param disc
     * @return 
     */
    public Product getProduct(PROD_TYPE type, String descr, double price, 
            DiscountStrategy disc){
        if(type==null || disc==null || descr == null){
            throw new NullPointerException();
        } else if (price < 0){
            throw new IllegalArgumentException();
        }
        switch (type){
            case CLOTHING:
                lastProdID++;
                return new ClothingProduct(lastProdID, descr, price, disc);
            default:
                return null;
        }
                
    }
    
     /**
     * This method returns a product with a default discount of NoDiscount.
     * @param type
     * @param descr
     * @param price
     * @param disc
     * @return 
     */
    public Product getProduct(PROD_TYPE type, String descr, double price){
        if(type==null || descr == null){
            throw new NullPointerException();
        } else if (price < 0){
            throw new IllegalArgumentException();
        }
        switch (type){
            case CLOTHING:
                lastProdID++;
                return new ClothingProduct(lastProdID, descr, price, new NoDiscount());
            default:
                return null;
        }
                
    }
    
}
