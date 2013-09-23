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
    private final String CUST_LOOKUP_ERR = "That customer ID was not found.";
    private final String PROD_LOOKUP_ERR = "That product ID was not found.";
    private final int INIT_LINE_ITEM_ARRAY_SIZE = 1;
    
    private Customer customer;
    private Receipt receipt;
    private LineItem[] lineItems;
    private Database database;
    
    public Register(Database d, int customerID){
        setDatabase(d);
        setCustomer(customerID);
        lineItems = new LineItem[INIT_LINE_ITEM_ARRAY_SIZE];
    }
    
    //getters
    
    public final Customer getCustomer(){
        return customer;
    }
    
    public final Receipt getReceipt(){
        return receipt;
    }
    
    public final LineItem[] getLineItems(){
        return lineItems;
    }
    
    //setters
    
    public final void setCustomer(int customerID){
        Customer cust = database.findCustomer(customerID);
        if(cust == null){
            throw new IllegalArgumentException(CUST_LOOKUP_ERR);
        }
        customer = cust;
    }
    
    public final void setDatabase(Database d){
        if (d == null){
            throw new NullPointerException();
        }
        this.database = d;
    }
    
    //public methods
    
    public void addProductToReceipt(int prodID, int quantity){
        Product prod = database.findProduct(prodID);
        if(prod == null){
            throw new IllegalArgumentException(PROD_LOOKUP_ERR);
        }
        
        addLineItem(prod, quantity);
    }
    
    public void printReceipt(){
        initializeReceipt();
        receipt.printReceipt();
    }
    
    //private methods
    
    private void initializeReceipt(){
        receipt = new RegisterReceipt(customer, lineItems);
    }
    
    private void addLineItem(Product prod, int quantity){
        if(prod == null){
            throw new NullPointerException();
        }
        if(lineItems[lineItems.length - 1] == null){
            expandArray(lineItems);
        }
        lineItems[lineItems.length - 1] = new LineItem(prod, quantity);
    }
 
    /**
     * Manual array resize. Adds one extra slot to the end of the array.
     * @param array The array to resize
     */
    private void expandArray(Object[] array){
        Object[] tmp = new Object[array.length + 1];
        
        for(int i = 0; i < array.length; i++){
            tmp[i] = array[i];
        }
        
        array = tmp;
    }
}
