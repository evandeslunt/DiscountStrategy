
package discountstrategy;

/**
 * A class for clothing products.
 * 
 * @author Liz Ife Van Deslunt
 */
public class ClothingProduct implements Product{
    // error messages 
    private final static String PROD_ERR = "Please enter a valid product number.";
    private final static String DESCR_ERR = "Please enter a description for this product.";
    private final static String PRICE_ERR = "Please enter a price greater than $0.00.";
    private final static String DISCOUNT_ERR = "Please supply a discount for this product.";
    
    // constants
    
    // global variables
    private int prodID;
    private String description;
    private double price;
    private DiscountStrategy discount;
    
    public ClothingProduct(int prodID, String descr, double price, DiscountStrategy discount){
        setProductID(prodID);
        setDescription(descr);
        setPrice(price);
        setDiscountType(discount);
    }
    
    //setters

    @Override
    public final void setDescription(String description) throws IllegalArgumentException, NullPointerException{
        if(description == null){
            throw new NullPointerException();
        } else if (description.length() == 0){
            throw new IllegalArgumentException(DESCR_ERR);
        }
        this.description = description;
    }

    @Override
    public final void setPrice(double price) throws IllegalArgumentException{
        if(price <= 0){
            throw new IllegalArgumentException(PRICE_ERR);
        }
        this.price = price;
    }

    @Override
    public final void setProductID(int prodID) throws IllegalArgumentException {
        if(prodID < 0){
            throw new IllegalArgumentException(PROD_ERR);
        }
        this.prodID = prodID;
    }

   
    @Override
    public final void setDiscountType(DiscountStrategy d) throws NullPointerException{
        if(d == null){
            throw new NullPointerException(DISCOUNT_ERR);
        }
        discount = d;
    }
    
    //getters
    @Override
    public final int getProductID() {
       return prodID;
    }
    
     @Override
    public final String getDescription() {
        return description;
    }
     
    @Override
    public final double getPrice() {
        return price;
    }
    
    @Override
    public final double getDiscountRate() {
        return discount.getDiscountRate();
    }

    @Override
    public final DiscountStrategy getDiscountType() {
       return discount;
    }

}
