/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

/**
 *
 * @author Liz Ife Van Deslunt
 */
public class Register {
    private final int INIT_PRODUCT_ARRAY_SIZE = 1;
    
    private Customer customer;
    private Receipt receipt;
    private Product[] products;
    private Database database;
    
    public Register(Customer c, Database d){
        setCustomer(c);
        setDatabase(d);
        products = new Product[INIT_PRODUCT_ARRAY_SIZE];
        
    }
    
    //getters
    
    public final Customer getCustomer(){
        return customer;
    }
    
    public final Receipt getReceipt(){
        return receipt;
    }
    
    public final Product[] getProducts(){
        return products;
    }
    
    //setters
    
    public final void setCustomer(Customer c){
        if(c == null){
            throw new NullPointerException();
        }
        this.customer = c;
    }
    
    public final void setDatabase(Database d){
        if (d == null){
            throw new NullPointerException();
        }
        this.database = d;
                
    }
    
    //private methods
    
    //array methods
    
            
}
