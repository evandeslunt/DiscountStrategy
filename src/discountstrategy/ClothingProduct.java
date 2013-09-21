/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

/**
 *
 * @author Liz Ife Van Deslunt
 */
public class ClothingProduct implements Product{
    
    private int prodID;
    private String description;
    private double price;
    private Discount discount;
    
    public ClothingProduct(int prodID, String descr, double price, Discount discount){
        setItemNumber(prodID);
        setDescription(descr);
        setPrice(price);
        setDiscountType(discount);
    }
    
    //setters

    @Override
    public final void setDescription(String description) {
        if(description == null){
            throw new NullPointerException();
        } else if (description.length() == 0){
            throw new IllegalArgumentException();
        }
        this.description = description;
    }

    @Override
    public final void setPrice(double price) {
        if(price <= 0){
            throw new IllegalArgumentException();
        }
        this.price = price;
    }

    @Override
    public final void setItemNumber(int itemNumber) {
        if(itemNumber <= 0){
            throw new IllegalArgumentException();
        }
        prodID = itemNumber;
    }

   
    @Override
    public final void setDiscountType(Discount d) {
        if(d == null){
            throw new NullPointerException();
        }
        discount = d;
    }
    
    //getters
    @Override
    public final int getItemNumber() {
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
    public final Discount getDiscountType() {
       return discount;
    }

}
