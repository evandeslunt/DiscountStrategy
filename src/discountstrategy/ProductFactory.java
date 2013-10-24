package discountstrategy;

/**
 * A Factory that creates product objects.
 * @author Liz Ife Van Deslunt
 */
public class ProductFactory {
    private static final String PRICE_ERR = "Please supply a price of at least $0.00";
    
    private static int lastProdID = 100;
    public static enum PROD_TYPE {CLOTHING};
    
    
    /**
     * Creates a product, given the type, description, and price. Sets the 
     * discount to NoDiscount by default.
     * @param type - The type of product, taken from the <code>PROD_TYPE</code>
     * enumeration.
     * @param descr - A description of the product
     * @param price - The price of the product before any discounts are applied.
     * 
     * @return A product with the specified type, description, and price.
     */
    public static Product getProduct(PROD_TYPE type, String descr, double price){
        if(type==null || descr == null){
            throw new NullPointerException();
        } else if (price < 0){
            throw new IllegalArgumentException(PRICE_ERR);
        }
        switch (type){
            case CLOTHING:
                lastProdID++;
                return new ClothingProduct(lastProdID, descr, price, new NoDiscount());
            default:
                return null;
        }
                
    }
    
    /**
     * Creates a product given the type, description, price, and discount. 
     * @param type - The type of product, taken from the <code>PROD_TYPE</code>
     * enumeration.
     * @param descr - A description of the product.
     * @param price - The price of the product before any discounts are applied.
     * @param discount - A <code>DiscountStrategy</code> object representing
     * the discount.
     * @return A product with the specified type, description, and price.
     */
    public static Product getProduct(PROD_TYPE type, String descr, double price
            , DiscountStrategy discount){
        if(type==null || descr == null || discount == null){
            throw new NullPointerException();
        } else if (price < 0){
            throw new IllegalArgumentException(PRICE_ERR);
        }
        switch (type){
            case CLOTHING:
                lastProdID++;
                return new ClothingProduct(lastProdID, descr, price, discount);
            default:
                return null;
        }
                
    }
    
}
